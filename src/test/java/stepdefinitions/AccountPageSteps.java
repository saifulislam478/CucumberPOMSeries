package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileSystemUtils;
import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.test.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private AccountPage accountpage;
	
	@Given("User already logged in the application")
	public void user_already_logged_in_the_application(DataTable credTable) {
		
	List<Map<String, String>>	credList=credTable.asMaps();
	
	String userName=credList.get(0).get("username");
	String pwd=credList.get(0).get("password");
	DriverFactory.getDriver().get("https://practicetestautomation.com/practice-test-login/");
	
	accountpage=loginPage.doLogin(userName,pwd);
	
	    
	}

	@Given("user in account page")
	public void user_in_account_page() {
		
	   String title= accountpage.getAccounPageTitle();
	   System.out.println("Account page title "+title);
	}

	@Then("user get account sections")
	public void user_get_account_sections(DataTable sectionsTable) {
		List<String> expectedAccountSectionsList=sectionsTable.asList();
	    System.out.println("Expected account sections list "+expectedAccountSectionsList);
	    List<String> actualAccountSectionList=accountpage.getAccountSectionsList();
	    System.out.println("Actual account sections list "+actualAccountSectionList);
	    Assert.assertTrue( actualAccountSectionList.containsAll(expectedAccountSectionsList));
	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(Integer actualSectionsCount) {
		
		System.out.println("actual Sections Count "+actualSectionsCount);
		System.out.println("expected count "+accountpage.getAccountSectionCount());
		
		Assert.assertTrue(accountpage.getAccountSectionCount()==actualSectionsCount);
	    
	}

}
