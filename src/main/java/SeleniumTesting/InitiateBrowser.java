package SeleniumTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class InitiateBrowser {

	static WebDriver driver;
	@BeforeTest
	public void openBrowser()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
		  FirefoxOptions options = new FirefoxOptions();
	        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); // Path to your Firefox binary

	        driver = new FirefoxDriver(options);
	}
	
	@Parameters("URL")
	@Test
	public void openURl(String URL) throws InterruptedException
	{
		driver.get(URL);
		Thread.sleep(Duration.ofSeconds(3));
	}
	
	@Test
	@Parameters("na")
	public void search(String na) {
	WebElement input=driver.findElement(By.id("APjFqb"));
	input.sendKeys(na);
	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
