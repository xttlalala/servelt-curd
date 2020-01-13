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
			// ��ͻ��˷���һ�����
			//1.������������
			response.setContentType("text/html;charset=UTF-8");
			//2.����ַ���
			PrintWriter out = response.getWriter();
			//3.���ַ�����д����
			out.println("<html><head><title>ͼ��</title></head>");
			out.println("<body>");
			out.println("<table border=1 width='80%' >");
			out.println("<tr>");
			out.println("<td>���</td>");
			out.println("<td>����</td>");
			out.println("<td>����</td>");
			out.println("<td>�۸�</td>");
			out.println("<td>����</td>");
			out.println("</tr>");
			
			//����һ��Dao
			BookDao dao = new BookDao();
			List<Book> list = dao.getAll();
			for(int i=0;i<list.size();i++) {
				Book book=list.get(i);
				out.println("<tr>");
				out.println("<td>"+(i+1)+"</td>");
				out.println("<td>"+book.getName()+"</td>");
				out.println("<td>"+book.getAuthor()+"</td>");
				out.println("<td>"+book.getPrice()+"</td>");
				out.println("<td><a href='DeleteBook?bookid="+book.getBookid()+"'>ɾ��</a>"
						+ "&nbsp;&nbsp;<a href='UpdatePageBook?bookid="+book.getBookid()+"'>�޸�</a></td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			out.println("<a href='saveBook.html'>����ͼ��");
			out.println("</body>");
			out.println("</html>");
			
			out.flush();//ˢ��
//		}
//			else {
//			response.sendRedirect("login.html");
//		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
