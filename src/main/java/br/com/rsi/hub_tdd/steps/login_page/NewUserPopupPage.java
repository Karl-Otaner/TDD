package br.com.rsi.hub_tdd.steps.login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsi.hub_tdd.steps.home_page.CreateNewAccount;

public class NewUserPopupPage {
	private WebDriver driver;
	
	public NewUserPopupPage(WebDriver driver) {
		this.driver = driver;
	}
	public CreateNewAccount newAccount() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement espera = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("CREATE NEW ACCOUNT")));
		espera.sendKeys(Keys.ENTER);
		driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
		
		return this.newAccount();
	}

}
