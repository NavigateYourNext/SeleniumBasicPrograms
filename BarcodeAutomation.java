package SeleniumProgs;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.common.GlobalHistogramBinarizer;

public class BarcodeAutomation {

	public static void main(String[] args)throws Exception {

		// ZXing company created barcode jar files
		// Through selenium it is not possible so we used this 3rd party tool
		// Download javase.jar and zxing.jar and zxing-core.jar file

		try {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // maximum time to load page if it loads before that then rest of the time will ignored
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // maximum time to load all elements of a page, if it loads before that then rest of the time will ignored
			driver.manage().window().maximize();


			driver.get("https://barcode.tec-it.com/en");

			String barCodeURL = driver.findElement(By.tagName("img")).getAttribute("src");
			System.out.println(barCodeURL);

			URL url = new URL(barCodeURL);
			BufferedImage bufferedImage = ImageIO.read(url); // it returns BufferedImage


			LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);		
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
			Result result = new MultiFormatReader().decode(binaryBitmap);

			System.out.println(result.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Message Is : "+e.getMessage());
		}



	}

}
