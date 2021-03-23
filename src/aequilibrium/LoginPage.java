package aequilibrium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends TestBase {

	public LoginPage(WebDriver driver) {
		TestBase.driver= driver;
	}
	// Locating elements

	@FindBy(how=How.ID, using="user-name")WebElement UsernameTextBox;

	@FindBy(how=How.ID, using="password")WebElement PasswordTextBox;
	
	//Set Username
	public void setUsername(String strUsername) {
		UsernameTextBox.sendKeys(strUsername);
	}
	
		
     // Set Password
	public void setPassword(String strPassword) {
		PasswordTextBox.sendKeys(strPassword);
	}
	
	// Click
	public void clickOnLoginButton() {
		WebElement LoginBtn = driver.findElement(By.id("login-button"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",LoginBtn);
	}
	}	
	
	
	

