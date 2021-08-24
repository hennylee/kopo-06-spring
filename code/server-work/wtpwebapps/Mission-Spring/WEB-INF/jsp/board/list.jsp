<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/layout.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/board.css"/>
<script src="${pageContext.request.contextPath }/resources/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#addBtn').click(function(){
			location.href = "writeForm.jsp" // location 객체는 url 정보를 가지고 있음
		})
	})

	
	/* 
		매개변수로 넘어온 no는 EL 태그였다.  
		흐름상, EL태그가 해석되어 JSP가 서블릿 코드로 변환된 이후에 
		웹브라우저가 스크립트를 실행하기 때문에 가능한 것이다.  
	*/
	function doAction(no){
		
		/* 
		JSP 엔진이 JSTL을 먼저 해석하기 때문에 
		웹브라우저에는 경우에 맞는 둘 중 하나의 JS스크립트만 날라간다.  
		*/
		<c:choose>
			<c:when test="${ not empty userVO}">
				location.href = 'detail.jsp?no=' + no + '&type=list';
													// 수정 후 list의 조회수 증가시키지 않기 위한 구분자
			</c:when>
			<c:otherwise>
				/* confirm 
					확인을 누르면 => true 
					취소를 누르면 => false
				*/
				if(confirm('로그인이 필요한 서비스입니다.\n 로그인페이지로 이동하시겠습니까?'))
					location.href = "/Mission-Web/jsp/login/login.jsp"
			</c:otherwise>
		</c:choose>
	}	
	
</script>
</head>
<body>
	<header>
		<%-- <jsp:include page="/jsp/include/topMenu.jsp"/> --%>
	</header>
	
	<section>
		<div align="center">
			<hr width="100%">
			<h2>게시판 목록</h2>
			<hr width="100%">
			<br>
			
			<table style="width : 100%" class="list">
				<tr>
					<th width = "7%">번호</th>
					<th>제목</th>
					<th width = "16%">작성자</th>
					<th width = "20%">등록일</th>
				</tr>
				<c:forEach items="${list }" var="board" varStatus="loop">
					<tr <c:if test="${loop.index mod 2 ne 0 }"> class = "odd"</c:if> >
						<td>${board.no }</td> <%-- board.no는 list[index].no 와 같다 --%>
						<td>
							<a href="${pageContext.request.contextPath }/board/${ board.no }">
							
							<%--
								미 로그인 상태일 때, doAction()함수로 confirm 창을 띄우는 방법
							--%>
							
							<%-- 
								0.
								<a href="javascript:doAction(${board.no })"> 
							--%>
							
							<%--
								1.
								<a onclick="doAction()">
								문제 : href 속성이 없어서 css 효과가 적용되지 않는다. 

								2.
								<a href="#" onclick="doAction()">
								문제 : href="#"으로 설정하면, css 효과는 적용되지만 uri 뒤에 # 이 붙어서 
								좋은 방법은 아니다. 
							--%>


								<c:out value="${board.title }"/>
							<%-- 
								코드링크를 악성코드 링크로 변환시키지 않는 방법 
									- out태그를 활용한다.
									- out태그의 ecscapeXml 속성을 통해 링크를 문자열로 변환시키게 되기 때문에 
									악성링크를 방지할 수 있는 것이다. 
							--%>
							</a>
						</td>
						<td>${board.writer }</td>
						<td>${board.regDate }</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			
			<c:if test="${ not empty userVO }">
				<div class="downBtnZone">
					<button id="addBtn">새글등록</button>
				</div>
			</c:if>

		</div>
	</section>
	
	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp" %> --%>
	</footer>
</body>
</html>

