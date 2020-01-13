package br.com.rsi.hub_tdd.steps.home_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private static WebElement element = null;
	
	public static WebElement lnk_MyAccount(WebDriver driver) {
		element = driver.findElement(By.id("menuUser"));
		return element;
	}
//	public static WebElement lnk_LogOut(WebDriver driver) {
//		
//		element = driver.findElement(By.id("loginMiniTitle"));
//		driver.findElement(By.className("Sign out")).click();
//		
//		return element;
//	}
	
}
