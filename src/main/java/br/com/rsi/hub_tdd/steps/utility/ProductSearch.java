package br.com.rsi.hub_tdd.steps.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearch {
	private static WebDriver driver;
	private static WebElement element;

	public static WebElement productName(WebDriver driver) {
		element = driver.findElement(By.id("autoComplete"));
		return element;
	}

	public static WebElement productFound(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"output\"]/div/div[2]/a[2]"));
		return element;
	}



}
