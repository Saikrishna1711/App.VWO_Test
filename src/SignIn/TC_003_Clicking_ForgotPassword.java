package SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_003_Clicking_ForgotPassword {
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
	@Test(priority = 3)
	public void run() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Forgot Password?')]")).click();
		if(driver.getCurrentUrl().contains("https://app.vwo.com/#/forgot-password")) {
			System.out.println("Naviagated to forgot password page");
		}
		driver.findElement(By.id("forgot-password-username")).sendKeys(email);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//body/div[@id='main-page']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/form[3]/ul[1]/li[3]/input[1]")).click();
		Thread.sleep(1500);
		WebElement message= driver.findElement(By.id("js-notification-box-msg"));
		System.out.println(message.getText());
		
	}
	@AfterTest
	public void End() {
		driver.close();
		driver.quit();
	}

}
