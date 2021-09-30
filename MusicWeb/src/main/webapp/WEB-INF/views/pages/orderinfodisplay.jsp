<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />

<title>Orderinfo</title>
</head>
<body>

<h3>Orderinfo</h3>
<h3>Select Orderinfo Table Result : ${fn:length(select)} row(s) selected</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>orderId</th>
		<th>name</th>
				<th>identification</th>
		<th>email</th>
				<th>ticketKind</th>
		<th>cost</th>
				<th>purchaseAmt</th>
		<th>payment</th>
				<th>memberId</th>
		<th>activityId</th>
	
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="row" items="${select}">
		<c:url value="/pages/orderinfo.page" var="path">
			<c:param name="orderId" value="${row.orderId}" />
			<c:param name="name" value="${row.name}" />
			<c:param name="identification" value="${row.identification}" />
			<c:param name="email" value="${row.email}" />
			<c:param name="ticketKind" value="${row.ticketKind}" />
			<c:param name="cost" value="${row.cost}" />
			<c:param name="purchaseAmt" value="${row.purchaseAmt}" />
			<c:param name="payment" value="${row.payment}" />
			<c:param name="memberId" value="${row.memberId}" />
			<c:param name="activityId" value="${row.activityId}" />

		</c:url>
	<tr>
		<td><a href="${path}">${row.orderId}</a></td>
				<td>${row.name}</td>
		<td>${row.identification}</td>
		<td>${row.email}</td>
		<td>${row.ticketKind}</td>
		<td>${row.cost}</td>
		<td>${row.purchaseAmt}</td>
		<td>${row.payment}</td>
		<td>${row.memberId}</td>
		<td>${row.activityId}</td>
		


	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/pages/orderinfo.page" />">Orderinfo Table</a></h3>

</body>
</html>