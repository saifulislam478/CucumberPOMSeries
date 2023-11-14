package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.test.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginsteps {

	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	
	private static String title;

@Given("User is on login page")
public void user_in_on_login_page() {
    
	DriverFactory.getDriver().get("https://practicetestautomation.com/practice-test-login/");
	

	
}

@When("User gets the title of the page")
public void user_gets_the_title_of_the_page() {
	
title=loginPage.getLoginPageTitle();
	
	System.out.println("Login Page Titele is "+title);
}
    


@Then("Page title should be {string}")
public void page_title_should_be(String expactedTitle) {
    

	Assert.assertTrue(title.contains(expactedTitle));
}

@Given("User is on login page forget passowrd")
public void user_is_on_login_page_forget_password() {
	
	
    
}


@Then("Forget passowrd link should be displayed")
public void forget_passowrd_link_should_be_displayed() {
    
}

//@Given("User is on login Page")
//public void user_is_on_login_page() 
//{
//}
    

@When("User enter username {string}")
public void user_enter_username(String uname) 
{
	loginPage.enterUserName(uname);

}
   


@When("user enter password {string}")
public void user_enter_password(String pwd) {
	loginPage.enterPassword(pwd);  
}

@When("user click on login button")
public void user_click_on_login_button() {
	loginPage.clickOnLogin();
   
}

}
