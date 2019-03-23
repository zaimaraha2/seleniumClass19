package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class ProductNServicePage extends TestBase {
	
	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement TypeName;
	@FindBy(xpath = "//input[@id=\"sales_price\"]")
	WebElement Salesprice;
	@FindBy(xpath = "//input[@id=\"item_number\"]")
	WebElement Itemnumber;
	@FindBy(xpath = "//textarea[@id=\"description\"]")
	WebElement Descriptions;
	@FindBy(xpath = "//span[text()='Products & Services']")
	WebElement ProductNService;
	@FindBy(xpath = "//a[text()='New Service']")
	WebElement NewService;
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement Submit;
	@FindBy(xpath = "//div[@class=\"alert alert-success fade in\"]")
	WebElement SuccessMessage;


	
	public ProductNServicePage() {
		PageFactory.initElements(driver, this);
	}
	 public void ProductNServices() {
		 ProductNService.click();
	 }
    public void NewService() {
    	NewService.click();
    }
    public boolean ValidateSuccessMessage() {
    	return SuccessMessage.isDisplayed();
    }
    public void NewOrder(String Name, String SalesPrice, String ItemNumber, String Description) {
    	TypeName.sendKeys(Name);
    	Salesprice.sendKeys(SalesPrice);
    	Itemnumber.sendKeys(ItemNumber);
    	Descriptions.sendKeys(Description);
    	Submit.click();
    }
    
}
