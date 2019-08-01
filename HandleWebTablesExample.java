package SeleniumProgs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;

public class HandleWebTablesExample {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // maximum time to load page if it loads before that then rest of the time will ignored
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // maximum time to load all elements of a page, if it loads before that then rest of the time will ignored


		driver.manage().window().maximize();

		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		
		String beforeXpath = "//table/tbody/tr[";
		String afterXpath = "]/td[5]";
		
		int maxAge = 1;
		int j = 1;
		
		for(int i=1; i<=10; i++)
		{
			String ageData = driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			int age = Integer.parseInt(ageData);
			if(age > maxAge)
			{
				maxAge=age;
				j=i;
			}
		}
		
		System.out.println("Maximum Age Is : "+maxAge);
		driver.findElement(By.xpath("//table/tbody/tr["+j+"]/td[@class=' select-checkbox']")).click();
		
		String name = "Cedric Kelly";
		try {
			driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]/preceding-sibling::td")).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
