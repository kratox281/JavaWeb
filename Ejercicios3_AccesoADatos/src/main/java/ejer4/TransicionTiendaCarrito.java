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
 * Servlet implementation class TransicionTiendaCarrito
 */
@WebServlet("/TransicionTiendaCarrito")
public class TransicionTiendaCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransicionTiendaCarrito() {
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
		ArrayList<String> productos;
		HttpSession sesion  = request.getSession();
		if(sesion.getAttribute("Compra")==null) {
		productos=new ArrayList<>();
		}else {
			productos = (ArrayList<String>) sesion.getAttribute("Compra");
		}
		productos.add(request.getParameter("productos"));
		sesion.setAttribute("Compra", productos);
		PrintWriter pw = response.getWriter();
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
				+ "    <a href=\"http://localhost:8080/EjerIIISesionesVSCookiesRubenCasas/Tienda\">Seguir comprando</a><br>\r\n"
				+ "    <a href=\"http://localhost:8080/EjerIIISesionesVSCookiesRubenCasas/Carrito\">Ir al carrito</a>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

}
