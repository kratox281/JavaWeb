<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Eleccion de delegado</h1>
<hr color="blue">
<p>Los candidatos a la eleccion de delegados son:</p>
<form action="ServletVotacion" method="post">
	<input type="checkbox" name="candidatos" value="RUTH"> Ruth <br>
	<input type="checkbox" name="candidatos" vaLue="VICTOR"> Victor <br>
	 <input type = "submit"> 
</form>
</body>
</html>