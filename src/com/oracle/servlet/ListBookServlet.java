package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.BookDao;
import com.oracle.vo.Book;

/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet("/listbook")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		if("nancy".equals(username)&&"123456".equals(password)) {
			// 向客户端返回一个表格
			//1.设置内容类型
			response.setContentType("text/html;charset=UTF-8");
			//2.获得字符流
			PrintWriter out = response.getWriter();
			//3.在字符流里写东西
			out.println("<html><head><title>图书</title></head>");
			out.println("<body>");
			out.println("<table border=1 width='80%' >");
			out.println("<tr>");
			out.println("<td>序号</td>");
			out.println("<td>书名</td>");
			out.println("<td>作者</td>");
			out.println("<td>价格</td>");
			out.println("<td>操作</td>");
			out.println("</tr>");
			
			//创建一个Dao
			BookDao dao = new BookDao();
			List<Book> list = dao.getAll();
			for(int i=0;i<list.size();i++) {
				Book book=list.get(i);
				out.println("<tr>");
				out.println("<td>"+(i+1)+"</td>");
				out.println("<td>"+book.getName()+"</td>");
				out.println("<td>"+book.getAuthor()+"</td>");
				out.println("<td>"+book.getPrice()+"</td>");
				out.println("<td><a href='DeleteBook?bookid="+book.getBookid()+"'>删除</a>"
						+ "&nbsp;&nbsp;<a href='UpdatePageBook?bookid="+book.getBookid()+"'>修改</a></td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			out.println("<a href='saveBook.html'>插入图书");
			out.println("</body>");
			out.println("</html>");
			
			out.flush();//刷新
//		}
//			else {
//			response.sendRedirect("login.html");
//		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
