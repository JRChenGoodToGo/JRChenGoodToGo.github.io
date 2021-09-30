<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register page</title>
<link rel="stylesheet" type="text/css" href="../css/main.css" />
</head>
<body>

	<h3>Welcome to Register</h3>

<form action="<c:url value="/pages/register.controller" />" method="post">
	<table>
		<tr>
			<td>Account :</td>
			<td><input type="text" name="account" value="${param.account}"></td>
			<td><span class="error">${errors.account}</span></td>
		</tr>
		<tr>
			<td>E-mail :</td>
			<td><input type="text" name="email" value="${param.email}"></td>
			<td><span class="error">${errors.email}</span></td>
		</tr>
		
		<tr>
			<td>Password :</td>
			<td><input type="text" name="passwd"
				value="${param.passwd}"></td>
			<td><span class="error">${errors.passwd}</span></td>
		</tr>
		<tr>
			<td>Password reInput :</td>
			<td><input type="text" name="passwdConfirm"
				value="${param.passwdConfirm}"></td>
			<td><span class="error">${errors.passwdConfirm}</span></td>
		</tr>
		
		<tr>
			<td>Name :</td>
			<td><input type="text" name="name"
				value="${param.name}"></td>
			<td><span class="error">${errors.name}</span></td>
			
		</tr>
		
		<tr>
			<td class="error">${errors.nullData }</td>
			<td align="right"><input type="submit" value="send"></td>
			<td><a href="/secure/login.page" > 已是會員... </a></td>
		</tr>

	</table>
</form>
<h4><a href="/pages/searching.page">searching</a></h4>

</body>
</html>