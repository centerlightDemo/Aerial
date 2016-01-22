package utilities;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn {
	 public   WebDriver driver;
	 public  String password ="06082003Tuba";
	 public  String userId="Jakther";
	 
	 public LogIn(WebDriver driver){
		 this.driver=driver;
		
	 }
	 
	 
	 //public WebElement errorMsg = driver.findElement(By.xpath(".//*[@id='loginForm:messages']/div/ul/li/span"));

	 public void validLogin() {

		try {
			
			driver.findElement(By.id("loginForm:userName")).sendKeys(userId);
			driver.findElement(By.id("loginForm:password")).sendKeys(password);
			driver.findElement(By.id("loginForm:loginButton")).click();
		} catch (NullPointerException a) {
			throw (a);

		}
	}

}
