package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {

    public OpenAccountPage(){
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerNameDropDrown;

    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;

    public void selectCustomerFromDropDown(String customerName){
        CustomListeners.node.log(Status.PASS,"Select ' " + customerName + " ' from dropdown" + customerNameDropDrown.getText());
        Reporter.log("select ' " + customerName + " ' from dropdown" + customerNameDropDrown.getText()+ "<br>");
        selectByVisibleTextFromDropDown(customerNameDropDrown, customerName);
    }

    public void selectCurrencyFromCurrencyDropDown(String currency){
        CustomListeners.node.log(Status.PASS,"Select ' " + currency + " ' from dropdown " + currencyDropDown.getText());
        Reporter.log("Select ' " + currency + " ' from dropdown" + currencyDropDown.getText()+ "<br>");
        selectByVisibleTextFromDropDown(currencyDropDown, currency);
    }

    public void clickOnProcessButton(){
        CustomListeners.node.log(Status.PASS,"Click on process button "+ processButton.getText());
        Reporter.log("Click on process button " + processButton.getText() + "<br>");
        clickOnElement(processButton);
    }

    public String getPopUpText(){
        CustomListeners.node.log(Status.PASS,"get text from pop up" + getTextFromAlert());
        Reporter.log("get text from pop up" + getTextFromAlert() + "<br>");
        return getTextFromAlert();
    }

    public void clickOkOnPopUp(){
        CustomListeners.node.log(Status.PASS,"Click ok on pop up" + "<br>");
        Reporter.log("Click ok on pop up"  + "<br>");
        acceptAlert();
    }


}
