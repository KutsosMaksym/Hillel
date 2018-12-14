import TestRailApi.APIException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;


public class AppTest extends TestBase {

    JiraMethods methods;

    @BeforeClass
    public void init() throws IOException, APIException {
        methods = PageFactory.initElements(browser, JiraMethods.class);
   //     testRail.createRun();
    }

    //
    @Test (priority = 1)
    public void succedLogin() {
        methods.login(browser, true);
    }

  /*  @Test (priority = 2)
    public void createIssue () throws InterruptedException {
        methods.CreateIssue();
        Assert.assertFalse(browser.findElements(By.cssSelector("a.issue-created-key.issue-link")).isEmpty());
    }

    @Test(priority = 3)
    public void openIssue() {
        methods.openIssue();
        //  Assert.assertTrue(browser.findElements(By.cssSelector("input#summary")).get(0).getAttribute("value").equals(summary)); // Why doesn't work?? There is no such elements
    }

    @Test (priority = 4)
    public void uploadFile () throws InterruptedException {
        methods.uploadFile();
        Thread.sleep(5000); // ToDo add customized sleep
        Assert.assertTrue(browser.findElements(By.cssSelector("a.attachment-title")).get(0).getAttribute("file-preview-title").equals("hpi.jpg"));//ToDO hpi.jpg
    }

    @Test (priority = 5)
    public void downloadFile () throws InterruptedException {
        methods.downloadFile();
    }*/
}
