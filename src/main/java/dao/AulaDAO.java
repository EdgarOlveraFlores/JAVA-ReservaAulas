package dao;

import java.util.*;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

import jakarta.transaction.Transaction;
import model.Aula;
import utils.HibernateUtil;

public class AulaDAO {
	
	public List<Aula> seleccionarAulas(){
		
		List<Aula> aulas = new ArrayList<Aula>();
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		
		Session session = sessFact.getCurrentSession();
		
		Transaction tr = null;
		 
		try {
			 
			tr = session.beginTransaction();
			aulas = session.createQuery("SELECT a FROM Aula a", Aula.class).getResultList();
			
		}catch( Exception e){
			
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
			aulas =  null;
			
		}
		finally {
			session.close();
			sessFact.close();
		}
		return aulas;
		
	}

	public Aula obtenerAula(int numAula) {
		Aula aula = new Aula();
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		
		Session session = sessFact.getCurrentSession();
		
		Transaction tr = null;
		try {
			tr = session.beginTransaction();
			aula = session.get(Aula.class,numAula);
			
		}catch( Exception e){
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
			aula = null;

		}
		finally {
			session.close();
			sessFact.close();
		}
		return aula;
	}
	
	public boolean crear(int numAula, String nombre, String descripcion, int capacidad) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		Transaction tr = null;
		try {
			tr = session.beginTransaction();
			Aula aula = new Aula();
			aula.setNumaula(numAula);
			aula.setNombre(nombre);
			aula.setCapacidad(capacidad);
			aula.setDescripcion(descripcion);
			
			session.save(aula);
			
			tr.commit();
			return true;
			
		}catch( Exception e){
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
			return false;

		}
		finally {
			session.close();
			sessFact.close();
		}
	}
	
	public boolean actualizar(int numAula, String nombre, int capacidad, String descripcion) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		Transaction tr = null;
		try {
			tr = session.beginTransaction();
			Aula aula = new Aula();
			aula.setNombre(nombre);
			aula.setCapacidad(capacidad);
			aula.setDescripcion(descripcion); 
			
			session.update(aula);
			
			tr.commit();
			
			return true;
		}catch( Exception e){
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
			return false;

		}
		finally {
			session.close();
			sessFact.close();
		}
	}

	public boolean eliminar(int numAula, String nombre, int capacidad, String descripcion) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		Transaction tr = null;
		try {
			tr = session.beginTransaction();
			Aula aula = session.get(Aula.class,numAula);
			session.delete(aula);
			
			tr.commit();
			
			return true;
			
		}catch( Exception e){
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
			return false;

		}
		finally {
			session.close();
			sessFact.close();
		}
	}
	public List<Aula> getAulas(String filter){
		List<Aula> aulas = new ArrayList<Aula>();
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		Transaction tr = null;
		
		try {
			tr = session.beginTransaction();
			String sql = "SELECT a FROM Aula a";
			
			
			if (filter != null && !filter.equals("")) {
				sql += "where descripcion like '%" + filter + "%'";
			}
			
			Query<Aula> query = (Query<Aula>)session.createQuery(sql);
			aulas = query.list();
			
			tr.commit();
			
			return true;
			
		}catch( Exception e){
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();

		}
		finally {
			session.close();
			sessFact.close();
		}
		return aulas;
	}
}
