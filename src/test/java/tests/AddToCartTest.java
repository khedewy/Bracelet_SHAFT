package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.HomePage;
import pages.SearchPage;

public class AddToCartTest extends TestBase {
	HomePage homePage;
	SearchPage searchPage;
	AddToCartPage add;

	@Test
	public void navigateToSearchPage() {
		homePage = new HomePage(driver);
		homePage.navigateToSearchPage();
	}

	@Test(priority = 1)
	public void searchForProduct() throws AWTException {
		searchPage = new SearchPage(driver);
		searchPage.searchForProduct("rings");
		Assert.assertEquals(searchPage.searchAssertion(), "RINGS");
	}

	@Test(priority = 2)
	public void addProductToCart() {
		add = new AddToCartPage(driver);
		add.navigateToFirstProduct();
		Assert.assertEquals(add.getFirstProductAssertionMessage(), "WAVE RING");
		add.addTCart();
		Assert.assertEquals(add.getAddProductToCartAssertion(), "ћдне527.33 EGP");
	}

}
