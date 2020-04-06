package week1.day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafTaps_DetailedAutomatiion {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
ChromeDriver driver =new ChromeDriver();
System.getProperty("webdriver.chrome.driver", "./chromedriver.exe");

//launch the browser
driver.get("http://leaftaps.com/opentaps/control/main");
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//enter username password and click on login
driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).sendKeys(Keys.ENTER);

//click on crmsfa link
driver.findElementByLinkText("CRM/SFA").sendKeys(Keys.ENTER);

//CLICK on leads link and click on find leads 
driver.findElementByLinkText("Leads").click();
driver.findElementByLinkText("Find Leads").sendKeys(Keys.ENTER);

//enter first name and click on find leads

driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Babu1");
driver.findElementByXPath("//button[text()='Find Leads']").click();

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
Thread.sleep(3000);

//Click on first resulting lead 
driver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]").click();

//getting the title and printing it
String title = driver.getTitle();
System.out.println("The title is "+title);

//click on edit
driver.findElementByLinkText("Edit").click();

//change company name
driver.findElementById("updateLeadForm_companyName").clear();
driver.findElementById("updateLeadForm_companyName").sendKeys("SocGen");

//click updATE
driver.findElementByClassName("smallSubmit").click();

Thread.sleep(5000);

//verifying whether company name has updated
String companyName = driver.findElementById("viewLead_companyName_sp").getText();
System.out.println(companyName);

 if (companyName.contentEquals("SocGen")) {
	 System.out.println("Company successfully updated as 'SocGen'");
	
}
 else
	 System.out.println("Company not updated correctly");
 
 driver.close();
}
}
