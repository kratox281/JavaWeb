

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Personas
 */
@WebServlet("/Personas")
public class Personas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> lPersonas = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Personas() {
        super();
       
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = "nulo";
		String telefono = "0";
		String edad ="0";
		if(request.getParameter("nombre")!=null) {
			nombre = request.getParameter("nombre");
		}
		if(request.getParameter("telefono")!= null) {
			telefono = request.getParameter("telefono");
			
		}
		if(request.getParameter("edad")!= null) {
			edad = request.getParameter("edad");
		}
		lPersonas.add(new Persona(nombre,telefono,edad));
        getServletConfig().getServletContext().setAttribute("lista",lPersonas );
        response.getWriter().append(nombre+" "+telefono+" "+edad);
        
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
