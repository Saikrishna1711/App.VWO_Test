package SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_004_Clicking_RememberMe {
	WebDriver driver;
	String email="saikrishnaampati@gmail.com";//change
	//String password="Kittu@4910"; // change
	
	@BeforeTest
	public void Start() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91728\\Desktop\\virtusa training\\driver1\\chromedriver.exe\\");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.vwo.com/#/login");
	}
	@Test(priority = 4)
	public void run() throws InterruptedException {
		WebElement CheckBox=  driver.findElement(By.cssSelector("ul use"));
		if(CheckBox.isSelected()) {
			System.out.println("remember me is already enabled");
		}
		else {
			CheckBox.click();
			Thread.sleep(3000);
			System.out.println("Enabled remember me");
		}
		
		
	}
	@AfterTest
	public void End() {
		driver.close();
		driver.quit();
	}

}
