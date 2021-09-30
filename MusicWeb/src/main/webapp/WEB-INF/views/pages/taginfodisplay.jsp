<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />

<title>taginfo</title>
</head>
<body>

<h3>taginfo</h3>
<h3>Select taginfo Table Result : ${fn:length(select)} row(s) selected</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>tagId</th>
		<th>tagName</th>
	
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="row" items="${select}">
		<c:url value="/pages/taginfo.page" var="path">
			<c:param name="tagid" value="${row.tagid}" />
			<c:param name="tagname" value="${row.tagname}" />

		</c:url>
	<tr>
		<td><a href="${path}">${row.tagid}</a></td>
		<td>${row.tagname}</td>


	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/pages/taginfo.page" />">taginfo Table</a></h3>

</body>
</html>