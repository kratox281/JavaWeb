package ejer1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RegistroInicio
 */
public class RegistroInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroInicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <form action=\"\" method=\"post\">\r\n"
				+ "        <input type=\"text\" name=\"user\" id=\"\" placeholder=\"User\">\r\n"
				+ "        <input type=\"password\" name=\"pwrd\" id=\"\" placeholder=\"Password\">\r\n"
				+ "        <input type=\"submit\" value=\"Acceder\">\r\n"
				+ "    </form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession sesion = request.getSession();
		String usuario = request.getParameter("user");
		String contrasenia = request.getParameter("pwrd");
		if (sesion.getAttribute("usuario") == null && sesion.getAttribute("contrasenia") == null) {
			sesion.setAttribute("usuario", usuario);
			sesion.setAttribute("contrasenia", contrasenia);
			doGet(request, response);
		} else {
			if (usuario.equals(sesion.getAttribute("usuario")) && contrasenia.equals(sesion.getAttribute("contrasenia"))) {
				pw.println("<html><body><h1> Bienvenido "+usuario+"</h1> </body> </html>");
			}
			else {
				pw.println("<html><body><h1>Usuario no reconocido </h1> </body> </html>");
				doGet(request, response);
			}
		}
	}

}
