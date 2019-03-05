package model;

public class LoginCredential 
{
	String username;
	String password;
	
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public boolean checkLogin()//Business Logic
	{
		if(username.equals("HimaBindu") && password.equals("hima"))
			return true;
		else
			return false;
	}
}