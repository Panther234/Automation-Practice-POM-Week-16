package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProductPage extends Utility {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
    WebElement proceedToCheckout;

    public void clickOnAddToCartBtn() {
        clickOnElement(addToCartBtn);
        CustomListeners.test.log(Status.PASS, "Click Add to cart  ");
        Reporter.log("Click Add to cart: "  + addToCartBtn.getText() + "<br>");
    }

    public void clickProceedToCheckOut(){
        clickOnElement(proceedToCheckout);
        CustomListeners.test.log(Status.PASS, "Clicking to Proceed to checkout button");
        Reporter.log("Clicking to Proceed to checkout button : " + proceedToCheckout.getText() + "<br>");
    }


}
