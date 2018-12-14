import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AppTest1023 {
    static WebDriver browser;
    static String currentDate = "Summary " + new Date();

    @BeforeTest
    public static void OpenBrowser()
    {
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

    }

    @Test (priority = 1)
    public static void LoginSucceed()
    {

        browser.get(("http://jira.hillel.it:8080/secure/Dashboard.jspa"));
        browser.findElement(By.cssSelector("input#login-form-username")).sendKeys("autorob");
        browser.findElement(By.cssSelector("input#login-form-password")).sendKeys("forautotests");
        browser.findElement(By.cssSelector("input#login")).click();
        Assert.assertTrue(browser.findElements(By.id("create_link")).size()!=0, "Login failed"); // TODO
    }

    @Test (priority = 2)
    public static void CreateIssue() throws InterruptedException {
        browser.findElement(By.cssSelector("a#create_link")).click();
        browser.findElement(By.cssSelector("input#project-field")).sendKeys("General QA Robert (GQR)");
        Thread.sleep(8000);
        browser.findElement(By.cssSelector("input#summary")).sendKeys(currentDate);
        browser.findElement(By.cssSelector("input#create-issue-submit")).click();
        Assert.assertTrue(browser.findElements(By.id("create_link")).size()!=0, "Login failed"); // TODO
    }
}
