<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.anounceTitle }</title>
</head>
<body>
	<h2>글 수정</h2>
	<form action="anounce-update" method="POST">
		<input type="hidden" name="page" value="${page }">
		<div>
			<p>글 번호 : ${vo.anounceNo }</p>
			<input type="hidden" name="anounceNo" value="${vo.anounceNo }">

		</div>
		<div>
			<p>
				제목 <input type="text" name="anounceTitle" value="${vo.anounceTitle }">
			</p>
		</div>
		<div>
			<p>작성자 : ${vo.writer }</p>
			<p>작성일 : ${vo.anounceCdate }</p>
		</div>
		<div>
			<textarea rows="20" cols="120" name="anounceContent">${vo.anounceContent }</textarea>
		</div>
		<div>
			<input type="submit" value="제출">
		</div>
	</form>

</body>
</html>
