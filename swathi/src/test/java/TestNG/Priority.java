package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority {

@Test(priority=5)
public void pavanKalyan() {
	System.out.println("Pavan selected");
	Reporter.log("PAVAN KALYAN");
}
@Test(priority=6)
public void prabhas() {
	System.out.println("Prabhas");
	Reporter.log("PRABHAS");
}
@Test(priority=4)
public void chiru() {
	System.out.println("Chiru");
	Reporter.log("CHIRU");
}
@Test(priority=3)
public void jaiBalayya() {
	System.out.println("Balayya");
	Reporter.log("BALAYYA");
	
}
@Test(priority=0)
public void alluArjun() {
	System.out.println("ALLU ARJUN");
	Reporter.log("ALLU ARJUN");
}
@Test(priority=2)
public void charan() {
	System.out.println("CHARAN");
	Reporter.log("CHARAN");
}
@Test(priority=1)
public void ntr() {
	System.out.println("NTR");
	Reporter.log("NTR");
}



}
