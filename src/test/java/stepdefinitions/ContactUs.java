package stepdefinitions;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.pages.ContactUsPage;
import com.test.factory.DriverFactory;
import com.test.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ContactUs {

	private ContactUsPage contactUsPage= new ContactUsPage(DriverFactory.getDriver());
	
	@Given("User navigate to contact us page")
	public void user_navigate_to_contact_us_page() {
		
		DriverFactory.getDriver().get("https://practicetestautomation.com/contact/");
		//String title=contactUsPage.contactPageTitle();
		//System.out.println(title);
		//Assert.assertTrue(title, );
	    
	}

	@When("usr file the form from given sheetname {string}  and rownumber {int}")
	public void usr_file_the_form_from_given_sheetname_and_rownumber(String sheetname, Integer rowNumber) {
		
		ExcelReader reader= new ExcelReader();
		try {
			List<Map<String,String>> listdata= reader.getData("D:/Selenium_cucumber/automation.xlsx", sheetname);
			String fname=listdata.get(rowNumber).get("fname");
			String lname= listdata.get(rowNumber).get("lname");
			String Email=listdata.get(rowNumber).get("Email");
			String comments=listdata.get(rowNumber).get("Comment or Message");
			
			contactUsPage.fillContactUsForm(fname, lname, Email, comments);
			
			
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	@When("Tick on checkbox")
	public void tick_on_checkbox() {
		contactUsPage.checkBoxSelect();
	    
	}

	@When("user click on send button")
	public void user_click_on_send_button() {
		contactUsPage.clickSend();
	    
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expectedValue) {
		
		String result=contactUsPage.getSuccessMessage();
		
		Assert.assertEquals(expectedValue, result, "Fail");
	    
	}
}
