package keywords;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.Repository;

public class TimeSheet {
	
	private Repository parser;
	WebDriver driver;
	String YesDate;
	
	
	public TimeSheet(WebDriver driver) {
		this.driver = driver;
		try {
			parser = new Repository("DataFile.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkLoginForm() {
		try{
			driver.findElement(parser.getLocator("userNameEntryField"));
		}catch(NoSuchElementException e) {
			return false;
		}
		return true;
	}
	
	public void getYesterdaysDay(){
		 Calendar cal = Calendar.getInstance();
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   
		   cal.add(Calendar.DATE, -1);
		   YesDate = dateFormat.format(cal.getTime());
		   System.out.println("Yesterday's date was " + YesDate);
		   
	}
	
	
	public void hover() {
		WebElement wb = driver.findElement(By.id("dv_" + YesDate));
		 Actions ac=  new Actions(driver);
		  ac.moveToElement(wb).build().perform();
		 List<WebElement> list = driver.findElements(By.cssSelector("[id=dv_"+ YesDate +"] [class='ng-binding']"));
		 for (WebElement webElement : list) {
			System.out.println(webElement.getText());
		}
	}
	
	public void logoutButtonFunction() {
		
		driver.findElement(parser.getLocator("profileButton")).click();
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(parser.getLocator("logoutLink")));
		driver.findElement(By.cssSelector("[class='user-profile-option user-profile-option1 list-unstyled'] li:nth-child(4) a")).click();
	}

	

}
