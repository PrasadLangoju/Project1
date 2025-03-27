package com.testing;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaunchUrl {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void initiate() {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void launchUrl() throws InterruptedException, IOException {
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Orasi", Keys.ENTER);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\CapturesSeleniumScreenshorts/pic.jpeg");
		FileHandler.copy(src, dest);

		System.out.println("Url launched successfully");
		Thread.sleep(3000);

	}

	@Test
	public void getYoutubeTitles() throws InterruptedException {
		driver.get("https://www.youtube.com");
		WebElement search = driver
				.findElement(By.xpath("//input[@class='ytSearchboxComponentInput yt-searchbox-input title']"));
		WebElement button = driver.findElement(By.xpath("//button[@class='ytSearchboxComponentSearchButton']"));
		button.click();
		Thread.sleep(2000);
		search.sendKeys("Alchemy Testing", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//yt-formatted-string[@id='text' and text()='Alchemy Testing']")).click();
		driver.findElement(By.xpath("//span[@id='title' and text()='Alchemy Playlists']")).click();
		Thread.sleep(2000);
		List<WebElement> namesOfVideos = driver.findElements(By.xpath("//a[@id='video-title']"));

//		for (WebElement EachVideoName : namesOfVideos) {
//			if(EachVideoName.getText().contains("01")) {
//				System.out.println(EachVideoName.getText());	
//			}
//			
//		}
		for (WebElement EachVideoName : namesOfVideos) {
			for (int i = 0; i < namesOfVideos.size(); i++) {
				System.out.println(EachVideoName.getText());
			}
		}

	}

	// System.out.println(namesOfVideos);
//		((JavascriptExecutor) driver).executeScript("arguments[0].value='Alchemy testing'", search);
//
//		List<WebElement> titles = driver.findElements(By.xpath("//a[@id='video-title']"));
//		for (int i = 0; i < 3; i++) {
//			System.out.println(titles.get(i));
//		}
	// }

	@Test
	public void youTube() throws InterruptedException, IOException {
		driver.get("https://www.youtube.com");
		WebElement searchElement = driver.findElement(By.xpath(
				"//input[@name='search_query' and @class=\"ytSearchboxComponentInput yt-searchbox-input title\"]"));
		// Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(searchElement));

		searchElement.sendKeys("Alchemy Testing");
		driver.findElement(By.xpath("//button[@class='ytSearchboxComponentSearchButton']")).click();
		Thread.sleep(3000);
		WebElement alchemy = driver
				.findElement(By.xpath("//yt-formatted-string[@id='text' and text()='Alchemy Testing']"));
		alchemy.click();
		System.out.println(alchemy.getText());

		WebElement playList = driver.findElement(
				By.xpath("//span[@class='style-scope ytd-shelf-renderer' and text()='Alchemy Playlists']"));

		playList.click();

		List<WebElement> allcontent = driver
				.findElements(By.xpath("//a[@class=\"yt-simple-endpoint style-scope ytd-grid-playlist-renderer\"]"));
		int i = 0;

		for (WebElement content : allcontent) {
			if(content.getText().contains("00")){
				continue;
			}
			
			if (i < 3) {
				System.out.println(content.getText());
				i++;
			}

			else {
				break;
			}

		}

//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
//		File dest = new File("D:\\CapturesSeleniumScreenshorts/" + timeStamp + "Alchemy.png");
//		FileHandler.copy(src, dest);
//
//		ExtentSparkReporter extetSparkReporter = new ExtentSparkReporter("D:\\Reports/ExtentReports.html");
//
//		extetSparkReporter.config().setReportName("Automation test report");
//		extetSparkReporter.config().setDocumentTitle("Report Title");
//
//		ExtentReports extent = new ExtentReports();
//		extent.attachReporter(extetSparkReporter);
//
//		ExtentTest test = extent.createTest("Sample test");
//		test.pass("Test Executed successfully");
//
//		extent.flush();

	}
	
	@Test
	public void collectingAListOfElements() throws InterruptedException {
		driver.get("https://www.youtube.com/");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[name='search_query']")).sendKeys("Alchemy Testing" , Keys.ENTER);
		
		
	}

	@AfterTest
	public void tearDown() {
		// driver.close();
	}

}
