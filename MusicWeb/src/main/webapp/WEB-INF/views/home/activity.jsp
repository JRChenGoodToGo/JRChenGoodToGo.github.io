<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String activityid = request.getParameter("activityid");
session.setAttribute("activityid", activityid);
String host = request.getParameter("host");
session.setAttribute("host", host);
String player = request.getParameter("player");
session.setAttribute("`player", player);
String theme = request.getParameter("theme");
session.setAttribute("theme", theme);
String subtitle = request.getParameter("subtitle");
session.setAttribute("subtitle", subtitle);
String activityintro = request.getParameter("activityintro");
session.setAttribute("activityintro", activityintro);
String bandIntro = request.getParameter("bandIntro");
session.setAttribute("bandIntro", bandIntro);


String showAddr = request.getParameter("showAddr");
session.setAttribute("showAddr", showAddr);
int g=0;
%>
AA
${showAddr}

<table>
<tr><td>activityid</td><td>${activityid}</td></tr>
<tr><td>tagid</td><td>${tagid}</td></tr>
	<tr><td>bandpost</td><td>${bandpost}</td></tr>
	<tr><td>host</td><td>${host}</td></tr>
	<tr><td>player</td><td>${player}</td></tr>
	<tr><td>theme</td><td>${theme}</td></tr>
	<tr><td>subtitle</td><td>${subtitle}</td></tr>
	<tr><td>activityintro</td><td>${activityintro}</td></tr>
	<tr><td>bandIntro</td><td>${bandIntro}</td></tr>
	<tr><td>locationId</td><td>${locationId}</td></tr>
	<tr><td>tape</td><td>${tape}</td></tr>
	<tr><td>uploadTime</td><td>${uploadTime}</td></tr>
	<tr><td>purchaseWeb</td><td>${purchaseWeb}</td></tr>
	<tr><td>memberId</td><td>${memberId}</td></tr>
	<tr><td>clickAmt</td><td>${clickAmt}</td></tr>
	</table>
	<h3><a href="<c:url value="/activity/ticket" />">我要購票</a></h3>
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
	
	
</body>
</html>