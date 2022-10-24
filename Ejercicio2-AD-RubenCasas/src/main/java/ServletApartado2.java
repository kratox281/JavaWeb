

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletApartado2
 */
@WebServlet("/ServletApartado2")
public class ServletApartado2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static String paramContext ="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletApartado2() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	paramContext = (String) config.getServletContext().getInitParameter("color");
    	}
    	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			getServletConfig().getServletContext().setAttribute("color", request.getParameter("colo"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body style=\"background-color:"+(request.getParameter("colo")!=null?request.getServletContext().getAttribute("color"):paramContext)+";\">");
		out.println("<form action=\"Servlet1Apartado4\" method=\"get\">\r\n"
				+ "    <input type=\"submit\" >\r\n"
				+ "    \r\n"
				+ "</form>");
		out.println("</body>");
		out.println("</html>");

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
