package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SortByPriceDefinition {

    private ChromeDriver chromeDriver;
    @Before()
    public void init() {

        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        chromeDriver.get("https://www.saucedemo.com");
        chromeDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        chromeDriver.findElement(By.id("password")).sendKeys("secret_sauce");

    }

    @Given("I am opening main page")
    public void oi_am_open_main_page() {
        chromeDriver.findElement(By.id("login-button")).click();
    }

    @When("I am sorting goods by price")
    public void i_am_sorting_goods_by_price() {
        chromeDriver.findElement(By.className("product_sort_container")).click();
        Select dropDown = new Select(chromeDriver.findElement(By.className("product_sort_container")));
        dropDown.selectByIndex(3);
    }
    @Then("Goods are storetd by price from higest to lowest")
    public void goodsAreSorted() {
        List<WebElement> results = chromeDriver.findElements(By.className("inventory_item_price"));

        double first, second;
        for (int i = 0; i < results.size()-1; i++) {

            first = Double.valueOf(results.get(i).getText().substring(1));
            second = Double.valueOf(results.get(i + 1).getText().substring(1));
            Assertions.assertTrue(first >= second);
        }
    }

    @After()
    public void quit() {
        chromeDriver.quit();
    }
}
