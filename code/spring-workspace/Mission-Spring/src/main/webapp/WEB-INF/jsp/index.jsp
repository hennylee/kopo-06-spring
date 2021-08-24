<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	${userVO } <br>
	${sessionScope.userVO }<br>
	
	<ul>
		<li><a href="${pageContext.request.contextPath }/board">보드</a></li>
		<li><a href="${pageContext.request.contextPath }/board/write">새글등록</a></li>
		
		<c:if test="${ empty userVO }">
			<li><a href="${pageContext.request.contextPath }/login">로그인</a></li>
		</c:if>
		<c:if test="${ not empty userVO }">
			<li><a href="${pageContext.request.contextPath }/logout">로그아웃</a></li>
		</c:if>
	</ul>
</body>
</html>