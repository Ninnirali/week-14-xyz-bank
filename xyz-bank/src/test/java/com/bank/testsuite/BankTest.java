package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import javafx.scene.control.Tab;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankTest extends TestBase {

    public BankTest(){
        PageFactory.initElements(driver,this);
    }

    HomePage homePage;
    CustomerLoginPage customerLoginPage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomersPage customersPage;
    AccountPage accountPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        customerLoginPage = new CustomerLoginPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customersPage = new CustomersPage();
        accountPage = new AccountPage();
        PageFactory.initElements(driver, this);
    }

    @Test(priority = 0, groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully(){

        homePage.clickOnBankManagerLoginButton();
        bankManagerLoginPage.clickOnAddCustomerTab();
        addCustomerPage.enterFirstName("Sia");
        addCustomerPage.enterLastName("Smith");
        addCustomerPage.enterPostCode("WC1 3AB");
        addCustomerPage.clickOnAddCustomer();
        String actual = addCustomerPage.getPopUpText();
        Assert.assertTrue(actual.contains("Customer added successfully"), "Customer hasn't been added successfully.");
        addCustomerPage.clickOkOnPopUp();
        addCustomerPage.clickOnHomeTabFromAddCustomerPage();

    }

    @Test(priority = 1, groups = {"sanity","smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully(){

        addCustomerPage.clickOnHomeTabFromAddCustomerPage();
        homePage.clickOnBankManagerLoginButton();
        bankManagerLoginPage.clickOnOpenAccountTab();
        openAccountPage.selectCustomerFromDropDown("Sia Smith");
        openAccountPage.selectCurrencyFromCurrencyDropDown("Pound");
        openAccountPage.clickOnProcessButton();
        String actual1 = openAccountPage.getPopUpText();
        Assert.assertTrue(actual1.contains("Account created successfully"), "Account hasn't been created successfully.");
        openAccountPage.clickOkOnPopUp();

    }

    @Test(priority = 2, groups = {"smoke","regression"})
    public void customerShouldLoginAndLogoutSuccessfully(){

        addCustomerPage.clickOnHomeTabFromAddCustomerPage();
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectCustomerNameFromDropDown("Sia Smith");
        customerLoginPage.clickOnLoginButton();
        customersPage.verifyLogOutButtonIsDisplayed();
        customersPage.clickOnLogOutButton();
        String actualText = customerLoginPage.getTextFromYourNameLabel();
        Assert.assertTrue(actualText.contains("Your Name"), "Customer hasn't logged out successfully.");

    }

    @Test(priority = 3,groups = {"smoke","regression"})
    public void customerShouldDepositMoneySuccessfully(){

         addCustomerPage.clickOnHomeTabFromAddCustomerPage();
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectCustomerNameFromDropDown("Sia Smith");
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositButton();
        accountPage.enterAmountToBeDeposited("100");
        accountPage.clickOnDepositAmountButton();
        String actualMessage = accountPage.getTextFromDepositConfirmationMessage();
        String expectedMessage = "Deposit Successful";
        Assert.assertEquals(actualMessage,expectedMessage,"Amount hasn't been deposited successfully.");

    }

    @Test(priority = 4, groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully(){

        addCustomerPage.clickOnHomeTabFromAddCustomerPage();
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectCustomerNameFromDropDown("Sia Smith");
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnWithdrawlButton();
        accountPage.enterAmountToBeWithdrawn("50");
        accountPage.clickOnWithdrawAmountButton();
        String actualMessage1 = accountPage.getTextFromWithdrawalConfirmationMessage();
        String expectedMessage = "Transaction successful";
        Assert.assertEquals(actualMessage1, expectedMessage,"Amount hasn't been withdrawn successfully.");

    }

}
