<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.reviewStarGrade{
	display: flex;
	flex-direction: row-reverse;
	font-size: 3rem;
	line-height: 3rem;
	justify-content: space-around;
	padding: 0 0.2em;
	text-align: center;
	width: 5em;
}
.reviewStarGrade input{
	display:none;
}
.reviewStarGrade label{
	cursor: pointer;
	color: #F0F0F0;
}
.reviewStarGrade :checked ~ label{
	color: #FFFF00;
}
.reviewStarGrade label:hover,
.reviewStarGrade label:hover ~ label{
	color: #FFFF00;
}
</style>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Review</title>
</head>
<body>
	<h1>리뷰 작성</h1>
	<form action="register" method="post" id="review">
		<input type="hidden" name="hotelNo" id="hotelNo" value="${hvo.hotelNo }">
		호텔 이름
		<br>
		<p id="hotelTitle">${hvo.hotelTitle }</p>
		<br>
		작성자
		<br>
		<input type="text" id="userid" name="reviewWriter" value="${mvo.memberUserid }" readonly>
		<br>
		<br>
		<div>
			<a>별점</a>
			<br>
			<div class="reviewStarGrade">
				<input type="radio" id="star5" name="reviewGrade" value="5">
				<label for="star5" class="star">★</label>
				<input type="radio" id="star4" name="reviewGrade" value="4">
				<label for="star4" class="star">★</label>
				<input type="radio" id="star3" name="reviewGrade" value="3">
				<label for="star3" class="star">★</label>
				<input type="radio" id="star2" name="reviewGrade" value="2">
				<label for="star2" class="star">★</label>
				<input type="radio" id="star1" name="reviewGrade" value="1">			
				<label for="star1" class="star">★</label>
			</div>
		</div>
		<br>
		<br>
		리뷰 이미지
   		<br>
		<input type="file" name="fileUpload" id="fileUpload" multiple>
		<input type="hidden" name="reviewPic" id="reviewPic">
		<div id="showlist">
		</div>
		<br>
		리뷰 내용
		<br>
		<input type="text" name="reviewContent" id="reviewContent" required>
		<hr>
		<input type="submit" id="send" value="등록">
	</form>
	
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