package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.function.Supplier;

public class LogInTestDefinition {

    private ChromeDriver chromeDriver;
    @Before()
   public void init() {

        chromeDriver = new ChromeDriver();

   }

    @Given("I am open the login page")
    public void oi_am_open_the_login_page() {
        chromeDriver.get("https://www.saucedemo.com");
    }

    @When("I am inputin my {string}")
    public void i_am_inputin_my_username(String username) {
        chromeDriver.findElement(By.id("user-name")).sendKeys(username);
    }
    @When("I am inputing my password")
    public void i_am_inputing_my_password() {
        chromeDriver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click subbmit button")
    public void click_subbmit_button() {
        chromeDriver.findElement(By.id("login-button")).click();
    }

    @Then("Main page is displayed")
    public void main_page() {
        Assertions.assertTrue(chromeDriver.findElement(By.className("app_logo")).isDisplayed());
    }

    @After()
    public void quit() {
        chromeDriver.quit();
    }




}
