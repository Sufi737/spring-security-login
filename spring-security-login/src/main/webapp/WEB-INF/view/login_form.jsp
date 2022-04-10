<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<head>
		<title>Custom login form</title>
		
		<style>
			.failed {
				color: red;
			}
		</style>
	</head>
	
	<body>
		<h3>Login Page</h3>
		<form:form action="${pageContext.request.contextPath}/processForm" method="POST">
			
			<c:if test="${param.error != null}">
				<i class="failed">Sorry you have entered invalid credentials</i>
			</c:if>
			<c:if test="${param.logout != null}">
				<i>You have been logged out successfully</i>
			</c:if>
			<p>
				User Name: <input type="text" name="username" />
			</p>
			<br />
			<p>
				Password: <input type="password" name="password" />
			</p>
			<br />
			<input type="submit" value="Log in" />
		</form:form>
	</body>
	
</html>