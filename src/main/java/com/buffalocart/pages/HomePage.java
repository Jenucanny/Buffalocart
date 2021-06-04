package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class HomePage extends PageUtility{
	WebDriver driver;
	public HomePage(WebDriver driver) //constructor (driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//@FindBy(xpath="//a[@class='dropdown-toggle']//span")
	@FindBy(xpath="//span[@class='logo-lg']")
	WebElement userpage;
	@FindBy(xpath="//button[@data-role='end']")
	WebElement endTour; 
	@FindBy(xpath="//section[@class='sidebar']/ul/li[2]/a")
	WebElement clickUserManagementPage;
	public boolean isHomePageLoaded() {
		sleep(3000);
		return getElementDisplayStatus(userpage);
		
	}
	public void handleEndTour()
	{
		clickOnElement(endTour);
		sleep(3000);
	}
	public UserManagementPage clickOnUserManagementPage() {
		
		clickOnElement(clickUserManagementPage);
		return new UserManagementPage(driver);
		
	}
}
