package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private static By myAccLoc = By.xpath("//*[@data-adobe-name='Header|GlobalNav|MyAccountClick']");

	//private static By myAccLoc = By.linkText("My Account");
	public static void clickOnMyAccountIcon(WebDriver driver) {
		
	driver.findElement(myAccLoc).click();
	}
	
}
