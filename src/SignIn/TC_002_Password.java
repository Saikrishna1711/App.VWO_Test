package SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_002_Password {
	WebDriver driver;
	String email="saikrishnaampati@gmail.com";//change
	String password="Kittu@4910"; // change
	
	@BeforeTest
	public void Start() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91728\\Desktop\\virtusa training\\driver1\\chromedriver.exe\\");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.vwo.com/#/login");
	}
	@Test(priority = 2)
	public void run() throws InterruptedException {
		if(driver.getCurrentUrl().contains("https://app.vwo.com/#/login"))
		System.out.println("Successfully Reached app.vwo site");
		driver.findElement(By.id("login-username")).sendKeys(email);
		driver.findElement(By.id("login-password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id("js-login-btn")).click();
		WebElement ErrorMessage= driver.findElement(By.id("js-notification-box-msg"));
		Thread.sleep(1500);
		if(ErrorMessage.isDisplayed()) {
			System.out.println(ErrorMessage.getText());
		}
		else {
			System.out.println("No errors");
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://app.vwo.com/#/setup/account-setup")) {
				System.out.println("sucessfully logged in");
			}
			
		}
		
		
	}
	@AfterTest
	public void End() {
		driver.close();
		driver.quit();
	}

}
