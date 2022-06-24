package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.print.attribute.standard.Chromaticity;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	private WebDriver driver;
	private Properties prop;
	public WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options.setHeadless(false));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	public String getURL() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		return prop.getProperty("URL");

	}

	
	public String getName() throws IOException
	{
		String FileInputStream;
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		return(System.getProperty("NAME"));
		//return prop.getProperty("NAME");
	}
	
	public void driverClose() {
		driver.close();
	}

	public String getScreenshotandPath(String TCName, WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//Reports//" + TCName + ".png";
		org.apache.commons.io.FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
	}
}
