package com.aituangou.service.impl;

import java.util.List;

import com.aituangou.po.Buyer;

public interface IBuyerService {
	public List getBuyers();
	public Buyer getBuyerDetails(Buyer buyer);
	public boolean update(Buyer buyer);
	public void delete(Buyer buyer);
	public boolean save(Buyer buyer);
}
