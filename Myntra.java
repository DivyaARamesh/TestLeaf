package week2.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
ChromeDriver driver=new ChromeDriver(options);

System.getProperty("webdriver.driver.chromedriver", "./chromedriver.exe");

driver.get("https://www.myntra.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//action class declaration
Actions builder =new Actions(driver);

//getting the women element
 WebElement women = driver.findElementByLinkText("Women");
 
 //mouse over on women
 builder.moveToElement(women).perform();
 
 Thread.sleep(5000);
 
 //click jackets and coats
 driver.findElementByLinkText("Jackets & Coats").click();
 
 //find total count of items on top
 String totalCount = driver.findElementByClassName("title-count").getText();
 System.out.println("The total count of available items are "+totalCount);

 //converting to int for comparison,REPLACING ANTHING OTHER THAN NUMBERS
 String text = totalCount.replaceAll("\\D","");
 int totalItemCount = Integer.parseInt(text);
 System.out.println("The total item count in integer "+ totalItemCount);
 
 //getting sum of all items under categories
 
String category1 = driver.findElementByClassName("categories-num").getText();
String category2 = driver.findElementByClassName("categories-num").getText();

//REPLACING ANTHING OTHER THAN NUMBERS
String string1 = category1.replaceAll("\\D", "");
String string2 = category2.replaceAll("\\D", "");

//converting to int
int category1Count = Integer.parseInt(string1);
int category2Count = Integer.parseInt(string2);
System.out.println("Category 1 Count "+category1Count);
System.out.println("Category 2 Count "+category2Count);

//validating the count

int TotalCategorySum =category1Count+category1Count;
if(TotalCategorySum==totalItemCount)
{
System.out.println("The  category count equals the total count");	

}
else
	System.out.println("Count not matching");

//checking coats

driver.findElementByXPath("//input[@value='Coats']").click();

//clicking on + more options under brand

driver.findElementByXPath("//div[@class='brand-more']").click();

//typing mango and clicking the checkbox

driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("MANGO");
Thread.sleep(5000);
driver.findElementByXPath("//input[@value='MANGO']").click();

//clciking on close button
driver.findElementByXPath("//span[contains(@class,'FilterDirectory-close')]").click();

//confirming all elements are of mango

List<WebElement> list = driver.findElementsByXPath("//h3[text()='MANGO']");

//total count displayed at the top

String count = driver.findElementByClassName("title-count").getText().replaceAll("\\D", "");
int finalCount = Integer.parseInt(count);

//verifying count at top and displayed items
if(list.size()==finalCount)
{
	System.out.println("The total count matches and the value is "+ finalCount);
}
else
	System.out.println("Mismatch in total count");
//sort by better discount,mouse over
WebElement discount = driver.findElementByClassName("sort-sortBy");
builder.moveToElement(discount).perform();

//click on better discount
driver.findElementByXPath("//label[text()='Better Discount']").click();
//price of first element
String price = driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]").getText();
System.out.println("The price of first element is "+ price);


//clcik on wishlist now
driver.findElementByXPath("(//span[contains(@class,'wishlist product')])[1]").click();

//click on close
driver.close();
	
}
}