package SeleniumProgs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RecordVideo {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		//Download MonteScreenRecorder.jar file and used MyScreenRecorder class methods as below
		
		MyScreenRecorder.startRecording("RecordVideo");
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.navigate().to("http://www.facebook.com/");
		
		driver.navigate().back();
		driver.navigate().forward();

		driver.navigate().back();
		driver.navigate().forward();
		

		driver.navigate().back();
		driver.navigate().forward();
		

		driver.navigate().back();
		driver.navigate().forward();
		

		driver.navigate().back();
		driver.navigate().forward();
		

		driver.navigate().back();
		driver.navigate().forward();
		

		driver.navigate().back();
		driver.navigate().forward();
		

		driver.navigate().back();
		driver.navigate().forward();
		

		driver.navigate().back();
		driver.navigate().forward();
		

		driver.navigate().back();
		driver.navigate().forward();
		
		
		
		MyScreenRecorder.stopRecording();
		driver.quit();

	}

}
