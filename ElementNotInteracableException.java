package SeleniumProgs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementNotInteracableException {

	public static void main(String[] args)throws Exception {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\akshay.shete\\Downloads\\Selenium Jars & Drivers\\chromedriver_win32\\chromedriver.exe");
		
		//WebDriver driver = new HtmlUnitDriver(); //HeadLess Browser / Ghost Browser. It won't work if script contains cursor movement/element movement etc.
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://www.vodacom.co.za");
		
		System.out.println("Before Login Title Is : "+driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		

		// It is used if the given WebElement is not visible/not interactable/not able to perform operations
		WebElement user = driver.findElement(By.xpath("//input[@id='login_username']"));
		Actions action = new Actions(driver);
		action.moveToElement(user).click().build().perform();
		action.moveToElement(user).sendKeys("0794463558").build().perform();
		
		//It is used if the given WebElement is not visible/not interactable/not able to perform operations
		WebElement pass = driver.findElement(By.xpath("//input[@id='login_password']"));
		action.moveToElement(pass).click().build().perform();
		action.moveToElement(pass).sendKeys("Vodacom#100").build().perform();
		
		//waiting till button enabled
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='login-form']/div/a[text()='Log in']")));
		
		driver.findElement(By.xpath("//form[@id='login-form']/div/a[text()='Log in']")).click();
		
		System.out.println("After Login Title Is : "+driver.getTitle());
		
		driver.quit();
		

	}

}
