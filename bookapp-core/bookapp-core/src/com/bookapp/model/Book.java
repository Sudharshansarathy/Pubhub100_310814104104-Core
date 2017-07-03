package com.bookapp.model;

public class Book {
	private int bookid;
	private String bookname;
	private String bookimage;
	private float bookprice;
	public float getBookprice() {
		return bookprice;
	}
	public void setBookprice(float f) {
		this.bookprice = f;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookimage() {
		return bookimage;
	}
	public void setBookimage(String bookimage) {
		this.bookimage = bookimage;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", bookimage=" + bookimage + ", bookprice="
				+ bookprice + "]";
	}

	
	

}
