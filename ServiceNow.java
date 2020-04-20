package week3.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
ChromeDriver driver =new ChromeDriver();
System.getProperty("webdriver.chrome.driver", "./chromedriver.exe");

//launch the browser
driver.get(" https://dev92474.service-now.com/");



//switching to frame

driver.switchTo().frame("gsft_main");

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//enter username password and click on login
driver.findElement(By.id("user_name")).sendKeys("admin");
driver.findElement(By.id("user_password")).sendKeys("India@123");
driver.findElement(By.id("sysverb_login")).sendKeys(Keys.ENTER);

//entering incident in filter navigator and pressing enter

driver.findElementById("filter").sendKeys("Incident",Keys.ENTER);
 Thread.sleep(5000);
//clicking on create new

driver.findElementByXPath("//div[text()='Create New']").click();              

//switching to frame
driver.switchTo().frame("gsft_main");
//getting the text written inside the number field

String incidentNumber = driver.findElementById("incident.number").getAttribute("value");
System.out.println("The incidnet number is : "+incidentNumber);

//clicking on search icon on caller field
 driver.findElementByXPath("(//span[@class='icon icon-search'])[1]").click();
 
 //switching to new window
 Set<String> windowHandles = driver.getWindowHandles();
 //handle of secondwindow and switching to it
 List<String> window =new ArrayList<String>(windowHandles);
 driver.switchTo().window(window.get(1));
 
 //getting the first name in the table
  WebElement table = driver.findElementById("sys_user_table");
  
  //getting first row
  WebElement firstRow = table.findElement(By.id("row_sys_user_62826bf03710200044e0bfc8bcbe5df1"));
  
  //getting all columns in first row
  
  List<WebElement> columns = firstRow.findElements(By.tagName("td"));
   
   //getting third column
  System.out.println("The value in the first column is "+ columns.get(2));
   columns.get(2).click();
   
   //switching back to main window
   
   driver.switchTo().window(window.get(0));
  
  //getting dropdown  category as software
  
  WebElement ddCategory = driver.findElementById("incident.category");
  Select dd1 =new Select(ddCategory);
  dd1.deselectByVisibleText("Software");
  
  //subcategory as email
  
  WebElement ddSubCategory = driver.findElementById("incident.subcategory");
  Select dd2 =new Select(ddSubCategory);
  dd2.deselectByVisibleText("Email");
  
 //contact type as walk in
  
  WebElement ddContactTpe = driver.findElementById("incident.contact_type");
  Select dd3 =new Select(ddContactTpe);
  dd3.deselectByVisibleText("Walk-in");
  
  //select state as in progress
  WebElement ddState = driver.findElementById("incident.state");
  Select dd4 =new Select(ddState);
  dd4.deselectByVisibleText("In Progress");
  
  //select urgency as high
  WebElement ddUrgency = driver.findElementById("incident.urgency");
  Select dd5 =new Select(ddState);
  dd5.deselectByVisibleText("1 - High");
  
  //clicking on look up at assignmnet group
  
  driver.findElementByXPath("(//span[@class='icon icon-search'])[4]").click();
//switch to new window again
  Set<String> windowHandles2 = driver.getWindowHandles();
  
List<String> windows2 =new ArrayList<String>();
windows2.get(1);

//getting the last value from table

WebElement table2 = driver.findElementById("sys_user_group_table");

//getting rows
 List<WebElement> allRowsTable2 = table.findElements(By.tagName("tr"));
	 //getting 20th Row
 
 WebElement twentyRow = allRowsTable2.get(19);
 
 //getting all columns from 20th row
 List<WebElement> lastColumn = twentyRow.findElements(By.tagName("td"));
 System.out.println("The last column value "+ lastColumn.get(2));
 lastColumn.get(2).click();
  //SWITCHING TO MAIN window
 
 driver.switchTo().window(windows2.get(0));
 
 //entering short description
 
 driver.findElementById("incident.short_description").sendKeys("Creating Incident For the Purpose of Management");
 
 //clicking on submit
  driver.findElementByXPath("//button[text()='Submit']").click();
  
  //entering the incidnet number in search box and press enter
  
  driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys(incidentNumber,Keys.ENTER);
  
  //clciking on the incidnt displaed
  
  driver.findElementByClassName("list_row list_odd").click();
  
  //verifing the incidnet num
  
  String number = driver.findElementById("incident.number").getAttribute("value");
   if(number== incidentNumber)
	   System.out.println("Verification done sucessfully");
   
   //updating impacted as high
   WebElement ddImpact= driver.findElementById("incident.impact");
   Select dd6 =new Select(ddImpact);
   dd6.deselectByVisibleText("1 - High");
   
   //entering description
   driver.findElementById("incident.description").sendKeys("Successfully Created an incident");
	
	
	//updating worknotes
	
	
	driver.findElementByXPath("(//textarea[@aria-label='Work notes'])[3]").sendKeys("Done Right");
	
	//Click update
	driver.findElementById("sysverb_update").click();

	//Come out of frame
	driver.switchTo().defaultContent();

	// Click logout
	driver.findElementByXPath("//span[text()='System Administrator']").click();

	driver.findElementByXPath("//a[text()='Logout']").click();

	// Close the browser
	driver.close();
	
}
}
