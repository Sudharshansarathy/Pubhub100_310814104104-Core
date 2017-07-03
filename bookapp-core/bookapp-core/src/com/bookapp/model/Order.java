package com.bookapp.model;

public class Order {
	private int userid;
	private int bookid;
	private int orderid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	@Override
	public String toString() {
		return "Orders [userid=" + userid + ", bookid=" + bookid + ", orderid=" + orderid + "]";
	}

}
