<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Try Something On MainPage</title>
</head>
<body>

<form action="/users/save"  method="post">
<table>
	<tr>
		<td>activityid : </td>
		<td><input type="text" name="activityid" value="${param.activityid}"></td>
		<td><span class="error">${errors.activityid}</span></td>
	</tr>
	<tr>
		<td>tagid : </td>
		<td><input type="text" name="tagId" value="${param.tagid}"></td>
		<td><span class="error">${errors.tagid}</span></td>
		<td></td>
	</tr>

	<tr>
	
		<td>bandpost : </td>
		<td><input type="text" name="bandpost" value="${param.bandpost}"></td>
		<td> <label>Photos:</label> </td>
		<td>Photo: <input type="file" name="photo" accept="image/png, image/jpeg" /> </td>
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


<c:if test="${not empty activityList }">
	<table border="1px">
		<thead>
			<tr>
				<td rowspan="5">demoPicture1</td>
				<td>demoTest= ${test }</td>
			</tr>
			<tr>
				<td>demoTheme</td>
			</tr>
			<tr>
				<td>demoSubtitle</td>
			</tr>
			<tr>
				<td>demoActivityIntro</td>
			</tr>
			<tr>
				<td>demoClickAmt</td>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="row" items= "${activityList }" >
				<tr>
					<td rowspan="5"> <img id="photo" alt="${row.photo }" src="data:image/png;base64,${row.photo } "> 1</td>
					<td>${row.tagName }</td>
				</tr> 
				<tr>
					<td>${row.theme }</td>
				</tr>
				<tr>
					<td>${row.subTitle } </td>
				</tr>
				<tr>
					<td>${row.activityIntro } </td>
				</tr>
				<tr>
					<td>${row.clickAmt }</td>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>
</c:if>
activityList= ${activityList } <hr/>
test= ${test }




</body>
</html>