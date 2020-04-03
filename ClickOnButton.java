package week1.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ClickOnButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChromeDriver driver =new ChromeDriver();
System.getProperty("webdriver.chrome.driver", "./chromedriver.exe");
//driver.get("http://leaftaps.com/opentaps/control/main");
//System.out.println(driver.findElementByTagName("h2").getCssValue("background-color"));
//System.out.println(driver.findElementByXPath("//label[@for='username']").getCssValue("font-size"));
//int width = driver.findElementByClassName("decorativeSubmit").getSize().getWidth();
//System.out.println(width);
//System.out.println(driver.findElementById("username").getLocation().getX());

driver.get("http://www.leafground.com/pages/Link.html");
System.out.println(driver.findElementByLinkText("Find where am supposed to go without clicking me?").getAttribute("href"));
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElementByPartialLinkText("broken").click();
boolean contains = driver.getTitle().contains("404");
System.out.println(contains);

//
	}
	

}
