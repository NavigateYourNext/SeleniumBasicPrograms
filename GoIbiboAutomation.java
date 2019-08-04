package SeleniumProgs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class GoIbiboAutomation {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");


		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // maximum time to load page if it loads before that then rest of the time will ignored
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); // maximum time to load all elements of a page, if it loads before that then rest of the time will ignored


		driver.manage().window().maximize();

		//Example 1
		driver.get("http://www.goibibo.com/");

		String source = "Johannesburg";
		String destination = "Mumbai";
		String departureDate = "3-01-2020";
		String returnDate = "6-02-2020";
		String noOfTraveller = "1";
		String noOfChildren = "0";
		String flightClass = "Economy";

		driver.findElement(By.xpath("//span[text()='Round trip']")).click();

		selectSource(driver,source);
		selectDestination(driver,destination);
		selectDepartureDate(driver,departureDate);
		selectArrivalDate(driver,returnDate);
		selectTravellerAndClass(driver,noOfTraveller,noOfChildren,flightClass);

		driver.findElement(By.id("gi_search_btn")).click();

	}

	public static void selectSource(WebDriver driver, String source)throws Exception
	{

		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(source);
		Thread.sleep(2000);

		List<WebElement> sugg = driver.findElements(By.xpath("//ul[@id='react-autosuggest-1']//li"));

		for(int i=0; i<sugg.size(); i++)
		{
			if(sugg.get(i).getText().startsWith(source))
			{
				sugg.get(i).click();
				break;
			}

		}

	}

	public static void selectDestination(WebDriver driver, String destination)throws Exception
	{
		driver.findElement(By.id("gosuggest_inputDest")).sendKeys(destination);
		Thread.sleep(2000);

		List<WebElement> sugg_1 = driver.findElements(By.xpath("//ul[@id='react-autosuggest-1']//li"));

		for(int i=0; i<sugg_1.size(); i++)
		{
			if(sugg_1.get(i).getText().startsWith(destination))
			{
				sugg_1.get(i).click();
				break;
			}

		}
	}

	public static void selectTravellerAndClass(WebDriver driver, String noOfTraveller, String noOfChildren, String flightClass)throws Exception
	{
		driver.findElement(By.id("pax_link_common")).click();

		String getAdults = driver.findElement(By.id("adultPaxBox")).getAttribute("value");
		String getChildrens = driver.findElement(By.id("childPaxBox")).getAttribute("value");

		while(!getAdults.equals(noOfTraveller))
		{

			driver.findElement(By.id("adultPaxPlus")).click();
			getAdults = driver.findElement(By.id("adultPaxBox")).getAttribute("value");
		}

		while(!getChildrens.equals(noOfChildren))
		{
			driver.findElement(By.id("childPaxPlus")).click();
			getChildrens = driver.findElement(By.id("childPaxBox")).getAttribute("value");
		}

		WebElement fClass = driver.findElement(By.id("gi_class"));
		Select s = new Select(fClass);

		if(flightClass.equals("Economy"))
			s.selectByValue("E");
		else if(flightClass.equals("Business"))
			s.selectByValue("B");
		else if(flightClass.equals("First class"))
			s.selectByValue("F");

	}

	
	public static void selectDepartureDate(WebDriver driver, String selectedDate_1)throws Exception
	{

		String[] splitDate = selectedDate_1.split("-");
		String month = formatDate(splitDate[1]);
		int id = 0;
		WebElement ddate = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Departure']"));
		WebElement prevButton = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/parent::div/preceding-sibling::div/span[1]"));
		String currentMonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();

		while(!currentMonth.equals(month+" "+splitDate[2]))
		{
			if(prevButton.isDisplayed() && id == 0)
			{
				prevButton.click();
				id = 1;
			}
			else
			{
				id = 0;
			}
			if(id == 0)
			{
				driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/parent::div/preceding-sibling::div/span[2]")).click();
				id = 1;
			}

			currentMonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		}


		driver.findElement(By.xpath("//div[@class='DayPicker-Day']/div[text()='"+splitDate[0]+"']")).click();
	}

	public static void selectArrivalDate(WebDriver driver, String selectedDate_1)throws Exception
	{
		String[] splitDate = selectedDate_1.split("-");
		String month = formatDate(splitDate[1]);
		int id = 0;
		WebElement ddate = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Return']"));
		WebElement prevButton = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/parent::div/preceding-sibling::div/span[1]"));
		String currentMonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();

		while(!currentMonth.equals(month+" "+splitDate[2]))
		{
			if(prevButton.isDisplayed() && id == 0)
			{
				prevButton.click();
				id = 1;
			}
			else
			{
				id = 0;
			}
			if(id == 0)
			{
				driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/parent::div/preceding-sibling::div/span[2]")).click();
				id = 1;
			}

			currentMonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		}


		driver.findElement(By.xpath("//div[@class='DayPicker-Day']/div[text()='"+splitDate[0]+"']")).click();
	}
	
	public static String formatDate(String month)
	{
		String mon = null;
		switch(month)
		{
		case "01" : mon = "January";
		break;
		case "02" : mon = "February";
		break;
		case "03" : mon = "March";
		break;
		case "04" : mon = "April";
		break;
		case "05" : mon = "May";
		break;
		case "06" : mon = "June";
		break;
		case "07" : mon = "Julu";
		break;
		case "08" : mon = "August";
		break;
		case "09" : mon = "September";
		break;
		case "10" : mon = "October";
		break;
		case "11" : mon = "November";
		break;
		case "12" : mon = "December";
		break;
		default : mon = "Please Select Proper Month";
		}

		return mon;

	}

}
