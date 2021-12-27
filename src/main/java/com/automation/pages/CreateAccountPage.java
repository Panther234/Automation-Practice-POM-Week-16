package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CreateAccountPage extends Utility {

    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(xpath = "//input[@id='postcode']")
    WebElement zipcode;

    @FindBy(id = "phone_mobile")
    WebElement phoneNumber;

    @FindBy(id = "alias")
    WebElement reference;

    @FindBy(xpath = "//span[normalize-space()='Register']")
    WebElement registerBtn;

    public void clickOnRegisterBtn(){
        clickOnElement(registerBtn);
//        Reporter.log("Click register : " + registerBtn.getText() + "<br>");
        CustomListeners.test.log(Status.PASS, "Click register");
    }

    public void enterAddress(String text){
        sendTextToElement(address,text);
        CustomListeners.test.log(Status.PASS, "Enter Address " + text);
        Reporter.log("Enter Address : " + text + address.getText() + "<br>");
    }

    public void enterCity(String text){
        sendTextToElement(city,text);
        CustomListeners.test.log(Status.PASS, "Enter City" + text);
        Reporter.log("Enter City : " + text + city.getText() + "<br>");
    }

    public void enterZipCode(String text){
        sendTextToElement(zipcode,text);
        CustomListeners.test.log(Status.PASS, "Enter Zipcode" + text);
        Reporter.log("Enter Zipcode : " + text + zipcode.getText() + "<br>");
    }

    public void enterPhoneNumber(String text){
        sendTextToElement(phoneNumber,text);
        CustomListeners.test.log(Status.PASS, "Enter PhoneNumber" + text);
        Reporter.log("Enter PhoneNumber : " + text + phoneNumber.getText() + "<br>");
    }

    public void enterReference(String text){
        sendTextToElement(reference,text);
        CustomListeners.test.log(Status.PASS, "Select Reference" + text);
        Reporter.log("Select Reference : " + text + reference.getText() + "<br>");
    }

    public void selectState(String text){
        sendTextToElement(state,text);
        CustomListeners.test.log(Status.PASS, "Select state " + text);
        Reporter.log("Select state : " + text + state.getText() + "<br>");
    }

    public void enterFirstName(String text){
        sendTextToElement(firstName,text);
        CustomListeners.test.log(Status.PASS, "Enter Firstname" + text);
        Reporter.log("Enter Firstname : " + text + firstName.getText() + "<br>");
    }
    public void enterLastName(String text){
        sendTextToElement(lastName,text);
        CustomListeners.test.log(Status.PASS, "Enter Lastname " + text);
        Reporter.log("Enter Lastname : " + text + lastName.getText() + "<br>");
    }
    public void enterPassword(String text){
        sendTextToElement(password,text);
        CustomListeners.test.log(Status.PASS, "Send text to Password" + text);
        Reporter.log("Send text to Password : " + text + password.getText() + "<br>");
    }
}
