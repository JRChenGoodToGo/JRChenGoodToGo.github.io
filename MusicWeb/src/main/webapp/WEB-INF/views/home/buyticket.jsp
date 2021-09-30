<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購票確認</title>
</head>
<body>

	<table>
		<tr><center>
			<td>activityid</td>
			<td>${activityid}</td>
		</tr>
		<tr>
			<td>tagid</td>
			<td>${tagid}</td>
		</tr>
		<tr>
			<td>bandpost</td>
			<td>${bandpost}</td>
		</tr>
		<tr>
			<td>host</td>
			<td>${host}</td>
		</tr>
		<tr>
			<td>player</td>
			<td>${player}</td>
		</tr>
		<tr>
			<td>theme</td>
			<td>${theme}</td>
		</tr>
		<tr>
			<td>subtitle</td>
			<td>${subtitle}</td>
		</tr>
		<tr>
			<td>activityintro</td>
			<td>${activityintro}</td>
		</tr>
		<tr>
			<td>bandIntro</td>
			<td>${bandIntro}</td>
		</tr>
		<tr>
			<td>locationId</td>
			<td>${locationId}</td>
		</tr>
		<tr>
			<td>tape</td>
			<td>${tape}</td>
		</tr>
		<tr>
			<td>uploadTime</td>
			<td>${uploadTime}</td>
		</tr>
		<tr>
			<td>purchaseWeb</td>
			<td>${purchaseWeb}</td>
		</tr>
		<tr>
			<td>memberId</td>
			<td>${memberId}</td>
		</tr>
		<tr>
			<td>clickAmt</td>
			<td>${clickAmt}</td>
		</tr>
	</table>

	<form name="myForm"
		action="<c:url value="/pages/orderinfo1.controller" />" method="get">
		<table>

			<tr>
				<td>name :</td>
				<td><input type="text" name="name" value="${param.name}"></td>
				<td><span class="error">${errors.name}</span></td>
				<td></td>
			</tr>
			<tr>
				<td>identification :</td>
				<td><input type="text" name="identification"
					value="${param.identification}"></td>
				<td><span class="error">${errors.identification}</span></td>
				<td></td>
			</tr>
			<tr>
				<td>email :</td>
				<td><input type="text" name="email" value="${param.email}"></td>
				<td><span class="error">${errors.email}</span></td>
				<td></td>
			</tr>
			<tr>
				<td>票種選擇<select name="ticketKind">
						<option value="預售票">預售票</option>
						<option value="早鳥票">早鳥票</option>
						<option value="現場票">現場票</option>
				</select></td>
			</tr>

			<tr>
				<td>cost :</td>
				<td><input type="text" name="cost" value="${param.cost}"></td>
				<td><span class="error">${errors.cost}</span></td>
				<td></td>
			</tr>
			<tr>
				<td>金額<select name="cost">
						<option value="${row.cost }">${row.cost }</option>
						<option value="${row.cost }">${row.cost }<option>
						<option value="${row.cost }">${row.cost }</option>
				</select></td>
			</tr>
			
			<tr>
				<td>purchaseAmt :</td>
				<td><input type="text" name="purchaseAmt"
					value="${param.purchaseAmt}"></td>
				<td><span class="error">${errors.purchaseAmt}</span></td>
				<td></td>
			</tr>
			<tr>
				<td>payment :</td>
				<td><input type="text" name="payment" value="${param.payment}"></td>
				<td><span class="error">${errors.payment}</span></td>
				<td></td>
			</tr>
			<tr>
				<td>memberId :</td>
				<td><input type="text" name="memberId"
					value="${param.memberId}"></td>
				<td><span class="error">${errors.memberId}</span></td>
				<td></td>
			</tr>
			<tr>
				<td>activityId :</td>
				<td><input type="text" name="activityId"
					value="${param.activityId}"></td>
				<td><span class="error">${errors.activityId}</span></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" name="orderinfo" value="Insert">
				</td>
			</tr>
		</table>
	</form>
	<h3>
		<span class="error">${errors.action}</span>
	</h3>
	<c:if test="${not empty insert}">
		<h3>Insert ORDERINFO Table Success</h3>
		<table border="1">

			<tr>
				<td>name</td>
				<td>${insert.name}</td>
			</tr>
			<tr>
				<td>identification</td>
				<td>${insert.identification}</td>
			</tr>
			<tr>
				<td>email</td>
				<td>${insert.email}</td>
			</tr>
			<tr>
				<td>ticketKind</td>
				<td>${insert.ticketKind}</td>
			</tr>
			<tr>
				<td>cost</td>
				<td>${insert.cost}</td>
			</tr>
			<tr>
				<td>purchaseAmt</td>
				<td>${insert.purchaseAmt}</td>
			</tr>
			<tr>
				<td>payment</td>
				<td>${insert.payment}</td>
			</tr>
			<tr>
				<td>memberId</td>
				<td>${insert.memberId}</td>
			</tr>
			<tr>
				<td>activityId</td>
				<td>${insert.activityId}</td>
			</tr>
		</table>
	</c:if>

</body>
</html>