package br.edu.cba.ifmt.DAO;

import java.util.ArrayList;
import java.util.List;

import br.edu.cba.ifmt.Model.City;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory; 


public class CityDAO {
	private SessionFactory _sessionFactory = HibernateUtil.getSessionFactory(); 
	
    public List<City> getAll() {
        List<City> cities = new ArrayList<>();
        Session session = SessionUtil.sessionOpen(_sessionFactory);
           	
        if (session == null)
			return cities;
		
        try {
        	cities = session.createQuery("from City").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			SessionUtil.sessionClose(session);
		}
        
        return cities;
    }
	
	public City getById(int id)  {
		City city = new City();		
	    Session session = SessionUtil.sessionOpen(_sessionFactory);
	    
	    if (session == null)
	    	return city;
	    
		try {
			city = (City) session.get(City.class, Integer.valueOf(id));
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			SessionUtil.sessionClose(session);
        }
		
		return city;
	}
}