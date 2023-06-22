package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBase {
    //protected static is not ideal for parallel runs
	protected RemoteWebDriver driver;

	private WebDriverWait wait;
	private long timeOut = 30;

	public void type(WebElement element, String text) {
		wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
		log("The value " + text + " is typed");
	}

	public void clearAndType(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
		log("The value is clear and then " + text + " is typed");
	}

	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isReadOnly(WebElement element) {
		String isRead = element.getAttribute("readonly");
		if (isRead.equals("true")) {
			return true;
		} else
			return false;
	}

	public void click(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		WebElement readyEle = wait.until(ExpectedConditions.elementToBeClickable(element));
		readyEle.click();
		log("The ele is clicked");
	}

	public String getElementColor(WebElement element) {
		String cssValue = element.getCssValue("background-color");
		log("background-color is " + cssValue);
		return cssValue;
	}

	// TODO: Enhance it later
	public void selectText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		WebElement selectedOption = select.getFirstSelectedOption();
		if (selectedOption.getText().equals(visibleText)) {
			log("is Selcted: " + visibleText);
		} else {
			log("Option is not there: " + visibleText);
		}
	}

	// TODO: you have to complete
	public void selectIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// TODO: you have to complete
	public void selectValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		log("Alert text is: " + alert.getText());
		alert.accept();
	}

	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		log("Alert text is: " + alert.getText());
		alert.dismiss();
	}

	public void typeInAlert(String text) {
		Alert alert = driver.switchTo().alert();
		log("Alert text is: " + alert.getText());
		alert.sendKeys(text);
	}

	public void switchToFrame(int i) {
		driver.switchTo().frame(i);
		log("Switched to the " + i + " th frmae");
	}

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
		log("Switched to the frmae");
	}

	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
		log("Switched to the frmae");
	}

	public boolean isElementDisplayed(WebElement element) {
		log(element.isDisplayed());
		return element.isDisplayed();
	}

	public void switchToWindow(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		int size = list.size();
		System.out.println("No.of windows: " + size);
		driver.switchTo().window(list.get(i));
		log("Switched to the window");
	}

	public void log(Object message) {
		System.out.println(message);
	}

}
