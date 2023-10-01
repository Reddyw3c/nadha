package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTests {
WebDriver driver;
    @Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
    	if(br.equals("chrome")) {
    		driver = new ChromeDriver();
    		
    	}
    	else if(br.equals("edge")) {
    		driver = new EdgeDriver();
    		
    	}
    	driver.manage().window().maximize();
		driver.get("http://183.82.103.245/nareshit/login.php");
		Reporter.log("Application Opened");
	}
    @Parameters({"Login Name","Password"})
	@Test(priority=1)
	public void loginApplication(String username, String Password) {
		driver.findElement(By.name("txtUserName")).sendKeys(username);
		driver.findElement(By.name("txtPassword")).sendKeys(Password);
		driver.findElement(By.name("Submit")).click();
		Reporter.log("Login Completed");
	}
	@Test(priority=2)
	public void enterFrame() {
		driver.switchTo().frame("rightMenu");
		Reporter.log("Enter the Frame");
	}
	@Test(priority=3)
	public void addEmployee() {
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		driver.findElement(By.id("txtEmpLastName")).sendKeys("putturu");
        driver.findElement(By.name("txtEmpFirstName")).sendKeys("reddy");
		driver.findElement(By.id("btnEdit")).click();
		Reporter.log("Add Employee completed");
	}
	@Test(priority=4)
	public void exitFrame() {
		driver.switchTo().defaultContent();
		Reporter.log("Exit The Frame");
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
}
