package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;

import dao.UsuarioDAO;
import jakarta.servlet.RequestDispatcher;
import model.Aula;
import model.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDAO uDao = new UsuarioDAO();
	AulaDAO aDao = new AulaDAO();
	RequestDispatcher rd;
    /**
     * Default constructor. 
     */
    public UsuarioController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("editar")) {
			editar(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equals("login")) {
			login(request,response);
		}
	}
	
	protected void login(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("username");
		String password = Digest.md5Hex(request.getParameter("password"));
		
		HttppSession session = request.getSession();
		
		Usuario logged = uDao.login(usuario, password);
		
		List<Aula> aulas = aDao.getAulas("");
		
		if (logged != null) {
			session.setAttribute("user", logged);
			session.setAttribute("aulas", aulas);
			rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
		}else {
			String msg = "Usuario u/o Uusuario incorrecto";
			request.setAttribute("message", msg);
			rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}
	
	
	protected void editar(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		jakarta.servlet.http.HttpServletRequest session = request.getSession();
		
		Usuario usuario = (Usuario)session.getAttribute("user");
		int idusuario = usuario.getIdusuario();
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		if (!password.equals(usuario.getPassword())) {
			password = DigestUtils.md5Hex(password).toString();
		}
		String email = request.getParameter("email");
		String puesto = request.getParameter("puesto");
		
		boolean editado = uDao.editar(idusuario, nombre, password, email, puesto);
		
		if (editado) {
			usuario.setNombre(nombre);
			usuario.setPassword(password);
			usuario.setEmail(email);
			usuario.setPuesto(puesto);
			
			session.setAttribute("user", usuario);
		}
		
		rd = request.getRequestDispatcher("/perfil.jsp");
		rd.forward(request, response);
	}
}




