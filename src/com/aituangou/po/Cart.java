package com.aituangou.po;

import com.aituangou.po.CartId;

public class Cart {
	private int cid;
	private CartId id;
    private double price;
    private int num;
    private double sumPrice;

  

    public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public CartId getId() {
		return id;
	}

	public void setId(CartId id) {
		this.id = id;
	}

	
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }
}
