<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>Activityinfo</title>
<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
</script>
</head>
<body>

<h3>Welcome  ${user.memberid}</h3>

<h3>Activityinfo Table</h3>

<form name="myForm" action="<c:url value="/pages/activityinfo.controller" />" method="get">
<table>
	<tr>
		<td>activityid : </td>
		<td><input type="text" name="activityid" value="${param.activityid}"></td>
		<td><span class="error">${errors.activityid}</span></td>
	</tr>
	<tr>
		<td>tagid : </td>
		<td><input type="text" name="tagid" value="${param.tagid}"></td>
		<td><span class="error">${errors.tagid}</span></td>
		<td></td>
	</tr>

	<tr>
		<td>bandpost : </td>
		<td><input type="text" name="bandpost" value="${param.bandpost}"></td>
		<td><span class="error">${errors.bandpost}</span></td>
	</tr>
	<tr>
		<td>host : </td>
		<td><input type="text" name="host" value="${param.host}"></td>
		<td><span class="error">${errors.host}</span></td>
	</tr>
	<tr>
		<td>player : </td>
		<td><input type="text" name="player" value="${param.player}"></td>
		<td><span class="error">${errors.player}</span></td>
	</tr>
		<tr>
		<td>theme : </td>
		<td><input type="text" name="theme" value="${param.theme}"></td>
		<td><span class="error">${errors.theme}</span></td>
	</tr>
		<tr>
		<td>subtitle : </td>
		<td><input type="text" name="subtitle" value="${param.subtitle}"></td>
		<td><span class="error">${errors.subtitle}</span></td>
	</tr>
		<tr>
		<td>activityintro : </td>
		<td><input type="text" name="activityintro" value="${param.activityintro}"></td>
		<td><span class="error">${errors.activityintro}</span></td>
	</tr>
		<tr>
		<td>bandIntro : </td>
		<td><input type="text" name="bandIntro" value="${param.bandIntro}"></td>
		<td><span class="error">${errors.bandIntro}</span></td>
	</tr>
		<tr>
		<td>locationId : </td>
		<td><input type="text" name="locationId" value="${param.locationId}"></td>
		<td><span class="error">${errors.locationId}</span></td>
	</tr>
		<tr>
		<td>tape : </td>
		<td><input type="text" name="tape" value="${param.tape}"></td>
		<td><span class="error">${errors.tape}</span></td>
	</tr>
		<tr>
		<td>uploadTime : </td>
		<td><input type="text" name="uploadTime" value="${param.uploadTime}"></td>
		<td><span class="error">${errors.uploadTime}</span></td>
	</tr>
		<tr>
		<td>purchaseWeb : </td>
		<td><input type="text" name="purchaseWeb" value="${param.purchaseWeb}"></td>
		<td><span class="error">${errors.purchaseWeb}</span></td>
	</tr>
		<tr>
		<td>memberId : </td>
		<td><input type="text" name="memberId" value="${param.memberId}"></td>
		<td><span class="error">${errors.memberId}</span></td>
	</tr>
	    <tr>
		<td>clickAmt : </td>
		<td><input type="text" name="clickAmt" value="${param.clickAmt}"></td>
		<td><span class="error">${errors.clickAmt}</span></td>
	    </tr>
	<tr>
		<td>
			<input type="submit" name="activityInfo" value="Insert">
			<input type="submit" name="activityInfo" value="Update">
		</td>
		<td>
			<input type="submit" name="activityInfo" value="Delete">
			<input type="submit" name="activityInfo" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>

<h3><span class="error">${errors.action}</span></h3>

<c:if test="${not empty delete}">
<h3>Delete Activityinfo Table Success : ${delete} row deleted</h3>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty insert}">
<h3>Insert Activityinfo Table Success</h3>
<table border="1">
	<tr><td>activityid</td><td>${insert.activityid}</td></tr>
	<tr><td>tagid</td><td>${insert.tagid}</td></tr>
	<tr><td>bandpost</td><td>${insert.bandpost}</td></tr>
	<tr><td>host</td><td>${insert.host}</td></tr>
	<tr><td>player</td><td>${insert.player}</td></tr>
	<tr><td>theme</td><td>${insert.theme}</td></tr>
	<tr><td>subtitle</td><td>${insert.subtitle}</td></tr>
	<tr><td>activityintro</td><td>${insert.activityintro}</td></tr>
	<tr><td>bandIntro</td><td>${insert.bandIntro}</td></tr>
	<tr><td>locationId</td><td>${insert.locationId}</td></tr>
	<tr><td>tape</td><td>${insert.tape}</td></tr>
	<tr><td>uploadTime</td><td>${insert.uploadTime}</td></tr>
	<tr><td>purchaseWeb</td><td>${insert.purchaseWeb}</td></tr>
	<tr><td>memberId</td><td>${insert.memberId}</td></tr>
	<tr><td>clickAmt</td><td>${insert.clickAmt}</td></tr>
	<tr><td>photo</td><td>${insert.photo}</td></tr>
	
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty update}">
<h3>Update Activityinfo Table Success</h3>
<table border="1">
<tr><td>activityid</td><td>${update.activityid}</td></tr>
	<tr><td>tagid</td><td>${update.tagid}</td></tr>
	<tr><td>bandpost</td><td>${update.bandpost}</td></tr>
	<tr><td>host</td><td>${update.host}</td></tr>
	<tr><td>player</td><td>${update.player}</td></tr>
	<tr><td>theme</td><td>${update.theme}</td></tr>
	<tr><td>subtitle</td><td>${update.subtitle}</td></tr>
	<tr><td>activityintro</td><td>${update.activityintro}</td></tr>
	<tr><td>bandIntro</td><td>${update.bandIntro}</td></tr>
	<tr><td>locationId</td><td>${update.locationId}</td></tr>
	<tr><td>tape</td><td>${update.tape}</td></tr>
	<tr><td>uploadTime</td><td>${update.uploadTime}</td></tr>
	<tr><td>purchaseWeb</td><td>${update.purchaseWeb}</td></tr>
	<tr><td>memberId</td><td>${update.memberId}</td></tr>
	<tr><td>clickAmt</td><td>${update.clickAmt}</td></tr>
	<tr><td>photo</td><td>${update.photo}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

</body>
</html>