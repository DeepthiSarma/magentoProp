package com.cts.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.cts.utils.PropUtils;

public class LaunchWebDriver {

	public WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser" })
	public void SetUp(@Optional("ch") String browserName) throws IOException {

		System.out.println(browserName);

		if (browserName.equalsIgnoreCase("ff")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "src/test/resources/driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS); // in case the page is taking > 60sec to load
PropUtils.getValue("src/test/resources/resources/data.properties","url");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException  {
		Thread.sleep(10000);
		driver.quit();
	}

}
