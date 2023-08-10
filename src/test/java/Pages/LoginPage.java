package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By userNameInput = By.id("user-name");
    private By userPassInput = By.id("password");
    private By submitButton = By.id("login-button");
    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage enterUserName (String userName){
        webDriver.findElement(userNameInput).sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword (String userPassword){
        webDriver.findElement(userPassInput).sendKeys(userPassword);
        return this;
    }

    public MainPage submit (){
        webDriver.findElement(submitButton).click();
        return new MainPage(webDriver);
    }


}
