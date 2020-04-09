package week2.day4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
ChromeDriver driver=new ChromeDriver();
System.getProperty("webdriver.driver.chromedriver", "./chromedriver.exe");

driver.get("https://www.flipkart.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//close the pop up
driver.findElementByXPath("//button[text()='✕']").click();

//click on TV and appliances
WebElement element = driver.findElementByXPath("//span[text()='TVs & Appliances']");

Actions builder =new Actions(driver);
builder.moveToElement(element).perform();

Thread.sleep(5000);

driver.findElementByLinkText("LG").click();



	}
}