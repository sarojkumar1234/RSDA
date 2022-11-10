package RSDA.RSDAAPP.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class RSDAREPORTS {
	
	static ExtentReports  extent;
	public static ExtentReports reportconfig()
	{

		ExtentSparkReporter reports=new ExtentSparkReporter(System.getProperty("user.dir")+"/src/RSDA_REPORTS");
		reports.config().setReportName("RSDA_APP_AUTOMATION_REPORT");
		reports.config().setDocumentTitle("RSDA APP RESULTS");
		 extent=new ExtentReports();
		extent.attachReporter(reports);
		return extent;
	}
	

}
