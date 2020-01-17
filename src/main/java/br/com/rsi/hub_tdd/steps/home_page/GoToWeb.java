package br.com.rsi.hub_tdd.steps.home_page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoToWeb {

	static WebDriver driver;
	private GoToWeb() {
		
	}

	public static WebDriver abreSite() {
		
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://www.advantageonlineshopping.com/#/");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
		return driver;

	}
	
	public static void aguardeElemento() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"follow\"]/a[3]/img")));
		
	}

	public static void fechaSite(WebDriver driver) {
		if (driver != null)
			driver.quit();
		driver = null;
	}

}
