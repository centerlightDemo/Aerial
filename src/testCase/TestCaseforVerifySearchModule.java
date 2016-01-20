package testCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utilities.AllMethod;
import utilities.LogIn;
import utilities.ScreenShot;
import utilities.StartUp;

public class TestCaseforVerifySearchModule extends StartUp{
//public static WebDriver driver;
	 
	

@Test(priority=0)
public void loging() throws InterruptedException{
	 LogIn signin=new  LogIn(driver);
	System.out.println("Start Test 1");
	extent.startTest("TC01.2", "Sign IN");
	signin.validLogin();
	Thread.sleep(2000);
	extent.log(LogStatus.PASS, "Landed Home Page",
			"View details below:",
			ScreenShot.captureScreen(driver, "Landed on Home Page"));
	extent.endTest();
}

	@Test(priority=1)
	public void clickSearchList() throws InterruptedException{
		System.out.println("Start Test 2");
		extent.startTest("TC01.3", "Click Search");
		AllMethod all=new AllMethod(driver);
		all.clickOnTheListByText("Members");
		Thread.sleep(2000);
		extent.log(LogStatus.PASS, "Member Search Page Open",
				"View details below:",
				ScreenShot.captureScreen(driver, "Member Search Page Open"));
		extent.endTest();
		}
		

	@Test(priority=2)
	public void clickNameTab() throws InterruptedException{
		System.out.println("Start Test 3");
		extent.startTest("TC01.4", "Member Search Tab Name Page Open");
		AllMethod all=new AllMethod(driver);
		all.clickOnTheTabByText("Name");
		Thread.sleep(2000);
		extent.log(LogStatus.PASS, "Member Search Tab Name Page Open",
				"View details below:",
				ScreenShot.captureScreen(driver, "Member Search Tab Name Page Open"));
		extent.endTest();
	}
	
	@Test(priority=3)
	public void membersSearchByName() throws InterruptedException{
		System.out.println("Start Test 4");
		extent.startTest("TC01.5", "Member Search By Name");
		Thread.sleep(2000);
		AllMethod all=new AllMethod(driver);
		all.searchByName("A");
		//driver.findElement(By.xpath(".//*[@id='memberSearchTabView:memberIdSearchForm:memberIdSearchLocalButton']")).click();
		Thread.sleep(2000);
		String memText=driver.findElement(By.xpath(".//*[@id='memberSearchResultsForm:memberSearchResultsTable:searchResultsTable_data']/tr[4]/td[3]")).getText();
		extent.log(LogStatus.PASS, "Member Search By Name ",
				"View details below:",
				ScreenShot.captureScreen(driver, "Member Search By Name"));
		extent.endTest();
		System.out.println(memText);
	}
	
}
