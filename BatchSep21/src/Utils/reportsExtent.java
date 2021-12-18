package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reportsExtent {

	static ExtentReports extent;
	static ExtentSparkReporter sparkReporter;

	public static void htmlStartReport() {
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("Report.xml");
		extent.attachReporter(sparkReporter);
	}

	public static void htmlEndReport() {
		extent.flush();
	}

}
