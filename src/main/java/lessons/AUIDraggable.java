package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AUIDraggable {

	static ChromeDriver driver;

	public static void main(String[] args) {
		// Open browser, go to site and maximize
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		droppable();
		//draggable();
		driver.quit();
	}

	static void draggable() {
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		WebElement src = driver.findElementById("draggable");
		Actions builder = new Actions(driver);
		Point location = src.getLocation();
		builder.dragAndDropBy(src, location.getX() + 20, location.getY() + 2000).perform();
	}

	static void droppable() {
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement src = driver.findElementById("draggable");
		WebElement target = driver.findElementById("droppable");
		Actions builder = new Actions(driver);
		//Point location = src.getLocation();
		builder.dragAndDrop(src, target).build().perform();
	}
}
