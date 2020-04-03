package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ACME_PROJECT {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
ChromeDriver driver =new ChromeDriver();
Actions obj =new Actions(driver);

System.getProperty("webdriver.chrome.driver", "./chromedriver.exe");

//launch the browser
driver.get("https://acme-test.uipath.com/account/login");
//username ,pass ,login click
driver.findElementByClassName("form-control").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
driver.findElementById("password").
sendKeys("leaf@12");
driver.findElementById("buttonLogin").click();

driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

//mouse over
WebElement element = driver.findElementByXPath("//button[text()[normalize-space()='Vendors']]");
//getting element Vendor
 //getting mouse over
obj.moveToElement(element).perform();

//click on search for vendors
driver.findElementByXPath("//a[@href='/vendors/search']").click();

//enter name blue lagoon and click search
driver.findElementById("vendorName").sendKeys("Blue Lagoon");
driver.findElementById("buttonSearch").click();

//finding country name
String text = driver.findElementByXPath("//td[text()='France']").getText();
System.out.println(text);
//click on logout
driver.findElementByXPath("//a[@href='/account/logout/']").click();

//close browser
driver.close();
}
	}
