<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>Orderinfo</title>
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

<h3>Orderinfo Table</h3>

<form name="myForm" action="<c:url value="/pages/orderinfo.controller" />" method="get">
<table>
	<tr>
		<td>orderId : </td>
		<td><input type="text" name="orderId" value="${param.orderId}"></td>
	
	</tr>
	<tr>
		<td>name : </td>
		<td><input type="text" name="name" value="${param.name}"></td>
		<td><span class="error">${errors.name}</span></td>
		<td></td>
	</tr>
		<tr>
		<td>identification : </td>
		<td><input type="text" name="identification" value="${param.identification}"></td>
		<td><span class="error">${errors.identification}</span></td>
		<td></td>
	</tr>
		<tr>
		<td>email : </td>
		<td><input type="text" name="email" value="${param.email}"></td>
		<td><span class="error">${errors.email}</span></td>
		<td></td>
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
		<td></td>
	</tr>
		<tr>
		<td>purchaseAmt : </td>
		<td><input type="text" name="purchaseAmt" value="${param.purchaseAmt}"></td>
		<td><span class="error">${errors.purchaseAmt}</span></td>
		<td></td>
	</tr>
	<tr>
		<td>payment : </td>
		<td><input type="text" name="payment" value="${param.payment}"></td>
		<td><span class="error">${errors.payment}</span></td>
		<td></td>
	</tr>
	<tr>
		<td>memberId : </td>
		<td><input type="text" name="memberId" value="${param.memberId}"></td>
		<td><span class="error">${errors.memberId}</span></td>
		<td></td>
	</tr>
	<tr>
		<td>activityId : </td>
		<td><input type="text" name="activityId" value="${param.activityId}"></td>
		<td><span class="error">${errors.activityId}</span></td>
		<td></td>
	</tr>

	<tr>
		<td>
			<input type="submit" name="orderinfo" value="Insert">
			<input type="submit" name="orderinfo" value="Update">
		</td>
		<td>
			<input type="submit" name="orderinfo" value="Delete">
			<input type="submit" name="orderinfo" value="Select">
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
<h3>Insert ORDERINFO Table Success</h3>
<table border="1">
	<tr><td>orderId</td><td>${insert.orderId}</td></tr>
	<tr><td>name</td><td>${insert.name}</td></tr>
		<tr><td>identification</td><td>${insert.identification}</td></tr>
	<tr><td>email</td><td>${insert.email}</td></tr>
		<tr><td>ticketKind</td><td>${insert.ticketKind}</td></tr>
	<tr><td>cost</td><td>${insert.cost}</td></tr>
		<tr><td>purchaseAmt</td><td>${insert.purchaseAmt}</td></tr>
	<tr><td>payment</td><td>${insert.payment}</td></tr>
	<tr><td>memberId</td><td>${insert.memberId}</td></tr>
	<tr><td>activityId</td><td>${insert.activityId}</td></tr>
	
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty update}">
<h3>Update taginfo Table Success</h3>
<table border="1">
	<tr><td>orderId</td><td>${update.orderId}</td></tr>
	<tr><td>name</td><td>${update.name}</td></tr>
		<tr><td>identification</td><td>${update.identification}</td></tr>
	<tr><td>email</td><td>${update.email}</td></tr>
		<tr><td>ticketKind</td><td>${update.ticketKind}</td></tr>
	<tr><td>cost</td><td>${update.cost}</td></tr>
		<tr><td>purchaseAmt</td><td>${update.purchaseAmt}</td></tr>
	<tr><td>payment</td><td>${update.payment}</td></tr>
	<tr><td>memberId</td><td>${update.memberId}</td></tr>
	<tr><td>activityId</td><td>${update.activityId}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

</body>
</html>