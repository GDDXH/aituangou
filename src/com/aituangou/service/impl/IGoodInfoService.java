package com.aituangou.service.impl;

import com.aituangou.po.GGoods;
import com.aituangou.po.Goods;

import java.io.File;

public interface IGoodInfoService {
    public void getAllGoodInfo();
    public void getGoodInfo(int id);
    public void getGGoodInfo(int id);
    public boolean changeGoodInfo(Goods goods, GGoods gGoods);
    public boolean changeGoodPic(File file1, File file2, File file3, File file4);
}
