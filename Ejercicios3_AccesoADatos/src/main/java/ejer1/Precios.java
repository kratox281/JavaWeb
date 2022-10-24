package ejer1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Precios
 */
@WebServlet("/Precios")
public class Precios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Precios() {
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
		HttpSession sesion = request.getSession(true);
		if (sesion.getAttribute("Total") == null) {
			sesion.setAttribute("Total", 0);
		} else {
			System.out.println("llega");
			int temp = 0;
			if (request.getParameter("valor") != null) {
				temp = (int) sesion.getAttribute("Total");
				System.out.println(temp);
				String valor = (String) request.getParameter("valor");
				switch (valor) {
				case "A":
					sesion.setAttribute("Total", temp + 1);
					break;

				case "B":
					sesion.setAttribute("Total", temp + 2);
					break;

				case "C":
					sesion.setAttribute("Total", temp + 3);
					break;

				case "D":
					sesion.setAttribute("Total", temp + 4);
					break;
				default:
					sesion.setAttribute("Total", temp + 0);
					break;
				}
			}
		}
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>\r\n" + "<html >\r\n" + "<head>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "    <h1>Tienda ABCD</h1>\r\n" + "    <form action=\"Precios\" method=\"get\">\r\n" + "\r\n"
				+ "        <input type=\"submit\" name=\"valor\" value=\"A\">\r\n"
				+ "        <input type=\"submit\" name=\"valor\" value=\"B\">\r\n"
				+ "        <input type=\"submit\" name=\"valor\" value=\"C\">\r\n"
				+ "        <input type=\"submit\" name=\"valor\" value=\"D\">\r\n" + "    </form>\r\n"
				+ "    <form action=\"Ticket\" method=\"get\">\r\n"
				+ "        <input type=\"submit\" value=\"Ticket\">\r\n" + "    </form>\r\n"
				+ (int) sesion.getAttribute("Total") + "</body>\r\n" + "</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
