package SeleniumProgs;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PDFReader {

	public static void main(String[] args)throws Exception {
		
		// download pdfbox.jar, fontbox.jar and org-apache-commons-logging.jar files
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // maximum time to load page if it loads before that then rest of the time will ignored
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // maximum time to load all elements of a page, if it loads before that then rest of the time will ignored


		driver.manage().window().maximize();

		driver.get("https://www.betterteam.com/downloads/employee-information-form-download-20170810.pdf");
		
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL Is : "+currentURL);
		
		//For system files
		//URL url = new URL("file:///C:/Users/akshay.shete/Documents/Claims/July%20Claim/July%20Taxi%20Bills.pdf");
		
		URL url = new URL(currentURL);
		InputStream is = url.openStream();
		
		BufferedInputStream fileParse = new BufferedInputStream(is);
		PDDocument document = null;
		
		document = PDDocument.load(fileParse);
		String pdfText = new PDFTextStripper().getText(document);
		
		System.out.println(pdfText);
		
		driver.quit();
	}

}
