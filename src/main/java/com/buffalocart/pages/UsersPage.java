package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class UsersPage extends PageUtility{
	WebDriver driver;
	public UsersPage(WebDriver driver) //constructor (driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//div[@class='box-tools']//a")
	WebElement addUserData;
	@FindBy(id="surname")
	WebElement prefix;
	@FindBy(id="first_name")
	WebElement fname;
	@FindBy(id="last_name")
	WebElement lname;
	@FindBy(id="email")
	WebElement email;
	
	@FindBys(
	@FindBy(xpath="//ul[@id='select2-role-results']//li"))
	List<WebElement> role;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="confirm_password")
	WebElement confpassword;
	@FindBy(id="cmmsn_percent")
	WebElement salesComm;
	@FindBy(xpath="//div[@class='icheckbox_square-blue']//ins")
	WebElement contactCheckbox;
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement selectContact;
	@FindBys(
	@FindBy(xpath="//ul[@class='select2-results__options']//li"))
	List<WebElement> selectContactOptions;
	
	@FindBy(id="submit_user_button")
	WebElement save;
	@FindBys(
			@FindBy(xpath="//table[@id='users_table']//tbody//td"))
	List<WebElement> table;
	
	public void clickToAddUser()
	{
		clickOnElement(addUserData);
	}
	public void selectRole(String roleget) {
		for(int i=0;i<role.size();i++)
		{
		if(role.get(i).getText().equalsIgnoreCase(roleget))
				{
			
			clickOnElement(role.get(i));
				}
		}
	}
	public void enterSurname(String s)
	{
		enterText(prefix,s);
	}
	public void enterFirstName(String f)
	{
		enterText(fname,f);
	}
	public void enterLastName(String l)
	{
		
		enterText(lname,l);
	}
	public void enterEmail(String e)
	{
		enterText(email,e);	
	}
	/*public void enterUserName(String u)
	{
		enterText(uname,u);
	}*/
	public void enterpassword(String p)
	{
		enterText(password,p);
	}
	public void enterconfirmPassword(String cp)
	{
		enterText(confpassword,cp);
	}
	public void enterSalesCommission(String sc)
	{
		enterText(salesComm,sc);
	}
	public void clickAllowSelectedContactCheckbox()
	{
		clickOnElement(contactCheckbox);
		
	}
	public void clickSelectContact()
	{
		clickOnElement(selectContact);
	}
	public void selectContactOptions(String option1) {
		for(int i=0;i<selectContactOptions.size();i++)
		{
		if(selectContactOptions.get(i).getText().equalsIgnoreCase(option1))	{
			clickOnElement(selectContactOptions.get(i));
			sleep(3000);
		}
		}
		
	}
	public void clickSave()
	{
		clickOnElement(save);
	}
	public void compareTable()
	{
		for(int i=0;i<table.size();i++)
		{
			String actualTable=table.get(i).getText();
		}
	}
	public List<String> verifyTable()
	{
		List<String> tablerow=new ArrayList<String>();
		for(int i=0;i<table.size()-1;i++)
		{
			tablerow.add(table.get(i).getText());
		}
		
		return tablerow;
	}
}
