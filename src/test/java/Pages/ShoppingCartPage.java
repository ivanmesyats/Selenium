package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage{

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement firstBuy;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement secondBuy;

    @FindBy(id = "shopping_cart_container")
    private WebElement navigateToCart;


    public ShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public MainPage addGoodsToCart () {
            firstBuy.click();
            secondBuy.click();
            navigateToCart.click();
            return new MainPage(webDriver);
        }

}
