package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {

    public BankManagerLoginPage(){
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerTab;

    @CacheLookup
    @FindBy(xpath = "//div//button[contains(text(),'Open Account')]")
    WebElement openAccountTab;


    public void clickOnAddCustomerTab(){
        CustomListeners.node.log(Status.PASS,"click on add customer tab" + addCustomerTab.getText());
        Reporter.log("click on add customer tab" + addCustomerTab.getText()+"<br>");
        clickOnElement(addCustomerTab);
    }

    public void clickOnOpenAccountTab(){
        CustomListeners.node.log(Status.PASS,"click on open account tab" + openAccountTab.getText());
        Reporter.log("click on open account tab" + openAccountTab.getText()+ "<br>");
        clickOnElement(openAccountTab);
    }


}
