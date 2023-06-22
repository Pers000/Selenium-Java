package lessons;

import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buttons {

	public static void main(String[] args) {
		//Open browser, go to site and maximize 
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/");
		driver.manage().window().maximize();
		driver.get("https://letcode.in/buttons");
		
		// location
		WebElement btn1 = driver.findElementById("position");
		Point location = btn1.getLocation();
		System.out.println("Find Location X and Y coordinates " + location);
		
		// color
		WebElement btn2 = driver.findElementById("color");
		String color = btn2.getCssValue("background-color");
		System.out.println("What is my coloer?: " + color);
		
		// width & height
		Rectangle rect = driver.findElementById("property").getRect();
		int height = rect.getHeight();
		int width = rect.getWidth();
		System.out.println("My height is " + height + "& my body fat is " + width);
		
		boolean enabled = driver.findElementById("isDisabled").isEnabled();
		if(enabled) {
			System.out.println("Button 'Disabled' is really disabled.");
		}else {
			System.out.println("Button 'Disabled' is actually enabled.");
		}
		
		driver.quit();
	}
}
