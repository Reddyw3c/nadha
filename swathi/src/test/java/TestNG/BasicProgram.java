package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class BasicProgram {
	
@Test
public void abc() {
	System.out.println("ABC printing");
	Reporter.log("ABC printing");
}
@Test
public void abcd() {
	System.out.println("ABCD printing");
	Reporter.log("ABCD printing");
}
@Test
public void xyz() {
	System.out.println("XYZ printing");
	Reporter.log("XYZ printing");
}


}
