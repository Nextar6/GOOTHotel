<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>${vo.eventTitle }</title>
</head>
<body>
	<h2>글 보기</h2>
	<div>
		<p>글 번호 : ${vo.eventNo }</p>
	</div>
	<div>
		<p>제목
			<input type="text" value="${vo.eventTitle }" readonly>
		</p>
	</div>
	<div>
		<p>작성자 : ${vo.writer }</p>
		<p>작성일 : ${vo.eventCdate }</p>
	</div>
	<div>
		<textarea rows="20" cols="120" readonly>${vo.eventContent }</textarea>
	</div>
	<a href="event?page=${page }"><input type="button" value="글 목록"></a>
	<a href="event-update?eventNo=${vo.eventNo }&page=${page }"><input type="button" value="글 수정"></a>
	<a href="delete?board=event&boardNo=${vo.eventNo }"><input type="button" value="글 삭제"></a>

	<!-- POST 방식으로 데이터를 전송하려면 form을 사용해야 한다. -->

</body>
</html>









