<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>A simple web App</title>
</head>
<body>
	<%String name=request.getParameter("name"); %>
	<p>nice to meet you <strong><%=name%></strong></p>
	<a href=index.jsp>Go back</a>
</body>
</html>