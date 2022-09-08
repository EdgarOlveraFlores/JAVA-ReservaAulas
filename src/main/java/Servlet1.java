

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletRequest response) throws jakarta.servlet.ServletException, IOException {
		// TODO Auto-generated method stub
		String parametro1 = request.getParameter("parametro1");
		request.setAttribute("parametro2", "python");
		System.out.println("Recibiendo Peticion con metodo GET"+ parametro1);
		
		HttpSession session = request.getSession();
		session.setAttribute("parametroSesion", "usuario1");
		
		String usuario = (String)session.getAttribute("parametroSesion");
		
		System.out.println("Parametro de sesion: " + usuario);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(jakarta.servlet.http.HttpServletRequest request, Servlet1 response) throws jakarta.servlet.ServletException, IOException {
		// TODO Auto-generated method stub
		String parametro1 = request.getParameter("parametro1");
		System.out.println("Recibiendo Peticion con metodo POST");
	}

}
