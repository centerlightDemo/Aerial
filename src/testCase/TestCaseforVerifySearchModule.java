package testCase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import utilities.*;

public class TestCaseforVerifySearchModule extends StartUp {

	@Test(priority = 0)
	public void loging() throws InterruptedException {
		LogIn signin = new LogIn(driver);
		System.out.println("Start Test 1");
		extent.startTest("TC01.2", "Sign IN("+browserUse+")");
		signin.validLogin();
		Thread.sleep(2000);
		extent.log(LogStatus.PASS, "Landed Home Page", "View details below:",
				ScreenShot.captureScreen(driver, "Landed on Home Page"));
		extent.endTest();
	}

	@Test(priority = 1)
	public void clickSearchList() throws InterruptedException {
		System.out.println("Start Test 2");
		extent.startTest("TC01.3", "Click Search");
		AllMethod all = new AllMethod(driver);
		all.clickOnTheListByText("Members");
		extent.log(LogStatus.PASS, "Expand Member Search List", "View details below:",
				ScreenShot.captureScreen(driver, "Expand List " +browserUse));
	
		extent.endTest();
	}

	@Test(priority = 2)
	public void clickNameTab() throws InterruptedException {
		System.out.println("Start Test 3");
		extent.startTest("TC01.4", "Member Search Tab Name Page Open");
		AllMethod all = new AllMethod(driver);
		all.clickOnTheTabByText("Name");
		Thread.sleep(2000);
		extent.log(LogStatus.PASS, "Member Search Tab Name Page Open", "View details below:",
				ScreenShot.captureScreen(driver, "Member Search Tab Name Page Open "+browserUse));
		extent.endTest();
	}

	@Test(priority = 3)
	public void membersSearchByName() throws InterruptedException {
		System.out.println("Start Test 4");
		extent.startTest("TC01.5", "Member Search By Name");
		Thread.sleep(2000);
		AllMethod all = new AllMethod(driver);
		all.searchByName("A");
		Thread.sleep(2000);
		
		extent.log(LogStatus.PASS, "Member Search By Name ", "View details below:",
				ScreenShot.captureScreen(driver, "Member Search By Name "+browserUse));
		extent.endTest();
	}

	
	@Test(priority = 4)
	public void openMemberProfile() throws InterruptedException{
		extent.startTest("TC01.6", "Open Member Profile");
		AllMethod all = new AllMethod(driver);
		all.clickMemberByDob("11/02/1925");
		
		
		Thread.sleep(2000);
		extent.log(LogStatus.PASS, "Open Member Profile ", "View details below:",
				ScreenShot.captureScreen(driver, "Open Member Profile "+browserUse));
		//System.out.println(memText);
		extent.endTest();
		driver.close();
	}
}
