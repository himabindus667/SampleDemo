package com.ecomm.dao;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean registerUser(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	
	}
	public boolean UpdateUser(UserDetail user)
	{
		try
		{
			sessionFactory.getCurrentSession();
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	public UserDetail getUser(String Username) 
	{
		Session session=sessionFactory.openSession();
		UserDetail userDetail=session.get(UserDetail.class, Username);
		session.close();
		return userDetail;
	}


}
