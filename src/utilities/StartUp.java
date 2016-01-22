package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.GridType;
import com.relevantcodes.extentreports.LogStatus;

public class StartUp {
	public static WebDriver driver=null;
	//public static WebElement errorMsg = driver.findElement(By.xpath(".//*[@id='loginForm:messages']/div/ul/li/span"));
	public static final ExtentReports extent = ExtentReports.get(StartUp.class);
	public static final String reportLocation = "C:\\Users\\jakther\\workspace\\aerial\\Report\\";
	public static String imageLocation = "images/";
	public static String urlReport="C:\\Users\\jakther\\workspace\\aerial\\Report\\aerial.html";
	public static String url="https://clhtest.medecision.com/ACM/login.faces";
	public static String browserUse=null; 
	
	
	
	@BeforeSuite
	public void reportIni(){
		extent.init(reportLocation + "Aerial.html", true,
				DisplayOrder.BY_OLDEST_TO_LATEST, GridType.STANDARD);
		extent.config().documentTitle("Areial Test report");
		extent.config()
				.reportTitle(
						"<h1><font color='#000099'Aerial Automation Test Result</font></h1> <h4>1.Verify LogIn Screen(Positive,Negetive)</h4><h4>");
		extent.config()
				.reportHeadline(
						"<b>Aerial Selenium Automation Test Report.Develop By:JAHED AKTHER</b>");
	}
	
	
	
	
	@Parameters({"browser"})
	@BeforeTest
	public void startup(String browserName) throws InterruptedException {
		System.out.println(browserName);
		
		if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\jakther\\Desktop\\jahed\\java\\IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
		    ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		    driver = new InternetExplorerDriver(ieCapabilities);
		    //driver = new InternetExplorerDriver();
		    browserUse="IE";
		}else if(browserName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
			browserUse="Firefox";
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jakther\\Desktop\\jahed\\java\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
			browserUse="Chrome";
		}
		
		
		//driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		
		extent.startTest("TC01.1", "Open The "+browserName+" Browser");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='commandBarForm:searchMenu_button']")).click();
		
		//driver.findElement(By.xpath(""));
		//For InValid Login
		
		extent.log(LogStatus.PASS, "Open Aerial Application",
				"View details below:",
				ScreenShot.captureScreen(driver, "Open Aplication"));
		extent.endTest();
	}
	
	@AfterSuite
	public void tearDown() {
		 //driver.close();
        WebDriver driver1=new FirefoxDriver();
		driver1.get(urlReport);
		System.out.println("Test Complete");
		driver1.manage().window().maximize();
	}
	
	
	
}
