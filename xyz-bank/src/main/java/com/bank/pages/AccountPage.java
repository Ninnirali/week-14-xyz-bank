package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AccountPage extends Utility {

    public AccountPage(){
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='deposit()' and contains(text(),'Deposit')]")
    WebElement depositButton;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountToBeDepositedField;

    @CacheLookup
    @FindBy(xpath ="//button[@type='submit' and contains(text(),'Deposit')]")
    WebElement depositAmountButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessfulText;

    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='withdrawl()' and contains(text(),'Withdrawl')]")
    WebElement withdrawlButton;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountToBeWithdrawnField;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Withdraw')]")
    WebElement withdrawAmountButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement transactionSuccessfulText;


    public void clickOnDepositButton(){
        CustomListeners.node.log(Status.PASS, "Click on depositButton :" + depositButton.getText());
        Reporter.log("Click on Deposit Button" + depositButton.getText() + "<br>");
        clickOnElement(depositButton);
    }

    public void enterAmountToBeDeposited(String amount){
        CustomListeners.node.log(Status.PASS,"Enter the deposit amount ' "+ amount + " ' into amount field" + amountToBeDepositedField.getText());
        Reporter.log("Enter the deposit amount" + amount +" into amount field" + amountToBeDepositedField.toString()+"<br>");
        sendTextToElement(amountToBeDepositedField, amount);
    }

    public void clickOnDepositAmountButton(){
        CustomListeners.node.log(Status.PASS,"Click on deposit button" + depositAmountButton.getText() + "<br>");
        Reporter.log("Click on Deposit button" + depositAmountButton.getText()+"<br>");
        clickOnElement(depositAmountButton);
    }

    public String getTextFromDepositConfirmationMessage(){
        CustomListeners.node.log(Status.PASS,"get text from deposit confirmation message" + depositSuccessfulText.getText() + "<br>");
        Reporter.log("get text from deposit confirmation message" + depositSuccessfulText.getText()+ "<br>");
        return getTextFromElement(depositSuccessfulText);
    }

    public void clickOnWithdrawlButton(){
        CustomListeners.node.log(Status.PASS,"Click on Withdrawl button" + withdrawlButton.getText());
        Reporter.log("Click on Withdrawl button" + withdrawlButton.getText()+ "<br>");
        clickOnElement(withdrawlButton);
    }

    public void enterAmountToBeWithdrawn(String amount){
        CustomListeners.node.log(Status.PASS,"Enter the withdrawl amount ' " + amount + " ' into amount field" + amountToBeWithdrawnField.getText());
        Reporter.log("Enter the withdrawl amount '" + amount + " ' into amount field" + amountToBeWithdrawnField.toString()+"<br>");
        sendTextToElement(amountToBeWithdrawnField, amount);
    }

    public void clickOnWithdrawAmountButton(){
        CustomListeners.node.log(Status.PASS,"click on withdraw amount button" + withdrawAmountButton.getText());
        Reporter.log("click on withdraw amount button" + withdrawAmountButton.getText() + "<br>");
        clickOnElement(withdrawAmountButton);
    }

    public String getTextFromWithdrawalConfirmationMessage(){
        CustomListeners.node.log(Status.PASS,"get text from Withdrawl confirmation message" + transactionSuccessfulText.getText());
        Reporter.log("get text from Withdrawl confirmation message" + transactionSuccessfulText.toString() + "<br>");
        return getTextFromElement(transactionSuccessfulText);
    }
}
