package test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import keywords.LoginHris;
import keywords.TimeSheet;

public class TestLogin extends Base
{
	
	boolean check;
	LoginHris ln;
	TimeSheet ts;
	
   @BeforeTest
   public void initiation() {
	   driver.get("https://hris.qainfotech.com/login.php");
	   ln = new LoginHris(driver);
	   ts = new TimeSheet(driver); 
   }
   
    @Test
    public void step01_LoginWithIncorrectPass() throws InterruptedException {
  
    	ln.goToLogin();
    	ln.login("arpanmishra", "incorrect_password");
    	ln.goToLogin();
    	Thread.sleep(2000);
    	check = ln.checkSingIn();
    	assertFalse(check);
    	
    	
    }
    @Test
    public void step02_LoginWithEmptyPass() throws InterruptedException {
    	
    	ln.clearFields();
    	ln.login("arpanmishra", "");
    	check = ln.checkSingIn();
    	assertFalse(check);
    	
    	
    }
    
    @Test
    public void step03_LoginWithCorrectPass() throws InterruptedException {
    	//Thread.sleep(2000);  
    	ln.goToLogin();
    	ln.clearFields();
    	ln.login("arpanmishra", "Arpan@321#");
    	check = ln.checkSingIn();
    	assertTrue(check);
    	
  	
    }
    
    @Test
    public void step04_VerificationOfInvisibilityOfLoginForm() {
	  	
    	boolean bool =  ts.checkLoginForm();
    	assertFalse(bool);
    }
    
    @Test
    public void step05_VerifyHover() {
    	ts.getYesterdaysDay();
    	ts.hover();
    	
    }
    
    @Test
    public void step06_TestLogout() {
    	ts.logoutButtonFunction();
    	
    }
    
   
  
    
    
}
