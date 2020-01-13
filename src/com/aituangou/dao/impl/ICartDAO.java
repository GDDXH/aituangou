package com.aituangou.dao.impl;

import java.util.List;

import com.aituangou.po.Cart;
import com.aituangou.po.Goods;

public interface ICartDAO extends IBaseDAO {
	public Goods findGoodById(int gid);
	public void save(Cart cart);
	public void deleteCart(Cart cart);
	public void updateCartNum(Cart cart);
	public List<Cart> findCarts(String hql);
	public void updateCartSumPrice(Cart cart);
}
