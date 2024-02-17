package com.example.nisar;

public class modelsell {
    String sellerdistrict, sellerimage,sellername, sellerphone, sellerprice, sellerstate;
    public  modelsell(){


    }

    public modelsell(String district, String image, String name,String phone,String price,String state) {
        this.sellerdistrict = district;
        this.sellerimage = image;
        this.sellername = name;
        this.sellerphone=phone;
        this.sellerprice=price;
        this.sellerstate=state;
    }

    public String getSellerdistrict() {
        return sellerdistrict;
    }

    public void setSellerdistrict(String district) {
        this.sellerdistrict = district;
    }

    public String getSellerimage() {
        return sellerimage;
    }

    public void setSellerimage(String image) {
        this.sellerimage = image;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String name) {
        this.sellername = name;
    }

    public String getSellerphone() {
        return sellerphone;
    }

    public void setSellerphone(String phone) {
        this.sellerphone = phone;
    }

    public String getSellerprice() {
        return sellerprice;
    }

    public void setSellerprice(String price) {
        this.sellerprice = price;
    }

    public String getSellerstate() {
        return sellerstate;
    }

    public void setSellerstate(String state) {
        this.sellerstate = state;
    }




}

