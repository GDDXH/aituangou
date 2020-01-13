package com.aituangou.service.impl;

import com.aituangou.po.Seller;
import com.aituangou.po.Shop;

public interface IChangeInfoService {
    public boolean changeInfo(Seller loginUser, Shop shop);
    public boolean changePass(String password);
}
