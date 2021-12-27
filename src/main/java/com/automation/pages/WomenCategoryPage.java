package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class WomenCategoryPage extends Utility {
    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='cat-name']")
    WebElement summerDressText;

    @FindBy(css = "div#layered_price_slider>a:nth-of-type(2)")
    WebElement slider;

    @FindBy(id = "layered_price_slider")
    WebElement fullSlider;

    @FindBy(xpath = "//a[normalize-space()='Blouse']")   //a[normalize-space()='Blouse']
    WebElement blouse;

    @FindBy(xpath = "(//a[@title='Printed Dress'][normalize-space()='Printed Dress'])[1]")
    WebElement printedDress;

    @FindBy(xpath = "//a[normalize-space()='Printed Chiffon Dress']")
    WebElement priChiDress;

    @FindBy(xpath = "(//a[@title='Printed Summer Dress'][normalize-space()='Printed Summer Dress'])[2]")
    WebElement summerDress;

    @FindBy(linkText = "Faded Short Sleeve T-shirts")
    WebElement fadedShortSleeveTShirt;

    public void verifySummerDressText(String text) {
        String actualString = getTextFromElement(summerDressText);
//        System.out.println("text of message: " + actualString);
        Assert.assertTrue(actualString.trim().equalsIgnoreCase(text.trim()));
        CustomListeners.test.log(Status.PASS, "Verify Summer Dress Text " + text);
        Reporter.log("Verify Summer Dress Text : " + text + summerDressText.getText() + "<br>");
    }

    public void sellProduct(String proName) {
        if (proName.equalsIgnoreCase("Blouse")) {
            CustomListeners.test.log(Status.PASS, "Select Product  " + proName);
            Reporter.log("Select Product : " + proName + blouse.getText() + "<br>");
            clickOnElement(blouse);
        } else if (proName.equalsIgnoreCase("Printed Dress")) {
            CustomListeners.test.log(Status.PASS, "Select Product  " + proName);
            Reporter.log("Select Product : " + proName + printedDress.getText() + "<br>");
            mouseHoverToElementAndClick(printedDress);
        } else if (proName.equalsIgnoreCase("Printed Chiffon Dress")) {
            CustomListeners.test.log(Status.PASS, "Select Product  " + proName);
            Reporter.log("Select Product : " + proName + priChiDress.getText() + "<br>");
            clickOnElement(priChiDress);
        } else if (proName.equalsIgnoreCase("Printed Summer Dress with Price $28.98")) {
            CustomListeners.test.log(Status.PASS, "Select Product  " + proName);
            Reporter.log("Select Product : " + proName + summerDress.getText() + "<br>");
            clickOnElement(summerDress);
        } else if (proName.equalsIgnoreCase("Faded Short Sleeve T-shirts")) {
            clickOnElement(fadedShortSleeveTShirt);
        }
    }

    public void setPriceRange() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, ((Double) (-0.75 * fullSlider.getSize().width)).intValue() + 1, 0).build().perform();
        CustomListeners.test.log(Status.PASS, "Drag Slider");
        Reporter.log("Drag Slider : " + "<br>");
    }

//    public void setPriceRange() throws InterruptedException {
//        Actions action = new Actions(driver);
//        action.click(slider).build().perform();
//        Thread.sleep(1000);
//        for (int i = 0; i < 75; i++) {
//            action.sendKeys(Keys.ARROW_LEFT).build().perform();
//        }
//
//    }
}
