package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCartPage extends Utility {
    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='icon-trash']")
    WebElement deleteButton;

    @FindBy(css = "p.alert.alert-warning")
    WebElement emptyCartMessage;

    public void clickDeleteButton() {
        clickOnElement(deleteButton);
        CustomListeners.test.log(Status.PASS, "Clicking Delete button");
    }

    public void verifyEmptyCartMessage(String text) throws InterruptedException {
        Thread.sleep(2000);
        String actualString = getTextFromElement(emptyCartMessage);
        System.out.println("text of message: " + actualString);
        Assert.assertTrue(actualString.trim().contains((text.trim())));
        CustomListeners.test.log(Status.PASS, "Verify shopping cart is empty Text " + text);
    }

}
