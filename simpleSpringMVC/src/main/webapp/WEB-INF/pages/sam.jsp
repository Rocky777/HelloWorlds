<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
	
</script>
<script>
	$(document).ready(function() {

		var obj = {
			"s1" : "reportTemplaten",
			"s2" : "reportTemplate"
		};
		$.each(obj, function(key, value) {
			var url = '/simpleSpringMVC/' + value;
			$.get(url, function(data) {
				var image = document.getElementById(key);
				image.src = 'data:image/jpg;base64,' + data;
			});
		});
		$(".sample").click(function() {
			$("#s3").attr('src', this.src);
		});
	});
</script>
</head>

<body>
	<form:form commandName="fileContent">
		<form:input path="filename" />

		<img alt="" id="s1" src="" width="100" height="100" class="sample" />
		<img alt="" id="s2" src="" width="100" height="100" class="sample" />
	</form:form>
	<img alt="" id="s3" src="" width="200" height="200" />

</body>
</html>