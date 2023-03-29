package com.yourstore.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.yourstore.base.Baseclass;

public class ExtentRepoters  extends Baseclass {
	public static ExtentReports genrateExtentReport()   {
		ExtentReports extentReport =new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+".//test-output/extentreports/extentreports.html");
		ExtentHtmlReporter  html=new ExtentHtmlReporter(extentReportFile);
		html.config().setTheme( Theme.DARK);
		html.config().setReportName("Ninja Project Test Results");
		html.config().setDocumentTitle("Project Test Results Report");
		html.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentReport.attachReporter(html);
		Properties congfigPro=new Properties();
		File configPropFile=new File (System.getProperty("user.dir")+".//src/test/java/com/yourstore/config/config.properties");
		
		
		try {
			FileInputStream fis =new FileInputStream(configPropFile);
			
			congfigPro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentReport.setSystemInfo("Application URL", congfigPro.getProperty("testURL"));
		extentReport.setSystemInfo("Browser Name", congfigPro.getProperty("browser"));
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("Username",System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
		
		return extentReport;
				
	}

}
 


