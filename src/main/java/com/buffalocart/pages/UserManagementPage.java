package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class UserManagementPage extends PageUtility{
	WebDriver driver;
	public UserManagementPage(WebDriver driver) //constructor (driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBys(
	@FindBy(xpath="//ul[@class='sidebar-menu']//ul//span[@class='title']"))
	List<WebElement> userManagementPageOptions;
	
	public List<String> userManagementList()
	{ List<String> menuName=new ArrayList<String>();
		for(int i=0;i<userManagementPageOptions.size();i++)
		{
			menuName.add(userManagementPageOptions.get(i).getText());
		}
		return menuName;
		
	}
	public UsersPage ClickOnUserPage()
	{
		for(int i=0;i<userManagementPageOptions.size();i++) {
		if(userManagementPageOptions.get(i).getText().equalsIgnoreCase("Users"))
		{
			clickOnElement(userManagementPageOptions.get(i));
		}
		}
		return new UsersPage(driver);
	}
	public RolesPage ClickOnRolesPage()
	{
		for(int i=0;i<userManagementPageOptions.size();i++) {
		if(userManagementPageOptions.get(i).getText().equalsIgnoreCase("Roles"))
		{
			clickOnElement(userManagementPageOptions.get(i));
		}
		}
		return new RolesPage(driver);
	}
		
	}

