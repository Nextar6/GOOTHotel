<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.questionTitle }</title>
</head>
<body>
	<h2>글 수정</h2>
	<form action="question-update" method="POST">
		<input type="hidden" name="page" value="${page }">
		<div>
			<p>글 번호 : ${vo.questionNo }</p>
			<input type="hidden" name="questionNo" value="${vo.questionNo }">

		</div>
		<div>
			<p>
				제목 <input type="text" name="questionTitle" value="${vo.questionTitle }">
			</p>
		</div>
		<div>
			<p>작성자 : ${vo.writer }</p>
			<p>작성일 : ${vo.questionCdate }</p>
		</div>
		<div>
			<textarea rows="20" cols="120" name="questionContent">${vo.questionContent }</textarea>
		</div>
		<div>
			<input type="submit" value="제출">
		</div>
	</form>

</body>
</html>
