
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTestClass {


    @Test
    public void verifyLogin() {
        safariDriver.get("https://www.saucedemo.com");

        boolean loginSuccssefull = new LoginPage(safariDriver)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .submit()
                .getMainContentVisability();

        Assertions.assertTrue(loginSuccssefull);

//        webDriver.quit();
    }

    @Test
    public void verifyLoginNegative() {
        safariDriver.get("https://www.saucedemo.com");

        boolean loginUnSuccssefull = new LoginPage(safariDriver)
                .enterUserName("locked_out_user")
                .enterPassword("secret_sauce")
                .submit()
                .getMainContentVisabilityNegative();

        Assertions.assertTrue(loginUnSuccssefull);

    }

        @Test
        public void verifyLoginOut () throws InterruptedException {
            safariDriver.get("https://www.saucedemo.com");

            new LoginPage(safariDriver)
                    .enterUserName("performance_glitch_user")
                    .enterPassword("secret_sauce")
                    .submit()
                    .sideBar();

            WaitersUtil.fluentWaiter(safariDriver,By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();



            Assertions.assertTrue(safariDriver.getTitle().equals("Swag Labs") );


        }
    }
