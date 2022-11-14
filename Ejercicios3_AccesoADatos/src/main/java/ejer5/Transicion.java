package ejer5;


import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.connector.Response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.Cookie;

/**
 * Servlet implementation class Transicion
 */
@WebServlet("/Transicion")
public class Transicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transicion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"e\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h1 style=\"font-weight: bold;\">Bienvenido a Web Libreria. Usted eligió"+request.getParameter("Lenguaje") +"</h1>\r\n"
				+ "    <a href=\"http://localhost:8080/Ejercicios3_AccesoADatos/PaginaPrinci\">Sigue comprando</a>\r\n"
				+ "    <a href=\"http://localhost:8080/Ejercicios3_AccesoADatos/Total\">Ver compra</a>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean creada = false;
		String libro = request.getParameter("Lenguaje");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		Cookie[] cs = request.getCookies();
		if(cs!=null) {
		for(Cookie c : cs) {
			if(c.getName().equals(libro)) {
				int temp = cantidad+Integer.parseInt(c.getValue());
				c.setValue(temp+"");
				creada = true;
				response.addCookie(c);
			}
		}}
		else {
		    Cookie c = new Cookie(libro, cantidad+"");
            response.addCookie(c);
		}
		if(!creada) {
			Cookie c = new Cookie(libro, cantidad+"");
			response.addCookie(c);
		}
		//response.getWriter().append("Soy el post");
	
		doGet(request, response);
	}

}
