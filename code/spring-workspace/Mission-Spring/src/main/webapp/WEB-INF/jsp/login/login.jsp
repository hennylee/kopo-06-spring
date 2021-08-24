<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/layout.css"/>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/board.css"/>
<script src="<%= request.getContextPath() %>/resources/js/myJS.js"></script>
<script type="text/javascript">
	/* 
	forward했을때, 또는 sendRedirect했을때
	alert를 띄우는 방법(비추)
	
	*/
	
	if ('${msg}')
		alert('${msg}')
	
	window.onload = function(){
		if('${param.msg}' != ''){
			alert('${param.msg}')
		}
	} 

	function checkForm(){
		let f = document.loginForm
		let id = f.id
		let password = f.password
		
		if(isNull(id, '아이디를 입력하세요'))
			return false
		
		if(isNull(password, '패스워드를 입력하세요'))
			return false
		
		/*
		if(id.value == ''){
			alert('아이디를 입력하세요')
			id.focus()
			return false
		}
		*/
		
		/*
		if(password.value == ''){
			alert('패스워드를 입력하세요')
			password.focus()
			return false
		}
		*/
		
		return true
	}
</script>

</head>
<body>
	<header>
		<%-- <jsp:include page="/jsp/include/topMenu.jsp"/> --%>
	</header>
	
	<section>
		<div align="center">
			<hr>
			<h2>로그인</h2>
			<hr>
			
			<br>
			
			<form method="post" name="loginForm" onsubmit="return checkForm()">
				<table style="width: 40%">
					<tr>
						<th>ID</th>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<th>PW</th>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="checkbox"> 아이디저장
						</td>
					</tr>
				</table>
				<br>
				<input type="submit" value="로그인">
			</form>
		</div>
	</section>
	
	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp" %> --%>
	</footer>
</body>
</html>