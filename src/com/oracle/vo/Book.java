package com.oracle.vo;

public class Book {
	Integer bookid;
	String name;
	String author;
	int price;
	
	public Book(Integer bookid, String name, String author, int price) {
		super();
		this.bookid = bookid;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	public Book() {
		super();
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	
	
 
}
