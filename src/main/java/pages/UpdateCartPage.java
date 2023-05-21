package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class UpdateCartPage {
	private SHAFT.GUI.WebDriver driver;

	public UpdateCartPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private final By plusButton = By.xpath(
			"/html/body/footer/mini-cart/section/div[2]/div/div[2]/div[1]/line-item/div/div[2]/div[2]/quantity-selector/div/button[2]");
	private final By onePlusAssertion = By.xpath("//div[ text()='ћдне1,054.66 EGP' ]");
	private final By towPlusAssertion = By.xpath("//div[ text()='ћдне1,318.98 EGP' ]");

	private final By removeItemsButton = By.xpath("//button[@class='cart__item-remove']");
	private final By removeAssertion = By.xpath("//span[text()='Your cart looks a little empty!']");

	public void clickPlusButton() {

		driver.element().click(plusButton);
	}

	public String firstPlusAssertion() {
		return driver.element().getText(onePlusAssertion);
	}

	public By getFirstPlusAssertionLocator() {
		return onePlusAssertion;
	}

	public String towPlusAssertion() {
		return driver.element().getText(towPlusAssertion);
	}

	public void removeItem() {
		driver.element().click(removeItemsButton);
	}

	public String removeItemAssertion() {
		return driver.element().getText(removeAssertion);
	}

	public By removeItemAssertionLocator() {
		return removeAssertion;
	}

}
