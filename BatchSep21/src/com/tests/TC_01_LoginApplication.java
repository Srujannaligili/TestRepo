package com.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.reports.Reports;

public class TC_01_LoginApplication extends Reports {
	public WebDriver driver;
	public ITestResult result;

	@Test
	public void launchHRMApplication() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\96.0.4664.45\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Need to check the syntax error
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		System.out.println("Open Orange HRM application");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
	}

	@BeforeTest
	public void initializeReport() {
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("report.html");
		extent.attachReporter(sparkReporter);
	}

	@BeforeMethod
	public void startTest() {
		test = extent.createTest("TC_01");
	}

	@AfterTest
	public void flushReport() {
		extent.flush();
	}
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException {
//		String fileDirectory = createResultFolder();
		if (result.getStatus() == ITestResult.SUCCESS) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, new File(result.getName() + ".png"));
		}
	}
}
