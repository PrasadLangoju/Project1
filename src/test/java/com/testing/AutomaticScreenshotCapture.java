package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.testing.Listen.class)
public class AutomaticScreenshotCapture extends Base{
	
	
	@BeforeMethod
	public void initialization() {
		setUp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void entertext() {
		
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("Facebook", Keys.ENTER);		
	}
	
	@Test
	public void getText() throws InterruptedException {
		
		String textCaptured=driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).getAttribute("value");
		System.out.println(textCaptured);
		Thread.sleep(4000);
		
	}
	
	@Test
	public void assertfalse() {
		
		driver.findElement(By.xpath("//a[@class='gb_A']")).click();
		Assert.assertTrue(false);
	}
	

}
