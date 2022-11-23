<%@page import="paquete.Incidencia"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!ArrayList<Incidencia>incidencias; %>
<%if(getServletContext().getAttribute("incidencias")!=null){
	incidencias= (ArrayList<Incidencia>)getServletContext().getAttribute("incidencias");
}	else{
	incidencias = new ArrayList<>();
}
	%>
	<table border="3">
	<tr>
	<td>ID</td>
	<td>Tema</td>
	<td>Descripcion</td>
	</tr>
<%for(Incidencia inc : incidencias){
	%>
	<tr>
	<td><%= inc.getId() %></td>
	<td><%= inc.getTema() %></td>
	<td><%= inc.getDescripcion() %></td>
	</tr>
	<% 	
	
} %>	
	
	</table>

</body>
</html>