package com.files.enttities;

public class userbeanclass 
{
	private String udername,userid,password,email;
	private int age;
	public String getUdername() {
		return udername;
	}
	public void setUdername(String udername) {
		this.udername = udername;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "userbeanclass[udername="+ udername +",userid="+ userid +",password="+ password +",email="+ email +",age="+ age +"]";
	}
}
