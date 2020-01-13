package com.aituangou.action;

import java.util.List;
import java.util.Map;

import com.aituangou.po.GoodCheck;
import com.aituangou.po.Goods;
import com.aituangou.service.GoodsService;
import com.aituangou.service.impl.IGoodsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List goods;
	private Goods good;
	private List goodchecks;
	private GoodCheck goodcheck;
	private IGoodsService goodsService = null;
	ActionContext context = ActionContext.getContext();
    Map<String, Object> session = (Map<String, Object>)context.getSession();
	
	public List getGoods() {
		return goods;
	}
	public void setGoods(List goods) {
		this.goods = goods;
	}
	public Goods getGood() {
		return good;
	}
	public void setGood(Goods good) {
		this.good = good;
	}
	public List getGoodchecks() {
		return goodchecks;
	}
	public void setGoodchecks(List goodchecks) {
		this.goodchecks = goodchecks;
	}
	public GoodCheck getGoodcheck() {
		return goodcheck;
	}
	
	public IGoodsService getGoodsService() {
		return goodsService;
	}
	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}
	public String findGoods(){
		goods = goodsService.getGoods();
		return "success";
	}
	public String findGoodsDetails(){
		good = goodsService.getGoodsDetails(good);
		return "success";
	}
	public String addGoods(){
		if(goodsService.save(good))
			return "success";
		return "fail";
	}
	public String updGoods(){
		if(goodsService.update(good))
			return "success";
		return "fail";
	}
	public String delGoods(){
		goodsService.delete(good);
		return "success";
	}
	public String findGoodchecks(){
		goodchecks = goodsService.getGoodcheck();
		return "success";
	}
	public String checkPass(){
		goodsService.checkPass(goodcheck);
		return "success";
	}
	public String unCheckPass(){
		goodsService.unCheckPass(goodcheck);
		return "success";
	}
	public void setGoodcheck(GoodCheck goodcheck) {
		this.goodcheck = goodcheck;
	}
}
