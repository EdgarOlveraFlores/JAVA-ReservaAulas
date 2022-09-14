package utils;

import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
		}catch(Throwable e) {
			System.out.println("Error"+ e);
			throw new ExceptionInInitializerError();
		}
		return sessionFactory;
	}
}
