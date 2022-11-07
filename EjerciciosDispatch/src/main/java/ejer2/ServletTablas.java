package ejer2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletTablas
 */
public class ServletTablas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTablas() {
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
		int numero = Integer.parseInt(request.getParameter("listaTabla"));
		PrintWriter pw = response.getWriter();
		String color;
		if (request.getParameter("color") != null) {
			color = request.getParameter("color");
		} else {
			color = "white";
		}
		pw.print("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n" + "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "    <table border=\"1px\" style=\"background-color: " + color + ";\">\r\n" + "");
		for(int i = 1; i<=10;i++) {
			pw.println("<tr>");
			pw.println("<td>"+numero+"x"+i+"</td>");
			pw.println("<td>"+(numero*i)+"</td>");
			pw.println("</tr>");
		}
		pw.print("   </table>\r\n"
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
		doGet(request, response);
	}

}
