package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;

public class UserDAOTest
{
	static UserDAO userDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		userDAO =(UserDAO)context.getBean("userDAO");
		
	}
	
	@Ignore
	@Test
	public void registerUserTest()
	
	{
		UserDetail user=new UserDetail();
		user.setUsername("Vaishu");
		user.setPassword("vaishnavi@456");
		user.setCustomerName("Vaishnavi");
		user.setEnable(false);
		user.setRole("Guest");
		user.setAddress("Australia");
		
		assertTrue("Problem in adding in User",userDAO.registerUser(user));
	
	}
	@Ignore
	@Test
	public void updateUserTest()
	{
		UserDetail user=userDAO.getUser("bindu");
		user.setPassword("sbrianvdaun");
		assertTrue("Problem in Updating the User",userDAO.UpdateUser(user));
		
	}

}
