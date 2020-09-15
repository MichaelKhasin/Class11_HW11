import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//  Using ngWebDriver
//(https://github.com/paul-hammant/ngWebDriver)
//
// Enter https://dgotlieb.github.io/AngularJS/main.html
// Clear first name.
// Enter your first name instead.
// Assert result.

public class Exercise2 {

    private static ChromeDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "E:\\QA_Automation_Java\\chromedriver_win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        NgWebDriver ngWebDriver = new NgWebDriver(driver);
        ngWebDriver.waitForAngularRequestsToFinish();
        driver.get("https://dgotlieb.github.io/AngularJS/main.html");
    }

    @Test
    public void test01_exercise2()  {
        driver.findElement(ByAngular.model("firstName")).clear();
        driver.findElement(ByAngular.model("firstName")).sendKeys("Michael");
        Assert.assertEquals("Michael",driver.findElement(ByAngular.binding("firstName")).getText());

        System.out.println(Util.getOS() + "  " + Util.getcurrentDate());

    }

}
