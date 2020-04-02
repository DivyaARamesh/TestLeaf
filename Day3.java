package week1.day3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.findElementById("email").sendKeys("divya.ramesh05@gmail.com");
		driver.findElementByXPath("//input[@value='Append ']").sendKeys("Divya",Keys.TAB);
		String attribute = driver.findElementByXPath("(//input[@name='username'])[1]").getAttribute("value");
		System.out.println(attribute);
		driver.findElementByXPath("(//input[@name='username'])[2]").clear();
		boolean enabled = driver.findElementByXPath("//input[@disabled='true']").isEnabled();
		System.out.println(enabled);
		//string 
		String obj=new String("  TestLeafss");
				System.out.println(obj.charAt(9));
		System.out.println(obj.length());
		System.out.println(obj.indexOf('s'));
		System.out.println(obj.lastIndexOf('s'));
		System.out.println(obj.trim());
		
	}

}
