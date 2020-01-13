package com.aituangou.service.impl;

import java.util.List;

import com.aituangou.po.Seller;

public interface ISellerService {
	public List getSellers();
	public Seller getSellerDetails(Seller transientInstance);
	public List<Seller> getSellersDetails();
	public boolean update(Seller transientInstance);
	public void delete(Seller transientInstance);
	public boolean save(Seller transientInstance);
}
