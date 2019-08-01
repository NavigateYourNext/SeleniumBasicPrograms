package SeleniumProgs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAutomation {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // maximum time to load page if it loads before that then rest of the time will ignored
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // maximum time to load all elements of a page, if it loads before that then rest of the time will ignored


		driver.manage().window().maximize();

		driver.get("http://www.google.com");

		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Testing");

		List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@class='erkvQe']//li/descendant::div[@class='sbl1']"));

		for(int i=0; i<suggestions.size(); i++)
		{
			if(suggestions.get(i).getText().equalsIgnoreCase("Testing Jobs"))
			{
				suggestions.get(i).click();
				break;
			}
		}
		
		driver.quit();

	}

}
