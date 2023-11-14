package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	private WebDriver driver;
	
	private  By accountSections = By.cssSelector("div#menu-primary li");
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
	}
 public int getAccountSectionCount()
 {
	 return driver.findElements(accountSections).size();
 }
 
 public String  getAccounPageTitle()
 {
	 return driver.getTitle();
 }
 
 public List<String> getAccountSectionsList()
 {
	 List<String> accountsList=new ArrayList<>();
	 List<WebElement> accountHeaderList=driver.findElements(accountSections);
	 
	 for( WebElement e:accountHeaderList)
	 {
		String header= e.getText();
		System.out.println(header);
		accountsList.add(header);
		
	 }
	return accountsList;			 
 }
 
}
