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
 * Servlet implementation class InsertBookServlet
 */
@WebServlet("/insertbook")
public class InsertBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		Book book = new Book(null,name,author,Integer.valueOf(price));
		System.out.println(book);
		
		//��ͼ��д�����ݿ�
		BookDao dao = new BookDao();
		dao.save(book);
		System.out.println("����ɹ���");
		response.sendRedirect("listbook");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
