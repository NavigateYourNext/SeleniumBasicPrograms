package SeleniumProgs;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // maximum time to load page if it loads before that then rest of the time will ignored
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); // maximum time to load all elements of a page, if it loads before that then rest of the time will ignored


		driver.manage().window().maximize();

		driver.get("https://www.facebook.com");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);

		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		for(String window:windows)
		{
			driver.switchTo().window(window);
			if(!driver.getTitle().contains("Facebook"))
			{
				driver.navigate().to("https://www.google.com");
				System.out.println(driver.getCurrentUrl());
				System.out.println("Hi Google");
			}
			driver.close();
		}

	}

}
