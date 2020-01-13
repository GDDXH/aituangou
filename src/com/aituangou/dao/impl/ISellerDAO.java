package com.aituangou.dao.impl;

import com.aituangou.po.Seller;

import java.util.List;

public interface ISellerDAO extends IBaseDAO {
    public boolean save(Seller instance);
    public boolean update(Seller seller);
    public List findByHql(String hql);
}
