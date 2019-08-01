package SeleniumProgs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWebTables {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // maximum time to load page if it loads before that then rest of the time will ignored
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // maximum time to load all elements of a page, if it loads before that then rest of the time will ignored


		driver.manage().window().maximize();

		driver.get("https://www.toolsqa.com/automation-practice-table/#");

		System.out.println("Print Entire Table :");

		WebElement table = driver.findElement(By.xpath("//table"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for(WebElement row : rows)
		{
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for(WebElement col : cols)
			{
				System.out.print(col.getText()+"\t");
			}
			System.out.println();
		}


		String beforeXpath = "//table//tr[";
		String afterXpath = "]/td[3]";

		int maxLength = 829;
		int minLength = 829;
		int j=1,k=1;

		for(int i=1 ; i<=4; i++)
		{
			String meter = driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			String[] met = meter.split("m");
			int meterInInt = Integer.valueOf(met[0]);
			if(meterInInt > maxLength)
			{
				maxLength = meterInInt;
				j=i;
			}
			else if(meterInInt < minLength)
			{
				minLength = meterInInt;
				k=i;
			}
		}

		System.out.println("Maximum Length Is :"+maxLength+" of "+driver.findElement(By.xpath("//table/tbody/tr["+j+"]/th")).getText());
		System.out.println("Minimum Length Is :"+minLength+" of "+driver.findElement(By.xpath("//table/tbody/tr["+k+"]/th")).getText());
	}

}
