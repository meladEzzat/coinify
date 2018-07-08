<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h2>${serverTime}</h2><br/>
	
	<h2>Coinify ATM</h2>

	<form action="withdraw" method="GET">
		Amount : <input type="text" name="amount"><input type="submit"
			value="Withdraw" />
	</form>
</body>
</html>
