<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />

<title>ticketsetting</title>
</head>
<body>

<h3>ticketsetting</h3>
<h3>Select ticketsetting Table Result : ${fn:length(select)} row(s) selected</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>id</th>
		<th>ticketKind</th>
		<th>cost</th>
		<th>storage</th>
		<th>soldDeadline</th>
		<th>activityId</th>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="row" items="${select}">
		<c:url value="/pages/ticketsetting.page" var="path">
			<c:param name="id" value="${row.id}" />
			<c:param name="ticketKind" value="${row.ticketKind}" />
			<c:param name="cost" value="${row.cost}" />
			<c:param name="storage" value="${row.storage}" />
			<c:param name="soldDeadline" value="${row.soldDeadline}" />
			<c:param name="activityId" value="${row.activityId}" />
		</c:url>
	<tr>
		<td><a href="${path}">${row.id}</a></td>
		<td>${row.ticketKind}</td>
		<td>${row.cost}</td>
		<td>${row.storage}</td>
		<td>${row.soldDeadline}</td>
		<td>${row.activityId}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/pages/ticketsetting.page" />">ticketsetting Table</a></h3>

</body>
</html>