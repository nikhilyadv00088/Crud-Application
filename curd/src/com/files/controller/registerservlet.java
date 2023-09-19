package com.files.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.files.enttities.userbeanclass;
import com.files.enttities.userdao;

/**
 * Servlet implementation class registerservlet
 */
@WebServlet("/register")
public class registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletReque"st request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		userbeanclass ub=new userbeanclass();
		
		ub.setUdername(request.getParameter("newusername"));
		ub.setUserid(request.getParameter("newuserid"));
		ub.setEmail(request.getParameter("newuseremail"));
		ub.setAge(Integer.parseInt(request.getParameter("newuserage")));
		
		String upassword=request.getParameter("newuserpassword");
		String urepassword=request.getParameter("repeatpassword");
		
		if(upassword.equals(urepassword))
		{
			ub.setPassword(request.getParameter("newuserpassword"));
			
			userdao udao=new userdao();
			int status = udao.insertRecord(ub);
			
			if(status==1)
			{
				pw.print("<h2>Registration Successfully , You can Login now! </h2>");
				RequestDispatcher rd=request.getRequestDispatcher("Home.html");
				rd.include(request, response);
			}
			else
			{
				pw.print("<h2>Unable to Register! Please Try Again</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("register.html");
				rd.include(request, response);
			}
		}
		else
		{
			pw.print("<h2>Password does not match! Please Try Again</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("register.html");
			rd.include(request, response);
		}
			
	}

}
