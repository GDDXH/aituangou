package com.aituangou.dao;

import com.aituangou.dao.impl.IShopDAO;
import com.aituangou.po.Shop;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ShopDAO extends BaseDAO implements IShopDAO {
    private Log log = LogFactory.getLog(ShopDAO.class);


	public Shop createShop(Shop instance){
        log.debug("create Shop instance");
        try {
        	session = getSession();
	        transaction = session.beginTransaction();
            session.save(instance);
            transaction.commit();
            session.close();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
        return instance;
    }
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

	public List findById(Integer shopid) {
		try {
			session=getSession();
			String queryString = "from Shop as shop where shop.shopid='" +shopid+"'";
			Query queryObject = session.createQuery(queryString); 
			List<Object> list = queryObject.list();
			session.close();
			return list;
		} catch (RuntimeException re) { 
			throw re; 
		}
	}

	public boolean save(Shop transientInstance) {
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

	public boolean update(Shop transientInstance) {
        try{
        	session = getSession();
	        transaction = session.beginTransaction();
            session.update(transientInstance);
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

	public void delete(Shop transientInstance) {
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
