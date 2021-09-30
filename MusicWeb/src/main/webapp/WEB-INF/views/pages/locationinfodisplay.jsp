<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />

<title>location Display</title>
</head>
<body>

<h3>Select locationinfo Table Result : ${fn:length(select)} row(s) selected</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>locationid</th>
		<th>showaddr</th>
		<th>showPlace</th>

	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="row" items="${select}">
		<c:url value="/pages/locationinfo.page" var="path">
			<c:param name="locationid" value="${row.locationid}" />
			<c:param name="showaddr" value="${row.showaddr}" />
			<c:param name="showplace" value="${row.showplace}" />

		</c:url>
	<tr>
		<td><a href="${path}">${row.locationid}</a></td>
		<td>${row.showaddr}</td>
		<td>${row.showplace}</td>

	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/pages/locationinfo.page" />">locationinfo Table</a></h3>

</body>
</html>