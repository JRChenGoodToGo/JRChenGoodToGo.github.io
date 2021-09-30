<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>Memberinfo</title>
<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
</script>
</head>
<body>

<h3>Welcome  ${user.memberid}</h3>

<h3>MEM Table</h3>

<form name="myForm" action="<c:url value="/pages/memberinfo.controller" />" method="get">
<table>
	<tr>
		<td>memberid : </td>
		<td><input type="text" name="memberid" value="${param.memberid}"></td>
		<td><span class="error">${errors.memberid}</span></td>
	</tr>
	<tr>
		<td>ACCOUNT : </td>
		<td><input type="text" name="account" value="${param.account}"></td>
		<td></td>
	</tr>

	<tr>
		<td>email : </td>
		<td><input type="text" name="email" value="${param.email}"></td>
		<td><span class="error">${errors.email}</span></td>
	</tr>
	<tr>
		<td>passwd : </td>
		<td><input type="text" name="passwd" value="${param.passwd}"></td>
		<td><span class="error">${errors.passwd}</span></td>
	</tr>
	<tr>
		<td>name : </td>
		<td><input type="text" name="name" value="${param.name}"></td>
		<td><span class="error">${errors.name}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="memberInfo" value="Insert">
			<input type="submit" name="memberInfo" value="Update">
		</td>
		<td>
			<input type="submit" name="memberInfo" value="Delete">
			<input type="submit" name="memberInfo" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>

<h3><span class="error">${errors.action}</span></h3>

<c:if test="${not empty delete}">
<h3>Delete Product Table Success : ${delete} row deleted</h3>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty insert}">
<h3>Insert memberInfo Table Success</h3>
<table border="1">
	<tr><td>memberid</td><td>${insert.memberid}</td></tr>
	<tr><td>account</td><td>${insert.account}</td></tr>
	<tr><td>email</td><td>${insert.email}</td></tr>
	<tr><td>passwd</td><td>${insert.passwd}</td></tr>
	<tr><td>name</td><td>${insert.name}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty update}">
<h3>Update memberInfo Table Success</h3>
<table border="1">
	<tr><td>memberid</td><td>${update.memberid}</td></tr>
	<tr><td>account</td><td>${update.account}</td></tr>
	<tr><td>email</td><td>${update.email}</td></tr>
	<tr><td>passwd</td><td>${update.passwd}</td></tr>
	<tr><td>name</td><td>${update.name}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

</body>
</html>