package br.com.rsi.hub_tdd.screenshort;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.utils.FileUtil;

public class ScreenRelatorio {

	public static void screenShortRelatorio(WebDriver driver) {
		File screenshort = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshort, new File("C:\\Users\\carlos.silva\\ToolsQA\\TDD\\TDD\\Screenshort/"
					+ Generator.dataHorParaArquvio() + ".png"));

		} catch (Exception e) {
			System.out.println("Houveram problemas ao copiar o arquivo para a pasta" + e.getMessage());

		}
	}
}
