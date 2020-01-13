package com.aituangou.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aituangou.dao.impl.IBuyerDAO;
import com.aituangou.po.Seller;

import com.aituangou.po.Buyer;

public class BuyerDAO extends BaseDAO implements IBuyerDAO {
	private Log log = LogFactory.getLog(BuyerDAO.class);
	public List find(String hql) {
        try {
        	session = getSession();
            String queryString = hql;
            Query queryObject = session.createQuery(queryString);
            List<Object> list = queryObject.list();
            session.close();
            return list;
        } catch (RuntimeException re) {
            throw re;
        }
	}
	public List findById(String bid) {
		try {
			session = getSession();
			String queryString = "from Buyer as buyer where buyer.id='" +bid+"'";
			Query queryObject = session.createQuery(queryString); 
            List<Buyer> list = queryObject.list();
            session.close();
            return list;
		} catch (RuntimeException re) { 
			throw re; 
		}
	}
    public boolean save(Seller seller) {
        log.debug("saving Buyer instance");
        try {
        	session = getSession(); 
        	transaction = session.beginTransaction(); 
        	session.save(seller);
        	transaction.commit();
            log.debug("save successful");
            return true;
        } catch (RuntimeException re) {
            log.error("save failed", re);
            return false;
        }
        finally{
            session.close();
        } 
    }

    public boolean update(Seller seller){
        log.debug("updating Buyer");
        try{
        	session = getSession(); 
        	transaction = session.beginTransaction(); 
            session.update(seller);
            transaction.commit();
            log.debug("update success");
            return true;
        }catch (RuntimeException re){
            log.error("update fail",re);
            return false;
        }finally{
            session.close();
        } 
    }
    public boolean delete(Buyer transientInstance) {
        try{
        	session = getSession(); 
        	transaction = session.beginTransaction(); 
            session.delete(transientInstance);
            transaction.commit();
            session.flush();
            return true;
        }catch (RuntimeException re){
        	if(transaction != null) 
        		transaction.rollback();
        	return false;
        }finally {
            session.close();
        }
	}

}
