import Pages.BasePage;
import Pages.LoginPage;
import Pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SortTest extends BaseTestClass {

    @Test
    public void sortGoodsByPrice() {
        safariDriver.get("https://www.saucedemo.com");

        MainPage loginSuccssefull = new LoginPage(safariDriver)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .submit()
                .sortByPrice();

        List<WebElement> results = safariDriver.findElements(By.className("inventory_item_price"));

        double first, second;
        for (int i = 0; i < results.size()-1; i++) {

            first = Double.valueOf(results.get(i).getText().substring(1));
            second = Double.valueOf(results.get(i+1).getText().substring(1));
            Assertions.assertTrue(first >= second);
        }



    }

    @Test
    public void checkGoodSame() {
        safariDriver.get("https://www.saucedemo.com");

        MainPage loginSuccssefull = new LoginPage(safariDriver)
                .enterUserName("problem_user")
                .enterPassword("secret_sauce")
                .submit();

        List<WebElement> results = safariDriver.findElements(By.className("inventory_item"));

        String first, second;
        for (int i = 0; i < results.size(); i++) {
            for (int j = i + 1; j < results.size(); j++) {
//            System.out.println(results.get(i).findElement(By.className("inventory_item_img")).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("src"));

                first = results.get(i).findElement(By.className("inventory_item_img")).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("src");
                second = results.get(j).findElement(By.className("inventory_item_img")).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("src");
                Assertions.assertTrue(first.equals(second));
            }
        }
    }

    @Test
    public void checkGoodNotSame() {
        safariDriver.get("https://www.saucedemo.com");

        MainPage loginSuccssefull = new LoginPage(safariDriver)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .submit();

        List<WebElement> results = safariDriver.findElements(By.className("inventory_item"));

        String first, second;
        for (int i = 0; i < results.size(); i++) {
            for (int j = i + 1; j < results.size(); j++) {
//            System.out.println(results.get(i).findElement(By.className("inventory_item_img")).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("src"));

                first = results.get(i).findElement(By.className("inventory_item_img")).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("src");
                second = results.get(j).findElement(By.className("inventory_item_img")).findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("src");
                Assertions.assertTrue(!first.equals(second));
            }
        }



    }

}

