package Utils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {
	static WebDriver driver = new ChromeDriver();
	public static void ExampleWindowHandles() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\96.0.4664.45\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Need to check the syntax error
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		String w1 = driver.getCurrentUrl();
		driver.findElement(By.xpath("//*[@id='tabButton']")).click();		
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		int windowCount = windows.size();
		driver.switchTo().window(windows.get(0));
		String w2 = driver.getCurrentUrl();
		driver.switchTo().window(windows.get(1));
		String w3 = driver.getCurrentUrl();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExampleWindowHandles();
	}

}
