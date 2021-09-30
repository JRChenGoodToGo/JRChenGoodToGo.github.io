<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>ticketsetting</title>
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

<h3>ticketsetting Table</h3>

<form name="myForm" action="<c:url value="/pages/Ticketsetting.controller" />" method="get">
<table>
	<tr>
		<td>id : </td>
		<td><input type="text" name=id value="${param.id}"></td>
		<td><span class="error">${errors.id}</span></td>
	</tr>
	<tr>
		<td>ticketKind : </td>
		<td><input type="text" name="ticketKind" value="${param.ticketKind}"></td>
		<td><span class="error">${errors.ticketKind}</span></td>
		<td></td>
	</tr>

	<tr>
		<td>cost : </td>
		<td><input type="text" name="cost" value="${param.cost}"></td>
		<td><span class="error">${errors.cost}</span></td>
	</tr>
	<tr>
		<td>storage : </td>
		<td><input type="text" name="storage" value="${param.storage}"></td>
		<td><span class="error">${errors.storage}</span></td>
	</tr>
	<tr>
		<td>soldDeadline : </td>
		<td><input type="text" name="soldDeadline" value="${param.soldDeadline}"></td>
		<td><span class="error">${errors.soldDeadline}</span></td>
		
	</tr>
	<tr>
		<td>activityId : </td>
		<td><input type="text" name="activityId" value="${param.activityId}"></td>
		<td><span class="error">${errors.activityId}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="ticketsetting" value="Insert">
			<input type="submit" name="ticketsetting" value="Update">
		</td>
		<td>
			<input type="submit" name="ticketsetting" value="Delete">
			<input type="submit" name="ticketsetting" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>

<h3><span class="error">${errors.action}</span></h3>

<c:if test="${not empty delete}">
<h3>Delete ticketsetting Table Success : ${delete} row deleted</h3>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty insert}">
<h3>Insert ticketsetting Table Success</h3>
<table border="1">
	<tr><td>id</td><td>${insert.id}</td></tr>
	<tr><td>ticketKind</td><td>${insert.ticketKind}</td></tr>
	<tr><td>cost</td><td>${insert.cost}</td></tr>
	<tr><td>storage</td><td>${insert.storage}</td></tr>
	<tr><td>soldDeadline</td><td>${insert.soldDeadline}</td></tr>
	<tr><td>activityId</td><td>${insert.activityId}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty update}">
<h3>Update ticketsetting Table Success</h3>
<table border="1">
	<tr><td>id</td><td>${update.id}</td></tr>
	<tr><td>ticketKind</td><td>${update.ticketKind}</td></tr>
	<tr><td>cost</td><td>${update.cost}</td></tr>
	<tr><td>storage</td><td>${update.storage}</td></tr>
	<tr><td>soldDeadline</td><td>${update.soldDeadline}</td></tr>
	<tr><td>activityId</td><td>${update.activityId}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

</body>
</html>