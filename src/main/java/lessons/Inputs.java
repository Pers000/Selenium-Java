package lessons;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Inputs {

	public static void main(String[] args) {
		// Open browser, go to site and maximize
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/edit");

		
		driver.findElementById("fullName").sendKeys("Monster Thutty");
	
		driver.findElementById("join").sendKeys(" Hacker", Keys.TAB);
		
		String attribute = driver.switchTo().activeElement().getAttribute("value");
		System.out.println("What is inside the text box: " + attribute);
	
		driver.findElementById("clearMe").clear();
		boolean enabled = driver.findElementById("noEdit").isEnabled();
		System.out.println("Confirm edit field is enabled: " + enabled);
		String isReadOnly = driver.findElementById("dontwrite").getAttribute("readonly");

		System.out.println("Confirm text is readonly: " + isReadOnly);

		driver.quit();

	}
}
