package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Groups {

@Test(priority=0,groups="sanity")
public void a() {
    System.out.println("SANITY IS PRINTIMNG");
    Reporter.log("Sanity is printing");
}
@Test(priority=1,groups={"smoke","sanity"})
public void c() {
	System.out.println("SMOKE & SANITY IS PRINTING");
	Reporter.log("Smoke & sanity is printing");
}
@Test(priority=2,groups={"smoke","regression"})
public void b() {
	System.out.println("SMOKE & REGRESSION IS PRINTING");
	Reporter.log("Smoke & Regression is printing");
}
@Test(priority=3,groups={"sanity","regression"})
public void a1() {
	System.out.println("Sanity & REgression is completed");
}
}
