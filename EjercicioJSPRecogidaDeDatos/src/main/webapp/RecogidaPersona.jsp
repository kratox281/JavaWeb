<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletPersona" method = "post">
<!--  (dni/nif, nombre, apellidos, direcci�n, tel�fono, correo-->
<input type="text" name="dni" placeholder="dni">
<input type="text" name="nombre" placeholder="nombre">
<input type="text" name="apellidos" placeholder="apellidos">
<input type="text" name="direcci�n" placeholder="direcci�n">
<input type="text" name="tel�fono" placeholder="tel�fono">
<input type="text" name="correo" placeholder="correo">

<input type="submit">
</form>
</body>
</html>