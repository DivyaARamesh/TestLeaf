package week4.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//https://dev101533.service-now.com/login.do?user_name=admin&sys_action=sysverb_login&user_password=zzZYEePxa0X5
//this is my user url
public class Project1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.driver.chromedriver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();


		driver.get("https://dev101533.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//switching to frame

		driver.switchTo().frame("gsft_main");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//enter username password and click on login
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Ananya@45");
		driver.findElement(By.id("sysverb_login")).sendKeys(Keys.ENTER);

		//entering change in filter navigator

		driver.findElementById("filter").sendKeys("Change");
		Thread.sleep(3000);

		//clicking on create new
		WebElement createNew = driver.findElementByXPath("//div[text()='Create New']");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createNew)).click();

		//click on normal change
		driver.findElementByXPath("//div[@class='container-fluid wizard-container']/a").click();
		Thread.sleep(3000);

		//switching to frame
		driver.switchTo().frame("gsft_main");

		//getting the change number
		String changeNum = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println("The change number is :" + changeNum);

		//click on submit
		driver.findElementByXPath("//button[text()='Submit']").click();

		//verifying the change num

		//searching the change
		//entering the change number in search box and press enter

		driver.findElementByXPath("//input[@class='form-control']").sendKeys(changeNum,Keys.ENTER);

		//clicking on change
		driver.findElementByXPath("//a[@class='linked formlink']").click();

		//verifing  the num

		String number = driver.findElementById("change_request.number").getAttribute("value");

		if(number==changeNum)
		{
			System.out.println("The change number vlidated successfully");
		}
	}

}


