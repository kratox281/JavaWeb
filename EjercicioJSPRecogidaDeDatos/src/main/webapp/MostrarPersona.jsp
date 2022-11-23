<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="paquete.Persona"%>
<!DOCTYPE html>
<%!Persona person; %>
<%
if((Persona)getServletContext().getAttribute("Persona")!=null){
	person = (Persona)getServletContext().getAttribute("Persona");
}else{
	person = new Persona("","","","","","");
}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RecogidaPersona.jsp">
Nombre:<%=person.getNombre()%><br>
DNI:<%=person.getDni() %><br>
Apellidos:<%=person.getApellidos()%><br>
Direccion:<%=person.getDireccion()%><br>
Correo:<%=person.getCorreo() %><br>
TLF:<%=person.getTelefono() %>
<input type="submit" value="volver">
</form>
</body>
</html>