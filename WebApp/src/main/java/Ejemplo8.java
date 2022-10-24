

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo8
 */
@WebServlet("/Ejemplo8")
public class Ejemplo8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n = 0;
		response.setContentType("text/plain");
		Cookie[] cs = request.getCookies();
		
		if(cs!=null) {
			for(Cookie c :cs) {
				if (c.getName().equals("cont")) {
					n = Integer.parseInt(c.getValue())+1;
					break;
				}
			}
		}
		Cookie c = new Cookie("cont",String.valueOf(n));
		c.setMaxAge(60*60*24*365);
		response.addCookie(c);
		response.getWriter().append("Número de visitas: "+n);
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
