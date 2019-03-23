package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestPages.ProductNServicePage;
import com.TestUtil.TestUtil;

public class ProductNServicePageTest extends TestBase{
	LoginPage loginpage;
	
	ProductNServicePage productnservice;
	
	String SheetName = "NewServiceInfo";

   public ProductNServicePageTest() {
	   super();
   }
   @BeforeMethod
   public void SetUp() {
	   
	   
	   initil();
	   productnservice = new ProductNServicePage();
	   loginpage = new LoginPage();
	   loginpage.VerifyLogin(prop.getProperty("UserName"),prop.getProperty("Password"));
   }
   @DataProvider
   
   public Object[][] moon (){
	   Object[][] data = TestUtil.getTestData(SheetName);
	return data;
   }
 /*  @Test(priority=0)
   public void ClickProductNServices() throws Exception {
	   Thread.sleep(5000);
	   productnservice.ProductNServices();
	   productnservice.NewService();
   }
   @Test(priority=1)
   public void ClickNewService() throws Exception {
	   Thread.sleep(5000);
	   productnservice.NewService();
   }*/
   @Test(dataProvider = "moon")
   public void CreateNewOrder(String Name,String SalesPrice,String ItemNumber, String Description) throws Exception {
	   Thread.sleep(5000);
	   productnservice.ProductNServices();
	   Thread.sleep(5000);
	   productnservice.NewService();
	   Thread.sleep(15000);
	   productnservice.NewOrder(Name, SalesPrice, ItemNumber, Description);
	   boolean Message= productnservice.ValidateSuccessMessage();
	   Assert.assertTrue(Message);
	   
   }
   
   @AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
   
   
   
}