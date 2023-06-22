package lessons;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseVsQuit {
	public static void main(String[] args) {
		// Open browser, go to site and maximize
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/");
		driver.manage().window().maximize();
		driver.get("https://letcode.in/buttons");

		// email pass
		String email = "ponsta360v6@gmail.com";
		String pass = "Pass123!";
		WebElement signIn = driver.findElementByLinkText("Log in");
		signIn.click();
		driver.findElementByName("email").sendKeys(email);
		System.out.println("Username entered.");
		driver.findElementByName("password").sendKeys(pass);
		System.out.println("Password entered.");
		driver.findElementByXPath("//button[text()='LOGIN']").click();
		System.out.println("User clicked the login button.");
		System.out.println("User has successfully logged in!");
		// driver.close();
		driver.quit();
	}
}
