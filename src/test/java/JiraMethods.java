import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Date;

public class JiraMethods {
    WebDriver browser;
    String summary = "summary " + new Date();
    private String linkToIssue;
    private String linkToAttachment;
//
//    @FindBy(css = "input#login-form-username")
//    private WebElement usernameField;


    public JiraMethods(WebDriver browser) {
        this.browser = browser;
    }

    public void login(WebDriver browser, boolean isLoginSucced) {
        browser.get("http://jira.hillel.it:8080/secure/Dashboard.jspa");
        browser.findElement(By.cssSelector("input#login-form-username")).sendKeys("autorob");
        if (isLoginSucced) {
            browser.findElement(By.cssSelector("input#login-form-password")).sendKeys("forautotests");
        } else {
            browser.findElement(By.cssSelector("input#login-form-password")).sendKeys("forautotests2");
        }
        browser.findElement(By.cssSelector("input#login")).click();
        Assert.assertTrue(browser.findElement(By.cssSelector("a#header-details-user-fullname")).getAttribute("data-username").equals("autorob"));//  ToDo create separate  method and call it in the AppTest
    }

    public void CreateIssue() throws InterruptedException {
        browser.findElement(By.cssSelector("a#create_link")).click();
        browser.findElement(By.cssSelector("input#project-field")).sendKeys("General QA Robert (GQR)\n");
        Thread.sleep(4000);
        browser.findElement(By.cssSelector("input#summary")).sendKeys(summary);
        browser.findElement(By.cssSelector("input#create-issue-submit")).click();
        linkToIssue = browser.findElements(By.cssSelector("a.issue-created-key.issue-link")).get(0).getAttribute("href");
    }

    public void openIssue() {
        browser.get(linkToIssue);
        //  Assert.assertTrue(browser.findElements(By.cssSelector("input#summary")).get(0).getAttribute("value").equals(summary)); // Why doesn't work?? There is no such elements
        browser.getTitle().contains(summary);
    }

    public void uploadFile() throws InterruptedException {
        browser.findElement(By.cssSelector("input.issue-drop-zone__file.ignore-inline-attach")).sendKeys("d:/TestData/hpi.jpg"); // ToDo split path and name of file
        Thread.sleep(5000); // ToDo add customized sleep
        linkToAttachment = browser.findElements(By.cssSelector("a.attachment-title")).get(0).getAttribute("href");
    }

    public void downloadFile() throws InterruptedException {
        browser.findElements(By.cssSelector("a.attachment-title")).get(0).click();
        Thread.sleep(8000);
        browser.findElement(By.cssSelector("a#cp-control-panel-download")).click();
        //   browser.findElement(By.cssSelector("a#cp-control-panel-download")).click();
        //    browser.get(linkToAttachment);
        //    browser.findElements(By.cssSelector())

    }

}
