<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />

<title>TimeInfo</title>
</head>
<body>

<h3>TimeInfo</h3>
<h3>Select TimeInfo Table Result : ${fn:length(select)} row(s) selected</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>id</th>
		<th>showdate</th>
		<th>entertime</th>
		<th>showtime</th>
		<th>showtotaltime</th>
		<th>activityid</th>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="row" items="${select}">
		<c:url value="/pages/timeinfo.page" var="path">
			<c:param name="id" value="${row.id}" />
			<c:param name="showdate" value="${row.showdate}" />
			<c:param name="entertime" value="${row.entertime}" />
			<c:param name="showtime" value="${row.showtime}" />
			<c:param name="showtotaltime" value="${row.showtotaltime}" />
			<c:param name="activityid" value="${row.activityid}" />
		</c:url>
	<tr>
		<td><a href="${path}">${row.id}</a></td>
		<td>${row.showdate}</td>
		<td>${row.entertime}</td>
		<td>${row.showtime}</td>
		<td>${row.showtotaltime}</td>
		<td>${row.activityid}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/pages/timeinfo.page" />">TimeInfo Table</a></h3>

</body>
</html>