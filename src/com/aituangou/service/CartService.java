package com.aituangou.service;

import java.util.List;

import com.aituangou.dao.CartDAO;
import com.aituangou.dao.impl.ICartDAO;
import com.aituangou.po.Cart;
import com.aituangou.po.Goods;

public class CartService {
	private ICartDAO cartDAO = null;
	

	public ICartDAO getCartDAO() {
		return cartDAO;
	}
	public void setCartDAO(ICartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}
	public Goods findGoodById(int gid) {
		return cartDAO.findGoodById(gid);
	}
	public void addCart(Cart cart) {
		Goods goods = cartDAO.findGoodById(cart.getId().getGoods().getId());
		cart.setPrice(goods.getPrice());
		cart.setSumPrice(goods.getPrice());
		cartDAO.save(cart);
	}
	@SuppressWarnings("unchecked")
	public List<Cart> findCarts(String bid) {
		String hql = "from Cart where bid='" +bid+ "'";
		return cartDAO.findCarts(hql);
	}
	public void deleteCart(Cart cart) {
		cartDAO.deleteCart(cart);
	}
	public void updateCartNum(Cart cart) {
		cartDAO.updateCartNum(cart);
	}
	public void updateCartSumPrice(Cart cart) {
		cartDAO.updateCartSumPrice(cart);
	}
}
