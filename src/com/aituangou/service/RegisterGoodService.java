package com.aituangou.service;

import com.aituangou.dao.impl.IGoodCheckDAO;
import com.aituangou.dao.impl.IGoodsDAO;
import com.aituangou.po.GoodCheck;
import com.aituangou.po.Seller;
import com.aituangou.service.impl.IRegisterGoodService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RegisterGoodService implements IRegisterGoodService {
    private Map<String, Object> session;
    private IGoodsDAO goodsDAO = null;
    private IGoodCheckDAO goodCheckDAO = null;
    private String path = "E:/java/aituangou/WebContent/images/";

    public void setGoodsDAO(IGoodsDAO goodsDAO) {
        this.goodsDAO = goodsDAO;
    }

    public void setGoodCheckDAO(IGoodCheckDAO goodCheckDAO) {
        this.goodCheckDAO = goodCheckDAO;
    }

    public boolean registerGood(GoodCheck good, File file1, File file2, File file3, File file4){
        ActionContext context = ActionContext.getContext();
        session = (Map<String, Object>) context.getSession();
        int id = 0,num1=0,num2=0;
        try{
            num1 = goodsDAO.getMaxId();
            num2 = goodCheckDAO.getMaxId();
            System.out.println("num1"+num1);
            System.out.println("num2"+num2);
        }catch (Exception e){
           e.printStackTrace();
        }
        if(num1!=0){
            id = num1;
        }
        if(num2!=0 && num2>num1){
            id = num2;
        }
        id++;
        good.setId(id);
        good.setPicture("/images/"+id+"/"+id+"_");
        Seller seller = (Seller) session.get("loginSeller");
        good.setShop(seller.getShop());
        try{
            goodCheckDAO.save(good);
            File file = new File(path + id);
            if(!file.exists()){
                file.mkdirs();
            }
            try{
                FileUtils.copyFile(file1, new File(file,id+"_60x60.jpg"));
                FileUtils.copyFile(file2, new File(file,id+"_80x80.jpg"));
                FileUtils.copyFile(file3, new File(file,id+"_350x350.jpg"));
                FileUtils.copyFile(file4, new File(file,id+"_800x800.jpg"));
            }catch (IOException e){
                e.printStackTrace();
                throw e;
            }
            session.put("registerGoodMessage","success");
            return true;
        }catch (Exception e){
            session.put("registerGoodMessage","fail");
            return false;
        }
    }

    public void goodCheck(){
        ActionContext context = ActionContext.getContext();
        session = (Map<String, Object>) context.getSession();
        Seller seller = (Seller)session.get("loginSeller");
        List list = goodCheckDAO.findByShopId(seller.getShop().getShopid());
        session.put("goodCheck",list);
    }

    public void deleteGoodCheck(int id){
        ActionContext context = ActionContext.getContext();
        session = (Map<String, Object>) context.getSession();
        GoodCheck goodCheck = findGoodCheckById(id);
        try{
            goodCheckDAO.delete(goodCheck);
            List list = (List) session.get("goodCheck");
            String path = this.path + id;
            deletePicture(path);
            Iterator iterator = list.iterator();
            while(iterator.hasNext()){
                GoodCheck temp = (GoodCheck) iterator.next();
                if(temp.getId()==goodCheck.getId()){
                    iterator.remove();
                }
            }
            session.put("goodCheck",list);
            session.put("deleteGoodCheck","success");
        }catch (Exception e){
            session.put("deleteGoodCheck","fail");
        }
    }

    private GoodCheck findGoodCheckById(int id){
        List list = goodCheckDAO.findGoodCheckById(id);
        GoodCheck goodCheck = (GoodCheck) list.get(0);
        return goodCheck;
    }

    private void deletePicture(String path){
        File file = new File(path);
        if(file.exists()){
            File temp[] = file.listFiles();
            for(int i=0;i<temp.length;i++){
                if(temp[i].isDirectory()){
                    deletePicture(path+"/"+temp[i].getName());
                }else {
                    temp[i].delete();
                }
            }
            file.delete();
        }
    }
}
