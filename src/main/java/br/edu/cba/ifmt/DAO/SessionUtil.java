package br.edu.cba.ifmt.DAO;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;

public class SessionUtil {
	public static Session sessionOpen(SessionFactory sessionFactory) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	public static void sessionClose(Session session) {
	    if (session != null) {
	        try {
	            session.close();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
