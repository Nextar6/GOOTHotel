<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.projectTitle }</title>
</head>
<body>
	<h2>글 수정</h2>
	<form action="project-update" method="POST">
		<input type="hidden" name="page" value="${page }">
		<div>
			<p>글 번호 : ${vo.projectNo }</p>
			<input type="hidden" name="projectNo" value="${vo.projectNo }">

		</div>
		<div>
			<p>
				제목 <input type="text" name="projectTitle" value="${vo.projectTitle }">
			</p>
		</div>
		<div>
			<p>작성자 : ${vo.writer }</p>
			<p>작성일 : ${vo.projectCdate }</p>
		</div>
		<div>
			<textarea rows="20" cols="120" name="projectContent">${vo.projectContent }</textarea>
		</div>
		<div>
			<input type="submit" value="제출">
		</div>
	</form>

</body>
</html>
