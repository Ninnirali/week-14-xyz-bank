package com.bank.testbase;

import com.bank.propertyreader.PropertyReader;
import com.bank.utility.Utility;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }

}
