package SeleniumProgs;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoIbiboAutomation {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");


		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // maximum time to load page if it loads before that then rest of the time will ignored
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); // maximum time to load all elements of a page, if it loads before that then rest of the time will ignored


		driver.manage().window().maximize();

		//Example 1
		driver.get("http://www.goibibo.com/");

		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Johannesburg");
		Thread.sleep(2000);

		List<WebElement> sugg = driver.findElements(By.xpath("//ul[@id='react-autosuggest-1']//li"));

		for(int i=0; i<sugg.size(); i++)
		{
			if(sugg.get(i).getText().startsWith("Johannesburg"))
			{
				sugg.get(i).click();
				break;
			}

		}

		driver.findElement(By.id("gosuggest_inputDest")).sendKeys("Mumbai");
		Thread.sleep(2000);

		List<WebElement> sugg_1 = driver.findElements(By.xpath("//ul[@id='react-autosuggest-1']//li"));

		for(int i=0; i<sugg_1.size(); i++)
		{
			if(sugg_1.get(i).getText().startsWith("Mumbai"))
			{
				sugg_1.get(i).click();
				break;
			}

		}

		String selectedDate_1 = "2-03-2020";
		String[] splitDate = selectedDate_1.split("-");
		String month = formatDate(splitDate[1]);
		
		
		int id = 0;
		WebElement ddate = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Departure']"));
		WebElement prevButton = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/parent::div/preceding-sibling::div/span[1]"));
		String currentMonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();

		while(!currentMonth.equals(month+" "+splitDate[2]))
		{
			Thread.sleep(2000);
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
			
			Thread.sleep(2000);
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
