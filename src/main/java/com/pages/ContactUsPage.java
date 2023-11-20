package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
	
	private WebDriver driver;
	
	private By fName=By.id("wpforms-161-field_0");
	private By lName=By.id("wpforms-161-field_0-last");
	private By emailID=By.id("wpforms-161-field_1");
	private By commentsMessage=By.id("wpforms-161-field_2");
	private By capchaCheck=By.cssSelector("recaptcha-checkbox-border");
	private By submitBtn=By.id("wpforms-submit-161");
	private By successmesage=By.id("wpforms-confirmation-161");
	
	
	public  ContactUsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String contactPageTitle()
	{
		return driver.getTitle();
	}
	
	public void fillContactUsForm(String fname, String lname, String email, String message)
	{
		driver.findElement(fName).sendKeys(fname);
		driver.findElement(lName).sendKeys(lname);
		driver.findElement(emailID).sendKeys(email);
		driver.findElement(commentsMessage).sendKeys(message);
		
		
		
	}
	
	public void checkBoxSelect()
	{
		//driver.findElement(capchaCheck).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(capchaCheck)).click();
	}
	
	public void clickSend()
	{
		driver.findElement(submitBtn).click();
		
	}
	
	public String getSuccessMessage()
	{
		return driver.findElement(successmesage).getText();
	}

}
