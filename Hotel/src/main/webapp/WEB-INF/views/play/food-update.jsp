<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 페이지</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js">
	
</script>
<style type="text/css">

</style>
</head>
<body>

	<h2>글 수정 페이지</h2>
	<br>

	<form action="update" method="POST" enctype="multipart/form-data">
		<div>
			<input type="hidden" name="playNo" value="${vo.playNo }" readonly/>
			<input type="hidden" name="page" value = "${page }"/>
				카테고리 <select name="playCategory">
					<option value="themaPark" selected>테마파크
					<option value="food">맛집
					<option value="leisure">레저
					<option value="perform">공연
					<option value="tour">투어
				</select>
		</div>
		<div>
			제목 : <input type="text" name="playTitle" value="${vo.playTitle }" required>
		</div>
		<div>
			<p>작성자 : ${vo.memberUserid }</p>
			가격 : <input type="text" name="playPrice" value="${vo.playPrice }" required>

		</div>
		<br>
		<div>
			<img src="display?fileName=/${vo.playPic }" />
		</div>
		<div>
			<textarea rows="20" cols="120" name="playContent" 
				required>${vo.playContent }</textarea>
		</div>
		예약 가능 날짜 : <input type="text" name="playBookDate" value="${vo.playBookDate }" required>
		<div>
			<h3>이미지 삽입</h3>
			<input style="display: block;" type="file" name="fileUpload" id="fileUpload"
				multiple>
		
				<input type="hidden" name="playPic" id="playPic" value="${vo.playPic }">
		

			<h3>수정할 이미지</h3>
			<div id="multipleDisplay"></div>
			

			<br>
			<hr>
			<input type="submit" value="수정하기">
		</div>
	</form>

	<input type="hidden" id="updateAlert" value="${update_result }">

	<script type="text/javascript">
		$(document).ready(function() {
			$('#fileUpload').on('change', function(event) {
				var formData = new FormData();
				var fileinput = $('#fileUpload');
				var filelist = fileinput[0].files;
				
				for(var i = 0; i < filelist.length; i++) {
					console.log("여기는 나오나" + filelist[i]);
					formData.append("filelist", filelist[i]);
				}
				
				$.ajax({
					type : 'POST',
					url : 'fileUpload',
					async : false,
					processData : false,
					contentType : false,
					data : formData,
					success : function(data) {
						console.log("여기가나오나" + data);
						var str = '<div>';
						for(var i = 0; i < filelist.length; i++){
							str += '<img src="display?fileName='
									+ data[i]
									+ '"/>';
						}
						str + '</div>';
						$('#multipleDisplay').html(str);
						
						$('#playPic').val(data);
						}
					
					
				}) // end ajax
			}); // end playFile.change
			
			
			var result = $('$updateAlert').val();
			if (result == 'fail') {
				alert('글 수정 실패!');
			}

		}); // end document
	</script>
	
</body>
</html>
