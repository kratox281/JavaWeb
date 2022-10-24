package ejer4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PaginaInicio
 */
@WebServlet("/PaginaInicio")
public class PaginaInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransicionInicioTienda transi = new TransicionInicioTienda();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaginaInicio() {
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
		HttpSession sesion = request.getSession();
		sesion.setAttribute("Contador", 0);
		sesion.setAttribute("Usuario", "admin");
		sesion.setAttribute("Password", "admin");

		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n" + "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "    <h1 style=\"text-decoration: underline;\">Carnicería Panizo</h1>\r\n" + "    <br>\r\n"
				+ "    <form action=\"\" method=\"post\">\r\n"
				+ "    Nombre <input type=\"text\" name=\"nombre\" ><br>\r\n"
				+ "    Contraseña <input type=\"password\" name=\"contra\"> <br>\r\n"
				+ "    <input type=\"submit\" value=\"acceder\">\r\n" + "</form></body>\r\n" + "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		boolean uc = sesion.getAttribute("Usuario").equals(request.getParameter("nombre"));
		boolean pc = sesion.getAttribute("Password").equals(request.getParameter("contra"));
		if(uc && pc) {
			transi.doGet(request, response);
		}else {
			int temp = (int)sesion.getAttribute("Contador")+1;
			sesion.setAttribute("Contador",temp);
			int intentos = 3-temp;
			PrintWriter pw = response.getWriter();
			if(intentos<=0) {
				pw.println("<h1>Acceso no permitido<h1>");
			}else {
			pw.println("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n" + "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n" + "</head>\r\n" + "<body>\r\n"
					+ "    <h1 style=\"text-decoration: underline;\">Carnicería Panizo</h1>\r\n" + "    <br>\r\n"
					+ "    <form action=\"\" method=\"post\">\r\n"
					+ "    Nombre <input type=\"text\" name=\"nombre\" ><br>\r\n"
					+ "    Contraseña <input type=\"password\" name=\"contra\"> <br>\r\n"
					+ "    <input type=\"submit\" value=\"acceder\">\r\n" + "</form>Te quedan "+intentos+" intentos</body>\r\n" + "</html>");
			}
			}
		

	}

}
