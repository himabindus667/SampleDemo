package com.ecomm.test;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTestT 
{
	static ProductDAO productDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}

	@Ignore
    @Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Skirts");
		product.setProductDesc("Kids wear");
		product.setStock(60);
		product.setPrice(500);
		product.setCategoryId(5);
		product.setSupplierId(3);
		assertTrue("Problem in adding the Product",productDAO.addProduct(product));
		
		
	}
	
	
    
	@Test
	public void deleteProductTest()
	{
		Product product= productDAO.getProduct(16);
		assertTrue("Problem in deleting the Product",productDAO.deleteProduct(product));
		
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(4);
		product.setPrice(6000);
		product.setStock(10);
		assertTrue("Problem in updating the Product",productDAO.updateProduct(product));
	}
	
	
	
	
	
	
	@Ignore
	@Test
	public void listProductsTest()
	{
	
		List<Product> listProducts=(List<Product>)productDAO.listProducts();
		assertTrue("Problem in Retreiving the Products",listProducts.size()>0);
		for(Product product:listProducts)
		{
			System.out.println(product.getProductName()+ "   ");
			System.out.println(product.getProductDesc()+ "   ");
			System.out.println(product.getStock()+ "   ");
			System.out.println(product.getPrice()+ "   ");
			
		}
	}
	
	

}
