package com.aituangou.dao;

import com.aituangou.dao.impl.IGoodsDAO;
import com.aituangou.po.Goods;
import com.aituangou.po.Shop;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;

import java.util.List;

public class GoodsDAO extends BaseDAO implements IGoodsDAO {
    private Log log = LogFactory.getLog(GoodsDAO.class);
    
	public List find(String hql) {
        try {
        	session=getSession();
            String queryString = hql;
            Query queryObject = session.createQuery(queryString);
            List<Object> list = queryObject.list();
            session.close();
            return list;
        } catch (RuntimeException re) {
            throw re;
        }
	}
    public List findByShop(Shop shop){
        log.debug("finding Goods instance by shop");
        String hql = "from Goods as goods where goods.shop.shopid='"+shop.getShopid()+"'";
        try {
        	session = getSession();
            String queryString = hql;
            Query queryObject = session.createQuery(queryString);
            List<Goods> list = queryObject.list();
            session.close();
            return list;
        } catch (RuntimeException re) {
            log.error("find by hql failed", re);
            throw re;
        }
    }
    public List findById(Integer gid) {
		try {
			session = getSession();
			String queryString = "from Goods as goods where goods.id='" +gid+"'";
			Query queryObject = session.createQuery(queryString); 
            List<Goods> list = queryObject.list();
            session.close();
            return list;
		} catch (RuntimeException re) { 
			throw re; 
		}
	}
    
    public List findGoodById(int id){
        log.debug("finding Goods instance by id");
        String hql = "from Goods where id='"+id+"'";
        try {
        	session = getSession();
            String queryString = hql;
            Query queryObject = session.createQuery(queryString);
            List<Goods> list = queryObject.list();
            session.close();
            return list;
        }catch (RuntimeException re){
            log.error("find by id failed",re);
            throw re;
        }
    }

    public boolean update(Goods instance) {
        log.debug("updating instance");
        try{
        	session = getSession(); 
        	transaction = session.beginTransaction(); 
            session.update(instance);
            transaction.commit();
            log.debug("update successful");
            return true;
        }catch (RuntimeException re){
            log.error("update failed",re);
            throw re;
        }finally {
        	session.close();
        }
    }


	public int getMaxId(){
        log.debug("finding max id instance by hql");
        int id=0;
        try{
        	session = getSession();
            String queryString = "select max(id) from Goods";
            Query queryObject = session.createQuery(queryString);
            id = (int)queryObject.list().get(0);
            session.close();
        }catch (RuntimeException re){
            log.error("find by hql failed", re);
            throw re;
        }
        return id;
    }
	@Override
	public void delete(Goods transientInstance) { 
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
	@Override
	public boolean save(Goods good) {
		try { 
			session = getSession(); 
			transaction = session.beginTransaction(); 
			session.save(good); 
			transaction.commit(); 
			return true;
		} catch (RuntimeException re) { 
			if(transaction != null) transaction.rollback();
			return false;
		} finally { 
			session.close(); 
		}
	}
    
}
