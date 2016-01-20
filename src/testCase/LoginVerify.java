package testCase;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginVerify {

	static WebDriver driver=null;
	
	public static void main(String[] args) {
		
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://clhtest.medecision.com/ACM/login.faces");
		driver.findElement(By.xpath(".//*[@id='loginForm:userName']")).sendKeys("jakther");
		driver.findElement(By.xpath(".//*[@id='loginForm:password']")).sendKeys("06082003Tuba");
		driver.findElement(By.xpath(".//*[@id='loginForm:loginButton']")).click();
		driver.findElement(By.xpath(".//*[@id='commandBarForm:searchMenu_button']")).click();
		
		//driver.findElement(By.xpath(""));
		//For InValid Login
		WebElement errorMsg=driver.findElement(By.xpath(".//*[@id='loginForm:messages']/div/ul/li/span"));
		
		
		
		
		String loginUser=driver.findElement(By.xpath(".//*[@id='commandBarForm:masterCommandMenuButton_button']")).getText();
		System.out.println(loginUser);
		     if(loginUser.equalsIgnoreCase(loginUser))
		         {
			      System.out.println("Pass");
		         }
		     else
		         {
				  System.out.println("Fail");
				  driver.close();
			     }
		  
		  
		List<WebElement> list=driver.findElements(By.xpath(".//*[@id='commandBarForm:searchMenu_menu']/ul/li/a/span"));
	
		for (int i=0;i<list.size();i++)
		      {
			    WebElement searchList=driver.findElement(By.xpath(".//*[@id='commandBarForm:searchMenu_menu']/ul/li["+(i+1)+"]/a/span"));
			    String searchListData =searchList.getText(); 
			      if(searchListData.equals("Providers"))
			         {
				      searchList.click();
				      driver.findElement(By.xpath(".//*[@id='j_idt29:providerNameSearchForm:practitionerLastName']")).sendKeys("Das");
				      driver.findElement(By.xpath(".//*[@id='j_idt29:providerNameSearchForm:searchLocalButton']")).click();
				      List <WebElement> dataFromList=driver.findElements(By.xpath(".//*[@id='providerSearchResultsForm:providerSearchResultsTable:searchResultsTable_data']/tr"));
				      System.out.println(dataFromList.size());
				  	  String memberData=driver.findElement(By.xpath(".//*[@id='providerSearchResultsForm:providerSearchResultsTable:searchResultsTable_data']/tr[1]")).getText();
				      System.out.println(memberData);
				      driver.findElement(By.xpath(".//*[@id='providerSearchResultsForm:providerSearchResultsTable:searchResultsTable:0:providerId']")).click();
				  	  String memberAllData=driver.findElement(By.xpath(".//*[@id='providerDetailIdentificationForm:j_idt27_content']")).getText();
				      System.out.println(memberAllData);
			         } 
	       	}
		
	}

}
