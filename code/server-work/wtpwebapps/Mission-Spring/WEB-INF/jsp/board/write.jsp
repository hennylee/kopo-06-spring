<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!-- spring을 활용한 예외처리를 위한 taglib -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/board.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/layout.css"/>
<style type="text/css">
.error{
	color: red
}
</style>

<script type="text/javascript" src= "${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<script>

</script>
</head>
<body>

	<header>
		<%-- <jsp:include page="/jsp/include/topMenu.jsp"/> --%>
	</header>
	
	<section>
	<div align="center">
		<hr width="100%">	
		<h2>게시글 등록폼</h2>
		<hr width="100%">	
		
		<form:form method="post" modelAttribute="boardVO">
								<!-- modelAttribute : controller에서 넘겨준 값, 5.0버전 이하에서는 다른 명칭이었다. --> 
								<!-- get과 post의 uri가 똑같기 때문에 action은 필요 없다. -->
								
			<form:hidden path="writer"/>
			<table border="1" style="width: 100%">
				<tr>
					<th>제목</th>
					<td>
						<form:input path="title"/> <!-- modelAttribute에 등록된 get메소드 -->
						<form:errors path="title" class="error"/>
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<c:out value="${ boardVO.writer }"/>
						<%-- <form:input path="writer"/> <!-- modelAttribute에 등록된 get메소드 -->
						<form:errors path="writer" class="error"/> --%>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<form:textarea rows="8" cols="60" path="content"/> <!-- modelAttribute에 등록된 get메소드 -->
						<form:errors path="content" class="error"/>
					</td>
				</tr>
			</table>
			
			<form:button type="submit">새글등록</form:button>
		</form:form>
		
	</div>
	</section>
	
	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp" %> --%>
	</footer>
	
</body>
</html>