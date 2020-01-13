package com.aituangou.po;

import java.util.HashSet;
import java.util.Set;

public class Shop {
    private int shopid;
    private String name;
    private Set sellers = new HashSet(0);
    private Set goods = new HashSet(0);
    private Set goodsCheck = new HashSet(0);
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getSellers() {
		return sellers;
	}
	public void setSellers(Set sellers) {
		this.sellers = sellers;
	}
	public Set getGoods() {
		return goods;
	}
	public void setGoods(Set goods) {
		this.goods = goods;
	}
	public Set getGoodsCheck() {
		return goodsCheck;
	}
	public void setGoodsCheck(Set goodsCheck) {
		this.goodsCheck = goodsCheck;
	}

}
