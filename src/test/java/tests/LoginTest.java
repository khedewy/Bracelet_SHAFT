package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.TestData.JSON;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginTest extends TestBase {
	HomePage homePage;
	RegisterPage registerPage;
	LoginPage log;
	String currentTime = String.valueOf(System.currentTimeMillis());
	SHAFT.TestData.JSON registerData;

	@Test
	public void NavigateToCreateAccount() {
		homePage = new HomePage(driver);
		homePage.navigateToCreateAccount();
		registerPage = new RegisterPage(driver);
		Assert.assertEquals(registerPage.getCreateAccountAssertionMessage(), "CREATE AN ACCOUNT");
	}

	@Test(priority = 1)
	public void enterUserData() throws InterruptedException {
		registerData = new JSON("registerData.json");
		registerPage = new RegisterPage(driver);
		registerPage.enterUserInfo(registerData.getTestData("firstName"), registerData.getTestData("lastName"),
				registerData.getTestData("email") + currentTime + "@gmail.com", registerData.getTestData("password"));
	}

	@Test(priority = 2)
	public void RegisterAssertion() throws InterruptedException {
		registerPage = new RegisterPage(driver);
		Thread.sleep(5000);
		registerPage.navigateToAccountInf();
		Assert.assertEquals(registerPage.getSuccessfulRegisterMessage(), "HI, MAHMOUD!\n" + "NICE TO HAVE YOU BACK.");
	}

	@Test(priority = 3)
	public void logOut() {
		homePage = new HomePage(driver);
		homePage.logOut();
	}

	@Test(priority = 4)
	public void navigateToLoginAndLogin() {
		registerData = new JSON("registerData.json");
		homePage = new HomePage(driver);
		log = new LoginPage(driver);
		homePage.navigateToLoginPage();
		Assert.assertEquals(log.getLoginPageAssertionMessage(), "WELCOME BACK!");
		log.enterLoginInformation(registerData.getTestData("email") + currentTime + "@gmail.com",
				registerData.getTestData("password"));
		Assert.assertEquals(log.getSuccessfulLoginAssertionMessage(), "HI, MAHMOUD!\n" + "NICE TO HAVE YOU BACK.");

	}

}
