package ejer4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Carrito
 */
@WebServlet("/Carrito")
public class Carrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		ArrayList<String> productos;
		HttpSession sesion  = request.getSession();
		if(sesion.getAttribute("Compra")!=null) {
			productos=(ArrayList<String>) sesion.getAttribute("Compra");
		}else {
			productos=new ArrayList<>();
		}
		pw.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h1 style=\"text-decoration: underline;\">Carnicería Panizo</h1>\r\n"
				+ "    <br>\r\n"
				);
		for(String producto:productos) {
			pw.println("<p>-"+producto+"</p>");
		}
		pw.println("  <br>\r\n"
				+ "    <a href=\"http://localhost:8080/EjerIIISesionesVSCookiesRubenCasas/Tienda\">Seguir comprando</a>\r\n"
				+ "    <br>\r\n"
				+ "    <a href=\"http://localhost:8080/EjerIIISesionesVSCookiesRubenCasas/PaginaInicio\">Volver al inicio</a>\r\n"
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
