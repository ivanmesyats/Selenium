package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends BasePage{

    private By mainContent  = By.id("shopping_cart_container");

    private By mainContentNegativ = new By.ByClassName("error-button");

    private By sideBar = By.id("react-burger-menu-btn");

    private By sortBatton = By.className("product_sort_container");

    private By logOut = By.xpath("//*[@id=\"logout_sidebar_link\"]");

    private By src = By.xpath("//*[@id=\"logout_sidebar_link\"]");


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean getMainContentVisability () {
        return webDriver.findElement(mainContent).isDisplayed();
    }

    public boolean getMainContentVisabilityNegative () {
        return webDriver.findElement(mainContentNegativ).isDisplayed();
    }

    public MainPage sideBar (){
        webDriver.findElement(sideBar).click();
        return new MainPage(webDriver);
    }

    public MainPage logOut (){
        webDriver.findElement(logOut).click();
        return new MainPage(webDriver);
    }

    public MainPage sortByPrice (){
        webDriver.findElement(sortBatton).click();
        Select dropDown = new Select(webDriver.findElement(sortBatton));
        dropDown.selectByIndex(3);
        return new MainPage(webDriver);
    }


}
