package com.aituangou.po;

public class OrderList {
    private int oid;
    private int gid;
    private double price;
    private int num;
    private double sumPrice;
    private String shipstate;
    private String recstate;
    private int shopid;
    private String bid;
    
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
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

    public String getShipstate() {
        return shipstate;
    }

    public void setShipstate(String shipstate) {
        this.shipstate = shipstate;
    }

    public String getRecstate() {
        return recstate;
    }

    public void setRecstate(String recstate) {
        this.recstate = recstate;
    }

	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}
    
}
