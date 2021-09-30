<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
<h3>後臺資料管理</h3>
<h3>Welcome ${user.custid}</h3>

<h3><a href="<c:url value="/login" />">Login</a></h3>
<h3><a href="<c:url value="/pages/memberinfo.page" />">memberinfo</a></h3>
<h3><a href="<c:url value="/pages/locationinfo.page" />">lcoationinfo</a></h3>
<h3><a href="<c:url value="/pages/activityinfo.page" />">activityinfo</a></h3>
<h3><a href="<c:url value="/pages/collectinfo.page" />">collectinfo</a></h3>
<h3><a href="<c:url value="/pages/taginfo.page" />">taginfo</a></h3>
<h3><a href="<c:url value="/pages/ticketsetting.page" />">ticketsetting</a></h3>
<h3><a href="<c:url value="/pages/timeinfo.page" />">timeinfo</a></h3>
<h3><a href="<c:url value="/pages/orderinfo.page" />">orderinfo</a></h3>
</body>
</html>