<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
	
</script>
</head>
<body>
	<form:form commandName="account" action="process" method="get">
		Id : <form:input path="id" />
		Name : <form:input path="name" />
		 <input type="submit" value="Submit"/>
		 
	</form:form>
</body>
</html>