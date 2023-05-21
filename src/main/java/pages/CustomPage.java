package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class CustomPage {
	private SHAFT.GUI.WebDriver driver;

	public CustomPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By customIcons = By.id("desktop-nav-custom");
	private By customPageAssertion = By.xpath("//h1[@style='color: #000']");
	private By EngravableProduct = By.cssSelector(".ss-results > div:nth-child(1) > article:nth-child(2) > form:nth-child(1) > a:nth-child(3) > div:nth-child(2)");
	private By writingBox = By.id("engravingText");
	private By symbolIcon = By.xpath("//button[@title='Basketball']");
	private By acceptTerms = By.id("acceptTerms");
	private By addToCartButton = By
			.xpath("//button[@class='product__add-to-cart button button--large button--full button--teal']");
	private By looksGreat = By.xpath("//button[text()='Looks great!']");
	private By addToCartAssertion = By.xpath("//div[text()='ћдне790.99 EGP']");

	public void navigateToCustomPage() {
		driver.element().click(customIcons);
	}

	public String getCustomPageAssertionMessage() {

		return driver.element().getText(customPageAssertion);
	}

	public By getCustomePageAssertionLocator() {
		return customPageAssertion;
	}

	public void customAnProduct(String custom) {

		driver.element().click(EngravableProduct);
		driver.element().scrollToElement(writingBox);
		driver.element().type(writingBox, custom);
		driver.element().scrollToElement(symbolIcon);
		driver.element().click(symbolIcon);
		driver.element().scrollToElement(acceptTerms);
		driver.element().click(acceptTerms);
	}

	public void addCustomToCart() {

		driver.element().click(addToCartButton);
		driver.element().click(looksGreat);

	}

	public String getAddToCartAssertionMessage() {

		return driver.element().getText(addToCartAssertion);
	}

	public By getAddToCartAssertionLocator() {
		return addToCartAssertion;
	}

}
