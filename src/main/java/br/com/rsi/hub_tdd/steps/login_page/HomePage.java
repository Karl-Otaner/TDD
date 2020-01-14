package br.com.rsi.hub_tdd.steps.login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsi.hub_tdd.steps.home_page.CreateNewAccount;
import br.com.rsi.hub_tdd.steps.home_page.Web;

public class HomePage {
	private WebDriver driver;
	
	private static WebElement element;
	 
	public static WebElement clickUser(WebDriver driver) {
		driver.findElement(By.id("menuUser")).click();
		return element;
	}
	public  static WebElement newAccount(WebDriver driver) {
		element = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
		return element;
	}

	
			
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		WebElement espera = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("CREATE NEW ACCOUNT")));
//		espera.sendKeys(Keys.ENTER);
//		element = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
//		return element;
//	}

}
