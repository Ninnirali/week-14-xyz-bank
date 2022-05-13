package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomersPage extends Utility {

    public CustomersPage(){
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logOutButton;



    public void verifyLogOutButtonIsDisplayed(){
        CustomListeners.node.log(Status.PASS,"verify that logout button is displayed" + logOutButton.getText());
        Reporter.log("verify that logout button is displayed" + logOutButton.getText()+ "<br>");
        verifyThatElementIsDisplayed(logOutButton);
    }

    public void clickOnLogOutButton(){
        CustomListeners.node.log(Status.PASS,"click on logout button" + logOutButton.getText());
        Reporter.log("click on logout button" + logOutButton.getText()+ "<br>");
        clickOnElement(logOutButton);
    }

}
