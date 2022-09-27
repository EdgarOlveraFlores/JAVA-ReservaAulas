package dao;
import model.Usuario;
import utils.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UsuarioDAO {
	public Usuario login(String username, String password) {
		Usuario usuario = null;
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		com.mysql.cj.xdevapi.Session session = sessFact.getCurrentSession();
		
		jakarta.transaction.Transaction tr = null;
		
		try {
			tr = session.beginTransaction();
			Query<Usuario> query = (Query<Usuario>)session.createQuery("SELECT u FROM Usuario u WHERE u.username = '" + username+ "' and u.password = '"+ password+"'");
			List<Usuario> usuarios = query.list();
			if (usuario.size() > 0) {
				usuario = usuarios.get(0);
				return usuario;
			}else {
				return null;
			}

		} catch (Exception e) {
			if (tr!=null) {
				tr.rollback();
			}
			e.printStackTrace();
			return null;
		}finally {
			session.close();
			sessFact.close();
		}
	}
}
