package com.reports;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.*;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest test;

	public String createResultFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		String path = "";
		File file = new File(System.getProperty("user.dir") + "\\Report\\" + sdf.format(new Date()).replace("/", "")
				+ "\\TestReport.html");
		if (!file.exists()) {
			file.mkdirs();
			path = System.getProperty("user.dir") + "\\Report\\" + sdf.format(new Date()).replace("/", "")
					+ "\\TestReport.html";
		} else {
			path = System.getProperty("user.dir") + "\\Report\\" + sdf.format(new Date()).replace("/", "")
					+ "\\TestReport.html"; 
		}
		return path;
	}

	public void initializeReport() {
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter(createResultFolder());
		extent.attachReporter(sparkReporter);
	}

	public void startTest(String testCaseName) {
		test = extent.createTest(testCaseName);
	}

	public void flushReport() {
		extent.flush();
	}

	public void takeScreenshot(ITestResult result) throws IOException {
//		String fileDirectory = createResultFolder();
		if (result.getStatus() == ITestResult.SUCCESS) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, new File(result.getName() + ".png"));
		}
	}

}
