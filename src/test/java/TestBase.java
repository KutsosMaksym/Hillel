import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver browser;
    public static Helper h;
    public static TestRail testRail;
    public static Map<String,Boolean> testResults = new HashMap();

    @BeforeTest
    public static void openBrowser() {
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        testRail = new TestRail();
    }

    @AfterTest
    public static void closeBrowser() {
       // browser.quit();
    }
    @AfterMethod
    public static void reportDebugInfo(ITestResult testResult) {
        String info = "";
        info += testResult.getMethod().getMethodName();
        info += ": ";
        info += testResult.isSuccess() ? "passed." : "failed.";
        testResults.put(testResult.getMethod().getMethodName(), testResult.isSuccess() );
    }
    @AfterClass
    public  static void reportTestResults(){
        for (Map.Entry entry : testResults.entrySet()){
            System.out.println(entry.getKey() + " is " + entry.getValue());
        }
    }
    @AfterClass
    public static void saveTestResultsIntoTestRail () {

    }
}
