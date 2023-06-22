package lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleElements {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/elements");
		driver.findElement(By.name("username")).sendKeys("ortonikc", Keys.ENTER);
		// sleep
		Thread.sleep(3000);
		//List<WebElement> links = driver.findElementsByXPath("(//div[@class='box'])[1]//li");
		List<WebElement> links = driver.findElementsByXPath("/html/body/app-root//div/ol/li[*]");
		for (WebElement link : links) {
			System.out.println(link.getText());
		}
		System.out.println("Closing remarks");
		driver.quit();
	}
}
