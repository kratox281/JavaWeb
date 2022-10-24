

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Mostrar
 */
@WebServlet("/Mostrar")
public class Mostrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mostrar() {
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
		ArrayList<Persona> lista = (ArrayList<Persona>) getServletConfig().getServletContext().getAttribute("lista");
		response.setContentType("text/html");
		PrintWriter wr = response.getWriter();
		wr.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <table border=\"3\">\r\n"
				+ "        <tr>\r\n"
				+ "            <td>Nombre</td>\r\n"
				+ "            <td>Edad</td>\r\n"
				+ "            <td>Telefono</td>\r\n"
				+ "        </tr>");
		for(Persona p:lista) {
			wr.println("<tr>"
					+ "<td>"+p.getNombre()+"</td>"
					+ "<td>"+p.getNumero()+"</td>"
					+ "<td>"+p.getTelefono()+"</td>"
					+ "</tr>");
		}
		wr.println("</table>\r\n"
				+ "    \r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
