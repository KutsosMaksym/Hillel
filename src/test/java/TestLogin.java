
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestLogin {




    @Test
    public void loginTest() throws InterruptedException {
        WebDriver browser =  new ChromeDriver();

        Login.login(browser);
        Thread.sleep(7000);
        Assert.assertTrue(browser.findElements(By.id("create_link")).size()!=0, "Login failed");
      //  browser.quit();
    }
}
