package com.jingbao.daomain;

public class Cart {
	String cartid;
	String goodsid;
	String userid;
	int shopnumber;
	String goodsname;
	double goodsprice;
	double smallsum;
	String goodspicture;
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public double getSmallsum() {
		return smallsum;
	}
	public void setSmallsum(double smallsum) {
		this.smallsum = smallsum;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getShopnumber() {
		return shopnumber;
	}
	public void setShopnumber(int shopnumber) {
		this.shopnumber = shopnumber;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public double getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(double goodsprice) {
		this.goodsprice = goodsprice;
	}
	public String getGoodspicture() {
		return goodspicture;
	}
	public void setGoodspicture(String goodspicture) {
		this.goodspicture = goodspicture;
	}
}
