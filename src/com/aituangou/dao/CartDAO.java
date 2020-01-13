package com.aituangou.dao;

import java.util.List;

import org.hibernate.Query;

import com.aituangou.dao.impl.ICartDAO;
import com.aituangou.po.Cart;
import com.aituangou.po.Goods;



public class CartDAO extends BaseDAO implements ICartDAO {
	public Goods findGoodById(int gid) {
		Goods goods = null;
        try {
        	 session = getSession();
             transaction = session.beginTransaction();
             goods = (Goods) session.get(Goods.class, gid);
        	 transaction.commit();
             session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return goods;
	}
	public void save(Cart cart) {
        try{
            session = getSession();
            transaction = session.beginTransaction();
            session.save(cart);
            transaction.commit();
            session.flush();
        }catch (Exception e){
        	 e.printStackTrace();
        }finally {
            session.close();
        }
	}
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
	public void updateCartNum(Cart cart) {
		try{
            session = getSession();
            transaction = session.beginTransaction();
            String hql = "update Cart cart set cart.num="+cart.getNum()+" where cart.cid="+cart.getCid();
            Query queryupdate=session.createQuery(hql);
            queryupdate.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
	}

	@SuppressWarnings("unchecked")
	public List<Cart>  findCarts(String hql) {
		try {
			session=getSession();
			String queryString = hql;
			Query queryObject = session.createQuery(queryString);
			List<Cart> carts= queryObject.list();
			session.close();
			return carts;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public void updateCartSumPrice(Cart cart) {
		try{
            session = getSession();
            transaction = session.beginTransaction();
            String hql = "update Cart cart set cart.sumPrice="+cart.getSumPrice()+" where cart.cid="+cart.getCid();
            Query queryupdate=session.createQuery(hql);
            queryupdate.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
	}
}
