package com.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestUtil.TestUtil;

public class LoginPageTest extends TestBase  {
	LoginPage loginpage;
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	
	public void SetUp() {
		initil();
		loginpage = new LoginPage();
		
	}
	@Test(priority=2)
	public void VerifyHomePage() {
		
		loginpage.VerifyLogin(prop.getProperty("UserName"),prop.getProperty("Password"));
		boolean dashboard = loginpage.VerifyHomepage();
		Assert.assertTrue(dashboard);
		//TestUtil.captureScreenShot(driver, "Homepage");
	}
	
	
	@Test(priority=0)
	public void VerifyLogoOfThePage() {
		boolean logo = loginpage.VerifyLogo();
		Assert.assertTrue(logo);
	}
	@Test(priority=1)
	public void VerifyTitleOfThePage() {
	String title =	loginpage.VerifyTitle();
	Assert.assertEquals(title,"Login - TechFios Test Application - Billing");
	}
	@Test(priority=3)
	public void VerifyErrorMessage() throws Exception {
		loginpage.VerifyLogin(prop.getProperty("InvalidUser"),prop.getProperty("InvalidPassword"));
		Thread.sleep(5000);
		boolean er = loginpage.VerifyError();
		Assert.assertTrue(er);
		System.out.println("the error message" + er);
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
		
	

}
