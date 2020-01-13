package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.BookDao;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/DeleteBook")
public class DeleteBookServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//»ñµÃid
		Integer bookId = Integer.valueOf(request.getParameter("bookid"));
		BookDao dao =new BookDao();
		dao.delete(bookId);
		response.sendRedirect("listbook");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
