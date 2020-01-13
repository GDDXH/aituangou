package com.aituangou.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.aituangou.po.Buyer;
import com.aituangou.po.Cart;
import com.aituangou.po.CartId;
import com.aituangou.po.Goods;
import com.aituangou.service.CartService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;



public class CartAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CartService cartService = null;
	private Goods good;
	private Cart cart;

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public CartService getCartService() {
		return cartService;
	}
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public Goods getGood() {
		return good;
	}
	public void setGood(Goods good) {
		this.good = good;
	}
	public String updateCart() {
	    ActionContext context = ActionContext.getContext();
	    Map<String, Object> session = (Map<String, Object>)context.getSession();
		System.out.println("cart.getCid()"+cart.getCid());
		System.out.println("cart.getNum()"+cart.getNum());
		cart.setSumPrice(cart.getPrice()*cart.getNum());
		cartService.updateCartNum(cart);
		cartService.updateCartSumPrice(cart);
		if(findCarts().equals("success"))
			return "success";
		else 
			return "fail";
	}
	public String deleteCart() {
		try {
			cartService.deleteCart(cart);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(findCarts().equals("success"))
			return "success";
		else 
			return "fail";
	}
	public String addGoods() {
	    ActionContext context = ActionContext.getContext();
	    Map<String, Object> session = (Map<String, Object>)context.getSession();
		Buyer buyer = (Buyer) session.get("loginUser");
		CartId cartId = new CartId();
		cartId.setBuyer(buyer);
		cartId.setGoods(good);
		cart.setId(cartId);
		cart.setSumPrice(cart.getPrice()*cart.getNum());
		cartService.addCart(cart);
		if(findCarts().equals("success"))
			return "success";
		else 
			return "fail";
	}
	public  String findCarts() {
	    ActionContext context = ActionContext.getContext();
	    Map<String, Object> session = (Map<String, Object>)context.getSession();
		Buyer buyer = (Buyer) session.get("loginUser");
		List carts = (List) cartService.findCarts(buyer.getId());
		List<Goods> cartGoods= new ArrayList<Goods>();
		for(int i = 0 ; i < carts.size(); i++) {
			cartGoods.add(cartService.findGoodById(((Cart)carts.get(i)).getId().getGoods().getId()));
		}
		session.put("carts",carts);
		session.put("cartGoods",cartGoods);	
		return "success";
	}
}

