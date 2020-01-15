package br.com.rsi.hub_tdd.steps.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenssageTest {
	private WebDriver driver;

	private static WebElement element;

	public static WebElement registeredUsere(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]"));
		return element;
	}

}
