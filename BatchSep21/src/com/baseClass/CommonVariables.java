package com.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonVariables {
	
	public static WebDriver driver;
	public static String BaseURL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	public static String TestDataPath = "/TM_AUG21_Framework/Data/Resource.xlsx";
	public static String CurrentTestCaseName;
	public static String Browser = "CHROME";
	public static WebElement element;

}
