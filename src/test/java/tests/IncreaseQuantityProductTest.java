package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.HomePage;
import pages.SearchPage;
import pages.UpdateCartPage;

public class IncreaseQuantityProductTest extends TestBase {

	UpdateCartPage update;
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

	@Test(priority = 3)
	public void IncreaseByOne() {
		update = new UpdateCartPage(driver);
		update.clickPlusButton();
		Assert.assertEquals(update.firstPlusAssertion(), "ћдне1,054.66 EGP");
	}

	@Test(priority = 4)
	public void increaseByTow() {
		update = new UpdateCartPage(driver);
		update.clickPlusButton();
		Assert.assertEquals(update.towPlusAssertion(), "ћдне1,318.98 EGP");
	}

}
