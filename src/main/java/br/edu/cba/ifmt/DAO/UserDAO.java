package br.edu.cba.ifmt.DAO;

import java.util.ArrayList;
import java.util.List;

import br.edu.cba.ifmt.Model.User;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration; 
import net.sf.hibernate.Transaction; 

public class UserDAO {
	private SessionFactory _factory; 
	
	public UserDAO() throws Exception{
	    _factory = new Configuration().configure().buildSessionFactory();
	}
	
    public List<User> getAll() throws HibernateException {
        List<User> users = null;
        Session session = null;

        try {
            session = _factory.openSession();
            Query query = session.createQuery("from User");
            users = query.list();
        } catch (HibernateException e) {
            System.err.println("Erro em UserDAO.getAll() do Hibernate: " + e.getMessage());
            throw new RuntimeException("Falha ao buscar todos os usuários", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users != null ? users : new ArrayList<>();
    }
	
	public User getById(int id) throws HibernateException {
		User user = new User();		
	    Session session = null;
	    
		try {
			session = _factory.openSession(); 
			
			user = (User) session.get(User.class, Integer.valueOf(id));
		} catch (Exception e) {
            System.err.println("Erro em UserDAO.getById(): " + e.getMessage());
			e.printStackTrace();
		} finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
		return user;
	}
	
	public boolean add(User user) throws HibernateException {
		boolean operation = false;
		
		Session session = _factory.openSession(); 
		Transaction tx = null;
		
		try {
		    tx = session.beginTransaction();
			session.save(user); 
			tx.commit();
			
		 	operation = true; 
		} catch (Exception e) {
			operation = false;
	        System.err.println("Erro em UserDAO.add(): " + e.getMessage());
			e.printStackTrace();
		} finally {
		    session.close();
		}
		return operation;
	}
	
	public boolean update(int id, User user) throws HibernateException {
		boolean operation = false;
		
		Session session = _factory.openSession(); 
		Transaction tx = null;
		
		try {
			User registeredUser = getById(id);
			if (registeredUser == null) {
				return false;
			}
			
		    tx = session.beginTransaction();
			session.update(user); 
			tx.commit();
		
		 	operation = true; 
		} catch (Exception e) {
			operation = false;
            System.err.println("Erro em UserDAO.update(): " + e.getMessage());
			e.printStackTrace();
		} finally {
		    session.close();
		}
		return operation;
	}
	
	public boolean delete(int id) throws HibernateException {
		boolean operation = false;
		
		Session session = _factory.openSession(); 
		Transaction tx = null;
		
		try {
			session = _factory.openSession();
			
			User registeredUser = getById(id);
			if (registeredUser == null) {
				return false;
			}
			
		    tx = session.beginTransaction();
			session.delete(registeredUser); 
			tx.commit();
			
		 	operation = true; 
		} catch (Exception e) {
            System.err.println("Erro em UserDAO.delete(): " + e.getMessage());
			e.printStackTrace();
		}finally {
			session.close();
        }
		return operation;
	}
}
