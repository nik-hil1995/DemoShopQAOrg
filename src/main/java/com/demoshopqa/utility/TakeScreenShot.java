package com.demoshopqa.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {

	public static void takeScreenShot(WebDriver driver, String filename) {
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\ScreenShot\\"+filename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
		
	}
	
	
}
