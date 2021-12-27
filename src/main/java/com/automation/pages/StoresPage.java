package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class StoresPage extends Utility {

    public StoresPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement popupHandle;

    @FindBy(xpath = "//button[@title='Zoom out']")
    WebElement zoomOutButton;

    public void clickOKOnMap() {
        clickOnElement(popupHandle);
        CustomListeners.test.log(Status.PASS, "Clicking on Map popup ");
//        Reporter.log("Enter Email: " + popupHandle.getText() + "<br>");
    }

    public void location() {
        zoomOutButton.click();
        zoomOutButton.click();
        takeScreenShot("screenshot");
        CustomListeners.test.log(Status.PASS, "Clicking on Map popup ");
        Reporter.log("Enter Email: " + zoomOutButton.getText() + "<br>");
    }
}
