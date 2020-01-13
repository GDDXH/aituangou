package com.aituangou.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class BaseDAO {
	private Log log = LogFactory.getLog(BaseDAO.class);
	private SessionFactory sessionFactory;
	protected Session  session;
	protected Transaction transaction;
	public Session getSession(){
		return sessionFactory.openSession();	
	}
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public List find(String hql) {
		List<Object> list =null;
        try {
        	session=getSession();
            String queryString = hql;
            Query queryObject = session.createQuery(queryString);
            list = queryObject.list();
            session.close();
        } catch (RuntimeException re) {
            throw re;
        } 
        return list;
    }

    public boolean update(Object object){
        log.debug("updating object");
        try{
        	session = getSession();
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
            session.flush();
            log.debug("update successful");
    		return true;
        }catch (RuntimeException re){
            log.error("update failed",re);
            throw re;
        }finally {
            session.close();
        }

    }

    public boolean save(Object object){
        log.debug("saving object instance");
        try{
        	session = getSession();
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
            session.flush();
            log.debug("save successful");
            return true;
        }catch (RuntimeException re){
            log.error("save failed",re);
            throw re;
        }finally {
            session.close();
        }
    }
    public void delete(Object object) {
        try{
        	session = getSession(); 
        	transaction = session.beginTransaction(); 
            session.delete(object);
            transaction.commit();
            session.flush();
        }catch (RuntimeException re){
        	if(transaction != null) 
        		transaction.rollback();
            throw re;
        }finally {
            session.close();
        }
	}
}
