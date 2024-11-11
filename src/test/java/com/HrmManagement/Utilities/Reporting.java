package com.HrmManagement.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.HrmManagement.TestCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public void onStart(ITestContext testContext)
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report"+timestamp+".html";
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		sparkReporter.config().setDocumentTitle("HrmManagementProject");
		sparkReporter.config().setReportName("Functional Test Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host Name", "loacalhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("User","srikanth");
		
		File screenshotDir=new File(System.getProperty("user.dir")+"/Screenshots/");
		if(!screenshotDir.exists())
		{
			screenshotDir.mkdir();
		}
	}
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	} 
	public void onTestFailure(ITestResult tr) 
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		try
		{
			BaseClass baseClass=new BaseClass();
			baseClass.captureScreenshot(Reporting.getDriver(),tr.getName());
			String screenshotpath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
			File f=new File(screenshotpath);
			if(f.exists())
			{
				logger.fail("screenshot is below:"+logger.addScreenCaptureFromPath(screenshotpath));
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("failed to capture the screenshot:"+e.getMessage());
		}
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testContext)
	{
        extent.flush(); 
    }
    
	private static WebDriver getDriver() {
		
		return BaseClass.driver;
	}

	
}
