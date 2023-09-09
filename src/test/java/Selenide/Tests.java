package Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Tests {

    @Test
    public void test() throws InterruptedException {
        Configuration.browser = "Safari";
        Selenide.open("https://the-internet.herokuapp.com/dynamic_loading");

        new DynamicLoading()
                .hiddenResultExec()
                .clickStart()
                .loading();

        Assertions.assertTrue($x("//*[@id=\"finish\"]/h4").is(visible));

    }

    @Test
    public void test2() throws InterruptedException {
        Configuration.browser = "Safari";
        Selenide.open("https://the-internet.herokuapp.com/dynamic_loading");

        new DynamicLoading()
                .byFact()
                .clickStart()
                .loading();

        var result = $x("//*[@id=\"finish\"]/h4").shouldBe(appear, Duration.ofSeconds(10000));

        Assertions.assertEquals("Hello World!",result.text());

    }
}
