package paquete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Servlet implementation class ServletIncidencia
 */
public class ServletIncidencia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletIncidencia() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean existe = true;
		int r = 0;
		String tema = "";
		String descripcion = "";
		ArrayList<Incidencia> incidencias;

		if (request.getServletContext().getAttribute("incidencias") != null) {
			incidencias = (ArrayList<Incidencia>) request.getServletContext().getAttribute("incidencias");
		} else {
			incidencias = new ArrayList<>();
		}

		do {
			ArrayList<Integer> ids = new ArrayList<>();
			r = new Random().nextInt(21);
			for (Incidencia inci : incidencias) {
				ids.add(inci.getId());
			}
			if (!ids.contains(r))
				existe = false;
		} while (existe);
		if (request.getParameter("tema") == null || request.getParameter("descripcion") == null) {
			request.getRequestDispatcher("AltaIncidencia.jsp").forward(request, response);
		}

		tema = request.getParameter("tema");
		descripcion = request.getParameter("descripcion");
		incidencias.add(new Incidencia(tema,descripcion,r));
		request.getServletContext().setAttribute("incidencias", incidencias);
		request.getRequestDispatcher("ConsultaIncidencia.jsp");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<html><body>");
		pw.print("<p> Se ha registrado con el numero "+r+"<p>");
		pw.print("<p>"+tema+"</p>");
		pw.print("<p>"+descripcion+"</p>");
		pw.print("<form action=\"ConsultaIncidencia.jsp\"> <input type =\"submit\" value = \"comprobar\"> </form>");
		pw.print("</body></html>");
	}

}
