package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TC_01 extends reportsExtent{
	
	static WebDriver driver = new ChromeDriver();
	
	public static void TC_01_openBrowser() {
		ExtentTest test = extent.createTest("TC_01_Test1");
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\96.0.4664.45\\chromedriver.exe");	
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Need to check the syntax error
		driver.manage().window().maximize();
		test.info("Opening Facebook application");
		driver.get("https://www.facebook.com/");		
		
		test.log(Status.INFO, "Select create new account");
		driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
//		System.out.println("Select create new account");
		
		String acutalTextSignUP = driver.findElement(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']")).getText();
		String ExpTextSignUP = "Sign U";
		
		test.info("Compare " + acutalTextSignUP + " and " + ExpTextSignUP);
		if(ExpTextSignUP.equals(acutalTextSignUP)) {
			test.pass(acutalTextSignUP + " is equal to " + ExpTextSignUP);
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Testing");
			test.log(Status.PASS, "Entered first name");
//			System.out.println("Entered first name");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Masters");
			System.out.println("Entered last name");
			driver.findElement(By.xpath("//*[@id='reg_form_box']/div[2]/div/div/input")).sendKeys("1234567890"); //Using Xpath
			System.out.println("Entered phone number");
			driver.findElement(By.id("password_step_input")).sendKeys("TestingMasters"); //Using ID
			System.out.println("Entered password");
			driver.findElement(By.name("birthday_day")).sendKeys("30"); //Using Name
			System.out.println("Entered birth date");
			driver.findElement(By.name("birthday_month")).sendKeys("May"); //Using Name
			System.out.println("Entered birth month");
			driver.findElement(By.name("birthday_year")).sendKeys("1999"); //Using Name
			System.out.println("Entered birth year");
			
			driver.findElement(By.xpath("//label[text()='Male']")).click();
			System.out.println("Selected male as gender");
			driver.findElement(By.name("websubmit")).click();
			System.out.println("Clicked on sign up");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		htmlStartReport();
		TC_01_openBrowser();
		htmlEndReport();
		
//		WebElement element = driver.findElement(By.xpath("//label[text()='Male']"));
//		Select sc = new Select(element);
		
		
	}

}
