package week2.day4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
ChromeDriver driver=new ChromeDriver();
System.getProperty("webdriver.driver.chromedriver", "./chromedriver.exe");

driver.get("http://www.leafground.com/pages/drop.html");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

WebElement draggable = driver.findElementById("draggable");
WebElement droppable = driver.findElementById("droppable");

Actions builder =new Actions(driver);
builder.dragAndDrop(draggable, droppable).perform();

}
}