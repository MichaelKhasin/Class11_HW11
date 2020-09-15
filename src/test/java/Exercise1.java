import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

// Enter https://dgotlieb.github.io/Selenium/synchronization.html
// Press on “remove checkbox” button and find the new element
//that will show up under the CheckBox - use Implicit Wait.
// Press on “Show hidden” button and find the new element that
//will replace the “Show hidden” button - use Thread.sleep().
// Press on “render” button and find the new element that will
//show under “render” button – use Explicit Wait. 

public class Exercise1 {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "E:\\QA_Automation_Java\\chromedriver_win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");
    }

    @Test
    public void test01_exercise1() throws InterruptedException {
        driver.findElement(By.id("btn")).click();
        driver.findElement(By.id("message"));

        driver.findElement(By.id("hidden")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("finish1"));

        driver.findElement(By.id("rendered")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));

        System.out.println(Util.getOS() + "  " + Util.getcurrentDate());

    }

}
