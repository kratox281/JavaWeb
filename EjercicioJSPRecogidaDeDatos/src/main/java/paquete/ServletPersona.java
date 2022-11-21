package paquete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletPersona
 */
public class ServletPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersona() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String dni;
		 String nombre;
		 String apellidos;
		 String direccion;
		 String telefono;
		 String correo;
		 dni  = request.getParameter("dni")!=null?request.getParameter("dni"):"";
		 nombre = request.getParameter("nombre")!=null?request.getParameter("nombre"):"";
		 apellidos = request.getParameter("apellidos")!=null?request.getParameter("apellidos"):"";
		 direccion = request.getParameter("dirección")!=null?request.getParameter("dirección"):"";
		 telefono = request.getParameter("teléfono")!=null?request.getParameter("teléfono"):"";
		 correo = request.getParameter("correo")!=null?request.getParameter("correo"):"";
		 Persona persona  = new Persona(dni, nombre, apellidos, direccion, telefono, correo);
		 request.getServletContext().setAttribute("Persona", persona);
		 request.getRequestDispatcher("MostrarPersona.jsp").forward(request, response);
	}

}
