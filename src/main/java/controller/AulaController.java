package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AulaDAO;
import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class AulaController
 */
public class AulaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AulaDAO aDao = new AulaDAO();
	RequestDispatcher rd;

    /**
     * Default constructor. 
     */
    public AulaController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (action.equals("listar")) {
			listar(request,response);
		}
	}
	
	protected void listar(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String queryParam = request.getParameter("query");
		List<Aula> aulas = aDao.getAulas(queryParam);
		request.setAttribute("aulas", aulas);
		rd = request.getRequestDistpatcher("/main.jsp");
		rd.forward(request, response);
	}

}
