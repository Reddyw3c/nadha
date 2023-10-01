package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Data_From_Database {
	@Test
	public void database() throws Exception {
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbun = "system";
		String dbps = "Lasya@123";
		Connection con = DriverManager.getConnection(dburl, dbun, dbps);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from hrm");
		WebDriver driver = null;
		while (rs.next()) {
			String username = rs.getString(1);
			String password = rs.getString(2);
			// System.out.println(username+" "+ password);
//			System.out.println(rs.getString("username") + "\t");
//			System.out.println(rs.getString("password") + "\t");

			// apply with application
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://183.82.103.245/nareshit/login.php");
			driver.findElement(By.name("txtUserName")).sendKeys(username);
			driver.findElement(By.name("txtPassword")).sendKeys(password);
			Thread.sleep(3000);
			driver.findElement(By.name("Submit")).click();
			Reporter.log("login completed");
			System.out.println("login complted");
			Thread.sleep(3000);
			driver.findElement(By.linkText("Logout")).click();

		}
		rs.close();
		driver.close();
		stmt.close();
		con.close();
	}
}
