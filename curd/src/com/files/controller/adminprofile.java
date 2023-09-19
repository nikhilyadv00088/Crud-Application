package com.files.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.files.enttities.userbeanclass;
import com.files.enttities.userdao;

/**
 * Servlet implementation class adminprofile
 */
@WebServlet("/adminprofile")
public class adminprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String action = request.getParameter("action");
		String uid=request.getParameter("userid");
		userdao ud=new userdao();
		
		if(action.equals("Search"))
		{
			userbeanclass user = ud.searchuser(uid);
			if(user!=null)
			{
				request.setAttribute("uname", user.getUdername());
				request.setAttribute("uid", user.getUserid());
				request.setAttribute("upass", user.getPassword());
				request.setAttribute("uemail", user.getEmail());
				request.setAttribute("uage", user.getAge());
				
				RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
				rd.forward(request, response);
			}
			else
			{
				
				pw.print("<h3>User not found!</h3>");
				
			}
			
		}
		else if(action.equals("Delete"))
		{
			int row = ud.deleteuser(uid);
			if(row!=0)
			{
				pw.print("<h3>User deleted successfully</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("Home.html");
				rd.include(request, response);
			}
			else
			{
				pw.print("<h3>User not found</h3>");
			}
			
		}
		else if(action.equals("Update"))
		{
			userbeanclass user = ud.searchuser(uid);
			if(user!=null)
			{
				request.setAttribute("uname", user.getUdername());
				request.setAttribute("uid", user.getUserid());
				request.setAttribute("upass", user.getPassword());
				request.setAttribute("uemail", user.getEmail());
				request.setAttribute("uage", user.getAge());
			
				RequestDispatcher rd=request.getRequestDispatcher("updateuser.jsp");
				rd.forward(request, response);
				
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				
			}
			else
			{
				pw.print("<h3>User not found!</h3>");
			}
		}
	}
}
