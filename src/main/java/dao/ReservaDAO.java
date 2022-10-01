package dao;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.Query;
import com.mysql.cj.xdevapi.Session;
import com.mysql.cj.xdevapi.SessionFactory;

import jakarta.transaction.Transaction;
import model.Reserva;
import utils.HibernateUtil;

public class ReservaDAO {

	public List<Reserva> getReservas(int idusuario){
		List<Reserva> resrevas = new ArrayList<Reserva>();
		
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		Transaction tr = null;
		
		try {
			tr = session.beginTransaction();
			Query<Reserva> query = (Query<Reserva>)session.createQuery("Select r from Reserva r where r.usuario.idusuario = " + idusuario);
		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
			sessFact.close();
		}
		return resrevas;
	}
	
	public boolean liberar(int idresreva) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		Transaction tr = null;
		
		try {
			tr = session.beginTransaction();
			Reserva resreva = (Reserva)session.get(Reserva.class, idresreva);
			
			int numaula = resreva.getAula().getNumaula();
			Aula aula = (Aula)session.get(Aula.class, numaula);
			aula.setEstado(false);
			session.update(aula);
			
			session.delete(reserva);
			
			tr.commit();
			
			return true;
			
		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
			return false;
		}finally {
			session.close();
			sessFact.close();
		}
		return resrevas;
	}
}
