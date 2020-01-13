package com.aituangou.action;

import com.aituangou.po.Buyer;
import com.aituangou.po.GGoods;
import com.aituangou.po.Goods;
import com.aituangou.po.Groups;
import com.aituangou.service.GroupsService;
import com.aituangou.service.IntroduceService;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;
import java.util.Map;

public class IntroduceAction {
    private String id;
    private Goods good;
    private GGoods gGoods;
    private IntroduceService introduceService = null;
    private GroupsService groupsService = null;
    ActionContext context = ActionContext.getContext();
    Map<String, Object> session = (Map<String, Object>)context.getSession();
    public GGoods getgGoods() {
        return gGoods;
    }

    public void setgGoods(GGoods gGoods) {
        this.gGoods = gGoods;
    }

    public void setGood(Goods good){
        this.good = good;
    }
    public Goods getGood(){
        return good;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    
    public IntroduceService getIntroduceService() {
		return introduceService;
	}

	public void setIntroduceService(IntroduceService introduceService) {
		this.introduceService = introduceService;
	}

	public GroupsService getGroupsService() {
		return groupsService;
	}

	public void setGroupsService(GroupsService groupsService) {
		this.groupsService = groupsService;
	}

	public String introduce(){
        good = (Goods) introduceService.searchGoods(id).get(0);
        if(good.getState()==1){
            gGoods = (GGoods) introduceService.searchGGoods(id).get(0);
        }
    	Buyer buyer = (Buyer) session.get("loginUser");
    	Groups group = new Groups();
    	group.setBid1(buyer.getId());
    	group.setGoodId(good.getId());
        List<Groups> groups = groupsService.findGroups(group);
     	session.put("groups", groups);
        return "success";
    }
}
