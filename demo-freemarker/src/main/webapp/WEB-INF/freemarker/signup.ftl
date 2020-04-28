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
				value="${(signup.name)!}" />
		</div>
		<#if (errors.age)??>
			<div>${errors.age}</div>
		</#if>
		<div>
			<label for="age">Age</label><input type="text" name="age"
				value="${(signup.age)!}" />
		</div>
		<#if (errors.agree)??>
			<div>${errors.agree}</div>
		</#if>
		<div>
				<input type="checkbox" name="agree" <#if (signup.agree)!false >checked</#if> />
				<label for="agree">Agree to terms and conditions</label>
		</div>
		<div>
			<input type="submit" value="Sign up!" />
		</div>
	</form>
</body>
</html>