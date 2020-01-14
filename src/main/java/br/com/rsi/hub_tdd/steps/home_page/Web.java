package br.com.rsi.hub_tdd.steps.home_page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
//	 static WebElement element;
	
	public static WebDriver acessChrome() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://advantageonlineshopping.com/#/");
		
		return driver;
	}
	 
	 
	 
//	public static WebElement clickUser(WebDriver driver) {
//		element = driver.findElement(By.id("menuUser"));
//		return element;
//	}
//	
//	public static WebElement clickNewAccount(WebDriver driver) {
//		element = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
//		return element;
//	}
	
}
