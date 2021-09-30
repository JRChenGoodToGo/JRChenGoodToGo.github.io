<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>Taginfo</title>
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

<h3>Taginfo Table</h3>

<form name="myForm" action="<c:url value="/pages/taginfo.controller" />" method="get">
<table>
	<tr>
		<td>tagid : </td>
		<td><input type="text" name="tagid" value="${param.memberid}"></td>
		<td><span class="error">${errors.tagid}</span></td>
	</tr>
	<tr>
		<td>tagname : </td>
		<td><input type="text" name="tagname" value="${param.tagname}"></td>
		<td><span class="error">${errors.tagname}</span></td>
		<td></td>
	</tr>

	<tr>
		<td>
			<input type="submit" name="tagInfo" value="Insert">
			<input type="submit" name="tagInfo" value="Update">
		</td>
		<td>
			<input type="submit" name="tagInfo" value="Delete">
			<input type="submit" name="tagInfo" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>

<h3><span class="error">${errors.action}</span></h3>

<c:if test="${not empty delete}">
<h3>Delete taginfo Table Success : ${delete} row deleted</h3>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty insert}">
<h3>Insert taginfo Table Success</h3>
<table border="1">
	<tr><td>tagid</td><td>${insert.tagid}</td></tr>
	<tr><td>tagname</td><td>${insert.tagname}</td></tr>
	
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty update}">
<h3>Update taginfo Table Success</h3>
<table border="1">
	<tr><td>tagid</td><td>${update.tagid}</td></tr>
	<tr><td>tagname</td><td>${update.tagname}</td></tr>

</table>
<script type="text/javascript">clearForm();</script>
</c:if>

</body>
</html>