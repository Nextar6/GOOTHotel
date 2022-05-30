<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js">
	
</script>
<style type="text/css">
#multipleContainer {
	display: grid;
	grid-template-columns: 1fr 1fr 1fr;
}

.image {
	display: block;
	width: 100%;
}

.image-label {
	position: relative;
	bottom: 22px;
	left: 5px;
	color: white;
	text-shadow: 2px 2px 2px black;
}
</style>
</head>
<body>

	<h2>글 작성 페이지</h2>
	<br>

	<form action="themapark-insert" method="POST" enctype="multipart/form-data">
		<div>
			<p>
				카테고리 : themapark
		</div>
		<div>
			제목 : <input type="text" name="themaparkTitle" placeholder="제목 입력" required>
		</div>
		<div>
			<p>
				작성자 : <input type="text" name="memberUserid">${vo.memberUserid }</p>
			가격 : <input type="number" name="themaparkPrice" placeholder="숫자를 입력하세요" />

		</div>
		<br>
		<div>
			<textarea rows="20" cols="120" name="themaparkContent" placeholder="내용입력"
				required></textarea>
		</div>
		예약 가능 날짜 : <input type="text" name="themaparkBookDate">
		<div>
			<!-- 이미지 파일 업로드 부분  -->
			<h3>이미지 파일 업로드</h3>

			<input style="display: block;" type="file" name="fileUpload"
				id="fileUpload" multiple> <input type="hidden"
				name="themaparkPic" id="themaparkPic">

			<div id="multipleDisplay"></div>
			<hr>
			<input type="submit" value="등록">
		</div>
	</form>


	<script type="text/javascript">
		$(document)
				.ready(
						function() {
		

							$('#fileUpload')
									.on(
											'change',
											function(event) {
												var formData = new FormData();
												var fileinput = $('#fileUpload');
												var filelist = fileinput[0].files;

												for (var i = 0; i < filelist.length; i++) {
													console.log("여기는 나오나"
															+ filelist[i]);
													formData.append("filelist",
															filelist[i]);
												}

												$
														.ajax({
															type : 'POST',
															url : 'fileUpload',
															async : false,
															processData : false,
															contentType : false,
															data : formData,
															success : function(
																	data) {
																console
																		.log("여기가나오나"
																				+ data);
																var str = '<div>';
																for (var i = 0; i < filelist.length; i++) {
																	str += '<img src="display?fileName='
																			+ data[i]
																			+ '"/>';
																}
																str + '</div>';
																$(
																		'#multipleDisplay')
																		.html(
																				str);
																$('#themaparkPic')
																		.val(
																				data);
															}

														}) // end ajax
											}); //end themaparkFile.change

						}); // end document
	</script>

</body>
</html>
