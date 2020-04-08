package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChromeDriver driver=new ChromeDriver();
System.getProperty("webdriver.driver.chromedriver", "./chromedriver.exe");

driver.get("http://leaftaps.com/opentaps/control/main");
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//enter username password and click on login
driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).sendKeys(Keys.ENTER);

//click on crmsfa link
driver.findElementByLinkText("CRM/SFA").sendKeys(Keys.ENTER);
//click on create lead
driver.findElementByLinkText("Create Lead").click();

//entering Source DD
WebElement source = driver.findElementById("createLeadForm_dataSourceId");
Select dd1=new Select(source);
 dd1.selectByVisibleText("Existing Customer");
 
 //entering Industry DD
 WebElement industry = driver.findElementById("createLeadForm_industryEnumId");
 Select dd2 =new Select(industry);
 //getting all options in DD
 List<WebElement> options = dd2.getOptions();
 //getting count
 int size = options.size();
 dd2.selectByIndex(size-1);










	}

}
