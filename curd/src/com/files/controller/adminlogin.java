package com.files.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.files.enttities.userbeanclass;
import com.files.enttities.userdao;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminlogin() {
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
		
		String id1=request.getParameter("userida");
		String pass1=request.getParameter("passworda");
		
		userdao ud=new userdao();
		userbeanclass user = ud.checkadminlogin(id1, pass1);
		
		if(user!=null) 
		{
			request.setAttribute("uname", user.getUdername());
			request.setAttribute("uid", user.getUserid());
			request.setAttribute("uemail", user.getEmail());
			request.setAttribute("uage", user.getAge());
			RequestDispatcher rd=request.getRequestDispatcher("adminprofile.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			pw.write("<h3>either id or password is incorrect</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("adminlogin.html");
			rd.include(request, response);
		}
	}

}
