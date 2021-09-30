<%@page import="java.awt.Image"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.sql.Blob"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Activity Page</title>
</head>
<body>
	<h3>Here Are Some Activity You Can See</h3>

	<% 
		byte[] photo = (byte[]) session.getAttribute("photo");
		
		
		char outPhoto[] = new char[photo.length * 2];
	    for (int i = 0; i < photo.length; i++) {
	    	outPhoto[i * 2] = "0123456789ABCDEF".charAt((photo[i] >> 4) & 15);
	    	outPhoto[i * 2 + 1] = "0123456789ABCDEF".charAt(photo[i] & 15);
	    }
		
		
		InputStream inputStream = new ByteArrayInputStream(photo, 0, photo.length);
		BufferedImage bi = ImageIO.read(inputStream);
		Image image = (Image) bi;
		out.print(image);
		
	%>
	photo: ${photoModel}
	<table border="1px">
		<tr>
			<td rowspan="5"><img id="photo" alt="${activityList.photo}"
				src=""> 1</td>
			<td>${activityList.tagId }</td>
		</tr>
		<tr>
			<td>${activityList.theme }</td>
		</tr>
		<tr>
			<td>${activityList.subTitle }</td>
		</tr>
		<tr>
			<td>${activityList.activityIntro }</td>
		</tr>
		<tr>
			<td>${activityList.clickAmt }</td>
		</tr>

	</table>

</body>
</html>