package TestNG;

import org.testng.annotations.Test;

public class InvocationCount {
 
	@Test(priority=0,invocationCount=4)
	public void launchBrowser() {
		System.out.println("Launching Browser");
	}
	@Test(priority=1)
	public void openApplication() {
		System.out.println("Open Application");
	}
	@Test(priority=2,invocationCount=6)
	public void loginInToApplication() {
		System.out.println("Login In To Application");
	}
	@Test(priority=3)
	public void searchProduct() {
		System.out.println("Search Product");
	}
	
}
