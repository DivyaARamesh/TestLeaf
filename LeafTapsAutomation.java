package week1.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafTapsAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.getProperty("webdriver.chrome.driver", "./chromedriver.exe");
ChromeDriver driver=new ChromeDriver();
driver.get("http://leaftaps.com/opentaps/control/main");
WebElement element = driver.findElementById("username");
element.sendKeys("DemoSalesManager");
driver.findElementById("password").sendKeys("crmsfa");
driver.findElementByClassName("decorativeSubmit").click();
driver.findElementByLinkText("CRM/SFA").click();
driver.findElementByLinkText("Create Lead").click();
driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
driver.findElementById("createLeadForm_firstName").sendKeys("Divya");
driver.findElementById("createLeadForm_lastName").sendKeys("Ramesh");
driver.findElementByClassName("smallSubmit").click();
String title = driver.getTitle();
System.out.println(title);
if (driver.getTitle().contains("View Lead | opentaps CRM")) {
	System.out.println("Lead created successfully");
}
	else
	{
		System.out.println("Lead has not been created.Please verify your details again");
	}
Thread.sleep(100);
driver.close();

	}

}

