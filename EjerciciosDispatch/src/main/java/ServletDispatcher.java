

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletDispatcher
 */
public class ServletDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher despachador ;//= request.getServletContext().getRequestDispatcher("/ServletCorrecto");
		//RequestDispatcher incorrecto = request.getServletContext().getRequestDispatcher("/ServletError");
		String pswrd = request.getParameter("cmpclave");
		if(pswrd.equals("admin")) {
			despachador = request.getServletContext().getRequestDispatcher("/ServletCorrecto");
		}else {
			despachador = request.getServletContext().getRequestDispatcher("/ServletError");
		}
		despachador.forward(request, response);
		
	}

}
