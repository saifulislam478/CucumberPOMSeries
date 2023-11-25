package Parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.test.factory.DriverFactory;
import com.test.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHook {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	
	private ConfigReader configReader;
	
	Properties prop;
	
	@Before(order=0)
	public void getProperty()
	{
		configReader=new ConfigReader();
		prop=configReader.init_prop();
	}
	
	@Before(order=1)
	public void launchBrowser()
	{
		String browserName=prop.getProperty("browser");
		
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browserName);
	}
	
	@After(order=0)
	public void quiBrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario)

	{
		if(scenario.isFailed())
		{
			String screenshotName=scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);
		}
		
	}

}