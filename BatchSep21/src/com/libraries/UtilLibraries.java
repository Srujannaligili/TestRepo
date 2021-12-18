package com.libraries;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.baseClass.CommonVariables;

public class UtilLibraries extends CommonVariables implements WebLibraries {

	public static void Click(String Xpath) {
		driver.findElement(By.xpath(Xpath)).click();
	}

//	public static void Click(String ID) {
//		driver.findElement(By.id(ID)).click();
//	}

	@Override
	public void enterText(String attribute, String attributeValue, String value, String tagName) {
		
		try {
			switch (attribute.toLowerCase()) {
			case "id":
				element = driver.findElement(By.id(attributeValue));
				element.click();
				element.clear();
				element.sendKeys(value);

			case "xpath":
				element = driver
						.findElement(By.xpath("//" + tagName + "[@" + attribute + "='" + attributeValue + "']"));
				element.click();
				element.clear();
				element.sendKeys(value);

			case "class":
				element = driver.findElement(By.className(attributeValue));
				element.click();
				element.clear();
				element.sendKeys(value);

			case "name":
				element = driver.findElement(By.name(attributeValue));
				element.click();
				element.clear();
				element.sendKeys(value);

			case "partialLinkText":
				element = driver.findElement(By.partialLinkText(attributeValue));
				element.click();
				element.clear();
				element.sendKeys(value);

			case "text":
				element = driver.findElement(By.xpath("//" + tagName + "[text()='" + attributeValue + "']"));
				element.click();
				element.clear();
				element.sendKeys(value);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void pressEnterKey() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void pressEscapeKey() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void mouseHover(String Xpath) {
		Actions ac = new Actions(driver);
		WebElement leaveText = driver.findElement(By.xpath(Xpath));
		ac.moveToElement(leaveText).build().perform();
	}

	public static void selectByVisibleText(String leaveType) {

		WebElement element = driver.findElement(By.xpath("//*[@id='applyleave_txtLeaveType']"));
//		WebElement element = driver
//				.findElement(By.xpath("//*[@id='applyleave_txtLeaveType']/option[text()='" + leaveType + "']"));
		Select sc = new Select(element);
		sc.selectByVisibleText(leaveType);
	}

	@Override
	public void Click() {

	}

	@Override
	public void enterText() {
		// TODO Auto-generated method stub

	}

}
