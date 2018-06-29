package test;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import keywords.LoginHris;

public class YesterdayDate extends Base {

	LoginHris ln;
	boolean check;
	
	 @BeforeTest
	   public void initiation() {
		   driver.get("https://hris.qainfotech.com/login.php");
		   ln = new LoginHris(driver);
	   }
	
	    public void step03_LoginWithCorrectPass() throws InterruptedException {
		 ln.goToLogin();
	    	ln.login("arpanmishra", "Arpan@321#");
	    	check = ln.checkSingIn();
	    	assertTrue(check);
  	
	    }
	 
	 @Test
	 public void step04_checkTimeSheetOfPreviousDate() {
		 
		 
	 }
	
}
