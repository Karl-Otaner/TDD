package br.com.rsi.hub_tdd.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCadastroUsuario {

	private static WebDriver driver;

	@Before

	public void SetUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://advantageonlineshopping.com/#/");
		Thread.sleep(4000);

	}

	@Test
	public void testCadastraUsuario() throws InterruptedException {
		driver.findElement(By.id("menuUserSVGPath")).click();
		Thread.sleep(1000);
//		driver.findElement(By.name("username")).sendKeys("Karl_Otaner2");
//		Thread.sleep(1000);
//		driver.findElement(By.name("password")).sendKeys("123456");
//		Thread.sleep(1000);
		driver.findElement(By.linkText("CREATE NEW ACCOUNT")).click();

		driver.findElement(By.name("usernameRegisterPage")).sendKeys("Karl_Otaner4");

		driver.findElement(By.name("emailRegisterPage")).sendKeys("carlos.silva@rsinet.com.br");

		driver.findElement(By.name("passwordRegisterPage")).sendKeys("Aa123456");

		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Aa123456");

		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Karl");

		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Otaner");

		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("55 11 1234567");

		Select drpPais = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		drpPais.selectByVisibleText("Brazil");

		driver.findElement(By.name("cityRegisterPage")).sendKeys("Osasco");

		driver.findElement(By.name("addressRegisterPage")).sendKeys("Av. Domingos Odália Filho, 301 - Centro");

		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("SAO PAULO");

		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("06010-060");

		driver.findElement(By.name("i_agree")).click();

		driver.findElement(By.id("register_btnundefined")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,200)");

		Thread.sleep(2000);
		driver.close();

	}
}