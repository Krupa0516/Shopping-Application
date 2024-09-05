<%@page import="linkcode.shop.admin.model.Product"%>
<%@page import="java.util.List"%>
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
<form action = "Searchproduct">
Enter Product Id<input type = "text" name= "prodid"><br>
<input type = "submit" value = "Search Here">
</form>
<%!List<Product>lst=null;
Product prod=null;%>

<%
Object o=session.getAttribute("prod");
if(o instanceof List){
	lst=(List<Product>)o;
	session.invalidate();
	
	if(lst!=null){
		prod=lst.get(0);
		lst=null;
		%>
		<table border="3px" background ="gray">
		<tr>
		<td><%=prod.getProdid() %></td>
		<td><%=prod.getProdname() %></td>
		<td><%=prod.getProdprice() %></td>
		<td><%=prod.getProdqty() %></td>
		</table>
		<% 
	}}
else{
	String str=(String) o;
	out.println(str);
 }
%>
<a href=Admin.html>Admin Page</a>
</body>
</html>