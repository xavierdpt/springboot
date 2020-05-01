<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>This is my form</p>
	<form method="post" action="/submitform" enctype="multipart/form-data">
		<div>
			<label for="myfile">My File</label><input type="file" name="myfile" />
		</div>
		<div>
			<input type="submit" value="Submit" />
		</div>
	</form>
</body>
</html>