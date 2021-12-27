package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SignInPage extends Utility {
    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailCreate;

    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createAccountButton;

    public void enterEmail(String text) {
        sendTextToElement(emailCreate, text);
        CustomListeners.test.log(Status.PASS, "Enter Email " + text);
        Reporter.log("Enter Email: " + text + emailCreate.getText() + "<br>");
    }
    public void clickCreateAccountButton() {
        clickOnElement(createAccountButton);
        CustomListeners.test.log(Status.PASS, "Click create account " );
        Reporter.log("Click create account: " + createAccountButton.getText() + "<br>");
    }
}
