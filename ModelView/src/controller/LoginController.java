package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 @WebServlet("/LoginController")
public class LoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		//Retrieving the data from form
		String username=request.getParameter("username");
		String password=request.getParameter("passwd");
		
		//Initilizing the LoginCredential object
		model.LoginCredential loginObj=new model.LoginCredential();
		loginObj.setUsername(username);
		loginObj.setPassword(password);
		
		//Checking the Login & Password
		if(loginObj.checkLogin())
		{
			request.setAttribute("username",username);
			RequestDispatcher dispatch=request.getRequestDispatcher("success.jsp");
			dispatch.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("Failure.jsp");
			dispatch.forward(request, response);
		}	
	}
}