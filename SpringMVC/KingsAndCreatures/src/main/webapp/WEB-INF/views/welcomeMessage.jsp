<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Spring 4 MVC Hello World Example with Maven Eclipse</title>
</head>
<body>
	<h2>Hello World, Spring MVC</h2>

	<p>Welcome, ${firstName}</p>
	<c:out value="${firstName}" />
	<button onClick="doStuff()">click me!</button>
</body>
</html>