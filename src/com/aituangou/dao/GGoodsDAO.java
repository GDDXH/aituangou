package com.aituangou.dao;

import com.aituangou.dao.impl.IGGoodsDAO;
import com.aituangou.po.GGoods;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GGoodsDAO extends BaseDAO implements IGGoodsDAO {
    private Log log = LogFactory.getLog(GGoodsDAO.class);

    public List findGGoodById(int id){
        log.debug("finding GGoods instance by id");
        String hql = "from GGoods where id='"+id+"'";
        try {
        	session = getSession();
            String queryString = hql;
            Query queryObject = session.createQuery(queryString);
			List<GGoods> gGoods = queryObject.list(); 
			session.close();
			return gGoods;
        }catch (RuntimeException re){
            log.error("find by id failed",re);
            throw re;
        }
    }
    
    public List findById(Integer gid) {	
		try {
			session = getSession();
			String queryString = "from GGoods as goods where goods.id='" +gid+"'";
			Query queryObject = session.createQuery(queryString); 
			List<GGoods> gGoods = queryObject.list(); 
			session.close();
			return gGoods;
		} catch (RuntimeException re) { 
			throw re; 
		}
	}
    public void update(GGoods instance) {
        log.debug("updating instance");
        try{
        	session = getSession(); 
        	transaction = session.beginTransaction(); 
            session.update(instance);
            transaction.commit();
            log.debug("update successful");
        }catch (RuntimeException re){
            log.error("update failed",re);
            throw re;
        }finally {
        	session.close();
        }
    }

	@Override
	public boolean save(GGoods ggoods) {
		try { 
			session = getSession(); 
			transaction = session.beginTransaction(); 
			session.save(ggoods); 
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
}
