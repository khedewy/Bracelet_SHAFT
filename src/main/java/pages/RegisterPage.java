package pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;

public class RegisterPage {
	private SHAFT.GUI.WebDriver driver;

	public RegisterPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private final By createAccountPageAssertion = By.xpath("//h1[@class='account__title']");
	private final By firstNameTxt = By.id("FirstName");
	private final By lastNameTxt = By.id("LastName");
	private final By emailTxt = By.id("Email");
	private final By passwordTxt = By.id("CreatePassword");
	private final By signInButton = By.cssSelector("input.button:nth-child(1)");
	private final By accountManageIcon = By
			.cssSelector("li.lg-max\\:hidden:nth-child(3) > a:nth-child(1) > svg:nth-child(1)");
	private final By accountInformation = By.xpath("//a[@href='/account' and text()='Account']");
	private final By assertionMessage = By.xpath("//h1[@class='account__name']");

	public String getCreateAccountAssertionMessage() {
		return driver.element().getText(createAccountPageAssertion);
	}

	public By getCreateAccountPageAssertionLocator() {
		return createAccountPageAssertion;
	}

	public void enterUserInfo(String firstName, String lastName, String email, String password)
			throws InterruptedException {

		driver.element().type(firstNameTxt, firstName);
		driver.element().type(lastNameTxt, lastName);
		driver.element().type(emailTxt, email);
		driver.element().type(passwordTxt, password);
		//driver.element().scrollToElement(signInButton);
		driver.element().click(signInButton);
	}

	public void navigateToAccountInf() throws InterruptedException {
		driver.element().hover(accountManageIcon);
		driver.element().click(accountInformation);
	}

	public String getSuccessfulRegisterMessage() {

		return driver.element().getText(assertionMessage);
	}

	public By getAssertionMeessageLocator() {
		return assertionMessage;
	}

}
