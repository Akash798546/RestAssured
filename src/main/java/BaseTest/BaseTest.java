package BaseTest;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	
	static RequestSpecification res;
	static Response response;
	
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
	
	public static void setBookStoreBaseUri()
	
	{
		RestAssured.baseURI="https://bookstore.toolsqa.com/swagger/";
		res=RestAssured.given();
	}
	
	public static void getStatusCode()
	{
		int statuscode= response.getStatusCode();
		 System.out.println("The Status code is --- "+statuscode);
	}
	
	public static void getResponseBody()
	{
		String resbody=response.getBody().asPrettyString();
		System.out.println("The Response body is ---");
		System.out.println(resbody);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		extent.flush();
	}

}
