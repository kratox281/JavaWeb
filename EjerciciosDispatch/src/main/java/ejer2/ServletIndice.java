package ejer2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletIndice
 */
public class ServletIndice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIndice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE HTML>\r\n"
				+ "<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Pagina de inicio</title>\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "        <form action=\"ServletDespachador\" method = \"post\">\r\n"
				+ "            <table align=\"center\" border=\"1\">\r\n"
				+ "                <tr>\r\n"
				+ "                    <td align=\"center\" colspan=\"2\" bgcolor=\"AABBFF\">\r\n"
				+ "                        <h2>Tablas de multiplicar</h2>\r\n"
				+ "                    </td>\r\n"
				+ "                </tr>\r\n"
				+ "                <tr bgcolor=\"orange\">\r\n"
				+ "                    <td align=\"right\"><b>Numero:</b></td>\r\n"
				+ "                    <td>\r\n"
				+ "                        <select name=\"listaTabla\">\r\n"
				+ "                            <option value=\"0\" selected>Elige una tabla</option>\r\n"
				+ "                            <option value=\"1\">1</option>\r\n"
				+ "                            <option value=\"2\">2</option>\r\n"
				+ "                            <option value=\"3\">3</option>\r\n"
				+ "                            <option value=\"4\">4</option>\r\n"
				+ "                            <option value=\"5\">5</option>\r\n"
				+ "                            <option value=\"6\">6</option>\r\n"
				+ "                            <option value=\"7\">7</option>\r\n"
				+ "                            <option value=\"8\">8</option>\r\n"
				+ "                            <option value=\"9\">9</option>\r\n"
				+ "                            <option value=\"10\">10</option>\r\n"
				+ "                        </select>\r\n"
				+ "                    </td>\r\n"
				+ "                </tr>\r\n"
				+ "                <tr>\r\n"
				+ "                    <td align=\"right\" colspan=\"2\">\r\n"
				+ "                        <font color=\"gray\">Elige un color para la tabla</font>\r\n"
				+ "                        <hr/>\r\n"
				+ "                        Negro<input type=\"radio\" name=\"color\" value=\"gray\" checked=\"checked\"/><br/>\r\n"
				+ "                        Rojo<input type=\"radio\" name=\"color\" value=\"red\"/><br/>\r\n"
				+ "                        Verde<input type=\"radio\" name=\"color\" value=\"green\"/><br/>\r\n"
				+ "                        Azul<input type=\"radio\" name=\"color\" value=\"#AABBFF\"/><br/>\r\n"
				+ "                        Naranja<input type=\"radio\" name=\"color\" value=\"orange\"/>\r\n"
				+ "                    </td>\r\n"
				+ "                </tr>\r\n"
				+ "                <tr>\r\n"
				+ "                    <td align=\"center\" colspan=\"2\" bgcolor=\"AABBFF\">\r\n"
				+ "                        <input type=\"submit\" value=\"Crear\"/>\r\n"
				+ "                        <input type=\"reset\" value=\"Borrar\"/>\r\n"
				+ "                    </td>\r\n"
				+ "                </tr>\r\n"
				+ "            </table>\r\n"
				+ "        </form>\r\n"
				+ "    </body>\r\n"
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
