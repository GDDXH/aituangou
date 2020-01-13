package com.aituangou.service.impl;

import com.aituangou.po.GoodCheck;

import java.io.File;

public interface IRegisterGoodService {
    public boolean registerGood(GoodCheck good, File file1, File file2, File file3, File file4);
    public void goodCheck();
    public void deleteGoodCheck(int id);
}
