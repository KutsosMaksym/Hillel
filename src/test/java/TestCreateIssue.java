import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestCreateIssue {
    static WebDriver browser = new ChromeDriver();
    static Date date = new Date();
    static String summary = "Summary " + date;

    public static void main(String[] args) throws InterruptedException {

        Login.login(browser);
        browser.findElement(By.cssSelector("a#create_link")).click(); // click by "Create"
        Thread.sleep(5000);
        browser.findElement(By.cssSelector("input[id=issuetype-field]")).sendKeys("Test\n"); // Select issue Type
        Thread.sleep(2000);
        browser.findElement(By.cssSelector("input[id=summary]")).sendKeys(summary); // Fill summary field with unique data summary + current date
        browser.findElement(By.cssSelector("input[id=create-issue-submit]")).click(); //click create issue
        Thread.sleep(6000);
        ///browser.findElement(By.cssSelector("a#issue-created-key issue-link")).click();

        List<WebElement> linkNewIssues = browser.findElements(By.cssSelector("a.issue-created-key.issue-link"));

        Thread.sleep(5000);


//        browser.findElement(By.cssSelector("input[id=create-issue-submit]")).click();

        //  browser.quit();
    }
}
