package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class LoginPage extends TestBase {
	@FindBy(xpath= "//input[@id=\"username\"]")
	WebElement Username;
	@FindBy(xpath= "//input[@id=\"password\"]")
	WebElement Password;
	@FindBy(xpath= "//button[@type=\"submit\"]")
	WebElement SignInButton;
	@FindBy(xpath= "//img[@class=\"logo\"]")
	WebElement Logo;
	@FindBy(xpath= "//div[@class=\"alert alert-danger fade in\"]")
	WebElement ErrorMessage;
	@FindBy(xpath= "//h2[text()='Dashboard ']")
	WebElement Dashboard;
	
	
	public LoginPage () {
		PageFactory.initElements(driver, this);
	}
	public void VerifyLogin(String Un, String pw) {
		Username.sendKeys(Un);
		Password.sendKeys(pw);
		SignInButton.click();
	}
	public String VerifyTitle() {
	return	driver.getTitle();
	
	}
	public boolean VerifyLogo() {
		return Logo.isDisplayed();
	}
	public void ErrorMessage(String Un, String pw) {
		Username.sendKeys(Un);
		Password.sendKeys(pw);
		SignInButton.click();
	}
	public boolean VerifyHomepage() {
		return Dashboard.isDisplayed();
	}
	public boolean VerifyError() {
	return	ErrorMessage.isDisplayed();
	}
	
		
		
	
	
  
}
