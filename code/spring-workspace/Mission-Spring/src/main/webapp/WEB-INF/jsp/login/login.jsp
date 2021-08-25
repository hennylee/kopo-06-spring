<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/layout.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/board.css" />
<script src="<%=request.getContextPath()%>/resources/js/myJS.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	/* 
	forward했을때, 또는 sendRedirect했을때
	alert를 띄우는 방법(비추)
	
	*/
	
	if ('${msg}')
		alert('${msg}')
	
	/*
	window.onload = function(){
		if('${param.msg}' != ''){
			alert('${param.msg}')
		}
	} 
	*/
	
	$(function(){
		let cId = getCookie("cookieId");
		
		if(cId){
			$('#id').val(cId);
			$('#rememberId').attr("checked", true);
		}
	});
	
	

	// form validation
	function checkForm(){
		let f = document.loginForm
		let id = f.id
		let password = f.password
		let rememberId = f.rememberId
		
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
		
		// 아이디 저장 여부
		if(rememberId.checked){
			rememberId.value = true;
			setCookie("cookieId", id.value, 7);
		}
		else{
			rememberId.value = false;
			deleteCookie("cookieId");
		}
		
		return true
	}
	
	// 쿠키 저장
	function setCookie(cookieName, value, exdays){ 
		let exdate = new Date(); 
		exdate.setDate(exdate.getDate() + exdays); // 쿠키 저장 기간 
		let cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString()); 
		document.cookie = cookieName + "=" + cookieValue; 
	}

	// 쿠키 얻기
	function getCookie(cookieName) { 
		cookieName = cookieName + '='; 
		let cookieData = document.cookie; 
		let start = cookieData.indexOf(cookieName); 
		let cookieValue = ''; 
		if(start != -1) { 
			start += cookieName.length; 
			let end = cookieData.indexOf(';', start); 
			if(end == -1)
				end = cookieData.length; 
			cookieValue = cookieData.substring(start, end); 
		} 
		return unescape(cookieValue); 
	}

	// 쿠키 삭제
	function deleteCookie(cookieName) { 
		let expireDate = new Date(); 
		expireDate.setDate(expireDate.getDate() - 1); 
		document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString(); 
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

			<form:form method="post" name="loginForm"
				onsubmit="return checkForm()">
				<table style="width: 40%">
					<tr>
						<th>ID</th>
						<td><input type="text" name="id" id="id"></td>
					</tr>
					<tr>
						<th>PW</th>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="checkbox" name="rememberId" id="rememberId" value=""> 아이디저장
						</td>
					</tr>
				</table>
				<br>
				<input type="submit" value="로그인">
			</form:form>
		</div>
	</section>

	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp" %> --%>
	</footer>
</body>
</html>