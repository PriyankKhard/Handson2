package Portal.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Resources.Base;

public class LinkDisplayed extends Base{
	WebDriver driver;
@Test
	public void LinkDisplayed() throws IOException  {

		driver = initializeDriver();

		driver.get(getURL());
		driver.manage().window().maximize();

		DashboardPage dp = new DashboardPage(driver);
		Assert.assertTrue(dp.LinkText().isDisplayed());
		
	}

@AfterTest
public void browserClose()
{
	driverClose();
}
}
