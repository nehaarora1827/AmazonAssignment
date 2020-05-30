package com.nagarro.selenium.Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	private static ExtentReports report;
	private static String reportFileName = "Test-Extent-Report" + ".html";
	private static String reportFilepath = System.getProperty("user.dir") + "//ExtentReport";
	private static String reportFileLocation = reportFilepath + "//" + reportFileName;

	// Create an extent report instance
	public static ExtentReports getInstance() {
		if (report == null) {
			String fileName = getReportPath(reportFilepath);

			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
			report = new ExtentReports();
			// Set environment details
			report.setSystemInfo("Host Name", "Neha");
			report.setSystemInfo("Environment", "Test");
			report.setSystemInfo("User Name", "Neha Arora");
			report.attachReporter(htmlReporter);
		}

		return report;
	}

	// Create the report path
	private static String getReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!");
				return reportFileLocation;
			} else {
				System.out.println("Failed to create directory: " + path);
				return System.getProperty("user.dir");
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
		return reportFileLocation;
	}

}