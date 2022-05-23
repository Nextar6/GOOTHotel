<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td{
	border-style : solid;
	border-width : 1px;
	text-align : center;
}
ul {
	list-style-type : none;
}

li {
	display : inline-block;
}

</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>1:1 문의 내역 관리자 페이지</title>
</head>
<body>


<h1>회원 1:1 문의 내역</h1>

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
		<!-- 관리자 1:1문의페이지 리플이 달려있으면 표시-->
			<c:forEach var="vo" items="${inqueryList }">
			
				<tr>
					<td>${vo.inqueryNo }</td>
					<td><a href="inquery-detail?inqueryNo=${vo.inqueryNo }&page=${pageMaker.criteria.page}">${vo.inqueryTitle }</a>
					<c:if test="${vo.inqueryReplyCount > 0 }">&#11093;답변 작성완료&#11093;</c:if></td>
					<td>${vo.memberUserid }</td>
					<fmt:formatDate value="${vo.inqueryCdate }"
						pattern="yyyy-MM-dd HH:mm:ss" var="inqueryCdate" />
					<td>${inqueryCdate }</td>
				</tr>
	
			</c:forEach>
		</tbody>
	</table>

	<hr>
	<ul>
		<c:if test="${pageMaker.hasPrev }">
			<li><a href="inquery-admin?page=${pageMaker.startPageNo - 1 }">이전</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPageNo }"
			end="${pageMaker.endPageNo }" var="num">

			<li><a href="inquery-admin?page=${num }">${num }</a></li>
		</c:forEach>
		<c:if test="${pageMaker.hasNext }">
			<li><a href="inquery-admin?page=${pageMaker.endPageNo + 1 }">다음</a></li>
		</c:if>

	</ul>
<input type="hidden" id="deleteAlert" value="${delete_result }">

<script type="text/javascript">
	$(document).ready(function(){
		var deleteResult = $('#deleteAlert').val();
		if(deleteResult == 'success') {
			alert('글 삭제 성공 !')
		}
				
	})

</script>

</body>
</html>

