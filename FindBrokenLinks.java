package SeleniumProgs;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinks {
	public static void main(String[] args)throws Exception {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // maximum time to load page if it loads before that then rest of the time will ignored
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // maximum time to load all elements of a page, if it loads before that then rest of the time will ignored


		driver.manage().window().maximize();

		driver.get("http://www.facebook.com");

	
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("Total Available Links Are :"+totalLinks.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		for(int i=0; i<totalLinks.size(); i++)
		{
			if(totalLinks.get(i).getAttribute("href") != null)
			{
				activeLinks.add(totalLinks.get(i));
			}
		}
		
		System.out.println("Total Active Links Are : "+activeLinks.size());
		
		int count = 0;
		for(int i=0; i<activeLinks.size(); i++)
		{
			HttpURLConnection huc = (HttpURLConnection)new URL(activeLinks.get(i).getAttribute("href")).openConnection();
			huc.connect();
			String message = huc.getResponseMessage();
			if(message.equalsIgnoreCase("ok"))
			{
				System.out.println(huc.getURL()+"->"+huc.getResponseCode()+"->"+message);
				count++;
			}
			else
			{
				System.out.println(huc.getURL()+"->"+huc.getResponseCode()+"->"+message);
			}
		}
		System.out.println("Total Activated Links Are :"+count);
		driver.quit();
	}
}

