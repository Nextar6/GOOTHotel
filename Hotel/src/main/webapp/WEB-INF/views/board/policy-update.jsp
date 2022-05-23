<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.policyTitle }</title>
</head>
<body>
	<h2>글 수정</h2>
	<form action="policy-update" method="POST">
		<input type="hidden" name="page" value="${page }">
		<div>
			<p>글 번호 : ${vo.policyNo }</p>
			<input type="hidden" name="policyNo" value="${vo.policyNo }">

		</div>
		<div>
			<p>
				제목 <input type="text" name="policyTitle" value="${vo.policyTitle }">
			</p>
		</div>
		<div>
			<p>작성자 : ${vo.writer }</p>
			<p>작성일 : ${vo.policyCdate }</p>
		</div>
		<div>
			<textarea rows="20" cols="120" name="policyContent">${vo.policyContent }</textarea>
		</div>
		<div>
			<input type="submit" value="제출">
		</div>
	</form>

</body>
</html>
