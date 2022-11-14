package Ejercicio2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Servlet implementation class ServletConcurrencia
 */
public class ServletConcurrencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int total = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConcurrencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private final Object lock = new Object();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Random r = new Random();
		ArrayList<Integer> numeros = new ArrayList<>();
		for(int i = 0;i<1000;i++) {
			numeros.add(r.nextInt());
		}
		
		synchronized (lock) {
			 for(int num :numeros) {
				 total += num;
			 }
			 for(int num:numeros) {
				 total -= num;
			 }
			 response.getWriter().append("El total"+total);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
