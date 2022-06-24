package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTestReporter {

	public static ExtentReports reports;

	public static ExtentReports getExtentReportObject() {
		String path = System.getProperty("user.dir") + "\\ExtentReports\\index.html";

		ExtentSparkReporter extReporter = new ExtentSparkReporter(path);
		extReporter.config().setReportName("Detailed Report");
		extReporter.config().setDocumentTitle("E2E Project");

		reports = new ExtentReports();
		reports.attachReporter(extReporter); // Here we are giving the information about the config changes which we did
		reports.setSystemInfo("Tester Name", "Priyank Khard");
		return reports;
	}

}
