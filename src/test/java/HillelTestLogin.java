
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class HillelTestLogin {


    static WebDriver browser =  new ChromeDriver();




    public static void main(String[] args) throws InterruptedException {
        browser.manage().window().maximize(); // full screen
        browser.get("http://jira.hillel.it:8080/secure/Dashboard.jspa");
        browser.findElement(By.cssSelector("input[id=login-form-username]")).sendKeys("autorob");
        browser.findElement(By.cssSelector("input[id=login-form-password]")).sendKeys("forautotests");
        browser.findElement(By.cssSelector("input[id=login]")).click();
        Thread.sleep(7000);
        Login.login(browser);

//ToDo
      //  assertFalse("Login failed",browser.findElements(By.id("create_link")).size()==0); // check: Create link is present after login
        Thread.sleep(7000);

        //  browser.quit();
    }
}
