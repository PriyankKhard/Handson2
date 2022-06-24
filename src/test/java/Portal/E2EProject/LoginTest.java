package Portal.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Portal.E2EProject.DashboardPage;
import Resources.Base;

public class LoginTest extends Base {
WebDriver driver;
	private static Logger log =  LogManager.getLogger(LoginTest.class.getName());
	
	@Test
    @Parameters({"username","password"})
	public void loginTest(String username, String password ) throws IOException, InterruptedException {

		driver = initializeDriver();
        log.info("Driver Initialized");
		driver.get(getURL());
		log.info("URL Retrieved");
		log.debug("getURL method call Successful");
		driver.manage().window().maximize();
		log.info("Windows Maximized Successfully ****");
		DashboardPage dp = new DashboardPage(driver);
		// driver.findElement(By.xpath("//li[@data-cy='account']")).click();

		dp.getSignin().click();

		LoginPage lp = new LoginPage(driver);
		lp.UserName().sendKeys(username);
		log.info("Successfully Entered User Name");
		lp.Password().sendKeys(password);
		log.info("Successfully Entered Password");
		lp.Submit.click();
		log.info("Successfully Submitted");
		log.info("***Test is Executed By "+ getName());
		Assert.assertEquals(lp.errorText.getText(), "Temporary error occured[#5001], please try again.");
		

	}

	
	@AfterTest
	public void browserClose()
	{
		driverClose();
	}
}
