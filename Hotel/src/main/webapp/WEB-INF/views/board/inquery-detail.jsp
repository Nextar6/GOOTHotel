<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>${vo.inqueryTitle }</title>
</head>
<body>
	<h2>1:1 문의 내역</h2>
	<div>
		<p>글 번호 : ${vo.inqueryNo }</p>
	</div>
	<div>
		<p>
			제목 <input type="text" value="${vo.inqueryTitle }" readonly>
		</p>
	</div>
	<div>
		<p>작성자 : ${vo.memberUserid }</p>
		<p>작성일 : ${vo.inqueryCdate }</p>
	</div>
	<div>
		<textarea rows="20" cols="120" readonly>${vo.inqueryContent }</textarea>
	</div>
	<a href="inquery?page=${page }"><input type="button" value="글 목록"></a>
	<a href="inquery-delete?inqueryNo=${vo.inqueryNo }"><input type="button" value="글 삭제"></a>


	<!-- 댓글 -->
	
	<h2>1:1 문의 답변</h2>
	
	<!-- 1:1문의 답변 -->
	<div style="text-align: center;">
		<div id="replies"></div>
	</div>
	
	
	<input type="hidden" id="inqueryNo" value="${vo.inqueryNo}">
	<input type="hidden" id="sessionUserid" value="${sessionScope.userid }">
   


	<!-- 관리자면 답변 글쓰기 가능  -->
	<hr>
	<br> <br> <br> <br> <br> 
	<c:if test="${sessionScope.userid == 'manager'}">
		<div style="text-align: center;">
			<input type="hidden" id="inqueryNo" value="${vo.inqueryNo}">
			<!-- 마지막이 2 -->
			<p>작성자 : ${sessionScope.userid } </p>
			<textarea
				id="inqueryRpContent" rows="10" cols="100"></textarea>
			<button id="btn_add">작성</button>
		</div>
	</c:if>

	

	<script type="text/javascript">

		$(document)
				.ready(
						function() {
							var inqueryNo = $('#inqueryNo').val(); // 게시판 번호 값
							getAllReplies();

							$('#btn_add')
									.click(
											function() {
												
												var inqueryRpContent = $(this).prevAll('#inqueryRpContent').val();
							
												var memberUserid = $('#sessionUserid').val(); // 댓글 작성자 아이디
												console.log(memberUserid);
												var obj = {
													'inqueryNo' : inqueryNo,
													'inqueryRpContent' : inqueryRpContent,
													'memberUserid' : memberUserid
												};
												console.log(obj);

												var JSONObj = JSON
														.stringify(obj);

												// $.ajax로 송수신
												$
														.ajax({
															type : 'post',
															url : 'replies',
															headers : {
																'Content-Type' : 'application/json',
																'X-HTTP-Method-Override' : 'POST'
															},
															data : JSONObj,
															success : function(
																	result) {
																console
																		.log(result);
																console
																		.log(status)
																if (result == 1) {
																	alert('댓글 입력 성공');
																	getAllReplies();
																}
															}
														}); // end ajax()
											}); // end btn_add.click()

							// 게시판의 댓글 전체 가져오기
							function getAllReplies() {
								var url = 'replies/all/' + inqueryNo;
								console.log("ㅎㅇ");

								$
										.getJSON(
												url,
												function(jsonData) {
													// jsonData : 서버에서 온 list 데이터가 저장되어 있음
													console.log(jsonData);
													// 힌트1. 로그인 한 사용자 아이디 값을 가져와야 함
													var sessionUserid = $('#sessionUserid').val();
													
													var manager = "manager";
													var list = ''; // JSON 데이터를 HTML에 표현할 문자열 변수

													// $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
													$(jsonData)
															.each(
																	function() {
																		// this : 컬렉션에서 각 데이터를 꺼내서 저장
																		console
																				.log(this);
																		// 힌트2. 댓글 작성자와 로그인 한 사용자를 비교

																		var inqueryRpCdate = new Date(
																				this.inqueryRpCdate);
																		var disabled = 'disabled';
																		var readonly = 'readonly';
																		var userid = ${sessionScope.userid};
																		if(userid == manager) {
																		   disabled = '';
																		   readonly = '';
																		}

																		list += '<div class="reply_item">'
																				+ '<pre>'
																				+ '<input type="hidden" id="inqueryRpNo" value="' + this.inqueryRpNo + '" readyonly />'
																				+ '<input type="hidden" id="writer" value="' + this.writer + '" />'
									
																				+ '&nbsp;&nbsp;' // 공백
																				+ '<textarea rows="10" cols="100" id="inqueryRpContent"' +  readonly + '>'
																				+ this.inqueryRpContent
																				+ '</textarea><br>'
																				+ '<p>작성자 : ' + this.memberUserid + '</p>'
																				+ '&nbsp;&nbsp;' // 공백
																				+ inqueryRpCdate
																				+ '&nbsp;&nbsp;' // 공백
																				+ '<button class="btn_update" ' + disabled + ' >수정</button>'
																				+ '<button class="btn_delete" ' + disabled + ' >삭제</button>'
																				+ '</pre>'
																				+ '</div>';
																	}); // end each()
													$('#replies').html(list);
												}); // end getJSON()
							} // end getAllReplies()

							// 수정 버튼을 클릭하면 선택된 댓글 수정
							$('#replies')
									.on(
											'click',
											'.reply_item .btn_update',
											function() {
												console.log(this);

												// 선택된 댓글의 replyNo, replyContent 값을 저장
												// prevAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접근
												var inqueryRpNo = $(this)
														.prevAll('#inqueryRpNo')
														.val();
												var inqueryRpContent = $(this)
														.prevAll(
																'#inqueryRpContent')
														.val();
												console.log("선택된 댓글 번호 : "
														+ inqueryRpNo
														+ ", 댓글 내용 : "
														+ inqueryRpContent);

												// ajax 요청
												$
														.ajax({
															type : 'put',
															url : 'replies/'
																	+ inqueryRpNo,
															data : JSON
																	.stringify({
																		'inqueryRpContent' : inqueryRpContent
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

							// 삭제 버튼을 클릭하면 선택된 댓글 삭제
							$('#replies')
									.on(
											'click',
											'.reply_item .btn_delete',
											function() {
												console.log(this);

												var inqueryRpNo = $(this)
														.prevAll('#inqueryRpNo')
														.val();
												console.log("선택된 댓글 번호 : "
														+ inqueryRpNo);

												// ajax 요청
												$
														.ajax({
															type : 'delete',
															url : 'replies/'
																	+ inqueryRpNo,
															data : JSON
																	.stringify({
																		'inquryNo' : inqueryNo
																	}),
															headers : {
																'Content-Type' : 'application/json',
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

						}); // end document()
	</script>
</body>
</html>

