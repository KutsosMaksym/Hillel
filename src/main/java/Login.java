import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    static void login ( WebDriver browser ) throws InterruptedException {
        browser.get("http://jira.hillel.it:8080/secure/Dashboard.jspa");
        browser.findElement(By.cssSelector("input[id=login-form-username]")).sendKeys("autorob");
        browser.findElement(By.cssSelector("input[id=login-form-password]")).sendKeys("forautotests");
        browser.findElement(By.cssSelector("input[id=login]")).click();
        Thread.sleep(7000);
    }
}
