package BaseClass;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

import java.io.File;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

//New
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//New end

import Utility.Utilities;


public class BaseClass {
	
	//new variables
	public static ExtentSparkReporter esReporter;
	public static ExtentReports eReports;
	public Capabilities cap;
	public DateFormat df;
	public Date date;
	public static Logger log;
	public static String reportDir = "";
	public static String reportTimestamp = "";
	public static ExtentTest eTest;
	public File directory;
	public static Utilities utilityObj;
	public String projectFolder = System.getProperty("user.dir");
	public String log4jConfPath = projectFolder + "/src/test/resources/Log4j.properties";
	public String logPath = "";
	public static String currentDateTime = "";
	//vaariables end
	public static AndroidDriver<MobileElement> androidDriver;

	@BeforeSuite
	public void setUP() {
		
		try {
			mobileDriver();
			log = Logger.getLogger(BaseClass.class.getName());
		
			reportTimestamp = getCurrentDateTime();// for providing current data and time for log file, use the same
													// time stamp in report zip for relative path
			reportDir = "C:/DarsiniTeachers_Automation/Reports/Report_" + reportTimestamp;// creates report folder with time
																						// stamp
			System.setProperty("logPath", "C:/DarsiniTeachers_Automation/Logs/LogFile_");
			PropertyConfigurator.configure(log4jConfPath);// Configured log files path
			extendReport();
			utilityObj = new Utilities();
			utilityObj.createDirectoryIfNotExist();// for log, report, screenshot
			
			log.info("Page loaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//NEW METHOD
	
	//END METHODS

	public void mobileDriver() {
		for (int i = 0; i < 5; i++) {
			try {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps = new DesiredCapabilities();
				caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0.0");
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
				caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "900");
				caps.setCapability(MobileCapabilityType.APP,
						"E:\\\\Random Crap\\\\Work\\\\Downloads\\\\Darisni Teachers - v1.52 - UAT.apk");
				caps.setCapability("unicodeKeyboard", "true");                                     
				caps.setCapability("resetKeyboard", "true");
				// URL url = new URL("http://127.0.0.1:4723/wd/hub");
				androidDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
				break;
			} catch (SessionNotCreatedException e) {
				System.out.println("Error occurred while creating session, retrying...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deviceLoginCheck(WebElement element) {
		for (int i = 1; i < 5; i++) {
			WebDriverWait wait = new WebDriverWait(androidDriver, 20);

			System.out.println("upload");
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	}

	public void clickWait(WebElement element) {

		for (int i = 1; i < 5; i++) {
			WebDriverWait wait = new WebDriverWait(androidDriver, 20);

			System.out.println("Cannot be clicked yet");
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}

	public WebElement customXpathMethod(String customNameString) {

		WebElement customName = androidDriver
				.findElement(By.xpath("//android.widget.TextView[@text='" + customNameString + "']"));
		return customName;
	}

	public void scrollUpMob(int howManySwipes) {
		org.openqa.selenium.Dimension size = androidDriver.manage().window().getSize();
		int startVerticalY = (int) (size.height * 0.4);
		int endVerticalY = (int) (size.height * 0.21);
		int startVerticalX = (int) (size.width / 2.1);
		try {
			for (int i = 1; i <= howManySwipes; i++) {
				new TouchAction<>(androidDriver).press(point(startVerticalX, startVerticalY))
						.waitAction(waitOptions(ofSeconds(2))).moveTo(point(startVerticalX, endVerticalY)).release()
						.perform();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	private void extendReport() {
		try {
			log.info("Report initiated");
			esReporter = new ExtentSparkReporter(reportDir + "/TestReport_" + getCurrentDateTime()+ ".html");
			esReporter.config().setDocumentTitle("Automation Report");
			esReporter.config().setReportName("Darsini Automation Report");
			esReporter.config().setTheme(Theme.STANDARD);
			eReports = new ExtentReports();
			eReports.attachReporter(esReporter);
			eReports.setSystemInfo("Project Name", "salesBoost");
			eReports.setSystemInfo("Platform", System.getProperty("os.name"));
			eReports.setSystemInfo("Environment", "QA");
			eReports.setSystemInfo("Browser", cap.getBrowserName().substring(0, 1).toUpperCase()+ cap.getBrowserName().substring(1).toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//NEW METHDODS
	@AfterMethod
	public void testReportResult(ITestResult result) {
		try {
			log.info("Report status initiated");
			// Passed test status along with screenshot will captured here
			if (result.getStatus() == ITestResult.SUCCESS) {
				eTest.log(Status.PASS, "Test passed");
			}

			// Failed test status along with screenshot will captured here
			else if (result.getStatus() == ITestResult.FAILURE) {
				eTest.log(Status.FAIL, "Test failed");
			}

			// Skipped test status along with screenshot will captured here
			else if (result.getStatus() == ITestResult.SKIP) {
				eTest.log(Status.SKIP, "Test failed");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@AfterSuite
	public void endSuite() {
		try {
			eReports.flush();
			utilityObj.createZip(reportDir);
			androidDriver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private String getCurrentDateTime() {
		try {
			log.info("Current date and time");
			df = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
			date = new Date();
			System.setProperty("currentDateTime", df.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentDateTime = df.format(date);
	}

}
