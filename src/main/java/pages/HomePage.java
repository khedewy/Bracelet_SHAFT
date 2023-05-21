package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class HomePage {
	private SHAFT.GUI.WebDriver driver;

	public HomePage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private final By accountManageOptions = By
			.cssSelector("li.lg-max\\:hidden:nth-child(3) > a:nth-child(1) > svg:nth-child(1)");
	private By createAccount = By.xpath("//a[text()='Create account']");
	private By loginButton = By.xpath("//a[@href='/account/login' and text()='Log in']");
	private By logOutButton = By.xpath("//a[text()='Log out']");
	private By searchIcon = By.cssSelector("li.lg-max\\:hidden:nth-child(1) > button:nth-child(1) > svg:nth-child(1)");

	public RegisterPage navigateToCreateAccount() {
	
		driver.element().hover(accountManageOptions);	
		driver.element().click(createAccount);
		return new RegisterPage(driver);
	}

	public LoginPage navigateToLoginPage() {
		
		driver.element().hover(accountManageOptions);	
		driver.element().click(loginButton);
		return new LoginPage(driver);
	}

	public void logOut() {
		driver.element().hover(accountManageOptions);	
		driver.element().click(logOutButton);
	}

	public SearchPage navigateToSearchPage() {
	
		driver.element().click(searchIcon);
		return new SearchPage(driver);
	}

}
