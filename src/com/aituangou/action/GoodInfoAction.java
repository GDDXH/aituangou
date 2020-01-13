package com.aituangou.action;

import com.aituangou.po.GGoods;
import com.aituangou.po.Goods;
import com.aituangou.service.GoodInfoService;
import com.aituangou.service.impl.IGoodInfoService;

import java.io.File;
import java.util.List;

public class GoodInfoAction {
    private Goods good;
    private GGoods gGoods;
    private int change,detail,delete;
    private File file1,file2,file3,file4;
    private IGoodInfoService goodInfoService = null;

    public void setGoodInfoService(IGoodInfoService goodInfoService) {
        this.goodInfoService = goodInfoService;
    }

    public File getFile1() {
        return file1;
    }

    public void setFile1(File file1) {
        this.file1 = file1;
    }

    public File getFile2() {
        return file2;
    }

    public void setFile2(File file2) {
        this.file2 = file2;
    }

    public File getFile3() {
        return file3;
    }

    public void setFile3(File file3) {
        this.file3 = file3;
    }

    public File getFile4() {
        return file4;
    }

    public void setFile4(File file4) {
        this.file4 = file4;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getDetail() {
        return detail;
    }

    public void setDetail(int detail) {
        this.detail = detail;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public GGoods getgGoods() {
        return gGoods;
    }

    public void setgGoods(GGoods gGoods) {
        this.gGoods = gGoods;
    }

    public String allGoodInfo(){
        goodInfoService.getAllGoodInfo();
        return "success";
    }

    public String getGoodInformation(){
        int id=0;
        if(change!=0){
            goodInfoService.getGoodInfo(change);
            goodInfoService.getGGoodInfo(change);
            change = 0;
            return "change";
        }else if(detail!=0){
            goodInfoService.getGoodInfo(detail);
            goodInfoService.getGGoodInfo(detail);
            detail = 0;
            return "detail";
        }else {
            return "fail";
        }
    }

    public String changeGoodInfo(){
        if(goodInfoService.changeGoodInfo(good,gGoods)){
            return "success";
        }else {
            return "fail";
        }
    }

    public String changeGoodPic(){
        if(goodInfoService.changeGoodPic(file1,file2,file3,file4)){
            return "success";
        }else {
            return "fail";
        }
    }
}
