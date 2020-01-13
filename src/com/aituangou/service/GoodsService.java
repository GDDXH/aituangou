package com.aituangou.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aituangou.dao.GGoodsDAO;
import com.aituangou.dao.GoodCheckDAO;
import com.aituangou.dao.GoodsDAO;
import com.aituangou.dao.impl.IGGoodsDAO;
import com.aituangou.dao.impl.IGoodCheckDAO;
import com.aituangou.dao.impl.IGoodsDAO;
import com.aituangou.po.GGoods;
import com.aituangou.po.GoodCheck;
import com.aituangou.po.Goods;
import com.aituangou.service.impl.IGoodsService;
import com.opensymphony.xwork2.ActionContext;

public class GoodsService  implements IGoodsService {
	private List goods = new ArrayList();
	private List goodchecks = new ArrayList();
	private IGoodsDAO goodsDAO = null;
	private IGoodCheckDAO goodCheckDAO = null;
	private IGGoodsDAO gGoodsDAO = null;
	private Map<String, Object> request, session;
	public List getGoodchecks() {
		return goodchecks;
	}



	public void setGoodchecks(List goodchecks) {
		this.goodchecks = goodchecks;
	}



	public IGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}



	public void setGoodsDAO(IGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}



	public IGoodCheckDAO getGoodCheckDAO() {
		return goodCheckDAO;
	}



	public void setGoodCheckDAO(IGoodCheckDAO goodCheckDAO) {
		this.goodCheckDAO = goodCheckDAO;
	}



	public IGGoodsDAO getgGoodsDAO() {
		return gGoodsDAO;
	}



	public void setgGoodsDAO(IGGoodsDAO gGoodsDAO) {
		this.gGoodsDAO = gGoodsDAO;
	}



	public void setGoods(List goods) {
		this.goods = goods;
	}



	public List getGoods() {
		String hql = "from Goods";
		List list = goodsDAO.find(hql);
		goods = list;
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		request.put("goods", goods); 
		if(list==null)
			System.out.println("goods list is null"); 
		return list;
	}

	public Goods getGoodsDetails(Goods transientInstance) {
		transientInstance = (Goods) goodsDAO.findById(transientInstance.getId()).get(0);
		ActionContext ctx = ActionContext.getContext();
		session=(Map) ctx.getSession(); 
		request=(Map) ctx.get("request"); 
		request.put("goodsDetails", transientInstance); 
		return transientInstance;
	}
	

	public boolean update(Goods transientInstance) {
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		if(goodsDAO.update(transientInstance)){
			request.put("tip", "更改商品信息成功!");
			transientInstance = getGoodsDetails(transientInstance);
			request.put("goodsDetails", transientInstance);
			request.put("upinfor", "success");
			return true;
		}
		request.put("tip", "更改商品信息失败!");
		request.put("upinfor", "fail");
		request.put("goodsDetails", transientInstance);
		return false;
	}

	public void delete(Goods transientInstance) {
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		transientInstance = (Goods) goodsDAO.findById(transientInstance.getId()).get(0);
		goodsDAO.delete(transientInstance);
		goods = getGoods();
		request.put("goods", goods);
		request.put("delinfor", "success");
		request.put("tip", "删除成功!");
	}

	public boolean save(Goods transientInstance) {
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		if(goodsDAO.save(transientInstance)){
			request.put("tip", "添加商品成功!");
			goods = getGoods();
			request.put("goods", goods);
			request.put("addinfor", "success");
			return true;
		}
		request.put("tip", "添加商品失败!");
		request.put("addinfor", "fail");
		goods = getGoods();
		request.put("goods", goods);
		return false;
	}
	public List getGoodcheck() {
		String hql = "from GoodCheck as good where good.flag=0";
		List list = goodCheckDAO.find(hql);
		goodchecks = list;
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		request.put("goodchecks", goodchecks); 
		if(list==null)
			System.out.println("goodchecks list is null"); 
		return list;
	}
	public boolean checkPass(GoodCheck transientInstance) {
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		transientInstance = (GoodCheck) goodCheckDAO.findById(transientInstance.getId()).get(0);
		transientInstance.setFlag(2);
		Goods good = new Goods();
		good.setId(transientInstance.getId());
		good.setName(transientInstance.getName());
		good.setType(transientInstance.getType());
		good.setPrice(transientInstance.getPrice());
		good.setNum(transientInstance.getNum());
		good.setCity(transientInstance.getCity());
		good.setPicture(transientInstance.getPicture());
		good.setShop(transientInstance.getShop());
		good.setState(0);
		GGoods ggoods = new GGoods();
		ggoods.setId(transientInstance.getId());
		if(goodCheckDAO.update(transientInstance) && goodsDAO.save(good) && gGoodsDAO.save(ggoods)){
			request.put("tip", "审核成功!");
			goodchecks = getGoodcheck();
			request.put("goodchecks", goodchecks);
			request.put("addinfor", "success");
			return true;
		}
		request.put("addinfor", "fail");
		request.put("tip", "审核失败!");
		goodchecks = getGoodcheck();
		request.put("goodchecks", goodchecks);
		return false;
	}
	public boolean unCheckPass(GoodCheck transientInstance) {
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		transientInstance = (GoodCheck) goodCheckDAO.findById(transientInstance.getId()).get(0);
		transientInstance.setFlag(1);
		if(goodCheckDAO.update(transientInstance)){
			//request.put("tip", "审核成功!");
			goodchecks = getGoodcheck();
			request.put("goodchecks", goodchecks);
			request.put("addinfor", "success");
			return true;
		}
		request.put("addinfor", "fail");
		request.put("tip", "审核失败!");
		goodchecks = getGoodcheck();
		request.put("goodchecks", goodchecks);
		return false;
	}
}
