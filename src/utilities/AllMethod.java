package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllMethod {
	public static WebDriver driver;

	public AllMethod(WebDriver driver) {
		this.driver = driver;

	}

	public  void clickOnTheListByText(String text) {
		driver.findElement(By.xpath(".//*[@id='commandBarForm:searchMenu_button']")).click();
		List<WebElement> list = driver.findElements(By.xpath(".//*[@id='commandBarForm:searchMenu_menu']/ul/li"));
		for (int i = 1; i <= list.size(); i++) {
			WebElement listText = driver
					.findElement(By.xpath(".//*[@id='commandBarForm:searchMenu_menu']/ul/li[" + i + "]/a/span"));
			if (listText.getText().contains(text)) {
				listText.click();
				break;
			} 
		}
	}

	public  void clickOnTheTabByText(String text) {
		driver.findElement(By.xpath(".//*[@id='commandBarForm:searchMenu_button']")).click();
		List<WebElement> list = driver.findElements(By.xpath(".//*[@id='memberSearchTabView']/ul/li"));
		for (int i = 1; i <= list.size(); i++) {
			WebElement listText = driver.findElement(By.xpath(".//*[@id='memberSearchTabView']/ul/li[" + i + "]/a"));
			if (listText.getText().contains(text)) {
				listText.click();
				break;
			} 
		}
	}
	
	public  void searchByName(String name){
		try{
		driver.findElement(By.xpath(".//*[@id='memberSearchTabView:memberNameSearchForm:lastName']")).sendKeys(name);
		driver.findElement(By.xpath(".//*[@id='memberSearchTabView:memberNameSearchForm:memberNameSearchLocalButton']")).click();
		}catch(NullPointerException a){
			throw (a);
	      }
	
	}
}
