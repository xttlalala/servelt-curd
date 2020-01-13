package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/UpdatePageBook")
public class UpdateBookPageServlet extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得用户请求：
//		request.setCharacterEncoding("UTF-8");
		String bookId = request.getParameter("bookid");
		Integer id = Integer.valueOf(bookId);
//		String name=request.getParameter("name");
//		String author = request.getParameter("author");
//		String price = request.getParameter("price");
//		Book book = new Book(null,name,author,Integer.valueOf(price));
//		System.out.println(book);
		//调用业务：
		BookDao dao = new BookDao();
		Book book = dao.getBookId(id);
		//显示页面：
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<form action='UpdateBook' method='post'>");
		out.println("<input type='hidden' name='bookid' value='"+book.getBookid()+"'>");
		out.println("name:<input type='test' name='name' value='"+book.getName()+"'><br/>");
		out.println("author:<input type='test' name='author' value='"+book.getAuthor()+"'><br/>");
		out.println("price:<input type='test' name='price' value='"+book.getPrice()+"'><br/>");
		out.println("<button type='submit'>修改</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		out.println();
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
