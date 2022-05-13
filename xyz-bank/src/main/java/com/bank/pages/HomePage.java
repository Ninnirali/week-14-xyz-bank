package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginTab;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLoginTab;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;

    public void clickOnCustomerLoginButton(){
        CustomListeners.node.log(Status.PASS,"click on customer login tab " + customerLoginTab.getText());
        Reporter.log("click on customer login tab " + customerLoginTab.getText()+ "<br>");
        clickOnElement(customerLoginTab);
    }

    public void clickOnBankManagerLoginButton(){
        CustomListeners.node.log(Status.PASS,"click on bank manager login tab " + bankManagerLoginTab.getText());
        Reporter.log("click on bank manager login tab" + bankManagerLoginTab.getText()+"<br>");
        clickOnElement(bankManagerLoginTab);
    }



}
