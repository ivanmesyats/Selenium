import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTestClass {
    public WebDriver safariDriver;

    @BeforeEach
    public void init() {
        safariDriver = new SafariDriver();
        safariDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterEach
    public void clear(){
        safariDriver.quit();
    }
}
