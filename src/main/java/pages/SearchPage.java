package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;


public class SearchPage {
	private SHAFT.GUI.WebDriver driver;
	Robot robot;

	public SearchPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By searchBox = By.id("searchInput");
	private By searchAssertion = By.xpath("//h1[@style='color: #000000']");
	private By secondProductAssertion = By.xpath("//li[text()='Anklets & Ankle Bracelets']");

	public void searchForProduct(String product) throws AWTException {
		driver.element().type(searchBox, product);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	public String searchAssertion() {

		return driver.element().getText(searchAssertion);
	}

	public By getsSearchAssertionLocator() {
		return searchAssertion;
	}

	public String secondProductAssertion() {

		return driver.element().getText(secondProductAssertion);
	}
	
	public By getSecondProductAssertionLocator() {
		return secondProductAssertion;
	}

}
