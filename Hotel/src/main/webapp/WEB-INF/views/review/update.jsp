<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Review</title>
</head>
<body>
	<h1>리뷰 수정</h1>
	<form action="update" method="post">
		<input type="hidden" name="reviewWriter" value="${vo.reviewWriter }">
		<input type="hidden" name="hotelNo" value="${vo.hotelNo }">
		<input type="hidden" name="reviewNo" value="${vo.reviewNo }">
		<div>
			호텔이름
			<br>
			${vo.hotelTitle }
		</div>
		<div>
			리뷰 별점
			<br>
			<input type="radio" name="reviewGrade" value="1" id="grade1" checked><label for="grade1">☆</label>
			<input type="radio" name="reviewGrade" value="2" id="grade2"><label for="grade2">☆</label>
			<input type="radio" name="reviewGrade" value="3" id="grade3"><label for="grade3">☆</label>
			<input type="radio" name="reviewGrade" value="4" id="grade4"><label for="grade4">☆</label>
			<input type="radio" name="reviewGrade" value="5" id="grade5"><label for="grade5">☆</label>
		</div>
		<div>
			리뷰 내용
			<br>
			<input type="text" name="reviewContent" id="reviewContent" required>
		</div>
		<div>
			리뷰 이미지
	   		<br>
			<input type="file" name="fileUpload" id="fileUpload" multiple>
			<input type="hidden" name="reviewPic" id="reviewPic">
			<div id="showlist">
			</div>
		</div>
		<input type="submit" id="send" value="수정">
	</form>

	<input type="hidden" name="reviewWriter" value="${vo.reviewWriter }">	
	<input type="hidden" name="reviewNo" value="${vo.reviewNo }">
	
	<script type="text/javascript">
	$(document).ready(function() {
		$('#fileUpload').on('change', function(event) {
			var formData = new FormData();
			var fileinput = $('#fileUpload');
			var filelist = fileinput[0].files;
			
			for(var i = 0; i < filelist.length; i++){
				console.log(filelist[i]);
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
					console.log(data);
					var str = '<div>';
					for(var i = 0; i < filelist.length; i++){
						str += '<img src="displayReview?fileName='
							+ data[i]
							+ '"/>';
					}
					str	+ '</div>';
					$('#showlist').html(str);
					$('#reviewPic').val(data);
				}
			})// end ajax
		}); // end fileUpload.change
	}); // end document	
	
	
	</script>
</body>
</html>