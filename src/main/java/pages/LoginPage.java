package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class LoginPage {
	private SHAFT.GUI.WebDriver driver;

	public LoginPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By loginPageAssertion = By.xpath("//h2[text()='Welcome Back!']");
	private By emailTxt = By.id("CustomerEmail");
	private By passwordTxt = By.id("CustomerPassword");
	private By loginButton = By.xpath("//input[@value='Log In']");
	private By assertionMessage = By.xpath("//h1[@class='account__name']");

	public String getLoginPageAssertionMessage() {
		return driver.element().getText(loginPageAssertion);
	}

	public By loginPageAssertionLocator() {
		return loginPageAssertion;
	}

	public void enterLoginInformation(String email, String password) {
		driver.element().type(emailTxt, email);
		driver.element().type(passwordTxt, password);
		driver.element().click(loginButton);
	}

	public String getSuccessfulLoginAssertionMessage() {
		return driver.element().getText(assertionMessage);
	}

	public By getSuccesfulLoginAssertionMessageLocator() {
		return assertionMessage;
	}

}
