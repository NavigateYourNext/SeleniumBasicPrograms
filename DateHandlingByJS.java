package SeleniumProgs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DateHandlingByJS {

	public static void main(String[] args)throws Exception {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		WebDriver driver = new ChromeDriver(dc);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // maximum time to load page if it loads before that then rest of the time will ignored
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); // maximum time to load all elements of a page, if it loads before that then rest of the time will ignored
		

		driver.manage().window().maximize();
		
		//Example 1
		driver.get("http://www.spicejet.com/");
		
		String selectedDate_1 = "22-10-2019";
		WebElement date_22 = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_txt_Fromdate']"));
		
		selectDateByJavaScript(driver,date_22,selectedDate_1);
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("Pune");
		
		//Example 2
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		
		WebElement dateId = driver.findElement(By.xpath("//div[@class='input-group date']/input"));
		WebElement dateId_1 = driver.findElement(By.xpath("//div[@class='input-daterange input-group']/input[@placeholder='Start date']"));
		
		String selectedDate = "21/08/2019";
		
		selectDateByJS(driver,dateId,dateId_1,selectedDate);
		
		
		driver.findElement(By.xpath("//a[text()='Date pickers']")).click();
		WebElement date_picker = driver.findElement(By.xpath("//li[@style='display: list-item;']/a[text()='JQuery Date Picker']"));
		try {
			Actions action = new Actions(driver);
			Thread.sleep(2000);
			action.moveToElement(date_picker).click().build().perform();		
			System.out.println(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//String selectedDate_1 = "21/08/2019";
		WebElement date_2 = driver.findElement(By.xpath("//input[@id='from']"));
		
		selectDateByJavaScript(driver,date_2,selectedDate_1);
		
		driver.quit();
	}
	
	public static void selectDateByJS(WebDriver driver, WebElement dateId, WebElement dateId_1,String selectedDate)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;	
		jse.executeScript("arguments[0].setAttribute('value','"+selectedDate+"');",dateId);
		
		jse.executeScript("arguments[0].scrollIntoView(true);", dateId_1);
		jse.executeScript("arguments[0].setAttribute('value','"+selectedDate+"');",dateId_1);
			
	}
	
	public static void selectDateByJavaScript(WebDriver driver,WebElement dateId,String selectedDate)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;	
		jse.executeScript("arguments[0].setAttribute('value','"+selectedDate+"');",dateId);
		
	}
}
