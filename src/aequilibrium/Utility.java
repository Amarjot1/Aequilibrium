package aequilibrium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;


public class Utility extends TestBase {
	public void failed() {
		
		TakesScreenshot cap=(TakesScreenshot)driver;
	File f = cap.getScreenshotAs(OutputType.FILE);
	try {
	FileHandler.copy(f, new File("C:\\Users\\Aman\\eclipse-workspace\\SwagLabs\\Screenshots"+"image.jpg"));
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}