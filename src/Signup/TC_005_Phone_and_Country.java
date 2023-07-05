package Signup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.tokens.FlowEntryToken;

public class TC_005_Phone_and_Country {
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
			String errormsg=driver.findElement(By.cssSelector(".js-free-trial-form-step1-container.js-step1-container > form[method='post']  .C\\(\\$color-red\\).Fz\\(\\$font-size-12\\).Op\\(0\\).Trsdu\\(0\\.15s\\).Trsp\\(\\$Op\\).invalid-input\\+Op\\(1\\).invalid-reason")).getText(); //EXTRACTING ERROR MESSAGE
			if(!errormsg.isEmpty()) {
				System.out.println(email  +" "+ errormsg);  //PRINTING ERROR MESSAGE
			}
			else if(driver.getCurrentUrl().contains("https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage")){
				System.out.println("Successfully reached registration page");
			}}
		}
	@Test(priority = 2)
	public void PhoneAndCountry() throws InterruptedException {
		Thread.sleep(2000);
		//driver.switchTo().frame(driver.findElement(By.id("iti-0__country-listbox")));
		//List<WebElement> countries= driver.findElements(By.className("iti__country iti__standard"));
		//System.out.println(countries.size());
		//for(int i=0;i<countries.size();i++) {
			//System.out.println(countries.get(i).getText());
		//}
		String number="7288024910";
		driver.findElement(By.cssSelector("input#page-v1-pnumber")).sendKeys(number);
		Thread.sleep(1500);
		driver.findElement(By.cssSelector(".D\\(b\\).Mih\\(510px\\)--md.js-free-trial-form-step2-container.js-step2-container.js-step2-show > form[method='post']  .W\\(100\\%\\).btn-modal-form-submit.button")).click();
		Thread.sleep(1500);
		WebElement errormsg= driver.findElement(By.cssSelector("[class='js-free-trial-form-step2-container js-step2-container Mih\\(510px\\)--md D\\(b\\) js-step2-show'] [class='Mb\\(5px\\)'] [class='C\\(\\$color-red\\) Fz\\(\\$font-size-12\\) Trsp\\(\\$Op\\) Trsdu\\(0\\.15s\\) Op\\(0\\) invalid-input\\+Op\\(1\\) invalid-reason']"));
		if(errormsg.isDisplayed()) {
			System.err.println(errormsg.getText());
		}
		else {
			System.out.println("Valid Phone number and country");
		}
		
	}
			
	
	
	@AfterTest()
	public void End() {
		driver.close();
		driver.quit();
	}

}
