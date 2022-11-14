package Ejercicio1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.locks.Lock;

import org.apache.tomcat.util.descriptor.web.ServletDef;

/**
 * Servlet implementation class Servletinicio1
 */
public class Servletinicio1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object lock  = new Object();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletinicio1() {
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
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		pw.println("<html><body><form action = \"\" method = \"post\"><input type=\"text\" name=\"nume\"><input type=\"submit\"></form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getServletContext().getAttribute("numero");
		
		String num = request.getParameter("nume");
		System.out.println(num);
		
		try {
			Thread.sleep(10000);
			synchronized (lock) {
				request.getServletContext().setAttribute("numero", num);
				request.getRequestDispatcher("/SegundoServlet1").forward(request, response);
			}
				 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
