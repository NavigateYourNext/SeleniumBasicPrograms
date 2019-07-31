package SeleniumProgs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptExecutorMethods {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // maximum time to load page if it loads before that then rest of the time will ignored
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // maximum time to load all elements of a page, if it loads before that then rest of the time will ignored
		
		
		driver.manage().window().maximize();
		
		driver.get("http://www.amazon.in");
		
		
		WebElement ele = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Sign in')]"));
		
		//highlightElement(driver,element); //To highlight an element
		//drawBorder(driver,element); // To draw a border 
		//generateAlert(driver, "There is a bug"); // To generate any alert
		//clickAnElementByJavaScript(driver, element); // To click an element
		//refreshBrowser(driver); // To refresh browser
		//System.out.println(getPageTitle(driver)); // To get page title
		//System.out.println(getPageText(driver)); // To get inner text of a page
		//scrollPageDown(driver); // To scroll till page end
		
		//scroll down till particular element visible
		scrollTillParticularElement(driver, driver.findElement(By.xpath("//div[@class='a-section as-title-block']/span/a[@aria-label='Up to 50% off: Bestsellers in fitness & sports - See more ']")));
	
		driver.quit();
	}
	
	public static void highlightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0; i<100; i++)
		{
			changeColor("rgb(0,200,0)",driver,element);
			changeColor(bgcolor,driver,element);
		}
	}
	
	public static void changeColor(String color, WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		
	}
	
	public static void drawBorder(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("alert('"+message+"')");
	}
	
	public static void clickAnElementByJavaScript(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshBrowser(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("history.go(0)");
		System.out.println("Browser Refreshed Succesfully ...");
	}
	
	
	public static String getPageTitle(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String title = jse.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getPageText(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String pageText = jse.executeScript("return document.documentElement.innerText").toString();
		return pageText;
	}
	
	public static void scrollPageDown(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollTillParticularElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}
