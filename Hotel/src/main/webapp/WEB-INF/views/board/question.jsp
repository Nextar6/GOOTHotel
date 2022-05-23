<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td{

	text-align : center;
}
ul {
	list-style-type : none;
}

li {
	display : inline-block;
}
table.type {
    border-collapse: separate;
  text-align: left;
  line-height: 1.5;
  border: 1px solid #ccc;
  margin: 20px 10px;
}
table.type thead {
  border-right: 1px solid #ccc;
  border-left: 1px solid #ccc;
  background: #e7708d;
}
table.type thead th {
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  color: #fff;
}
table.type tbody th {
  width: 150px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #fcf1f4;
}
table.type td {
  width: 350px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
}

</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<title>inform</title>
</head>
<body>
<%@ include file="header.jspf"%>
	<br>
<h1 style="float: left; color: white;">Q&A</h1>

	

	<div style="background-color: #1abc9c; padding: 25px; text-align: right">

		<form action="anounce" method="get">
			<input type="date"> <select name="pagingCount">
				<option value="5" selected>5
				<option value="10">10
				<option value="20">20
			</select> <select name="select">
				<option value="titleOrContent">제목+내용
				<option value="writer">작성자
			</select> <input type="text" name="keyword" placeholder="search"> <input
				type="submit" value="검색">
		</form>
	</div>
		<a href="register"><input type="button" value="글작성" style="width: auto; float: right;"></a>
	<br>
	

	<hr>
	
	<table class="type">
		<thead>
			<tr>
				<th style="width: 60px">번호</th>
				<th style="width: 700px">제목</th>
				<th style="width: 120px">작성자</th>
				<th style="width: 100px">작성일</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="vo" items="${questionList }">
				<tr>
					<td>${vo.questionNo }</td>
					<td><a href="question-detail?questionNo=${vo.questionNo}&page=${pageMaker.criteria.page}">${vo.questionTitle }</a></td>
					<td>${vo.writer }</td>
					<fmt:formatDate value="${vo.questionCdate }"
						pattern="yyyy-MM-dd HH:mm:ss" var="questionCdate" />
					<td>${questionCdate }</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<hr>
	<ul>
		<c:if test="${pageMaker.hasPrev }">
			<li><a href="list.do?page=${pageMaker.startPageNo - 1 }">이전</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPageNo }"
			end="${pageMaker.endPageNo }" var="num">

			<li><a href="list.do?page=${num }">${num }</a></li>
		</c:forEach>
		<c:if test="${pageMaker.hasNext }">
			<li><a href="list.do?page=${pageMaker.endPageNo + 1 }">다음</a></li>
		</c:if>

	</ul>
 <%@ include file="footer.jspf" %>

</body>
</html>
