<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />

<title>Activityinfo Display</title>
</head>
<body>

	<h3>Select Activityinfo Table Result : ${fn:length(select)} row(s) selected</h3>
	<c:if test="${not empty select}">
		<table>
			<thead>
				<tr>
					<th>activityid</th>
					<th>tagid</th>
					<th>bandpost</th>
					<th>host</th>
					<th>player</th>
					<th>theme</th>
					<th>subtitle</th>
					<th>activityintro</th>
					<th>bandIntro</th>
					<th>locationId</th>
					<th>tape</th>
					<th>uploadTime</th>
					<th>purchaseWeb</th>
					<th>memberId</th>
                    <th>clickAmt</th>
                    <th>photo</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="row" items="${select}">
					<c:url value="/pages/activityinfo.page" var="path">
						<c:param name="activityid" value="${row.activityid}" />
						<c:param name="tagid" value="${row.tagid}" />
						<c:param name="bandpost" value="${row.bandpost}" />
						<c:param name="host" value="${row.host}" />
						<c:param name="player" value="${row.player}" />
						<c:param name="theme" value="${row.theme}" />
						<c:param name="subtitle" value="${row.subtitle}" />
						<c:param name="activityintro" value="${row.activityintro}" />
						<c:param name="bandIntro" value="${row.bandIntro}" />
						<c:param name="locationId" value="${row.locationId}" />
						<c:param name="tape" value="${row.tape}" />
						<c:param name="uploadTime" value="${row.uploadTime}" />
						<c:param name="purchaseWeb" value="${row.purchaseWeb}" />
						<c:param name="memberId" value="${row.memberId}" />
                        <c:param name="clickAmt" value="${row.clickAmt}" />
                        <c:param name="photo" value="${row.photo}" />
					</c:url>
					<tr>
						<td><a href="${path}">${row.activityid}</a></td>
						<td>${row.tagid}</td>
						<td>${row.bandpost}</td>
						<td>${row.host}</td>
						<td>${row.player}</td>
						<td>${row.theme}</td>
						<td>${row.subtitle}</td>
						<td>${row.activityintro}</td>
						<td>${row.bandIntro}</td>
						<td>${row.locationId}</td>
						<td>${row.tape}</td>
						<td>${row.uploadTime}</td>
						<td>${row.purchaseWeb}</td>
						<td>${row.memberId}</td>
			            <td>${row.clickAmt}</td>
						<td>${row.photo}</td>
						

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</c:if>

	<h3>
		<a href="<c:url value="/pages/activityinfo.page" />">Activityinfo Table</a>
	</h3>

</body>
</html>