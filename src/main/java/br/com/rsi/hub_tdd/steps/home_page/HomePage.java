package br.com.rsi.hub_tdd.steps.home_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public static WebElement element;

	public static WebElement clickUser(WebDriver driver) {
		element = driver.findElement(By.id("menuUserLink"));
		return element;
	}

	public static WebElement createNewAccount(WebDriver driver) {
		element = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
		return element;
	}
	
	public static WebElement findProduct(WebDriver driver) {
		element = driver.findElement(By.id("menuSearch"));
		return element;
	}
	
	public static WebElement imagemHome(WebDriver driver) {
		element = driver.findElement(By.id("miceLink"));
		return element;
	}

	
}
