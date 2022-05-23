<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>${vo.foodTitle }</title>
</head>
<body>
<%@ include file="header.jspf" %>
	<h2>글 보기</h2>
	<div>
		<p>글 번호 : ${vo.foodNo }</p>
	</div>
	<div>
		<p>
			제목 <input type="text" value="${vo.foodTitle }" readonly>
		</p>
	</div>
	<div>
		<p>작성자 : ${vo.memberUserid }</p>
		<p>작성일 : ${vo.foodCdate }</p>
		<p>가격 : ${vo.foodPrice}</p>
		<p>예약기간 : ${vo.foodBookDate}</p>

	</div>


	<div>
		<!-- 이미지 -->
		<div>
		<c:forEach var="picArray" items="${picArray }">
		<c:set var="cutThumbnail" value="${fn:replace(picArray, 's_', '') }"/>
			<img src="display?fileName=/${cutThumbnail }" style="max-height: 100vh;
  max-width: 100vh;" />
		</c:forEach>
		</div>

		<textarea rows="20" cols="120" readonly>${vo.foodContent }</textarea>

	</div>


	<a href="food?page=${page }"><input type="button" value="글 목록"></a>
	<a href="food-update?foodNo=${vo.foodNo }&page=${page }"><input
		type="button" value="글 수정"></a>
	<a href="food-delete?foodNo=${vo.foodNo }"><input type="button"
		value="글 삭제"></a>
	<br>
	<hr>

	<!-- POST 방식으로 데이터를 전송하려면 form을 사용해야 한다. -->
	<div style="text-align: right;">
	<p>리뷰 작성</p>
	
	
		<select id="foodRvLike">
			<option value="1">최악!!! &#128507;
			<option value="2">별로에요... &#128517;
			<option value="3">보통이에요&#128512;
			<option value="4" selected>좋아요! &#128525;
			<option value="5">최고에요! &#128151;</option>
		</select> 
		<input type="text" id="foodRvTitle" placeholder="제목"><br>
		작성자 : ${memberUserid }<input type="text" id="memberUserid">
		<input type="text" id="foodRvContent" placeholder="내용">
		<button id="btn_add">작성</button>
		


	</div>

	<input type="hidden" id="foodNo" value="${vo.foodNo}">
	<input type="hidden" id="memberUserid">
	<input type="hidden" id="foodRvContent">

	<input type="hidden" id="deleteAlert" value="${delete_result }">
	
	<div style="text-align: center;">
	<hr>
		<div id="replies"></div>
	</div>


	<!-- 자바스크립트 코드 -->
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var foodNo = $('#foodNo').val();
							getAllReplies();

							$('#btn_add').click(function() {
								var foodRvLike = $('#foodRvLike').val();
								var foodRvTitle = $('#foodRvTitle').val();
								var foodRvContent = $('#foodRvContent').val();
								var memberUserid = $('#memberUserid').val();

								var obj = {
									'foodNo' : foodNo,
									'foodRvTitle' : foodRvTitle,
									'foodRvLike' : foodRvLike,
									'foodRvContent' : foodRvContent,
									'memberUserid' : memberUserid
								};
								console.log(obj);
								var JSONObj = JSON.stringify(obj);

								// $.ajax로 송수신
								$.ajax({
									type : 'post',
									url : 'foodReplies',
									headers : {
										'Content-Type' : 'application/json',
										'X-HTTP-Method-Override' : 'POST'
									},
									data : JSONObj,
									success : function(result, status) {
										console.log(result);
										console.log(status);
										if (result == 1) {
											alert('입력 성공');
											getAllReplies();
											
										}
									}
								}); // end ajax()

							}); // end btn_add.click()

							function getAllReplies() {
								var url = 'foodReplies/all/' + foodNo;
								// 제이슨 ~~!!!!
								console.log("나오나 확인");
								$
										.getJSON(
												url,
												function(jsonData) {
													// jsonData : 서버에서 온 list 데이터가 저장되어 있음
													console.log(jsonData);
													var memberUserid = $(
															'#memberUserid')
															.val();

													var list = ''; // JSON 데이터를 HTML에 표현할 문자열 변수
													// $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
													$(jsonData)
															.each(
																	function() {
																		// this : 컬렉셔네서 각 데이터를 꺼내서 저장
																		console
																				.log(this);
																		var foodRpCdate = new Date(
																				this.foodRvCdate);
																		var disabled = 'disabled';
																		var readonly = 'readyonly';
																		//var memberUserid = $
																		//{sessionScope.memberUserid};
																		var like = '확인';
																		if (this.foodRvLike == 1){
																			like = '최악!!! &#128507;'
																		}else if (this.foodRvLike == 2) {
																			like = '별로에요... &#128517;' 
																		} else if(this.foodRvLike == 3){
																			like = '보통이에요&#128512;'
																		} else if(this.foodRvLike == 4){
																			like = '좋아요! &#128525;'
																		} else if(this.foodRvLike == 5){
																			like = '최고에요! &#128151;'
																		}
																		

																																			
																			
																		//if (memberUserid == this.memberUserid) {
																			disabled = '';
																			readonly = '';
																		//}
																		list += '<div class="reply_item">'
																				+ '<pre>'
																				+ '<input type="hidden" id="foodRvNo" value="' + this.foodRvNo + '" />'
																				+ '<input type="hidden" id="memberUserid" value="' + this.memberUserid + '" />'
																				+ '<input type="hidden" id="foodRvLike" value="' + this.foodRvLike + '"/>'
																				+ like 
																				+ '&nbsp;&nbsp;'
																				+ this.foodRvTitle
																				+ '&nbsp;&nbsp;'
																				+ this.memberUserid
																				+ '&nbsp;&nbsp;'
																				+ this.foodRvCdate
																				+ '&nbsp;&nbsp;'
																				+ '&nbsp;&nbsp;'
																				+ '&nbsp;&nbsp;'
																				+ '&nbsp;&nbsp;'
																				+ '<button class="btn_update"' + disabled + ' >수정</button>'
																				+ '<button class="btn_delete"' + disabled + ' >삭제</button><br>'
																				+ '<textarea rows="5" cols="100" readonly>' + this.foodRvContent + '</textarea>'
																				
										
																				+ '</pre>'
																				+ '</div>';
																	}); // end each()
													$('#replies').html(list);

												}); // end getJSON()

							} // end getALLReplies() 05-04 11:15

							// 수정
							$('#replies')
									.on(
											'click',
											'.reply_item .btn_update',
											function() {
												console.log(this);

												// 선택된 댓글의 replyNo, replyContent 값을 저장
												// prevAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접근
												var playRvNo = $(this).prevAll(
														'#foodRvNo').val();
												var playRvContent = $(this)
														.prevAll(
																'#replyRvContent')
														.val();
												console.log("선택된 댓글 번호 : "
														+ playRvNo
														+ ", 댓글 내용 : "
														+ playRvContent);

												// ajax
												$
														.ajax({
															type : 'put',
															url : 'foodReplies/'
																	+ playRvNo,
															data : JSON
																	.stringify({
																		'foodRvContent' : playRvContent
																		
																	}),
															headers : {
																'Content-Type' : 'application/json',
																'X-HTTP-Method-Override' : 'PUT'
															},
															success : function(
																	result) {
																console
																		.log(result);
																if (result == 'success') {
																	alert('댓글 수정 성공!');
																	getAllReplies();
																}
															}
														});

											}); // end replies.on()

							// 댓글 삭제
							$('#replies')
									.on(
											'click',
											'.reply_item .btn_delete',
											function() {
												console.log(this);

												var playRvNo = $(this).prevAll(
														'#foodRvNo').val();
												console.log("선택된 리뷰 번호 : "
														+ playRvNo);
												var playRvLike = $(this).prevAll('#foodRvLike').val();
												console.log("선택된 리뷰의 평점 : " + playRvLike)
												// ajax
												$
														.ajax({
															type : 'delete',
															url : 'foodReplies/'
																	+ playRvNo,
															data : JSON
																	.stringify({
																		'foodRvNo' : playRvNo,
																		'foodNo' : playNo,
																		'foodRvLike' : playRvLike
																	}),
															headers : {
																'Content-type' : 'application/json',
																'X-HTTP-Method-Override' : 'DELETE'
															},
															success : function(
																	result) {
																if (result == 'success') {
																	alert('댓글 삭제 성공!');
																	getAllReplies();
																}
															}
														}); // end ajax()
											}); // end replies.on()

							// 글 삭제
							var result = $('$deleteAlert').val();
							if (result == 'fail') {
								alert('글 삭제 실패!');
							}
						}); // end document()
	</script>
 <%@ include file="footer.jspf" %>
</body>
</html>









