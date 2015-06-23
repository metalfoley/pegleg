<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Doubloon to Dollar Converter</title>
</head>
<body>
	<h1>Doubloon To Dollar Converter</h1>
	<form>
		<label for="dtod">Doubloons: </label>
		<input type="text" name="dtod" id="dtod"/>
		<button type="submit" id="getConversion">Submit</button>
	</form>
	<p id="conversion"></p>
	<%@ include file="../includes/footer.jsp" %>
</body>
</html>