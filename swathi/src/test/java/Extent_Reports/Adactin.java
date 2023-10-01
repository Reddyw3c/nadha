package Extent_Reports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Adactin {
public WebDriver driver;
@Parameters({"browser","url"})
@BeforeClass
public void openApplication(String br, String url) {
	if(br.equals("chrome")) {
	driver = new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	driver.get(url);
	Reporter.log("APPLICATION OPENED");
}
@Test(priority=1)
public void verifyOpenApplication() {
	Boolean actual = driver.findElement(By.xpath("//td[text()='Existing User Login - Build 1']")).isDisplayed();
	Assert.assertTrue(actual);
	Reporter.log("VERIFIED APPLICATION");
}
@Parameters({"username","password"})
@Test(priority=2)
public void loginApplication(String username,String password) {
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("login")).click();
	Reporter.log("LOGIN COMPLETED");
}
@Test(priority=3)
public void verifyLogin() {
	Boolean actual =driver.findElement(By.xpath("//td[text()='Welcome to Adactin Group of Hotels']")).isDisplayed();
    Assert.assertTrue(actual);
    Reporter.log("VERIFIED LOGIN COMPLETED"); 
   
}
@Test(priority=4)
public void searchHotel() throws Exception {
	WebElement location = driver.findElement(By.id("location"));
	Select dropdown = new Select(location);
    dropdown.selectByVisibleText("Melbourne");
    Thread.sleep(5000);
    
   WebElement rooms = driver.findElement(By.id("room_nos"));
   Select room = new Select(rooms);
   room.selectByVisibleText("3 - Three");
   driver.findElement(By.id("datepick_in")).sendKeys("02/09/2023");
   driver.findElement(By.id("datepick_out")).sendKeys("03/09/2023");
   
   WebElement adults = driver.findElement(By.id("room_nos"));
   Select adult = new Select(adults);
   adult.selectByVisibleText("1 - One");
   driver.findElement(By.id("Submit")).click();
   Reporter.log("SEARCH HOTEL COMPLETED");
   
}
@Test(priority=5)
public void verifySearchHotel() {
	Boolean actual = driver.findElement(By.xpath("//td[text()='Select Hotel ']")).isDisplayed();
	Assert.assertTrue(actual);
	Reporter.log("VERIFIED SEARCH HOTEL");
	
}
@Test(priority=6)
public void selectHotel() {
	driver.findElement(By.id("radiobutton_1")).click();
	driver.findElement(By.id("continue")).click();
	Reporter.log("SELECT HOTEL COMPLETED");
}
@Test(priority=7)
public void BookAHotel() {
	driver.findElement(By.id("first_name")).sendKeys("Reddy");
	driver.findElement(By.id("last_name")).sendKeys("Putturu");
	driver.findElement(By.id("address")).sendKeys("ABCDEFGHJKLSYEDGEUD");
	driver.findElement(By.id("cc_num")).sendKeys("1234567890987654");
	WebElement cctype = driver.findElement(By.id("cc_type"));
	Select drop = new Select(cctype);
	drop.selectByVisibleText("Master Card");
	WebElement ccexp = driver.findElement(By.id("cc_exp_month"));
	Select drop1 = new Select(ccexp);
	drop1.selectByVisibleText("March");
	WebElement ccyr= driver.findElement(By.id("cc_exp_year"));
	Select drop2 = new Select(ccyr);
	drop2.selectByVisibleText("2025");
	driver.findElement(By.id("cc_cvv")).sendKeys("123");
	driver.findElement(By.name("book_now")).click();
	
	Reporter.log("Book A Hotel Completed");
}
@Test(priority=8)
public void verifyBookAHotel() {
	Boolean actual = driver.findElement(By.xpath("//td[text()='Book A Hotel ']")).isDisplayed();
	Assert.assertTrue(false);
	Reporter.log("Verified Book A Hotel");
}
@Test(priority=9,dependsOnMethods="verifyBookAHotel")
public void bookingConformation() {
	driver.findElement(By.id("search_hotel")).click();
	Reporter.log("Booking Confirmation Completed");
}
@AfterClass
public void closeApplication() {
	driver.quit();
}
}

