package br.com.rsi.hub_tdd.steps.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsi.hub_tdd.steps.Generator;
import br.com.rsi.hub_tdd.steps.Screenshort;
import br.com.rsi.hub_tdd.steps.FormAccount.NewUserInformation;
import br.com.rsi.hub_tdd.steps.home_page.GoToWeb;
import br.com.rsi.hub_tdd.steps.home_page.HomePage;
import br.com.rsi.hub_tdd.steps.utility.Constant;
import br.com.rsi.hub_tdd.steps.utility.ExcelUtils;

public class TestCadastroPositivo {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {

		driver = GoToWeb.abreSite();
	}

	@Test
	public void TestNewAccont() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_Cadastro + Constant.File_Cadastro, "Planilha1");

//		GoToWeb.IrSite(driver);

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(HomePage.clickUser(driver)));
//		Thread.sleep(2000);
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
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.imagemHome(driver)));

		assertEquals("http://www.advantageonlineshopping.com/#/", driver.getCurrentUrl());

		Screenshort.printTela(driver, Generator.dataHorParaArquvio());
	}

	@After
	public void tearDown() {
//		driver.close()
		GoToWeb.fechaSite(driver);
	}

}
