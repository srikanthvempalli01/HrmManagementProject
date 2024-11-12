package com.HrmManagement.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.HrmManagement.PageObjectClasses.LoginDDT;
import com.HrmManagement.Utilities.XLUtils;

public class TC_TestCaseLoginDDT_002 extends BaseClass
{
    @Test(dataProvider = "LoginData")
    public void LoginDDTTest(String user, String passwd) throws InterruptedException
    {
        driver.get(baseURL1);
        logger.info("URL is opened");

        LoginDDT lt = new LoginDDT(driver);
        lt.setUsername(user);
        Thread.sleep(2000);
        logger.info("Entered the Username");
        lt.setPassword(passwd);
        Thread.sleep(2000);
        logger.info("Entered the Password");
        lt.clickLogin();
        if(driver.getTitle().equals("ParaBank | Accounts Overview"))
        {
            Assert.assertTrue(true);
            logger.info("Login successfull");
            Thread.sleep(2000);
            lt.clickLogout();
            logger.info("Logout successfull");
        } 
        else
        {
            Assert.assertTrue(false);
            logger.info("Login failed");
        }
    }

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException
    {
        String path = System.getProperty("user.dir") + "/src/test/java/com/HrmManagement/TestData/LoginDDT.xlsx";
        int rowcount=XLUtils.getRowCount(path, "Sheet1");
        int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
        String[][] loginData = new String[rowcount][colcount];
        for (int i = 1; i <= rowcount; i++)
        {
            for (int j = 0; j < colcount; j++) 
            {
                loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return loginData;
    }
}
