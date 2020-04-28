<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/signup">
		<div>
			<label for="name">Name</label><input type="text" name="name"
				value="${signup.name}" />
		</div>
		<c:if test="${errors.containsKey('age')}">
			<div>${errors.age}</div>
		</c:if>
		<div>
			<label for="age">Age</label><input type="text" name="age"
				value="${signup.age}" />
		</div>
		<c:if test="${errors.containsKey('agree')}">
			<div>${errors.agree}</div>
		</c:if>
		<div>
			<c:if test="${signup.agree }">
				<input type="checkbox" name="agree" checked />
				<label for="agree">Agree to terms and conditions</label>
			</c:if>
			<c:if test="${!signup.agree }">
				<input type="checkbox" name="agree" />
				<label for="agree">Agree to terms and conditions</label>
			</c:if>

		</div>
		<div>
			<input type="submit" value="Sign up!" />
		</div>
	</form>
</body>
</html>