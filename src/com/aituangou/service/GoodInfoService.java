package com.aituangou.service;

import com.aituangou.dao.impl.IGGoodsDAO;
import com.aituangou.dao.impl.IGoodsDAO;
import com.aituangou.po.GGoods;
import com.aituangou.po.Goods;
import com.aituangou.po.Seller;
import com.aituangou.po.Shop;
import com.aituangou.service.impl.IGoodInfoService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GoodInfoService implements IGoodInfoService {
    private Map<String, Object> session;

    private IGoodsDAO goodsDAO = null;
    private IGGoodsDAO gGoodsDAO = null;

    public void setGoodsDAO(IGoodsDAO goodsDAO) {
        this.goodsDAO = goodsDAO;
    }

    public void setgGoodsDAO(IGGoodsDAO gGoodsDAO) {
        this.gGoodsDAO = gGoodsDAO;
    }

    public void getAllGoodInfo(){
        ActionContext context = ActionContext.getContext();
        session = (Map) context.getSession();
        Seller seller = (Seller) session.get("loginSeller");
        Shop shop = seller.getShop();
        List list = goodsDAO.findByShop(shop);
        session.put("goods",list);
    }

    public void getGoodInfo(int id){
        ActionContext context = ActionContext.getContext();
        session = (Map) context.getSession();
        List list = goodsDAO.findGoodById(id);
        session.put("good",(Goods)list.get(0));
    }

    public void getGGoodInfo(int id){
        ActionContext context = ActionContext.getContext();
        session = (Map) context.getSession();
        List list = gGoodsDAO.findGGoodById(id);
        session.put("gGoods",(GGoods)list.get(0));
    }

    public boolean changeGoodInfo(Goods goods, GGoods gGoods){
        ActionContext context = ActionContext.getContext();
        session = (Map) context.getSession();
        Goods good = (Goods) session.get("good");
        GGoods gGood = (GGoods) session.get("gGoods");
        good.setName(goods.getName());
        good.setCity(goods.getCity());
        good.setType(goods.getType());
        good.setPrice(goods.getPrice());
        good.setNum(goods.getNum());
        good.setState(goods.getState());
        gGood.setGprice(gGoods.getGprice());
        gGood.setGnum(gGoods.getGnum());
        try{
            goodsDAO.update(good);
            gGoodsDAO.update(gGood);
            session.put("changeGoodInfo","success");
            return true;
        }catch (Exception e) {
            session.put("changeGoodInfo", "fail");
            return false;
        }
    }

    public boolean changeGoodPic(File file1,File file2,File file3,File file4){
        ActionContext context = ActionContext.getContext();
        session = (Map) context.getSession();
        Goods good = (Goods) session.get("good");
        int id = good.getId();
        File file = new File("E:/java/aituangou/WebContent/images/"+id);
        if(!file.exists()){
            file.mkdirs();
        }
        try{
            if(file1!=null){
                FileUtils.copyFile(file1, new File(file,id+"_60x60.jpg"));
            }
            if(file2!=null){
                FileUtils.copyFile(file2, new File(file,id+"_80x80.jpg"));
            }
            if(file3!=null){
                FileUtils.copyFile(file3, new File(file,id+"_350x350.jpg"));
            }
            if(file4!=null){
                FileUtils.copyFile(file4, new File(file,id+"_800x800.jpg"));
            }
            session.put("changeGoodInfo","success");
            return true;
        }catch (IOException e){
            e.printStackTrace();
            session.put("changeGoodInfo","fail");
            return false;
        }
    }
}
