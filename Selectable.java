package week2.day4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
ChromeDriver driver=new ChromeDriver();
System.getProperty("webdriver.driver.chromedriver", "./chromedriver.exe");

driver.get("http://www.leafground.com/pages/selectable.html");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

Actions builder =new Actions(driver);


//getting xpath of items to be selected
WebElement item1 = driver.findElementByXPath("//ol[@id='selectable']/li[1]");
WebElement item2 = driver.findElementByXPath("//ol[@id='selectable']/li[2]");
WebElement item4 = driver.findElementByXPath("//ol[@id='selectable']/li[4]");
WebElement item7 = driver.findElementByXPath("//ol[@id='selectable']/li[7]");
//builder.keyDown(Keys.CONTROL).click(item1).click(item2).click(item4).perform();
 // or method to select items 1 to 4
//selecting by click on  src elem and release on dest ele
//builder.clickAndHold(item1).release(item4).perform();

//selecting the last 4
builder.clickAndHold(item4).release(item7).perform();
	}
}