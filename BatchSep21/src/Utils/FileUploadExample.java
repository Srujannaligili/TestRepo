package Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadExample {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\Geecko\\geckodriver.exe");		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Need to check the syntax error
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		System.out.println(driver.getTitle());
		String w1 = driver.getCurrentUrl();
		System.out.println(w1);
		driver.findElement(By.xpath("//*[@id='windowButton']")).click();		
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		int windowCount = windows.size();
		System.out.println(windowCount);
		driver.switchTo().window(windows.get(0));
		String w2 = driver.getCurrentUrl();
		System.out.println(w2);
		driver.switchTo().window(windows.get(1));
		String w3 = driver.getCurrentUrl();
		System.out.println(w3);
		
		/*
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		System.out.println("Open Orange HRM application");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		
		Actions ac = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));
		ac.moveToElement(element).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']")).click();
		
		/*
		
		Thread.sleep(3000);
		//Double click
		Actions ac = new Actions(driver);
		WebElement element = driver.findElement(By.id("doubleClickBtn"));
		ac.doubleClick(element).build().perform();
		
		WebElement elementRightClick = driver.findElement(By.id("rightClickBtn"));
		ac.contextClick(elementRightClick).build().perform();

		ac.moveToElement(elementRightClick);
		//File Upload
//		WebElement fileUpload = driver.findElement(By.xpath("//input[@id='uploadFile']"));
//		fileUpload.sendKeys("C:\\Users\\hp\\Documents\\Zoom\\SeleniumOct'21\\FileUpload.txt");
 */
		
		//FileDownload
//		driver.findElement(By.xpath("//*[text()='Cras justo odio']")).click();
//		Thread.sleep(2000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		/*
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		WebElement fileUpload = driver.findElement(By.xpath("//*[@id='photofile']"));
		fileUpload.sendKeys("C:\\Users\\hp\\Documents\\Zoom\\SeleniumOct'21\\FileUpload.txt");
		*/
		
	}

}
