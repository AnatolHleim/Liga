import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.DriverType;

public abstract class BaseTestClass {

    protected WebDriver driver;

    @Before()
    public void beforeClass() {
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @After()
    public void afterClass() {
        driver.quit();
    }
}