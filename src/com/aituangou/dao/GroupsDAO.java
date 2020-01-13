package com.aituangou.dao;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;

import com.aituangou.po.GGoods;
import com.aituangou.po.Goods;
import com.aituangou.po.Groups;
import com.aituangou.po.OrderList;

public class GroupsDAO extends BaseDAO {
	private Log log = LogFactory.getLog(GroupsDAO.class);
	public void save(Groups group) {
        log.debug("saving group instance");
        try{
        	session = getSession();
            transaction = session.beginTransaction();
            session.save(group);
            transaction.commit();
            log.debug("save successful");
        }catch (RuntimeException re){
            log.error("save failed",re);
            throw re;
        }finally {
            session.close();
        }
	}
	public void delete(int groupId) {
        log.debug("delete group instance");
        try{
        	session = getSession();
            transaction = session.beginTransaction();
        	Groups group =(Groups)session.get(Groups.class,groupId); 
            session.delete(group);
            transaction.commit();
            log.debug("delete successful");
        }catch (RuntimeException re){
            log.error("delete failed",re);
            throw re;
        }finally {
            session.close();
        }
	}
	public void saveOrder(OrderList order) {
        log.debug("saving group instance");
        try{
        	session = getSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            log.debug("save successful");
        }catch (RuntimeException re){
            log.error("save failed",re);
            throw re;
        }finally {
            session.close();
        }
	}
	public GGoods findGGoodById(int gid) {
        try{
        	session = getSession();
            transaction = session.beginTransaction();
            GGoods gGoods =  (GGoods)session.get(GGoods.class, gid);
            session.close();
            return gGoods;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}
	public Object findGoodById(int id) {
		try{
        	session = getSession();
            transaction = session.beginTransaction();
            Goods goods = (Goods)session.get(Goods.class, id);
            session.close();
            return goods;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}
	public int findMaxOrderId() {
        int id=0;
        try{
        	session = getSession();
            String queryString = "select max(oid) from OrderList";
            Query queryObject = session.createQuery(queryString);
            id = (int)queryObject.list().get(0);
            session.close();
        }catch (RuntimeException re){
            throw re;
        }
        return id;
	}
}
