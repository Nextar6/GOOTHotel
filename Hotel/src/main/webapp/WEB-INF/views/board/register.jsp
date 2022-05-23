<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>

	<h2>글 작성 페이지</h2>
	<br>
	
	<form action="register" method="POST">
		<div>
			<select name="boardCategory">
				<option value="anounce" selected>공지사항
				<option value="event">Event
				<option value="project">프로젝트
				<option value="policy">약관및정책
				<option value="question">Q&A
			</select>
		</div>
		<div>
			<p>제목 :</p>
			<input type="text" name="boardTitle" placeholder="제목 입력" required>
		</div>
		<div>
			<p>작성자 :</p>
			<input type="text" name="writer" required>
		</div>
		<br>
		<div>
			<textarea rows="20" cols="120" name="boardContent" placeholder="내용입력"
				required></textarea>
		</div>
		<div>
			<input type="submit" value="등록">
		</div>

	</form>

</body>
</html>







