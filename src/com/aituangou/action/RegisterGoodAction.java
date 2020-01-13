package com.aituangou.action;

import com.aituangou.po.GoodCheck;
import com.aituangou.service.impl.IRegisterGoodService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.util.Map;

public class RegisterGoodAction extends ActionSupport {
    private GoodCheck good;
    private File file1,file2,file3,file4;
    private double number;
    private IRegisterGoodService registerGoodService = null;
    int deleteGoodCheck;

    public int getDeleteGoodCheck() {
        return deleteGoodCheck;
    }

    public void setDeleteGoodCheck(int deleteGoodCheck) {
        this.deleteGoodCheck = deleteGoodCheck;
    }

    public void setRegisterGoodService(IRegisterGoodService registerGoodService) {
        this.registerGoodService = registerGoodService;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public GoodCheck getGood() {
        return good;
    }

    public void setGood(GoodCheck good) {
        this.good = good;
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

    public String registerGood(){
        good.setNum((int)number);
        if(registerGoodService.registerGood(good,file1,file2,file3,file4)){
            return "success";
        }else {
            return "fail";
        }
    }

    public String goodCheck(){
        registerGoodService.goodCheck();
        return "success";
    }

    public String deleteGoodCheck(){
        registerGoodService.deleteGoodCheck(deleteGoodCheck);
        return "success";
    }

    public void validateRegisterGood(){
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = (Map<String, Object>)context.getSession();
        String name = good.getName();
        String city = good.getCity();
        double price = good.getPrice();
        System.out.println(name);
        System.out.println(city);
        System.out.println(price);
        System.out.println(number);
        if(name == null || name.equals("")){
            session.put("registerGoodError","name");
            this.addActionError("name");
        }else if(city == null || city.equals("")){
            session.put("registerGoodError","city");
            this.addActionError("city");
        }else if(price<=0){
            session.put("registerGoodError","price");
            this.addActionError("price");
        }else if(number<=0){
            session.put("registerGoodError","number");
            this.addActionError("number");
        }else if(file1==null || file2==null || file3==null || file4==null){
            session.put("registerGoodError","picture");
            this.addActionError("picture");
        }
    }
}
