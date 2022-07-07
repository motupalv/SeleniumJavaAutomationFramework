package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * This class has been created by Vigneshwar Motupalli on May 12, 2022
 */
public class BaseTest {

    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extentReports;
    public ExtentTest logger;

    @BeforeTest
    public void beforeTestMethod() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Sr.SDET", "Barathwaj Ravisankar");
    }


    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void beforeMethodMethod(String browserName, Method testMethod) {
        logger = extentReports.createTest(testMethod.getName());
        setupDriver(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void afterMethodMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case:" + methodName + "Passed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, markup);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case:" + methodName + "Failed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.PASS, markup);
        }
        driver.quit();
    }


    @AfterTest
    public void afterTestMethod() {
        extentReports.flush();
    }

    public void setupDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Barathwaj.Ravisankar\\IdeaProjects\\TestVagrantCodingAssignment\\drivers\\chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Barathwaj.Ravisankar\\IdeaProjects\\TestVagrantCodingAssignment\\drivers\\geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Barathwaj.Ravisankar\\IdeaProjects\\TestVagrantCodingAssignment\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }
}
