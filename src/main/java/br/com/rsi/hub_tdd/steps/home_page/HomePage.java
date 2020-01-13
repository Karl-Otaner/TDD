package br.com.rsi.hub_tdd.steps.home_page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
//	public static WebDriver acessChrome() {
//		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("http://advantageonlineshopping.com/#/");
//		
//		return driver;
//	}
	
	
	
	
	
	
	
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
