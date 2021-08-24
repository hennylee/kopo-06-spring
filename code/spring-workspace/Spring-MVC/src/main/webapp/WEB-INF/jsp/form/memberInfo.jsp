<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보</h2>
	
	<ul>
		<li>id : ${memberVO.id }</li>
		<li>pw : ${memberVO.pw }</li>
		<li>name : ${memberVO.name }</li>
	</ul>
	<ul>
		<li>id : ${vo.id }</li>
		<li>pw : ${vo.pw }</li>
		<li>name : ${vo.name }</li>
	</ul>
	
	
</body>
</html>