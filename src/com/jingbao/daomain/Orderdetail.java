package com.jingbao.daomain;

public class Orderdetail {
	String orderid;
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public int getShopnumber() {
		return shopnumber;
	}
	public void setShopnumber(int shopnumber) {
		this.shopnumber = shopnumber;
	}
	public double getSmallsum() {
		return smallsum;
	}
	public void setSmallsum(double smallsum) {
		this.smallsum = smallsum;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getGoodspicture() {
		return goodspicture;
	}
	public void setGoodspicture(String goodspicture) {
		this.goodspicture = goodspicture;
	}
	public double getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(double goodsprice) {
		this.goodsprice = goodsprice;
	}
	String goodsid;
	int shopnumber;
	double smallsum;
	String goodsname;
	String goodspicture;
	double goodsprice;
}
