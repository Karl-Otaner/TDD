package br.com.rsi.hub_tdd.steps.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaProduto {
	public static WebElement element;

	public static WebElement produtoEscolido(WebDriver driver) {
		element = driver.findElement(By.id("18"));
		return element;
	}
	

	
}
