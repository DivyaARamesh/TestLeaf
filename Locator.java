package week1.day2;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.getProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver =new ChromeDriver(options);
		
		
		driver.get("https://www.facebook.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("email").sendKeys("XXX@gmail.com");
		driver.findElementById("pass").sendKeys("xxx");
		driver.manage().window().maximize();
		driver.findElementById("loginbutton").click();
		driver.findElementById("userNavigationLabel").click();
		Thread.sleep(10000);
		driver.findElementByPartialLinkText("Log Out").click();

	}

}
