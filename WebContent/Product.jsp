<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {background-color : Lightgreen;}
div
{
 color:red;
}
</style>
</head>
<body>
<%!String str=null;%>
<form action="ProductController">

<table>

<tr>
<td>Product Id</td>
<td><input type="text" name="prodid"></td>
</tr>

<tr>
<td>Product Name</td>
<td><input type="text" name="prodname"></td>
</tr>

<tr>
<td>Product Price</td>
<td><input type="text" name="prodprice"></td>
</tr>

<tr>
<td>Product Quantity</td>
<td><input type="text" name="prodqty"></td>
</tr>

<tr>
<td><input type="submit" name="Save products" value ="Save Products"></td>
</tr>
</table>
</form>

<div>

<%
   str=(String)session.getAttribute("msg");
   session.invalidate();
%>

<h1><%=str %></h1>
<a href="Admin.html">Admin Page</a>
</body>
</html>