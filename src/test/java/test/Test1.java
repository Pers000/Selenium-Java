package test;

import org.letcode.pages.HeaderPage;
import org.letcode.pages.HomePage;
import org.letcode.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import projectSpecific.LetCodeBase;

public class Test1 extends LetCodeBase{
	@Test
	public void login() throws InterruptedException {
		HomePage home = new HomePage(driver);
		String welcomeMessage = home.validateWelcomeMessage();
		Assert.assertEquals(welcomeMessage.trim(), "LetCode with Koushik");
		HeaderPage header = new HeaderPage(driver);
		header.clickLoginMenu();
		LoginPage login = new LoginPage(driver);
		login.enterUserEmail("ponsta360v6@gmail.com");
		login.enterPassword("Pass123!");
		login.clickLogin();
		Thread.sleep(3000);
		String toastMessage = home.validateToastMessage();
		System.out.println(toastMessage);
		Assert.assertEquals(toastMessage.trim(), "Welcome Tamiduk");
	}

}
