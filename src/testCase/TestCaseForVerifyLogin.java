package testCase;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utilities.ScreenShot;
import utilities.StartUp;


public class TestCaseForVerifyLogin extends StartUp{
		
	
	@Test(priority=0)
	public void verifyBlankIdAndPassword() throws InterruptedException{
		/*LogIn logIn=new LogIn(driver);
		logIn.validLogin("","");
		    if (logIn.errorMsg.isEnabled())
		        {
			       System.out.println("Test Case Pass");
	        	}
		    else{
			System.out.println("Test Case Fail");
             		
			
		        }*/
		extent.startTest("TC01.2", "Verify Id and Password Blank Submit and Appropriate Error Message");
		driver.findElement(By.xpath(".//*[@id='loginForm:userName']")).sendKeys(" ");
		driver.findElement(By.xpath(".//*[@id='loginForm:password']")).sendKeys(" ");
		driver.findElement(By.xpath(".//*[@id='loginForm:loginButton']")).click();
	
		Thread.sleep(2000);
	    WebElement errorMsg = driver.findElement(By.xpath(".//*[@id='loginForm:messages']/div/ul/li/span"));
		 if (errorMsg.isEnabled())
	        {
			 extent.log(LogStatus.PASS, "Appropriate Error Message",
						"View details below:",
						ScreenShot.captureScreen(driver, "Error Message on Submit Blank ID and Password"));  
			 System.out.println("Test Case Pass");
     	}
	    else{
		System.out.println("Test Case Fail");
      		
		
	        }
		 extent.endTest();
		
	       	}
	
	
	@Test(priority=1)
	public void verifyInvalidUserID() throws InterruptedException{
		/*LogIn logIn=new LogIn(driver);
		
		logIn.validLogin("jahedakther",logIn.password);
	    if (logIn.errorMsg.isEnabled())
	        {
		       System.out.println("Test Case Pass");
        	}
	    else{
		System.out.println("Test Case Fail");
		
		
	        }*/
		extent.startTest("TC01.3", "Verify Submit invalid Id  and Appropriate Error Message");
		driver.findElement(By.xpath(".//*[@id='loginForm:userName']")).clear();
		driver.findElement(By.xpath(".//*[@id='loginForm:password']")).clear();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='loginForm:userName']")).sendKeys("jahedakther");
		driver.findElement(By.xpath(".//*[@id='loginForm:password']")).sendKeys("06082003Tuba");
		driver.findElement(By.xpath(".//*[@id='loginForm:loginButton']")).click();
		
		Thread.sleep(2000);
		WebElement errorMsg = driver.findElement(By.xpath(".//*[@id='loginForm:messages']/div/ul/li/span"));
		if (errorMsg.isEnabled())
	        {
		       System.out.println("Test Case Pass");
		       extent.log(LogStatus.PASS, "Appropriate Error Message",
						"View details below:",
						ScreenShot.captureScreen(driver, "Error Message on Submit Invalid  ID "));
     	}
	    else{
		System.out.println("Test Case Fail");
      		
		
	        }
		
		extent.endTest();
		
	}
	
	@Test(priority=2)
	public void verifyInvalidpassword() throws InterruptedException{
		/*LogIn logIn=new LogIn(driver);
		logIn.validLogin(logIn.id,"1346546564");
	    if (logIn.errorMsg.isEnabled())
	        {
		       System.out.println("Test Case Pass");
        	}
	    else{
		System.out.println("Test Case Fail");
		
		
	        }*/
		extent.startTest("TC01.4", "Verify Submit invalid Password  and Appropriate Error Message");
		driver.findElement(By.xpath(".//*[@id='loginForm:userName']")).clear();
		driver.findElement(By.xpath(".//*[@id='loginForm:password']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='loginForm:userName']")).sendKeys("jakther");
		driver.findElement(By.xpath(".//*[@id='loginForm:password']")).sendKeys("1234567");
		driver.findElement(By.xpath(".//*[@id='loginForm:loginButton']")).click();
		Thread.sleep(2000);
		WebElement errorMsg = driver.findElement(By.xpath(".//*[@id='loginForm:messages']/div/ul/li/span"));
		 if (errorMsg.isEnabled())
	        {
		       System.out.println("Test Case Pass");
		       extent.log(LogStatus.FAIL, "Appropriate Error Message",
						"View details below:",
						ScreenShot.captureScreen(driver, "Error Message on Submit Invalid  Password "));
     	}
	    else{
		System.out.println("Test Case Fail");
      		
		
	        }
		 extent.endTest();
	}
	
	@Test(priority=3)
	public void verifyValidLogin() throws InterruptedException{
		/*LogIn logIn=new LogIn(driver);
		logIn.validLogin(logIn.id,logIn.password);
	    if (logIn.errorMsg.isEnabled())
	        {
		       System.out.println("Test Case Fail");
        	}
	    else{
		System.out.println("Test Case Pass");
		
		
	        }*/
		//driver.findElement(By.xpath(".//*[@id='loginForm:userName']")).clear();
		extent.startTest("TC01.5", "Verify Submit Valid Id  and Password");
		driver.findElement(By.xpath(".//*[@id='loginForm:password']")).clear();
		Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='loginForm:userName']")).sendKeys("jakther");
		driver.findElement(By.xpath(".//*[@id='loginForm:password']")).sendKeys("06082003Tuba");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='loginForm:loginButton']")).click();
		
		Thread.sleep(2000);
		WebElement errorMsg = driver.findElement(By.xpath(".//*[@id='loginForm:messages']/div/ul/li/span"));
		 if (errorMsg.isDisplayed())
	        {
		       System.out.println("Test Case fail");
		       System.out.println("Test Case pass");
				 extent.log(LogStatus.FAIL, "Valid Log in",
							"View details below:",
							ScreenShot.captureScreen(driver, "Valid Log In"));
     	}
	    else{
		
      		
		
	        }
		 extent.endTest();
	}

}
