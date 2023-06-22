package lessons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) {
		// Open browser, go to site and maximize
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/");
		driver.manage().window().maximize();
		driver.get("https://letcode.in/alert");
		
		//Click Simple Alert button
		driver.findElement(By.id("accept")).click();
		System.out.println("User has clicked 'Simple Alert' button");

		//Confirming alert
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		//driver.switchTo().alert().accept();
		System.out.println("User has accepted welcome alert.");

		//Click Confirm Alert button
		driver.findElement(By.id("confirm")).click();
		System.out.println("User has clicked 'Confirm Alert' button");
		System.out.println(alert.getText());
		alert.dismiss();
		System.out.println("User is not happy on letcode.");
		
		
		// type in alert
		driver.findElement(By.id("prompt")).click();
		alert.sendKeys("Monster");
		alert.accept();
		
		driver.quit();

	}
}
