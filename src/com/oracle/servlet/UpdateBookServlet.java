package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.BookDao;
import com.oracle.vo.Book;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/UpdateBook")
public class UpdateBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bookId = request.getParameter("bookid");
		Integer id = Integer.valueOf(bookId);
		String name=request.getParameter("name");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		Book book = new Book(id,name,author,Integer.valueOf(price));
	
		BookDao dao = new BookDao();
		dao.update(book);
		
		response.sendRedirect("listbook");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
