package com.aituangou.dao;

import com.aituangou.dao.impl.IGoodCheckDAO;
import com.aituangou.po.GoodCheck;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import java.util.List;

public class GoodCheckDAO extends BaseDAO implements IGoodCheckDAO {
    private Log log = LogFactory.getLog(GoodCheckDAO.class);


	public int getMaxId(){
        int id=0;
        try {
        	session = getSession();
            String queryString = "select max(id) from GoodCheck";
            Query queryObject = session.createQuery(queryString);
            id = (int)queryObject.list().get(0);
        } catch (RuntimeException re) {
            log.error("find by hql failed", re);
            throw re;
        }finally {
        	session.close();
        }
        return id;
    }
    public List findById(Integer gid) {
		try {
			session=getSession();
			String queryString = "from GoodCheck as good where good.id='" +gid+"'";
			Query queryObject = session.createQuery(queryString); 
            List<GoodCheck> list = queryObject.list();
            session.close();
            return list;
		} catch (RuntimeException re) { 
			throw re; 
		}
	}
    public void save(GoodCheck instance){
        log.debug("saving GoodCheck instance");
        try {
        	session = getSession(); 
        	transaction = session.beginTransaction(); 
            session.save(instance);
            transaction.commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }finally {
        	session.close();
        }
    }

    public List findByShopId(int shopid){
        log.debug("finding goodcheck by shopid");
        try{
        	session = getSession();
            String queryString = "from GoodCheck where shop.shopid='"+shopid+"'";
            Query query = session.createQuery(queryString);
            log.debug("find success");
            List<GoodCheck> list = query.list();
            session.close();
            return list;
        }catch (RuntimeException re){
            log.error("find failed",re);
            throw re;
        }
    }

    public void delete(GoodCheck goodCheck){
        log.debug("deleting goodcheck");
        try{
        	session = getSession(); 
        	transaction = session.beginTransaction(); 
            session.delete(goodCheck);
            transaction.commit();
            log.debug("delete success");
        }catch (RuntimeException re){
            log.error("delete failed",re);
            throw re;
        }finally {
			session.close();
		}
    }

    public List findGoodCheckById(int id){
        log.debug("finding goodcheck by id");
        try{
        	session = getSession();
            String queryString = "from GoodCheck where id='"+id+"'";
            Query query = session.createQuery(queryString);
            List<GoodCheck> list = query.list();
            session.close();
            return list;
        }catch (RuntimeException re){
            log.error("find failed");
            throw re;
        }
    }
	@Override
	public boolean update(GoodCheck transientInstance) {
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
}
