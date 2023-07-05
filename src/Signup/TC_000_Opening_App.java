package Signup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_000_Opening_App {
	WebDriver driver;
	
	@BeforeTest
	public void Start() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91728\\Desktop\\virtusa training\\driver1\\chromedriver1.exe\\");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.vwo.com/#/login");
	}
	@Test
	public void run() {
		if(driver.getCurrentUrl().contains("https://app.vwo.com/#/login"))
		System.out.println("Successfully Reached app.vwo site");
		
	}
	@AfterTest
	public void End() {
		driver.close();
		driver.quit();
	}

}
