import Pages.LoginPage;
import Pages.ShoppingCartPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ShopingTest extends BaseTestClass{


    @Test
    public void countNumberOfGoodsInCart() {
        safariDriver.get("https://www.saucedemo.com");

        new LoginPage(safariDriver)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .submit();

        ShoppingCartPage buy = new ShoppingCartPage(safariDriver);

        buy.addGoodsToCart();

        var results = safariDriver.findElements(By.className("cart_quantity"));
        Integer test = 0;

       for (int i = 0; i < results.size(); i++){
           test += Integer.valueOf(results.get(i).getText().substring(0));

       }

       System.out.println(test);
        Assertions.assertEquals( 2, test);



    }
}
