<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

<h3>Welcome ${user.name}</h3>

<h3><a href="<c:url value="/secure/login.page" />"> Login</a></h3>
<h3><a href="<c:url value="/pages/searching.page" />"> Searching</a></h3>
<h3><a href="<c:url value="/pages/activity.page" />"> Activity</a></h3>
<h3><a href="<c:url value="/pages/checklogin/*" />">Collection: </a></h3>
<h3><a href="<c:url value="/pages/checklogin/*" />">Activity Managing: </a></h3>
<h3><a href="<c:url value="/pages/showactivity.controller" />">Show Activity: </a></h3>

<h3><a href="<c:url value="/pages/testinterceptor.controller" />">TestInterceptor: </a></h3>

<% 
	//String user = request.getParameter("user");
	//out.print(user); // null
	//String loggedInCookie = request.getParameter("loggedInCookie");
	//out.print(loggedInCookie); // null
	Object userSession = session.getAttribute("user");
	//out.print(userSession);
	//Object loggedInCookieSession = session.getAttribute("loginStatus");
	//out.print(loggedInCookieSession);
	session.setAttribute("user", userSession);
	//session.setAttribute("loginStatus", loggedInCookieSession);
	Object activity = session.getAttribute("act");
	//out.print(activity);
%>
<h3> select ${fn: length(activityList) } rows</h3>
activityList= ${activityList }
test= ${test }



</body>
</html>