package br.com.rsi.hub_tdd.steps.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsi.hub_tdd.steps.Generator;
import br.com.rsi.hub_tdd.steps.Screenshort;
import br.com.rsi.hub_tdd.steps.FormAccount.NewUserInformation;
import br.com.rsi.hub_tdd.steps.home_page.HomePage;
import br.com.rsi.hub_tdd.steps.utility.Constant;
import br.com.rsi.hub_tdd.steps.utility.ExcelUtils;
import br.com.rsi.hub_tdd.steps.utility.MenssageTest;

public class TestCadastroNegativo {
	private static ChromeDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://advantageonlineshopping.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void TestNewAccont() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_Cadastro + Constant.File_Cadastro, "Planilha1");

		HomePage.clickUser(driver).click();
		HomePage.createNewAccount(driver).sendKeys(Keys.ENTER);

		NewUserInformation.registerName(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		NewUserInformation.registerEmail(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		NewUserInformation.registerPsw(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		NewUserInformation.ConfirmRegisterPsw(driver).sendKeys(ExcelUtils.getCellData(1, 3));
		NewUserInformation.firstRegisterName(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		NewUserInformation.LastRegisterName(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		NewUserInformation.phoneRegisterNum(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		NewUserInformation.contryListbox(driver).selectByVisibleText(ExcelUtils.getCellData(1, 7));
		NewUserInformation.cityRegister(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		NewUserInformation.addressRegister(driver).sendKeys(ExcelUtils.getCellData(1, 9));
		NewUserInformation.regionRegister(driver).sendKeys(ExcelUtils.getCellData(1, 10));
		NewUserInformation.postalRegister(driver).sendKeys(ExcelUtils.getCellData(1, 11));
		NewUserInformation.iAgree(driver).click();
		NewUserInformation.registerBtn(driver).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,200)");
		
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		

		assertEquals("User name already exists", MenssageTest.registeredUsere(driver).getText());
		Screenshort.printTela(driver, Generator.dataHorParaArquvio());
	}

	@After
	public void tearDown() throws InterruptedException {
		driver.close();
	}

}
