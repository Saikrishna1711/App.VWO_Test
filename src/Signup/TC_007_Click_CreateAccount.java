package Signup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_007_Click_CreateAccount {
	String email="ampatiaikrishna@gmail.com";
	String fname="saikrishna";
	String lname="ampati";
	String phone="1234567890";
	String password="Kittu@4910";
	
	
	WebDriver   driver;
	WebElement  email_error;
	WebElement  fname_error;
	WebElement  lname_error;
	WebElement  ph_Country_error;
	WebElement  password_error;
	JavascriptExecutor js=(JavascriptExecutor)(driver);
	
	@BeforeSuite
	public void Start() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91728\\Desktop\\virtusa training\\driver1\\chromedriver.exe\\");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.vwo.com/#/login");//opens login page
	}
	@BeforeTest
	public void StartFreeTrial() throws InterruptedException {
		if(driver.getCurrentUrl().contains("https://app.vwo.com/#/login")) {// extract url
			System.out.println("Successfully Reached app.vwo site");
			driver.findElement(By.cssSelector("[data-qa='bericafeqo']")).click(); // Clicking Start free trial
			if(driver.getCurrentUrl().contains("https://vwo.com/free-trial/")) {  //  
				System.out.println("Succesfully reached Sign up page");
			}
		}
	}
	@Test(priority = 1)
	public void Work_Email() throws InterruptedException {
		driver.findElement(By.cssSelector(".js-free-trial-form-step1-container.js-step1-container > form[method='post']  input[name='email']")).sendKeys((email));// sending invalid e-mail
		Thread.sleep(1500);
		driver.findElement(By.cssSelector(".js-free-trial-form-step1-container.js-step1-container > form[method='post'] > .Mt\\(10px\\).Ta\\(c\\) > .W\\(100\\%\\).btn-modal-form-submit.button")).click(); //CLICK ON CREATE ACCOUNT
		Thread.sleep(2000);
		email_error=driver.findElement(By.cssSelector(".js-free-trial-form-step1-container.js-step1-container > form[method='post']  .C\\(\\$color-red\\).Fz\\(\\$font-size-12\\).Op\\(0\\).Trsdu\\(0\\.15s\\).Trsp\\(\\$Op\\).invalid-input\\+Op\\(1\\).invalid-reason")); //EXTRACTING ERROR MESSAGE
		if(email_error.isDisplayed()) {
			System.out.println(email  +" "+ email_error.getText());  //PRINTING ERROR MESSAGE
		}
		else {
			System.out.println("Valid email adress");
		}
	}
			
	@Test(priority =2 )
	public void FirstName() throws InterruptedException {
		Thread.sleep(1000);
		fname="sai krishna";
		driver.findElement(By.cssSelector("#page-v1-fname")).sendKeys(fname);//First name as empty //first name with special chars// valid first name
		Thread.sleep(1500);
		
			
	}
	@Test(priority = 3,enabled = true)
	public void lastName() throws InterruptedException { // change
		driver.findElement(By.cssSelector("#page-v1-lname")).sendKeys(lname);//last name as empty,last name with special char ,valid last name
		Thread.sleep(1000);
		//driver.findElement(By.cssSelector("[class='js-free-trial-form-step2-container js-step2-container Mih\\(510px\\)--md D\\(b\\) js-step2-show'] [data-qa='page-su-submit']")).click(); // clicking create account
		Thread.sleep(1500);
		
	}
	@Test(priority = 4 , enabled = true)
	public void PhoneAndCountry() throws InterruptedException {
		Thread.sleep(2000);
		/*driver.switchTo().frame(driver.findElement(By.id("iti-0__country-listbox")));
		List<WebElement> countries= driver.findElements(By.className("iti__country iti__standard"));
		System.out.println(countries.size());
		for(int i=0;i<countries.size();i++) {
			System.out.println(countries.get(i).getText());
		}*/
		driver.findElement(By.cssSelector("input#page-v1-pnumber")).sendKeys(phone);
		Thread.sleep(1500);
		driver.findElement(By.cssSelector(".D\\(b\\).Mih\\(510px\\)--md.js-free-trial-form-step2-container.js-step2-container.js-step2-show > form[method='post']  .W\\(100\\%\\).btn-modal-form-submit.button")).click();
		Thread.sleep(1500);
		
		
	}
	@Test(priority = 5 , enabled = true)
	public void Password() throws InterruptedException {
		driver.findElement(By.id("page-v1-pwd")).sendKeys(password);
		Thread.sleep(1500);
		//driver.findElement(By.cssSelector(".D\\(b\\).Mih\\(510px\\)--md.js-free-trial-form-step2-container.js-step2-container.js-step2-show > form[method='post']  .W\\(100\\%\\).btn-modal-form-submit.button")).click();
		Thread.sleep(1500);
		
	}
	@Test( priority = 6 , enabled  = true)
	public void ClickCreate() throws InterruptedException {
		Thread.sleep(1500);
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.findElement(By.cssSelector("[class='js-free-trial-form-step2-container js-step2-container Mih\\(510px\\)--md D\\(b\\) js-step2-show'] [data-qa='page-su-submit']")).click();
		Thread.sleep(1000);
		
		
		/* Finding error on fname */WebElement fname_error= driver.findElement(By.cssSelector(".D\\(b\\).Mih\\(510px\\)--md.js-free-trial-form-step2-container.js-step2-container.js-step2-show > form[method='post']  .D\\(f\\)--md.Jc\\(sb\\)--md.Mb\\(5px\\) > div:nth-of-type(1) > .C\\(\\$color-red\\).Fz\\(\\$font-size-12\\).Op\\(0\\).Trsdu\\(0\\.15s\\).Trsp\\(\\$Op\\).invalid-input\\+Op\\(1\\).invalid-reason"));
		Thread.sleep(1500);
		if(fname_error.isDisplayed()) {
			System.out.println(fname+ " "+fname_error.getText());
		}
		else {
			System.out.println("Valid first name");
		}
		/* Finding error on lname */WebElement lname_error= driver.findElement(By.cssSelector(".D\\(b\\).Mih\\(510px\\)--md.js-free-trial-form-step2-container.js-step2-container.js-step2-show > form[method='post']  .D\\(f\\)--md.Jc\\(sb\\)--md.Mb\\(5px\\) > div:nth-of-type(2) > .C\\(\\$color-red\\).Fz\\(\\$font-size-12\\).Op\\(0\\).Trsdu\\(0\\.15s\\).Trsp\\(\\$Op\\).invalid-input\\+Op\\(1\\).invalid-reason"));
		if(lname_error.isDisplayed())
		{
			System.out.println(lname+ " "+ lname_error);
		}
		else {
			System.out.println("Valid last name");
		}
		/* Finding error on phone and country */WebElement ph_Country_error= driver.findElement(By.cssSelector("[class='js-free-trial-form-step2-container js-step2-container Mih\\(510px\\)--md D\\(b\\) js-step2-show'] [class='Mb\\(5px\\)'] [class='C\\(\\$color-red\\) Fz\\(\\$font-size-12\\) Trsp\\(\\$Op\\) Trsdu\\(0\\.15s\\) Op\\(0\\) invalid-input\\+Op\\(1\\) invalid-reason']"));
		if(ph_Country_error.isDisplayed()) {
			System.err.println(phone +" "+ph_Country_error.getText());
		}
		else {
			System.out.println("Valid Phone number and country");
		}
		/* Finding error on password */WebElement password_error=driver.findElement(By.cssSelector(".Mb\\(5px\\).Pos\\(r\\) > .C\\(\\$color-red\\).Fz\\(\\$font-size-12\\).Op\\(0\\).Trsdu\\(0\\.15s\\).Trsp\\(\\$Op\\).invalid-input\\+Op\\(1\\).invalid-reason"));
		if(password_error.isDisplayed()) {
			System.out.println(password_error.getText());
			System.out.println("Password must have: 1.8 or more Charcaters 2.Upper and lower letters 3.A number or special character " );
		}
		else {
			System.out.println("valid Password");
		}
		
		/* Checking account created or not */ if(driver.getCurrentUrl().contains("https://app.vwo.com/#/setup/account-setup")){
			System.out.println("Successfully created Account");
		}
		else {
			System.out.println("Account not created");
		}
		
	}
	
	@AfterTest()
	public void End() {
		driver.quit();
	}
	
	@AfterSuite
	public void Close() {
		driver.close();
	}

}
