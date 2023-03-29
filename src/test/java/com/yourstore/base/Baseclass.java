package com.yourstore.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.yourstore.utilites.Utilites;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public  static WebDriver driver;
	public  static Properties pro;
	public static  Actions action;
	public  Random rand;
	public  static Properties dataPro;

	@BeforeSuite
	public static void launchApplication() {
		DOMConfigurator.configure("log4j.xml");
		pro = new Properties();
		File proFile = new File(System.getProperty("user.dir") + ".//src/test/java/com/yourstore/config/config.properties");
		dataPro = new Properties();
		File dataFile = new File(
				System.getProperty("user.dir") + ".//src/test/java/com/yourstore/config/testdata.properties");

		try {
			FileInputStream dataFis = new FileInputStream(dataFile);
			dataPro.load(dataFis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream(proFile);
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	String browserName=pro.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}else if(browserName.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Utilites.PAGE_Load_TIME,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Utilites.IMPLICIT_WAIT_TIME,TimeUnit.SECONDS);
	driver.get("http://tutorialsninja.com/demo");
	action = new Actions(driver);

	
	}
	
	@AfterSuite
	public static void closeApplication() {
		driver.quit();
	}
}