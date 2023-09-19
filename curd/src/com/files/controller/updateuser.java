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
 * Servlet implementation class updateuser
 */
@WebServlet("/updateuser")
public class updateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateuser() {
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
		String Action=request.getParameter("update");
		
		
		userbeanclass ub=new userbeanclass();
		
		ub.setUdername(request.getParameter("newname"));
		ub.setUserid(request.getParameter("newid"));
		ub.setEmail(request.getParameter("newemail"));
		ub.setAge(Integer.parseInt(request.getParameter("newage")));
		
		userdao ud=new userdao();
		HttpSession session = request.getSession();
		userbeanclass ub1 = (userbeanclass) session.getAttribute("user");
		String u1id=ub1.getUserid();
		
		if(Action.equals("Updateuser"))
		{
			System.out.println(ub+" "+u1id);
			int status = ud.updaterecord(ub,u1id);
			
			
			
			if(status==1)
			{
				pw.print("<h3>User updated successfully</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("Home.html");
				rd.include(request, response);
			}
			else
			{
				pw.print("<h3>user not found</h3>");
			}
		}
		
	}

}
