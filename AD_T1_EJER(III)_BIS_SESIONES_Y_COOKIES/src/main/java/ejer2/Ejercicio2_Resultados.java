package ejer2;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.naming.Context;

/**
 * Servlet implementation class Ejercicio2_Resultados
 */
public class Ejercicio2_Resultados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio2_Resultados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cs = request.getCookies();
		boolean votado=false;
		ArrayList<String> sintomas = (ArrayList<String>) getServletContext().getAttribute("sintomas");
		if(cs!=null) {
		for(Cookie c: cs) {
			if(c.getValue().equals(request.getParameter("usuario"))) {
				votado=true;
			}
		}
		}
		if(votado) {
			response.getWriter().append("Usted ya ha votado");
		}else {
			Cookie c = new Cookie(request.getParameter("usuario"),request.getParameter("usuario"));
			response.addCookie(c);
			//votantes.add(request.getParameter("usuario"));
			//getServletContext().setAttribute("votantes", votantes);
			comprobaciones(sintomas, request);
			Map<String,Integer> mapa = contarYeditar(sintomas);
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html><body>");
			pw.println("<table border=\"1px  solid black\">");
			for(Map.Entry<String, Integer> entrada:mapa.entrySet()) {
				pw.println("<tr>");
				pw.println("<td>"+entrada.getKey()+"</td>");
				pw.println("<td>"+entrada.getValue()+"</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
			pw.println("</body></html>");
			
		}
		
	}
	
	private void comprobaciones(ArrayList<String> compro,HttpServletRequest request) {
		if(request.getParameter("sintomas1")!=null) {
			compro.add(request.getParameter("sintomas1"));
		}
		if(request.getParameter("sintomas2")!=null) {
			compro.add(request.getParameter("sintomas2"));
		}
		if(request.getParameter("sintomas3")!=null) {
			compro.add(request.getParameter("sintomas3"));
		}
		if(request.getParameter("sintomas4")!=null) {
			compro.add(request.getParameter("sintomas4"));
		}
		if(request.getParameter("sintomas5")!=null) {
			compro.add(request.getParameter("sintomas5"));
		}
		
	}
	private Map<String,Integer>contarYeditar(ArrayList<String> compro) {
		Map<String,Integer> mapa = new HashMap();
		for(String s:compro) {
			if(mapa.containsKey(s)) {
				int temp=mapa.get(s)+1;
				mapa.remove(s);
				mapa.put(s,temp);
			}else {
				mapa.put(s, 1);
			}
		}
		return mapa;
	}

}
