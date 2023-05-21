package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.TestData.JSON;

import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends TestBase {
	HomePage homePage;
	RegisterPage registerPage;
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

}
