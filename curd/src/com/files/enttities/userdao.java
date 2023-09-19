package com.files.enttities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userdao 
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public userdao()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver found");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","12345");
			System.out.println("connection created");
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public userbeanclass checklogin(String id,String pass)
	{
		userbeanclass ub=null;
		
		try 
		{
			ps=con.prepareStatement("select * from userdata where userid=? and password=?");
			ps.setString(1, id);
			ps.setString(2, pass);
			
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				ub=new userbeanclass();
				ub.setUdername(rs.getString(1));
				ub.setUserid(rs.getString(2));
				ub.setPassword(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setAge(rs.getInt(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ub;
	}
	
	public int insertRecord(userbeanclass user)
	{
		int status=0;
		try {
			ps=con.prepareStatement("insert into userdata value(?,?,?,?,?)");
			ps.setString(1, user.getUdername());
			ps.setString(2, user.getUserid());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getAge());
			
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	
	public userbeanclass checkadminlogin(String id1 , String pass1) {
		
	
	   userbeanclass ubc=null;
	   
	   try {
		ps=con.prepareStatement("select * from useradmin where userid=? and password=?");
		ps.setString(1, id1);
		ps.setString(2, pass1);
		
		rs=ps.executeQuery();
		
		if(rs.next()) 
		{
			ubc=new userbeanclass();
			ubc.setUdername(rs.getString(1));
			ubc.setUserid(rs.getString(2));
			ubc.setPassword(rs.getString(3));
			ubc.setEmail(rs.getString(4));
			ubc.setAge(rs.getInt(5));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ubc;
	
	}
	
	public userbeanclass searchuser(String id)
	{
		userbeanclass ub=null;
		
		try {
			ps=con.prepareStatement("select * from userdata where userid=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				ub=new userbeanclass();
				ub.setUdername(rs.getString(1));
				ub.setUserid(rs.getString(2));
				ub.setPassword(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setAge(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ub;
		
				
	}
	
	public int deleteuser(String id)
	{
		int row=0;
		try {
			ps=con.prepareStatement("delete from userdata where userid=?");
			ps.setString(1, id);
			row=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
		
	}
	
	public int updaterecord(userbeanclass user,String u1id)
	{
		int status=0;
		try {
			ps=con.prepareStatement("update userdata set username=?, userid=?, email=?, age=? where userid=?");
			ps.setString(1, user.getUdername());
			ps.setString(2, user.getUserid());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getAge());
			ps.setString(5, u1id);
			
			status=ps.executeUpdate();
			System.out.println(u1id);
			System.out.println(status);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	}
