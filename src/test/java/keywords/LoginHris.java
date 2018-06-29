package keywords;

import java.io.IOException;

import javax.swing.text.Style;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import test.Repository;

public class LoginHris {
	
	private Repository parser;
	WebDriver driver;
	
	public LoginHris(WebDriver driver){
		this.driver = driver;
		try {
			parser = new Repository("DataFile.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void goToLogin() {
		driver.findElement(parser.getLocator("loginPannel")).click();
	}
	
	public void login(String username , String password) {

		driver.findElement(parser.getLocator("userNameEntryField")).sendKeys(username);
		driver.findElement(parser.getLocator("passwordEntryField")).sendKeys(password);
		driver.findElement(parser.getLocator("signIn")).click();
	
	}
	
	
	
	public void clearFields() {
		
		driver.findElement(parser.getLocator("userNameEntryField")).clear();
		driver.findElement(parser.getLocator("passwordEntryField")).clear();
	}
	
	
	public boolean checkSingIn() {
		
		try {
		if(driver.findElement(parser.getLocator("invalidText")).getText().contains("Invalid Login")) {
			return false;
		}
		else if(driver.findElement(parser.getLocator("passwordEntryField")).getAttribute("Style").contains("red")){
			return false;
		}
		else {
			return true;
			}
		}catch(NoSuchElementException e) {
			return true;
		}
		
		
	}
	
		

}
