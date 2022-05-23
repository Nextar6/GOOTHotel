<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">


table, th, td {
	
	text-align: center;
}

ul {
	list-style-type: none;
}

li {
	display: inline-block;
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
<h1 style="float: left; color: white;">공지사항</h1>


	
	<div style="background-color: #1abc9c; padding: 25px; text-align: right">

		<form id="searchFrom" action="anounce" method="get">
		<select name="pagingCount">
			<option value="5" selected>5
			<option value="10">10
			<option value="20">20
		</select>
			<input type="date"> <select name="select">
				<option value="titleOrContent">제목+내용
				<option value="writer">작성자
			</select> <input type="text" name="keyword" id="keyword" placeholder="search">
			<input type="submit" value="검색">
		</form>

	</div>
	<a href="register"><input type="button" value="글작성" style="width: auto; float: right;"></a>
	<br>


	<hr>


	<table class="type">
		<thead>
			<tr>
				<th  style="width: 60px">번호</th>
				<th  style="width: 700px">제목</th>
				<th  style="width: 120px">작성자</th>
				<th  style="width: 100px">작성일</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="vo" items="${anounceList }">
				<tr>
					<td>${vo.anounceNo }</td>
					<td><a
						href="anounce-detail?anounceNo=${vo.anounceNo }&page=${pageMaker.criteria.page}">${vo.anounceTitle }</a></td>
					<td>${vo.writer }</td>
					<fmt:formatDate value="${vo.anounceCdate }"
						pattern="yyyy-MM-dd HH:mm:ss" var="anounceCdate" />
					<td>${anounceCdate }</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<hr>
	<!-- 에러발견 TODO 아래 링크 검색시 url경로 정리 페이징처리 완료할것 4.28 -->
	<!-- 5.02 검색페이징 처리 완료 c:choose 사용 keyword값 page 보내주기-->
	<ul>
		<c:if test="${pageMaker.hasPrev }">
			<li><a href="anounce?page=${pageMaker.startPageNo - 1 }">이전</a></li>
		</c:if>


		<c:forEach begin="${pageMaker.startPageNo }"
			end="${pageMaker.endPageNo }" var="num">
			<c:choose>
				<c:when test="${select != null }">
					<li><a
						href="anounce?page=${num }&keyword=${keyword}&select=${select}&pagingCount=${pagingCount}">${num }</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="anounce?page=${num }&pagingCount=${pagingCount}">${num }</a></li>
				</c:otherwise>

			</c:choose>

		</c:forEach>


		<c:if test="${pageMaker.hasNext }">
			<li><a href="anounce?page=${pageMaker.endPageNo + 1 }">다음</a></li>
		</c:if>
	</ul>
	<%@ include file="footer.jspf"%>

	<script type="text/javascript">
		
	</script>
</body>
</html>
