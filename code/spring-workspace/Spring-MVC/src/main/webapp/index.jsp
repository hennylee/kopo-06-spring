<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>기본</h3>
	<ul>
		<li><a href="<%=request.getContextPath()%>/hello/hello.do">hello</a></li>
		<li><a href="<%=request.getContextPath() %>/method/method.do">method</a></li>
		<li><a href="<%=request.getContextPath() %>/form/joinForm.do">form</a></li>
	</ul>

	<h3>ResponseBody</h3>
	<ul>
		<li><a href="<%=request.getContextPath() %>/ajax/resBody.do">문자열 응답</a></li>
		<li><a href="<%=request.getContextPath() %>/ajax/resBody.json">json 응답</a></li>
		<li><a href="<%=request.getContextPath() %>/ajax/resVOBody.json">json vo 응답</a></li>
		<li><a href="<%=request.getContextPath() %>/ajax/resStringListBody.json">json List(문자열) 응답</a></li>
		<li><a href="<%=request.getContextPath() %>/ajax/resVOListBody.json">json List VO 응답</a></li>
	</ul>

	<h3>RestController</h3>
	<ul>
		<li><a href="<%=request.getContextPath() %>/ajax/restBody.do">문자열 응답</a></li>
		<li><a href="<%=request.getContextPath() %>/ajax/restBody.json">json 응답</a></li>
		<li><a href="<%=request.getContextPath() %>/ajax/restVOBody.json">json vo 응답</a></li>
		<li><a href="<%=request.getContextPath() %>/ajax/restStringListBody.json">json List(문자열) 응답</a></li>
		<li><a href="<%=request.getContextPath() %>/ajax/restVOListBody.json">json List VO 응답</a></li>
	</ul>

	<h3>File</h3>
	<ul>
		<li><a href="<%=request.getContextPath() %>/file/uploadForm.do">파일 업로드</a></li>
	</ul>
	
</body>
</html>