package controller;

import java.io.IOException;
import model.Reserva;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ReservaController
 */
public class ReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReservaDAO rDao = new ReservaDAO();
	
	RequestDispatcher rd;
    /**
     * Default constructor. 
     */
    public ReservaController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (action.equals("action")) {
			listar(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		doGet(request, response);
	}
	
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idusuario = Integer.parseInt(request.getParameter("idusuario"));
		
		List<Reserva> reservas = rDao.getReservas(idusuario);
		
		request.detAttribute("resrevas", reservas);
		
		rd = request.getRequestDistpatcher("/reservas.jsp");
		rd.forward(request, response);

	}
	
	
	protected void listar(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int idreserva = Integer.parseInt(request.getParameter("idreserva"));
		boolean liberado = rDao.liberar(idreserva);
		
		request.detAttribute("liberado", liberado);
		
		Usuario usuario = (Usuario)session.getAttribute("user");
		
		rd = request.getRequestDispatcher("/reserva?action=listar&idusuario="+usuario.getIdusuario());
		rd.forward(request, response);
	}
	
}
