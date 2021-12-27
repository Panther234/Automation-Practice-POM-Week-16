package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class MyAccountPage extends Utility {
    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='View my customer account']//span[1]")
    WebElement accountName;

    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    WebElement myAccountText;

    public void verifyAccountName(String account){
        String actualString = getTextFromElement(accountName);
        System.out.println("text of message: " + actualString);
        Assert.assertTrue(actualString.contains((account)));
        CustomListeners.test.log(Status.PASS, "Verify Summer Dress Text " + account);
        Reporter.log("Verify Summer Dress Text  : " + account + accountName.getText() + "<br>");
    }
    public void verifyMyAccountText(String text){
        String actualString = getTextFromElement(myAccountText);
        System.out.println("text of message: " + actualString);
        Assert.assertTrue(actualString.contains((text)));
        CustomListeners.test.log(Status.PASS,"Verify 'My Account' text is displayed " + text);
        Reporter.log("Verify 'My Account' text is displayed : " + text + myAccountText.getText() + "<br>");
    }



}
