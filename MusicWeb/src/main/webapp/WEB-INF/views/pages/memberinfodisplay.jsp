<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />

<title>MemberInfo</title>
</head>
<body>

<h3>memberinfo</h3>
<h3>Select Product Table Result : ${fn:length(select)} row(s) selected</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>memberId</th>
		<th>account</th>
		<th>email</th>
		<th>passwd</th>
		<th>name</th>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="row" items="${select}">
		<c:url value="/pages/memberinfo.page" var="path">
			<c:param name="memberid" value="${row.memberid}" />
			<c:param name="account" value="${row.account}" />
			<c:param name="email" value="${row.email}" />
			<c:param name="passwd" value="${row.passwd}" />
			<c:param name="name" value="${row.name}" />
		</c:url>
	<tr>
		<td><a href="${path}">${row.memberid}</a></td>
		<td>${row.account}</td>
		<td>${row.email}</td>
		<td>${row.passwd}</td>
		<td>${row.name}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/pages/memberinfo.page" />">Product Table</a></h3>

</body>
</html>