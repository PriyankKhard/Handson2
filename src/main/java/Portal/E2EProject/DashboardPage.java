package Portal.E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.Base;

/**
 * Hello world!
 *
 */
public class DashboardPage {

	public WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[@id='signin_info']/a[1]")
	WebElement getSignin;

	@FindBy(xpath = "//li[@class='business']")
	WebElement LinkText;

	// get the Login elements
	public WebElement getSignin() {
		return getSignin;

	}

	public WebElement LinkText() {
		return LinkText;
	}

}
