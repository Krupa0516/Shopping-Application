<%@page import="java.util.List"%>
<%@page import="linkcode.shop.admin.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {background-color : Lightgreen;}
</style>
</head>
<body>
<%!List<Product> lst = null;
	Product prod = null;%>

	<%
	lst =(List<Product>) session.getAttribute("prodlst");
		session.invalidate();
%>
<table border="3px" background="gray">
	<%		
		for(Product prod:lst){
	%>
	
		<tr>
			<td><%=prod.getProdid()%></td>
			<td><%=prod.getProdname()%></td>
			<td><%=prod.getProdprice()%></td>
			<td><%=prod.getProdqty()%></td>
		</tr>

	<%} %>
		</table>
				<a href="Admin.html">Admin page</a>
</body>
</html>