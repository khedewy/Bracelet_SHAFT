package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class ShopPage {
	private SHAFT.GUI.WebDriver driver;

	public ShopPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By shopOptions = By.id("desktop-nav-shop");
	private By ringsProduct = By.id("desktop-nav-shop-jewelry-rings");
	private By firstProductAssertion = By.xpath("//li[text()='Rings']");
	private By engravables = By.id("desktop-nav-shop-jewelry-engravables");
	private By engravablesAssertion = By.xpath("//li[text()='Engraved Jewelry']");

	public void navigateToRingsProduct() {
		driver.element().hover(shopOptions);
		driver.element().click(ringsProduct);
	}

	public String getFirstProductAssertionMessage() {

		return driver.element().getText(firstProductAssertion);
	}

	public By getFirstProductAssertionLocator() {
		return firstProductAssertion;
	}

	public void navigateToSecondProduct() {
		driver.element().hover(shopOptions);
		driver.element().click(engravables);
	}

	public String getEngravablesAssertionMessage() {

		return driver.element().getText(engravablesAssertion);
	}

	public By secondProductAssertionLocator() {
		return engravablesAssertion;
	}

}
