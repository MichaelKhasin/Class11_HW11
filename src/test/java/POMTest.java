import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class POMTest extends WebCalculator{


    @BeforeClass
    public static void runOnceBeforeClass() {
        getUrl("https://dgotlieb.github.io/WebCalculator/");
    }

    @Test
    public void test01() {
       sevenDimensions();
       isSixDisplayed();
       mathAndAssert();


    }

}
