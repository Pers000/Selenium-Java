package lessons;

import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	
	public static void main(String[] args) {
		// Open browser, go to site and maximize
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/frame");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("firstFr");
		driver.findElementByName("fname").sendKeys("Monster");
		//driver.switchTo().frame(0);
		driver.switchTo().frame("aswift_0");
		driver.findElementByName("email").sendKeys("rawr@sample.com");
		driver.switchTo().defaultContent(); 
		driver.findElementByTagName("button").click();
	
		
//		driver.quit();
		
		
		
		
		
		
		
		
	}
}
