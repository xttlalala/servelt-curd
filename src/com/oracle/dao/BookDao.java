package com.oracle.dao;

import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.vo.Book;

public class BookDao {
	public List<Book> getAll(){
		return Dao.query("select * from book",Book.class);
	}
	public void save(Book book) {
		Dao.executeSql("insert into book values(null,?,?,?)", book.getName(),book.getAuthor(),book.getPrice());
	}
	public void delete(Integer bookId) {
		Dao.executeSql("delete from book where bookid=?", bookId);
	}
	//只查一条，专门为修改所作的方法；
	public Book getBookId(Integer bookid) {
		return Dao.queryOne("select * from book where bookid=?",Book.class,bookid);
	}
	public void update(Book book) {
		Dao.executeSql("update book set name=?,author=?,price=? where bookid=?",book.getName(),book.getAuthor(),book.getPrice(),book.getBookid());
	}
}
