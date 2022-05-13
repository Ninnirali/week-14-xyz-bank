package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {

    public AddCustomerPage(){
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCodeField;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Add Customer')]")
    WebElement addCustomerTab;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeTab;


    public void enterFirstName(String firstname){
        CustomListeners.node.log(Status.PASS,"Enter ' " + firstname + " ' to the firstnameField" + firstNameField.getText());
        Reporter.log("Enter ' " + firstname + " ' to the field" + firstNameField.getText() + "<br>");
        sendTextToElement(firstNameField, firstname);
    }

    public void enterLastName(String lastname){
        CustomListeners.node.log(Status.PASS,"Enter ' " + lastname + " ' to the lastnameField" + lastNameField.getText());
        Reporter.log("Enter ' "+ lastname +" ' to the field" + lastNameField.getText() + "<br>");
        sendTextToElement(lastNameField, lastname);
    }

    public void enterPostCode(String postcode){
        CustomListeners.node.log(Status.PASS,"Enter ' " + postcode + " ' to the postcodeField " + postCodeField.getText());
        Reporter.log("Enter postcode to the field" + postCodeField.getText() + "<br>");
        sendTextToElement(postCodeField, postcode);
    }

    public void clickOnAddCustomer(){
        CustomListeners.node.log(Status.PASS,"click on add customer tab" + addCustomerTab.getText());
        Reporter.log("click on add customer tab" + addCustomerTab.getText() + "<br>");
        clickOnElement(addCustomerTab);
    }

    public String getPopUpText(){
        CustomListeners.node.log(Status.PASS,"get text from pop up" + getTextFromAlert());
        Reporter.log("get text from pop up" + getTextFromAlert() + "<br>");
        return getTextFromAlert();
    }

    public void clickOkOnPopUp(){
        CustomListeners.node.log(Status.PASS,"click ok on pop up");
        Reporter.log("click ok on pop up"+"<br>");
        acceptAlert();
    }

    public void clickOnHomeTabFromAddCustomerPage(){
        CustomListeners.node.log(Status.PASS,"Click on homepage from customer page" + homeTab.getText());
        Reporter.log("click on homepage from customer page" + homeTab.getText() + "<br>");
        clickOnElement(homeTab);
    }

}
