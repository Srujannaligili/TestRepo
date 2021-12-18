package com.reports;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsExample {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest test;
	public static String resultFile;
	
	public void report() {
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("report.html");
		extent.attachReporter(sparkReporter);
	}
	
	public void endReport() {
		extent.flush();
	}
	
	public void TC_01() {
		try {
		extent.createTest("TC_Login");
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\Geecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		test.log(Status.INFO, "Upload url lauched");
		System.out.println("Open Demo QA");	
		test.log(Status.PASS, "Launched URL");
		
		WebElement fileUpload = driver.findElement(By.xpath("//input[@id='uploadFile']"));
		fileUpload.sendKeys("C:\\Users\\hp\\Documents\\Zoom\\SeleniumOct'21\\FileUpload.txt");
		
		driver.findElement(By.xpath("//*[text()='Download']")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		ReportsExample obj = new ReportsExample();
		obj.report();
		obj.TC_01();
		obj.endReport();
	}

}
