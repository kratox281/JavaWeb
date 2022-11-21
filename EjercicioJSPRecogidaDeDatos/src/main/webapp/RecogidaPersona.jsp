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
<!--  (dni/nif, nombre, apellidos, dirección, teléfono, correo-->
<input type="text" name="dni" placeholder="dni">
<input type="text" name="nombre" placeholder="nombre">
<input type="text" name="apellidos" placeholder="apellidos">
<input type="text" name="dirección" placeholder="dirección">
<input type="text" name="teléfono" placeholder="teléfono">
<input type="text" name="correo" placeholder="correo">

<input type="submit">
</form>
</body>
</html>