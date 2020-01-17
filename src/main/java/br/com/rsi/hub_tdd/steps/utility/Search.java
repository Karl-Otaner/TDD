package br.com.rsi.hub_tdd.steps.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search {
	private WebDriver driver;

	private static WebElement element;
	public static WebElement search(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span"));
		return element;
	}

}
