package com.aituangou.service.impl;

import com.aituangou.po.Buyer;
import com.aituangou.po.Seller;
import com.aituangou.po.Shop;

public interface IRegisterService {
    public boolean register(Seller registerUser);
    public void register(Buyer registerUser);
}
