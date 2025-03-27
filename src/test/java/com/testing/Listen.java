package com.testing;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import jdk.javadoc.internal.doclets.toolkit.taglets.InheritableTaglet.Output;

public class Listen extends Base implements ITestListener{


	@Override
	public void onTestFailure(ITestResult result) {
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String folderPath=System.getProperty("user.dir")+"/screenshots/";
		File folder = new File (folderPath);
		if(!folder.exists()) {
			folder.mkdir();
		}
		String fileName="Screenshot_"+System.currentTimeMillis()+".png";
		
		File dest= new File(folderPath+fileName);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
