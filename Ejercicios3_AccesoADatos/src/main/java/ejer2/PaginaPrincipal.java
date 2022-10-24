package ejer2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaginaPrincipal
 */
@WebServlet("/PaginaPrincipal")
public class PaginaPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaginaPrincipal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = "";
		//String dominio = "";
		boolean local = true;
		// TODO Auto-generated method stub
		Cookie[] cs = request.getCookies();
		if (cs != null) {
			for (Cookie c : cs) {
				if (c.getName().equals("usuario")) {
					user = c.getValue();
				}
			}
			for (Cookie c : cs) {
				if (!c.getPath().contains("localhost")) {
					local=false;
					
				} else {
					local = true;
				}
			}
		}
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		if(local) {
		pw.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "    <h1 style=\"text-decoration: underline;\">SALÚDAME!!!!!!</h1>\r\n"
				// ****************************************************************************************************************************
				// Esta es la linea que se modifica
				+ (user.equals("") ? "<p>Bienvenido a mi Web</p>" : "<p>Me alegro de verte " + user)
				+ "</p>"
				// ****************************************************************************************************************************
				+ "\r\n" + "    <form action=\"SegundaPagina\" method=\"get\">\r\n"
				+ "        Nombre: <input type=\"text\" name=\"nombre\"><br>\r\n"
				+ "        <input type=\"submit\" value=\"Confirmar\">\r\n" + "    </form>\r\n"
				+ "</body>\r\n" + "</html>");
		}else {
			response.getWriter().append("No tienes acceso");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
