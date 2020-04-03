package week1.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafTaps_DetailedAutomatiion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChromeDriver driver =new ChromeDriver();
System.getProperty("webdriver.chrome.driver", "./chromedriver.exe");

//launch the browser
driver.get("http://leaftaps.com/opentaps/control/main");

//enter username password and click on login
driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).sendKeys(Keys.ENTER);

//click on crmsfa link
driver.findElementByLinkText("CRM/SFA").sendKeys(Keys.ENTER);

//CLICK on leads link and click on find leads ,email ,enter email and click on find leads button
driver.findElementByLinkText("Leads").click();
driver.findElementByLinkText("Find Leads").sendKeys(Keys.ENTER);
driver.findElementByLinkText("Email").sendKeys(Keys.ENTER);
driver.findElementByXPath("(//span[text()='Advanced']/following::input)[5]").sendKeys("babu@testleaf.com");
driver.findElementByXPath("//button[text()='Find Leads']").click();

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//capture name of first resulting lead 
String text = driver.findElementByXPath("//table[@class='x-grid3-row-table']").getText();
System.out.println("First Resulting Lead for our search"+text);

//click on first resulting lead and clicking on duplicate lead
driver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]").click();
driver.findElementByXPath("(//a[@class='subMenuButton'])[1]").click();

//getting the title and printing it
String title = driver.getTitle();
 if (title=="Duplicate Lead") {
	 System.out.println("Title successfully verified as 'Duplicate Lead'");
	
}
 else
	 System.out.println("Title not matching with 'Duplicate Lead'");
 //click on create lead
 
 driver.findElementByLinkText("Create Lead").click();
 
 //back to duplicate lead page
 driver.navigate().back();
 
// getting the duplicate lead name
 String duplicateleadname  = driver.findElementById("createLeadForm_firstName").getAttribute("value");
 System.out.println(duplicateleadname);
 
 //verifying if duplicate lead name matches captured name of first result
 
 if (text==duplicateleadname) {
	 System.out.println("Validation completed successfully");
	
}
 else 
	 System.out.println("Duplicate lead name doesnot match Captured FirstLead Name");
 
 driver.close();
}
}
