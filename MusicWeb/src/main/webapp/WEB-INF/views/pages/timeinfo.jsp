<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>TIMEINFO</title>
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

<h3>TIMEINFO Table</h3>

<form name="myForm" action="<c:url value="/pages/timeinfo.controller" />" method="get">
<table>
	<tr>
		<td>id : </td>
		<td><input type="text" name="id" value="${param.id}"></td>
		<td><span class="error">${errors.id}</span></td>
	</tr>
	<tr>
		<td>showDate : </td>
		<td><input type="text" name="showdate" value="${param.showdate}"></td>
		<td><span class="error">${errors.showdate}</span></td>
		<td></td>
	</tr>

	<tr>
		<td>entertime : </td>
		<td><input type="text" name="entertime" value="${param.entertime}"></td>
		<td><span class="error">${errors.entertime}</span></td>
	</tr>
	<tr>
		<td>showtime : </td>
		<td><input type="text" name="showtime" value="${param.showtime}"></td>
		<td><span class="error">${errors.showtime}</span></td>
	</tr>
	<tr>
		<td>showtotaltime : </td>
		<td><input type="text" name="showtotaltime" value="${param.showtotaltime}"></td>
		<td><span class="error">${errors.showtotaltime}</span></td>
	</tr>
		<tr>
		<td>activityid : </td>
		<td><input type="text" name="activityid" value="${param.activityid}"></td>
		<td><span class="error">${errors.activityid}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="timeinfo" value="Insert">
			<input type="submit" name="timeinfo" value="Update">
		</td>
		<td>
			<input type="submit" name="timeinfo" value="Delete">
			<input type="submit" name="timeinfo" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>

<h3><span class="error">${errors.action}</span></h3>

<c:if test="${not empty delete}">
<h3>Delete timeinfo Table Success : ${delete} row deleted</h3>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty insert}">
<h3>Insert timeinfo Table Success</h3>
<table border="1">
	<tr><td>id</td><td>${insert.id}</td></tr>
	<tr><td>showdate</td><td>${insert.showdate}</td></tr>
	<tr><td>enterTime</td><td>${insert.entertime}</td></tr>
	<tr><td>showtime</td><td>${insert.showtime}</td></tr>
	<tr><td>showtotaltime</td><td>${insert.showtotaltime}</td></tr>
	<tr><td>activityid</td><td>${insert.activityid}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty update}">
<h3>Update TIMEINFO Table Success</h3>
<table border="1">
	<tr><td>id</td><td>${update.id}</td></tr>
	<tr><td>showdate</td><td>${update.showdate}</td></tr>
	<tr><td>enterTime</td><td>${update.entertime}</td></tr>
	<tr><td>showtime</td><td>${update.showtime}</td></tr>
	<tr><td>showtotaltime</td><td>${update.showtotaltime}</td></tr>
	<tr><td>activityid</td><td>${update.activityid}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

</body>
</html>