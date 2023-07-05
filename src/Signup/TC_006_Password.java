package Signup;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_006_Password {
	WebDriver driver;
	
	@BeforeTest
	public void Start() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91728\\Desktop\\virtusa training\\driver1\\chromedriver.exe\\");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.vwo.com/#/login");//opens login page
	}
	@Test(priority = 1)
	public void StartFreeTrial() throws InterruptedException {
		if(driver.getCurrentUrl().contains("https://app.vwo.com/#/login")) {// extract url
			System.out.println("Successfully Reached app.vwo site");
			driver.findElement(By.cssSelector("[data-qa='bericafeqo']")).click(); // Clicking Start free trial
			if(driver.getCurrentUrl().contains("https://vwo.com/free-trial/")) {  //  
				System.out.println("Succesfully reached Sign up page");
			}
			//driver.findElement(By.cssSelector(".js-free-trial-form-step1-container.js-step1-container > form[method='post']  input[name='email']")).sendKeys((" "));// sending empty e-mail
			String email="saikrishnamapati@gmail.com";
			driver.findElement(By.cssSelector(".js-free-trial-form-step1-container.js-step1-container > form[method='post']  input[name='email']")).sendKeys((email));// sending invalid e-mail
			Thread.sleep(1500);
			driver.findElement(By.cssSelector(".js-free-trial-form-step1-container.js-step1-container > form[method='post'] > .Mt\\(10px\\).Ta\\(c\\) > .W\\(100\\%\\).btn-modal-form-submit.button")).click(); //CLICK ON CREATE ACCOUNT
			Thread.sleep(2000);
			WebElement errormsg=driver.findElement(By.cssSelector(".js-free-trial-form-step1-container.js-step1-container > form[method='post']  .C\\(\\$color-red\\).Fz\\(\\$font-size-12\\).Op\\(0\\).Trsdu\\(0\\.15s\\).Trsp\\(\\$Op\\).invalid-input\\+Op\\(1\\).invalid-reason")); //EXTRACTING ERROR MESSAGE
			if(errormsg.isDisplayed()) {
				System.out.println(email  +" "+ errormsg.getText());  //PRINTING ERROR MESSAGE
			}
			else {
				System.out.println("Valid email adress");
			}}
		}
	@Test(priority = 2)
	public void Password() throws InterruptedException {
		String pass="sai";
		driver.findElement(By.id("page-v1-pwd")).sendKeys(pass);
		Thread.sleep(1500);
		driver.findElement(By.cssSelector(".D\\(b\\).Mih\\(510px\\)--md.js-free-trial-form-step2-container.js-step2-container.js-step2-show > form[method='post']  .W\\(100\\%\\).btn-modal-form-submit.button")).click();
		Thread.sleep(1500);
		WebElement errormsg1=driver.findElement(By.cssSelector(".Mb\\(5px\\).Pos\\(r\\) > .C\\(\\$color-red\\).Fz\\(\\$font-size-12\\).Op\\(0\\).Trsdu\\(0\\.15s\\).Trsp\\(\\$Op\\).invalid-input\\+Op\\(1\\).invalid-reason"));
		if(errormsg1.isDisplayed()) {
			System.out.println(pass+" "+errormsg1.getText());
			System.out.println("Password must have: 1.8 or more Charcaters 2.Upper and lower letters 3.A number or special character " );
		}
		else {
			System.out.println("valid Password");
		}
		
		
	}
	
	@AfterTest()
	public void End() {
		driver.close();
		driver.quit();
	}

}
