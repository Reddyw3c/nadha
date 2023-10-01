package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
	WebDriver driver;

@Test(dataProvider="datasuplier",dataProviderClass = Dataaa.class)
public void login( String username, String password) throws Exception {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://183.82.103.245/nareshit/login.php");
	driver.findElement(By.name("txtUserName")).sendKeys(username);
	driver.findElement(By.name("txtPassword")).sendKeys(password);
	driver.findElement(By.name("Submit")).click();
	Reporter.log("Login Completed");
	Thread.sleep(3000);
}
@Test
public void logout() {
	driver.findElement(By.linkText("Logout")).click();
	Reporter.log("Logout Completed");
}
}
