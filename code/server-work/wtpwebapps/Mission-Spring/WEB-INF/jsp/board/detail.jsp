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
<script>
	function clickBtn(type){
		switch (type) {
		case 'U':
			location.href = "updateForm.jsp?no=${ board.no }"
			break;
		case 'D':
			if(confirm('게시글을 삭제할까요?'))
				location.href = "delete.jsp?no=${ board.no }"
			break;
		case 'L':
			location.href = "${ pageContext.request.contextPath}/board"
			break;
		}		
	}
	
	
	function doDownload(fsn, fon){
		
		/* 폼태그로 전송하려니, 제출할 submit 버튼이 없어서 문제이기 때문에, uri 뒤에 넘겨주는 방식을 선택했음 */
		location.href = "fileDownload.jsp?fsn=" + fsn+"&fon=" + fon
		console.log(fon)
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
		<h2>게시판 상세</h2>
		<hr width="100%">
		
		<table style="width:100%;">
			<tr>
				<th width="25%">번호</th>
				<td><c:out value="${ board.no }"/></td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td><c:out value="${ board.title }"/></td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td><c:out value="${ board.writer }"/>
				</td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td><c:out value="${ board.content }"/></td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td><c:out value="${ board.viewCnt }"/></td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td><c:out value="${ board.regDate }"/></td>
			</tr>
			<%-- <tr>
				<th>첨부파일</th>
				<td>
				forEach태그로 첨부파일의 갯수만큼만 출력한다.
					<c:forEach items="${fileList }" var="file">
						
						파일명이 마크업태그일수도 있으니 out태그로 출력한다					
					<a href="/Mission-Web/upload/${ file.fileSaveName }">
					<a href="javascript:doDownload('${file.fileSaveName }', '${file.fileOriName }')">
							<c:out value="${ file.fileOriName }"/>
						</a>
						(${ file.fileSize } bytes)
						
						<br>
					</c:forEach>
				
				</td>
			</tr> --%>
		</table>
		
		<br>
		
		<div class="downBtnZone">
			<%--			
			<button onclick="location.href='list.jsp'">목록</button>
			 --%>
			<%-- 작성자이면 수정/삭제가 가능해야함 --%>			
			<%--
			<button onclick="location.href='updateForm.jsp?no=${ board.no }'">수정</button>
			<button onclick="location.href='delete.jsp?no=${ board.no }'">삭제</button>
			 --%>
			 
			<c:if test="${ board.writer eq sessionScope.userVO.id }">
				<button onclick="clickBtn('U')">수정</button>
				<button onclick="clickBtn('D')">삭제</button>
			</c:if>
			<button onclick="clickBtn('L')">목록</button>
		</div>
		
		<hr>
			댓글 : <input type="text" name="comment" />
			작성자 : <input type="text" name="writer" />
			<button>댓글 등록</button>
		<hr>
		
	</section>
	
	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp" %> --%>
	</footer>
</body>
</html>
