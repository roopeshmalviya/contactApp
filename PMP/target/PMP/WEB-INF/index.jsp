<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:url var="url_login" value="/login"></s:url>
	<f:form action="${url_login}" modelAttribute="command">
		<table border="1">
			<tr>
				<td>Username</td>
				<td><f:input path="loginName" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><f:input path="password" /></td>
			</tr>
			<tr>
				<td>
					<button>LogIn</button> <a href="#">New Registration</a>
				</td>
			</tr>

		</table>
	</f:form>


</body>
</html>