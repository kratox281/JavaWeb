<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="paquete.Persona"%>
<!DOCTYPE html>
<%!Persona person =(Persona)getServletContext().getAttribute("Persona"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RecogidaPersona.jsp">
<%=person.getNombre()%><br>
<%=person.getDni() %>
<br>
<%=person.getApellidos()%><br>
<%=person.getDireccion()%><br>
<%=person.getCorreo() %><br>
<%=person.getTelefono() %>
<input type="submit" value="volver">
</form>
</body>
</html>