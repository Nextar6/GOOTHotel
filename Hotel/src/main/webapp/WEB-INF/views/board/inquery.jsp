<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
	border-style: solid;
	border-width: 1px;
	text-align: center;
}

ul {
	list-style-type: none;
}

li {
	display: inline-block;
}
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>1:1 문의 내역</title>
</head>
<body>

	<h2>문의 내역이 없습니다.</h2>
	<a href="inquery-register"><input type="button" value="1:1문의 등록하기"></a>
	<hr>

	<h1>나의 문의 내역</h1>

	<table>
		<thead>
			<tr>
				<th style="width: 60px">번호</th>
				<th style="width: 700px">제목</th>
				<th style="width: 120px">작성자</th>
				<th style="width: 100px">작성일</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="vo" items="${inqueryList }">
				<c:if test="${sessionScope.userid == vo.memberUserid}">
					<tr>
						<td>${vo.inqueryNo }</td>
						<td><a
							href="inquery-detail?inqueryNo=${vo.inqueryNo }&page=${pageMaker.criteria.page}">${vo.inqueryTitle }</a>
						</td>
						<td>${vo.memberUserid }</td>
						<fmt:formatDate value="${vo.inqueryCdate }"
							pattern="yyyy-MM-dd HH:mm:ss" var="inqueryCdate" />
						<td>${inqueryCdate }</td>
					</tr>
				</c:if>

			</c:forEach>
		</tbody>
	</table>

<!-- TODO 페이징처리 다음페이지 다른방식으로 개선 -->
	<hr>

		<input type="hidden" id="insertAlert" value="${insert_result}" />

	<script type="text/javascript">
		$(document).ready(function() {
			var insertResult = $('#insertAlert').val()
			if (insertResult == 'success') {
				alert('글 등록 성공!');
			}
		})
	</script>

</body>
</html>

