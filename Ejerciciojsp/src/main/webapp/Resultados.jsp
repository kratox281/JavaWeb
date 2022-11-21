<%@page import="java.util.ArrayList"%>
<%@page import="paquete.Votacion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Votacion.jsp">
	<%!ArrayList<Votacion> votacion; %>
	<%if((getServletContext().getAttribute("votaciones")==null)){
		System.out.println("Es nula");
	}else{
		 votacion= (ArrayList<Votacion>) getServletContext().getAttribute("votaciones");
	}
	
	
		%>
	
		<%!int votosVictor = 0;%>
		<%!int votosBlanco = 0;%>
		<%!int votosRuth = 0;%>

		<%
		for (Votacion voto : votacion) {
			ArrayList<String> votospersona = voto.getVotos();
			for (String vot : votospersona) {
				switch (vot) {
				case "RUTH":
			votosRuth++;
			break;
				case "VICTOR":
			votosVictor++;
			break;
				default:
			votosBlanco++;
			break;
				}
			}
		}
		%>
		<table>
		<tr>
			<td>Victor</td>
			<td><%=votosVictor+""%></td>
		</tr>
		<tr>
			<td>Ruth</td>
			<td><%=votosRuth+""%></td>
		</tr>
		<tr>
			<td>Blanco</td>
			<td><%=votosBlanco+""%></td>
		</tr>
		</table>
		<input type="submit" value="Volver">
	</form>
</body>
</html>