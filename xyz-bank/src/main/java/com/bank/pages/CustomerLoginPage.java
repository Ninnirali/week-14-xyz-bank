package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    public CustomerLoginPage(){
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement yourNameDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameLabel;


    public void selectCustomerNameFromDropDown(String customerName){
        CustomListeners.node.log(Status.PASS,"Select ' " + customerName + "' from dropdown " + yourNameDropDown.getText());
        Reporter.log("Select ' " + customerName + " ' from dropdown" + yourNameDropDown.getText()+ "<br>");
        selectByVisibleTextFromDropDown(yourNameDropDown, customerName);
    }

    public void clickOnLoginButton(){
        CustomListeners.node.log(Status.PASS,"click on login button" + loginButton.getText());
        Reporter.log("click on login button" + loginButton.getText() + "<br>");
        clickOnElement(loginButton);
    }

    public String getTextFromYourNameLabel(){
        CustomListeners.node.log(Status.PASS,"get text from YourNameLabel" + yourNameLabel.getText());
        Reporter.log("get text from YourNameLabel" + yourNameLabel.getText()+ "<br>");
        return getTextFromElement(yourNameLabel);
    }

}
