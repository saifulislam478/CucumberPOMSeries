package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	
	//1. By locator
	private By userName=By.id("username");
	private By password= By.id("password");
	private By signInButton=By.id("submit");

	
	//Constructor of the page class
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Page actions
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void isForgetPasswordLikExist()
	{
		driver.findElement(password);
	}
	
	public void enterUserName(String uname)
	
	{
		driver.findElement(userName).sendKeys(uname);
	}
	
public void enterPassword(String pwd)
	
	{
		driver.findElement(password).sendKeys(pwd);
	}

public void clickOnLogin()
{
	driver.findElement(signInButton).click();
}

public AccountPage doLogin(String ur, String pwd)
{
	System.out.println("Login with username "+ur+" and Password "+pwd);
	driver.findElement(userName).sendKeys(ur);
	driver.findElement(password).sendKeys(pwd);
	driver.findElement(signInButton).click();
	
	return new AccountPage(driver);
}
}
