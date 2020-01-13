package com.aituangou.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aituangou.dao.impl.IAdminDAO;

import com.aituangou.po.Admin;

public class AdminDAO extends BaseDAO implements IAdminDAO{
	public List find(String hql) {
     
        try {
        	session=getSession();
            String queryString = hql;
            Query queryObject = session.createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            throw re;
        } finally{
            session.close();
        }        
	}
	public List findById(String aid){
		try {
			session = getSession();
			String queryString = "from Admin as admin where admin.aid='" +aid+"'";
			Query queryObject = session.createQuery(queryString); 
			List<Admin> list = queryObject.list();
			return list; 
		} catch (RuntimeException re) { 
			throw re; 
		} finally{
            session.close();
        }  
	}
	public boolean save(Admin transientInstance) { 
		try { 
			session = getSession(); 
			transaction = session.beginTransaction(); 
			session.save(transientInstance); 
			transaction.commit(); 
			return true;
		} catch (RuntimeException re) { 
			if(transaction != null)
				transaction.rollback();
			return false;
		} finally { 
			session.close(); 
		}
	}
	public void update(Admin transientInstance) {
		try { 
			session = getSession(); 
			transaction = session.beginTransaction(); 
			session.update(transientInstance); 
			transaction.commit(); 
		} catch (RuntimeException re) { 
			if(transaction != null)
				transaction.rollback();
		} finally { 
			session.close(); 
		}
	}	
	public void delete(Admin transientInstance) {
 
        try{
        	session = getSession(); 
			transaction = session.beginTransaction(); 
            session.delete(transientInstance);
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
