package com.aituangou.dao;

import com.aituangou.dao.impl.ISellerDAO;
import com.aituangou.po.Seller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class SellerDAO extends BaseDAO implements ISellerDAO {
    private Log log = LogFactory.getLog(SellerDAO.class);

    public boolean save(Seller instance) {
        log.debug("saving Seller instance");
        try {
        	session = getSession();
	        transaction = session.beginTransaction();
            session.save(instance);
            transaction.commit();
            log.debug("save successful");
            return true;
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        } finally {
        	session.close();
        }
    }
    
    public List findById(String sid) {
		try {
			session = getSession();
			String queryString = "from Seller as seller where seller.id='" +sid+"'";
			Query queryObject = session.createQuery(queryString); 
			List<Seller> list = queryObject.list(); 
			session.close();
			return list;
		} catch (RuntimeException re) { 
			throw re; 
		}
	}

    public boolean update(Seller seller){
        log.debug("updating seller");
        try{
        	session = getSession();
	        transaction = session.beginTransaction();
            session.update(seller);
            transaction.commit();
            log.debug("update success");
            return true;
        } catch (RuntimeException re){
            log.error("update fail",re);
            throw re;
        } finally {
        	session.close();
        }
    }

    public List findByHql(String hql) {
        log.debug("finding Seller instance by hql");
        try {
        	session = getSession();
            String queryString = hql;
            Query queryObject = session.createQuery(queryString);
            List<Seller> list = queryObject.list(); 
			session.close();
			return list;
        } catch (RuntimeException re) {
            log.error("find by hql failed", re);
            throw re;
        }
    }
}
