package com.BHEd.Listeners;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	
	static ExtentReports report;
	
	public static ExtentReports setupExtentReport() {
		
		SimpleDateFormat format= new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();
		String actualDate=format.format(date);
		
//		String reportPath = System.getProperty("user.dir")+
//				"/Reports/BHEdExtentReport.html";
		String reportPath = System.getProperty("user.dir")+
				"/Reports/BHEdExtentReport.html";
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

		report = new ExtentReports();
		report.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("Automation Report");
		sparkReport.config().setTheme(Theme.DARK);
		//sparkReport.config().setReportName("Extent Report");
		try {
			sparkReport.loadXMLConfig("D:\\SAMSBHEd2021\\logoconfig.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//sparkReport.loadXMLConfig(new File("extent.xml"));
		
		//Desktop.getDesktop().browse(new File("D:\\SAMSBHEd2021\\Reports\\LogoTest.html").toURI());
		
//		report.setSystemInfo("Executed on Environment:",System.getProperty(constants.url));
//		report.setSystemInfo("Executed on Browser:", System.getProperty(constants.browser));
		report.setSystemInfo("Executed on OS:", System.getProperty("os.name"));
		report.setSystemInfo("Executed by User:", System.getProperty("user.name"));
		
		return report;
		
	}

}
