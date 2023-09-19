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
 * Servlet implementation class Loginservlet
 */
@WebServlet("/loginone")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		// get parameter() : to get the parameter values
		
		String id=request.getParameter("userid");
		String pass=request.getParameter("password");
		
		userdao ud=new userdao();
		userbeanclass user = ud.checklogin(id, pass);
		
		if(user!=null)
			{
				request.setAttribute("uname", user.getUdername());
				request.setAttribute("uemail", user.getEmail());
				request.setAttribute("uage", user.getAge());
				RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
				
			}
		else
		{
			pw.print("<h3>either id or password is incorrect</h3>");
		    RequestDispatcher rd=request.getRequestDispatcher("login.html");
		    rd.include(request, response);
			
		}
	}

}
