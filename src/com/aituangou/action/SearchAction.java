package com.aituangou.action;

import com.aituangou.service.SearchService;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;
import java.util.Map;

public class SearchAction {
    private String name;
    private String sort;
    private int number;
    private SearchService searchService = null;
    ActionContext context = ActionContext.getContext();
    Map session = (Map)context.getSession();
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	public String search(){
		System.out.println(name);
        if(name!=null || !name.equals("")){
            System.out.println(sort);
            List list = searchService.search(name,sort);
            session.put("goods",list);
            if(list!=null){
                number = list.size();
            }else {
                number = 0;
            }
        }else {
            session.put("goods",null);
            number = 0;
        }
        return "success";
    }
}
