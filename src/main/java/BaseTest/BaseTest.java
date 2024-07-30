package BaseTest;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	
	static ExtentTest test;
	static ExtentReports extent;
	public static ExtentReports getReport()
	{
		if(extent==null)
		{
			extent=new ExtentReports();
			ExtentSparkReporter spark=new ExtentSparkReporter("Extent_Report.html");
			spark.config().setTheme(Theme.DARK);
			spark.config().setReportName("Rest Assured Report");
			extent.attachReporter(spark);
		}
		return extent;
	}
	
	@BeforeMethod
	public void InitialingMethod(ITestResult result)
	{
		extent = BaseTest.getReport();
		test = extent.createTest(result.getMethod().getMethodName().toUpperCase());
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		extent.flush();
	}

}
