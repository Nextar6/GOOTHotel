<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inquery</title>
</head>
<body>
	<h2>1:1 문의</h2>
	<form action="inquery-register" method="POST">
		<input type="hidden" name="page" value="${page }">
		<div>
		
		
		
		</div>
		<div>
			<p>
				제목 <input type="text" name="inqueryTitle"  placeholder="제목 입력" required>
			</p>
		</div>
		<div>
			<p>작성자 : <input type="hidden" name="memberUserid" value="${sessionScope.userid }"/> </p>

		</div>
		<div>
			<textarea rows="20" cols="120" name="inqueryContent" placeholder="내용입력" required></textarea>
		</div>
		<div>
			<input type="submit" value="제출">
		</div>
	</form>
	<a href="inquery?page=${page }"><input type="button" value="글 목록"></a>

</body>
</html>
