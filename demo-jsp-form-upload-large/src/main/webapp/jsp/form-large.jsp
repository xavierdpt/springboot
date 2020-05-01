<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function doSubmit(e) {
	e.preventDefault();
	var xhr = new XMLHttpRequest();
	xhr.open("post", e.target.action);
	xhr.onload = function() {
		if(!xhr.status == 200) {
			document.getElementById('result').innerText="Error "+xhr.status+": "+xhr.statusText;
		} else {
			document.getElementById('result').innerText=xhr.responseText;
		}
	}
	xhr.upload.onprogress = function(evt) {
		document.getElementById('sent').firstChild.nodeValue=evt.loaded;
		if(evt.lengthComputable) {
			document.getElementById('total').firstChild.nodeValue=evt.total;
		}
	}
	xhr.onerror = function() {
		document.getElementById('result').innerText="Unknown error";
	}
	xhr.setRequestHeader('X-Large-Upload','1');
	xhr.send(new FormData(e.target));
}
</script>
</head>
<body>
	<p>This is my form</p>
	<form method="post" action="/submitform-large"
		enctype="multipart/form-data" onsubmit="doSubmit(event);">
		<div>
			<label for="myfile">My File</label><input type="file" name="myfile" />
		</div>
		<div>
			<input type="submit" value="Submit" />
		</div>
	</form>
	<div>
		<span id="sent">?</span>/<span id="total">?</span>
	</div>
	<div id="result"></div>
</body>
</html>