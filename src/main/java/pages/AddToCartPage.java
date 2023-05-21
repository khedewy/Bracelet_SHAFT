package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class AddToCartPage {
	private SHAFT.GUI.WebDriver driver;

	public AddToCartPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By firstProduct = By.xpath("/html/body/main/div[5]/section/collection-grid/div/div/div[1]/article[3]/form/a/div[2]");
	private By firstProductAssertion = By.xpath("//h1[text()='Wave Ring']");
	private By addToCartButton = By
			.cssSelector(".product__add-to-cart > span:nth-child(1)");
	private By addProductAssertion = By.xpath("//div[text()='ћдне527.33 EGP']");

	public void navigateToFirstProduct() {
		
		driver.element().click(firstProduct);
	}

	public String getFirstProductAssertionMessage() {

		return driver.element().getText(firstProductAssertion);
	}
	
	public By getFirstProductAssertionLocator() {
		return firstProductAssertion;
	}

	public void addTCart() {
		
		driver.element().click(addToCartButton);
	}

	public String getAddProductToCartAssertion() {
		
		return driver.element().getText(addProductAssertion);
	}
	
	public By getAddToCarAssertionLocator() {
		return addProductAssertion;
	}

}
