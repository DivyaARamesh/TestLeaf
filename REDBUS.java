package week1.day5;

import java.text.DateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class REDBUS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
ChromeDriver driver =new ChromeDriver(options);
System.getProperty("webdriver.chrome.driver","./chromedriver.exe");

//opening browser
driver.get("https://www.redbus.in/");
//to maximize
driver.manage().window().maximize();

//enter source location
driver.findElementById("src").sendKeys("Chennai");
Thread.sleep(5000);
driver.findElementById("src").sendKeys(Keys.TAB);

//entering dest location
driver.findElementById("dest").sendKeys("Bengaluru");
Thread.sleep(5000);
driver.findElementById("dest").sendKeys(Keys.TAB);

//selection date
//driver.findElementById("onward_cal").click();
Thread.sleep(5000);
//enter 30/4 as date
driver.findElementByXPath("(//td[text()='30'])[2]").click();

//click on search buses
driver.findElementById("search_btn").click();

Thread.sleep(5000);
//checking after 6pm departure
driver.findElementByXPath("(//label[@for='dtAfter 6 pm'])[1]").click();

//checking sleeper
driver.findElementByXPath("(//label[@for='bt_SLEEPER'])[1]").click();

//seats available
driver.findElementByXPath("(//div[contains(@class,'w-15 fl')]//a)[2]").click();
	}

}
