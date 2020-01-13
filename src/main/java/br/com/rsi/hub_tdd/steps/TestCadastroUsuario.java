package br.com.rsi.hub_tdd.steps;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.common.GenericXmlInputStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import br.com.rsi.hub_tdd.steps.home_page.HomePage;

public class TestCadastroUsuario {

	private static WebDriver driver;

	@Rule
	public TestName test = new TestName();

	@Before

	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://advantageonlineshopping.com/#/");

	}

	@Test
	public void testCadastraUsuario() {

		HomePage.lnk_MyAccount(driver).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement espera = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("CREATE NEW ACCOUNT")));
		espera.sendKeys(Keys.ENTER);

//		driver.findElement(By.linkText("CREATE NEW ACCOUNT")).click();

		driver.findElement(By.name("usernameRegisterPage")).sendKeys("Karl_Otaner9");

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
		
		boolean displayed = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']")).isDisplayed();
		System.out.println(displayed);					
		Assert.assertTrue(displayed);
		String screenshortArquivo = "C:\\Users\\carlos.silva\\ToolsQA\\TDD\\TDD\\Screenshort/"
				+ Generator.dataHorParaArquvio() + test.getMethodName() +".png";
		Screenshort.printTela(driver, screenshortArquivo);


	}

	@After
	public void tearDown() {
//		driver.close();

	}
}