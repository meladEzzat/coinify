<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notes and coins result page</title>
</head>
<body>

		<center>
			<font color="red">${notesAndCoinsResult.getMessage()}</font>
		</center>


	<c:if test="${empty notesAndCoinsResult.getMessage() }">
		<h3>You will recieve ::</h3>

		<c:forEach items="${notesAndCoinsResult.getNotesAndCoinsResult()}" var="item">
			<c:if test="${item.key >= 50 }">
			${item.value} X ${item.key} Note <br>
			</c:if>
			<c:if test="${item.key < 50 }">
			${item.value} X ${item.key} Coin <br>
			</c:if>
		</c:forEach>

		<h3>Total amount :: ${amount}</h3>
	</c:if>


</body>
</html>