import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebCalculator {

    private static WebDriver driver;

    // Singleton driver instantiation
    public WebCalculator(){
        driver = DriverSingleton.getDriverInstance();
    }

    public static void getUrl(String url) {
        driver.get(url);
    }

    public void sevenDimensions(){
        WebElement we = driver.findElement(By.id(Constants.seven_ID_locator));
        System.out.println(we.getRect().getX());
        System.out.println(we.getRect().getY());
    }
    public void isSixDisplayed(){
        WebElement we1 = driver.findElement(By.id(Constants.six_ID_locator));
        System.out.println("Is displayed is " + we1.isDisplayed());
    }

    public void mathAndAssert() {
        String str = "7";
        WebElement myfive = driver.findElement(By.id("five"));
        myfive.click();
        WebElement myadd = driver.findElement(By.id("add"));
        myadd.click();
        WebElement mytwo = driver.findElement(By.id("two"));
        mytwo.click();
        WebElement myequal = driver.findElement(By.id("equal"));
        myequal.click();

        WebElement myscreen = driver.findElement(By.id("screen"));
        Assert.assertEquals(str, myscreen.getText());
    }
}

