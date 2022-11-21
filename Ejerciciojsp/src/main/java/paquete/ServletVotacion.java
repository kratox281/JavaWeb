package paquete;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ServletVotacion
 */
public class ServletVotacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVotacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Votacion> votaciones;
	
			votaciones = new ArrayList<>();
		
		
		ArrayList<String> decisiones = new ArrayList<>();
		if(request.getParameterValues("candidatos")!=null) {
			String[] votos = request.getParameterValues("candidatos");
			for(String voto :votos) {
				decisiones.add(voto);
			}
		}else {
			decisiones.add("Blanco");
		}
		votaciones.add(new Votacion("alumn", decisiones));
		//System.out.println("Lo sube");
		request.getServletContext().setAttribute("votaciones", votaciones);
		//System.out.println("Pero no reenvia");
		request.getRequestDispatcher("Resultados.jsp").forward(request, response);
		
	}

}
