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
public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='login1']")
	WebElement UserName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;

	@FindBy(xpath = "//input[@title='Sign in']")
	public
	WebElement Submit;
	
	@FindBy(xpath="//div[@id='div_login_error']")
	public
	WebElement errorText;

	public WebElement UserName() {
		return UserName;
	}

	public WebElement Password() {
		return Password;
	}

	public WebElement Submit() {
		return Submit;}
		
	public WebElement errorText()
		{
			return errorText;
		}
	}

