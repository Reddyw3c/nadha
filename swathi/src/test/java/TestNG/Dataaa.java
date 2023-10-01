package TestNG;

import org.testng.annotations.DataProvider;


public class Dataaa {
	@DataProvider
   public Object[][] datasuplier() {
	   Object[][] data = new Object[2][2];
	   data[0][0] = "nareshit";
	   data[0][1] = "nareshit";
	   data[1][0] = "nareshit";
	   data[1][1] = "nareshit";
	   return data;
   }
   
}
