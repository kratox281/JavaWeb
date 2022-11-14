package ejer5;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Total
 */
@WebServlet("/Total")
public class Total extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Total() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"es\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h1 style=\"font-weight: bolder;\">Compra Total</h1>\r\n"
				+ "    <table>\r\n"
				+ "        <tr>\r\n"
				+ "            <td>Titulo del libro</td>\r\n"
				+ "            <td>Unidades</td>\r\n"
				+ "            <td>Precio</td>\r\n");
		
		Cookie[] cs = request.getCookies();
		for(Cookie c:cs) {
		    String nombre = c.getName();
		    int cantidad =Integer.parseInt(c.getValue());
		    int precio=0;
		    switch (nombre) {
                case "Java":
                    precio=cantidad*9;
                    break;
                case "C":
                    precio=cantidad*2;
                    break;
                case "C++":
                    precio=cantidad*1;
                    break;
                case "Python":
                    precio=cantidad*10;
                    break;     
            }
 			pw.println("<tr>");
			pw.println("<td>"+nombre+"</td>");
			pw.println("<td>"+cantidad+"</td>");
			pw.println("<td>"+precio+"</td>");
			pw.println("</tr>");
		}
		pw.println("    </table>\r\n"
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
