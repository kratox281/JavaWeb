package ejer2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class Ejercicio2_Encuesta
 */
public class Ejercicio2_Encuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio2_Encuesta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		getServletContext().setAttribute("votantes", new ArrayList<String>());
		getServletContext().setAttribute("sintomas",new ArrayList<String>());
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Encuesta COVID</h1>");
		pw.println("<form action=\"Ejercicio2_Resultados\" method=post>");
		pw.println("<input type=\"text\" name=\"usuario\" placeholder=\"Nombre de usuario\"> <br>");
		pw.println("Fiebre <input type=\"checkbox\" name=\"sintomas1\" value=\" Fiebre\"><br>");
		pw.println("Tos Secas <input type=\"checkbox\" name=\"sintomas2\" value=\" Tos Seca\"><br>");
		pw.println("Diarrea <input type=\"checkbox\" name=\"sintomas3\" value=\" Diarrea\"><br>");
		pw.println("Perdida de olfato <input type=\"checkbox\" name=\"sintomas4\" value=\"Perdida de Olfato\"><br>");
		pw.println("Dolor muscular <input type=\"checkbox\" name=\"sintomas5\" value=\"Dolor Muscular\"><br>");
		pw.println("<input type=\"submit\">");
		pw.println("</form></body></html>");
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
