package aequilibrium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

 
public class TestCases extends TestBase {
	
WebDriver driver;
// parameterized method for login
public void login(String Username,String Password) {
	
	driver.findElement(By.id("user-name")).clear();
	driver.findElement(By.id("user-name")).sendKeys(Username);
	
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys(Password);
	
		WebElement LoginBtn = driver.findElement(By.id("login-button"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",LoginBtn);
	}


	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");	
		}
	
	@Test (priority=1)
	public void TestCase1() {
		login("standard_user", "secret_sauce");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
	
	@Test(priority=2)
	public void TestCase2() {
		login(" locked_out_user", "secret_sauce");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
	
	@Test(priority=3)
	public void TestCase3() {
		login("locked_out_user", " ");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
	
	@Test(priority=4)
	public void TestCase4() {
		login("performance_glitch_user", "Secret_sauce ");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
	
	@Test(priority=5)
	public void TestCase5() {
		login(" ", " ");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	


}
