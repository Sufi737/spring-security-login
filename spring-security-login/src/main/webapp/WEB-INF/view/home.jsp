<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
	<head>
		<title>Homepage</title>
	</head>
	<body>
		<h1>Welcome!</h1>
		
		<security:authorize access="hasRole('MANAGER')">
			<hr>
				<p>
					<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
				</p>
			</hr>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
		<hr>
			<p>
				<a href="${pageContext.request.contextPath}/systems">Admin Cruise</a>
			</p>
		</hr>
		</security:authorize>
		
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" />
		</form:form>
	</body>
</html>