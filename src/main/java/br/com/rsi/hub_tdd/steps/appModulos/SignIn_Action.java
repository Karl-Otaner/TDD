package br.com.rsi.hub_tdd.steps.appModulos;

 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.rsi.hub_tdd.steps.home_page.HomePage;

import br.com.rsi.hub_tdd.steps.home_page.NewUser;
import br.com.rsi.hub_tdd.steps.utility.Constant;
import br.com.rsi.hub_tdd.steps.utility.ExcelUtils;

public class SignIn_Action {

	public static void Execute(WebDriver driver) throws Exception {
		HomePage.lnk_MyAccount(driver).click();
		NewUser.btn_NewUser(driver).click();
		ExcelUtils.setExcelFile(Constant.Path_Cadastro + Constant.File_Cadastro, "Planilha1");
		
		driver.findElement(By.name("usernameRegisterPage")).sendKeys(ExcelUtils.getCellData(0, 1));
//		 String sUserName = ExcelUtils.getCellData(1, 1);
		 
//		 String sPassword = ExcelUtils.getCellData(1, 2);
		 
		 
//		 NewUser.txtbx_UserName(driver).sendKeys("Karl_Otaner2");
//		 
//		 NewUser.txtbx_Password(driver).sendKeys("Aa123456");
		 
		 
		        }
	
}
