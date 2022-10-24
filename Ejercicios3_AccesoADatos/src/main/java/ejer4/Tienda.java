package ejer4;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Tienda
 */
@WebServlet("/Tienda")
public class Tienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tienda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ArrayList<String> productos = new ArrayList<>();
		//HttpSession sesion  = request.getSession();
		//sesion.setAttribute("Compra", productos);
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html>\r\n"
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
				+ "    <form action=\"TransicionTiendaCarrito\" method=\"post\">\r\n"
				+ "    <select name=\"productos\">\r\n"
				+ "        <option value=\"Chorizo\">Chorizo</option>\r\n"
				+ "        <option value=\"Costillas\">Costillas</option>\r\n"
				+ "        <option value=\"Filetes\">Filetes</option>\r\n"
				+ "        <option value=\"Muslitos\">Muslitos</option>\r\n"
				+ "        <option value=\"Salchichas\">Salchichas</option>\r\n"
				+ "    </select>\r\n"
				+ "    <input type=\"submit\" value=\"Añadir\">;\r\n"
				+ "</form>\r\n"
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
