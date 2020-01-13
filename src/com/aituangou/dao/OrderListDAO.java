package com.aituangou.dao;

import com.aituangou.dao.impl.IOrderListDAO;
import com.aituangou.po.Cart;
import com.aituangou.po.Goods;
import com.aituangou.po.Groups;
import com.aituangou.po.OrderList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import java.util.List;

public class OrderListDAO extends BaseDAO implements IOrderListDAO {
    private Log log = LogFactory.getLog(OrderListDAO.class);

    public List findByHql(String hql) {
        log.debug("finding OrderInfo by hql");
        List<Object> list=null;
        try {
        	session = getSession();
            String queryString = hql;
            Query queryObject = session.createQuery(queryString);
            list = queryObject.list();
            session.close();
            return list;
        } catch (RuntimeException re) {
            log.error("find by hql failed", re);
            throw re;
        }
    }

    public void update(OrderList orderList){
        log.debug("updating OrderInfo ");
        try{
        	session = getSession(); 
        	transaction = session.beginTransaction(); 
            session.update(orderList);
            transaction.commit();
            log.debug("update successful");
        }catch (Exception e){
            log.error("update failed",e);
            e.printStackTrace();
        }finally {
        	session.close();
        }
    }


	public void save(OrderList orderList) {
		log.debug("saving orderList instance"); 
        try{
        	session = getSession();
	        transaction = session.beginTransaction();
            session.save(orderList);
            transaction.commit();
            log.debug("save successful");
        }catch (RuntimeException re){
            log.error("save failed",re);
            throw re;
        }finally {
            session.close();
        }	
	}


	public void updateGood(Goods good) {
		 try{
	        	session = getSession(); 
	        	transaction = session.beginTransaction(); 
	            session.update(good);
	            transaction.commit();   
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally {
	        	session.close();
	      }
	}

	@Override
	public void deleteCart(Cart cart) {
		try{
	    	session = getSession();
	        transaction = session.beginTransaction();
	        session.delete(cart);
	        transaction.commit();
		}catch (Exception e){
			 e.printStackTrace();
		}finally {
		    session.close();
		}	
	}

	@Override
	public void addGroup(Groups groups) {
        try{
        	session = getSession();
            transaction = session.beginTransaction();
            session.save(groups);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
	}

	@Override
	public void updateOrderRecstateByOid(int oid1, String recstate) {
		try{
            session = getSession();
            transaction = session.beginTransaction();
            String hql = "update OrderList orderList set orderList.recstate='"+recstate+"' where orderList.oid="+oid1;
            Query queryupdate=session.createQuery(hql);
            queryupdate.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
	}

	@Override
	public void deleteGroup(Groups groups) {
		try{
	    	session = getSession();
	        transaction = session.beginTransaction();
	        session.delete(groups);
	        transaction.commit();
		}catch (Exception e){
			 e.printStackTrace();
		}finally {
		    session.close();
		}	
	}
}
