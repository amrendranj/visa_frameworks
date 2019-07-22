<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Form</title>
<style type="text/css">
	.errClass{
		color: red;
	}
</style>
</head>
<body>
	<h1>Product Form</h1>
	<form:form method="post" action="addProduct.do" commandName="product"> 
		Name<form:input path="name"/><form:errors path="name" cssClass = "errClass"></form:errors></br>
		Category<form:input path="category" /><form:errors path="category" cssClass = "errClass"></form:errors></br>
		Price<form:input path="price" /><form:errors path="price" cssClass = "errClass"></form:errors></br>				
		Count<form:input path="count" /><form:errors path="count" cssClass = "errClass"></form:errors></br>
		<button type="submit">Add Product</button>
	</form:form>
</body>
</html>