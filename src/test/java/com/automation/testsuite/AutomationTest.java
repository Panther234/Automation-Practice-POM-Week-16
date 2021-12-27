package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.*;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class AutomationTest extends TestBase {
    HomePage homePage;
    WomenCategoryPage womenCategoryPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;
    StoresPage storesPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        womenCategoryPage = new WomenCategoryPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
        myAccountPage = new MyAccountPage();
        storesPage = new StoresPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldDeleteProductFromCartSuccessfully() throws InterruptedException {
        homePage.selectMenu("Women");
        womenCategoryPage.sellProduct("Faded Short Sleeve T-shirts");
        productPage.clickOnAddToCartBtn();
        productPage.clickProceedToCheckOut();
        shoppingCartPage.clickDeleteButton();
        shoppingCartPage.verifyEmptyCartMessage("Your shopping cart is empty.");
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldSeeSummerCollection() {
        homePage.selectWomenMenu();
        homePage.selectSummerDress();
        womenCategoryPage.verifySummerDressText("SUMMER DRESSES ");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldSeePriceChangeResult() throws InterruptedException {
        homePage.selectWomenMenu();
        homePage.selectSummerDress();
        womenCategoryPage.verifySummerDressText("SUMMER DRESSES ");
        womenCategoryPage.setPriceRange();
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        homePage.signInLink();
        signInPage.enterEmail(getRandomEmail());
        signInPage.clickCreateAccountButton();
        createAccountPage.enterFirstName("Bob");
        createAccountPage.enterLastName("Alexa");
        createAccountPage.enterPassword("Abc1234");
        createAccountPage.enterAddress("1, Bond Street");
        createAccountPage.enterCity("london");
        createAccountPage.selectState("Alaska");
        createAccountPage.enterZipCode("12345");
        createAccountPage.enterPhoneNumber("0123456789");
        createAccountPage.enterReference("Home");
        createAccountPage.clickOnRegisterBtn();
        myAccountPage.verifyMyAccountText("MY ACCOUNT");
        myAccountPage.verifyAccountName("Bob Alexa");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserCanBrowseOurStoreOnMap() {
        homePage.clickOnOurStores();
        storesPage.clickOKOnMap();
        storesPage.location();
    }


}
