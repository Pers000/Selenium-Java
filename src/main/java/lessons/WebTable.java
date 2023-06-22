package lessons;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {


	public static void main(String[] args) throws InterruptedException {
		// Open browser, go to site and maximize
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/table");
		driver.manage().window().maximize();
		
		System.out.println("SHOPPING LIST");
		WebElement shoppingList = driver.findElementById("shopping");
		List<WebElement> rows = shoppingList.findElements(By.tagName("tr"));
		//How to get the number of rows
		System.out.println("Total number of shopping rows: " + rows.size());
		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			//How to get the number of columns
			//System.out.println("Total number of columns: " + cols.size());
			WebElement data = cols.get(0);
			WebElement data2 = cols.get(1);
			System.out.println("Item Name: " + data.getText() + " with a price of " + data2.getText() + ".");
		}
		
		
		WebElement table = driver.findElementByCssSelector("table#simpletable>tbody");
		List<WebElement> rows2 = table.findElements(By.tagName("tr"));
		//How to get the number of rows
		System.out.println("Total number of rows: " + rows2.size());
		for (int i = 0; i < rows2.size(); i++) {
			List<WebElement> cols = rows2.get(i).findElements(By.tagName("td"));
			//How to get the number of columns
			//System.out.println("Total number of columns: " + cols.size());
			WebElement fName = cols.get(0);
			WebElement lName = cols.get(1);
			WebElement emailAdd = cols.get(2);
			System.out.println("Name: " + fName.getText() + " " + lName.getText() + " with Email Address of " + emailAdd.getText());
			if (lName.getText().equals("Man")) {
					cols.get(3).findElement(By.tagName("input")).click();
					//Don't forget to add break if conditions are met
					break;
			}
			
		}
		System.out.println("I'm done!");
		//driver.quit();
	}
}











