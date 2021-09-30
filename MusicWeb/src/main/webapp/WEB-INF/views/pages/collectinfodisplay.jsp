<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />

<title>collectInfo</title>
</head>
<body>

<h3>collectInfo</h3>
<h3>Select collectInfo Table Result : ${fn:length(select)} row(s) selected</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>

		<th>memberId</th>

		<th>activityid</th>

	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="row" items="${select}">
		<c:url value="/pages/collectinfo.page" var="path">
	
			<c:param name="memberid" value="${row.memberid}" />

			<c:param name="activityid" value="${row.activityid}" />

		</c:url>
	<tr>
		<td><a href="${path}">${row.memberid}</a></td>

		<td>${row.activityid}</td>

	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/pages/collectinfo.page" />">collectInfo Table</a></h3>

</body>
</html>