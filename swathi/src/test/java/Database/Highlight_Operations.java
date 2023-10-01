package Database;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Highlight_Operations {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("document.getElementById('email').style.border='2px red solid';");
		Thread.sleep(3000);
		js.executeScript("document.getElementById('email').setAttribute('style','border:2px red solid; background:yellow;')");
		
	}

}
