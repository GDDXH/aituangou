package com.aituangou.po;

import java.util.HashSet;
import java.util.Set;

public class Goods {
    private int id;
    private String name;
    private String type;
    private double price;
    private int num;
    private int sales;
    private String city;
    private String picture;
    private double score;
    private int state;
    private Shop shop;
	private Set comments = new HashSet(0);
	private Set orders = new HashSet(0);
	private Set carts = new HashSet(0);
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

	public Set getComments() {
		return comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}


	public Set getOrders() {
		return orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getCarts() {
		return carts;
	}

	public void setCarts(Set carts) {
		this.carts = carts;
	}
    
}
