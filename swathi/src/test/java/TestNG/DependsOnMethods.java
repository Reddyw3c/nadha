package TestNG;

import org.junit.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {

@Test(priority=0)	
public void launchApplication() {
	System.out.println("Launch Application");
}
@Test(priority=1,dependsOnMethods="launchApplication")
public void openApp() {
	Assert.assertTrue(false);
	System.out.println("Open App");
}
@Test(priority=2,dependsOnMethods="openApp")
public void loginApp() {
	System.out.println("Login App");
}
}
