package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest
{
	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	
    @Ignore
	@Test
	public void addCategory() 
	{
		Category category=new Category();
	    //category.setCategoryId(1);
	    category.setCategoryName("Men");
		category.setCategoryDesc("All types of Clothes");
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));
	}

    @Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(11);
		assertTrue("Problem in deleting Category",categoryDAO.deleteCategory(category));
	}
	
    @Ignore
    @Test
    public void updateCategoryTest()
    {
		Category category=categoryDAO.getCategory(8);
		category.setCategoryDesc("Traditional wear for Women");
		assertTrue("Problem in Updating Category",categoryDAO.updateCategory(category));
    }
    
  //  @Ignore
       
    @Test
    public void listCategoriesTest()
    {
    	
    	List<Category> listCategories=categoryDAO.listCategories();
    	assertTrue("Problem in retriving categories",listCategories.size()>0);
    	/*
    	for(Category category:listCategories) 
    	{
    	System.out.print(category.getCategoryDesc()+"  ");
    	System.out.print(category.getCategoryId()+"  ");
    	System.out.println(category.getCategoryName()+"  ");

        }
    */
    }
    
}
