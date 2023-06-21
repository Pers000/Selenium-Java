package chpater1;

import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in./");
		driver.manage().window().maximize();
		String email = "ponsta360v6@gmail.com";
		String password = "Pass123!";
	}
}
