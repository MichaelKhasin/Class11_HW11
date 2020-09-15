import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Enter https://dgotlieb.github.io/Navigation/Navigation.html
//• Press on “Show alert” button and print alert text.
//• Press on “Show prompt” button, fill your name and assert result.
//• Press on “Show confirm box” button, press on one button and
//assert result accordingly.
//• Open new tab and go back to main tab.
//• Open new window and go back to main window

public class Exercise3 {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "E:\\QA_Automation_Java\\chromedriver_win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://dgotlieb.github.io/Navigation/Navigation.html");
    }

    @Test
    public void test01_alert()  {
        driver.findElement(By.id("MyAlert")).click();
        System.out.println(driver.switchTo().alert().getText());

        System.out.println(Util.getOS() + "  " + Util.getcurrentDate());
    }

    @Test
    public void test02_prompt()  {
        try {
            driver.findElement(By.id("MyPrompt")).click();
            driver.switchTo().alert().sendKeys("Misha");
            driver.switchTo().alert().accept();
            Assert.assertEquals("Misha", driver.findElement(By.id("output")).getText());
        }
        catch (UnhandledAlertException e) {
            e.printStackTrace();
        }
        System.out.println(Util.getOS() + "  " + Util.getcurrentDate());

    }

    @Test
    public void test03_confirm()  {
        driver.findElement(By.id("MyConfirm")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals("Confirmed", driver.findElement(By.id("output")).getText());

        System.out.println(Util.getOS() + "  " + Util.getcurrentDate());
    }

    @Test
    public void test04_newTab()  {

        ((JavascriptExecutor)driver).executeScript("window.open()");
        //driver.findElement(By.xpath("/html/body")).sendKeys(Keys.CONTROL +"t");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        System.out.println(Util.getOS() + "  " + Util.getcurrentDate());
         }

    @Test
    public void test05_newWindow()  {

//        new Actions(driver).sendKeys(Keys.CONTROL +"n").perform();

//        WebElement currentElement = driver.switchTo().activeElement();
//        currentElement.sendKeys(Keys.CONTROL +"l");
//
//        ((JavascriptExecutor)driver).executeScript("window.open()");
//        //driver.findElement(By.xpath("/html/body")).sendKeys(Keys.CONTROL +"t");
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(0));

    }


}
