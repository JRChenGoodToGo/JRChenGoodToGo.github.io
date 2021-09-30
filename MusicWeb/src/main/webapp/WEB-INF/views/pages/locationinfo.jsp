<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>LocationInfo</title>
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

<h3>LocationInfo Table</h3>

<form name="myForm" action="<c:url value="/pages/locationinfo.controller" />" method="get">
<table>
	<tr>
		<td>locationid : </td>
		<td><input type="text" name="locationid" value="${param.locationid}"></td>
		<td><span class="error">${errors.locationid}</span></td>
	</tr>
	<tr>
		<td>showAddr : </td>
		<td><input type="text" name="showAddr" value="${param.showAddr}"></td>
        <td><span class="error">${errors.showAddr}</span></td>
		<td></td>
	</tr>

	<tr>
		<td>showPlace : </td>
		<td><input type="text" name="showplace" value="${param.showplace}"></td>
		<td><span class="error">${errors.showplace}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="locationInfo" value="Insert">
			<input type="submit" name="locationInfo" value="Update">
		</td>
		<td>
			<input type="submit" name="locationInfo" value="Delete">
			<input type="submit" name="locationInfo" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>

<h3><span class="error">${errors.action}</span></h3>

<c:if test="${not empty delete}">
<h3>Delete locationinfo Table Success : ${delete} row deleted</h3>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty insert}">
<h3>Insert locationinfo Table Success</h3>
<table border="1">
	<tr><td>locationid</td><td>${insert.locationid}</td></tr>
	<tr><td>showaddr</td><td>${insert.showaddr}</td></tr>
	<tr><td>showplace</td><td>${insert.showplace}</td></tr>

</table>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty update}">
<h3>Update locationinfo Table Success</h3>
<table border="1">
	<tr><td>locationid</td><td>${update.locationid}</td></tr>
	<tr><td>showaddr</td><td>${update.showaddr}</td></tr>
	<tr><td>showplace</td><td>${update.showplace}</td></tr>

</table>
<script type="text/javascript">clearForm();</script>
</c:if>

</body>
</html>