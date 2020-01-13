package com.aituangou.po;

import java.util.HashSet;
import java.util.Set;

public class Buyer {
    private String id;
    private String password;
    private String name;
    private String telephone;
    private String address;
    private String repassword;
    private Set carts = new HashSet(0);
    public Buyer(){}
    public Buyer(String id,String password){
        this.id = id;
        this.password = password;
    }
    public Buyer(String id,String password,String name,String telephone,String address){
        this.id = id;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getRepassword() {
        return repassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
	public Set getCarts() {
		return carts;
	}
	public void setCarts(Set carts) {
		this.carts = carts;
	}
    
}
