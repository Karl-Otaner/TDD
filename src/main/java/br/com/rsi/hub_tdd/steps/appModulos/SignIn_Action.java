package br.com.rsi.hub_tdd.steps.appModulos;

 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.rsi.hub_tdd.steps.home_page.HomePage;
import br.com.rsi.hub_tdd.steps.login_page.NewUserPage;
import br.com.rsi.hub_tdd.steps.utility.Constant;
import br.com.rsi.hub_tdd.steps.utility.ExcelUtils;

public class SignIn_Action {

	public static void Execute(WebDriver driver) throws Exception {
		HomePage.lnk_MyAccount(driver).click();
		NewUserPage.btn_NewUser(driver).click();
		ExcelUtils.setExcelFile(Constant.Path_Cadastro + Constant.File_Cadastro, "Planilha1");
		
		driver.findElement(By.name("usernameRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 0));
		driver.findElement(By.name("emailRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 1));
		driver.findElement(By.name("passwordRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 2));
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 3));
		driver.findElement(By.name("first_nameRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 4));
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 5));
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 6));
		driver.findElement(By.name("countryListboxRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 7));
		driver.findElement(By.name("cityRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 8));
		driver.findElement(By.name("addressRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 9));
//		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 10));
//		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 11));
//		 String sUserName = ExcelUtils.getCellData(1, 1);
		 
//		 String sPassword = ExcelUtils.getCellData(1, 2);
		 
		 
//		 NewUser.txtbx_UserName(driver).sendKeys("Karl_Otaner2");
//		 
//		 NewUser.txtbx_Password(driver).sendKeys("Aa123456");
		 
		 
		        }
	
}
