package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this); }

    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    WebElement clickSignInLink;

    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenMenu;

    @FindBy(xpath = "//li[@class='sfHover']//a[@title='Summer Dresses'][normalize-space()='Summer Dresses']")
    WebElement summerDress;

    @FindBy(xpath = "//a[contains(text(),'Our stores')]")
    WebElement ourStore;

    public void selectWomenMenu(){
        mouseHoverToElement(womenMenu);
        CustomListeners.test.log(Status.PASS, "Mousehover on Women menu ");
        Reporter.log("Mousehover on Women menu : " + womenMenu.getText() + "<br>");
    }
    public void selectSummerDress(){
        clickOnElement(summerDress);
        CustomListeners.test.log(Status.PASS, "Clicking on Summer Dress ");
        Reporter.log("Clicking on Summer Dress : " + summerDress.getText() + "<br>");
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@id='block_top_menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
    }
    public void signInLink (){
        clickOnElement(clickSignInLink);
        CustomListeners.test.log(Status.PASS, "Clicking on SignIn Link ");
        Reporter.log("Clicking on SignIn Link : "  + clickSignInLink.getText() + "<br>");
    }
    public void clickOnOurStores(){
        clickOnElement(ourStore);
        CustomListeners.test.log(Status.PASS, "Clicking on Our Stores Link ");
        Reporter.log("Clicking on Our Stores Link : " + ourStore.getText() + "<br>");
    }


}
