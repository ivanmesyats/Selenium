package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasePage {

    public WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
