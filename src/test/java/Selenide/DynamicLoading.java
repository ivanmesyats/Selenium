package Selenide;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicLoading {

    private SelenideElement hiddenResult = $x("//*[@id=\"content\"]/div/a[1]");
    private SelenideElement byFact = $x("//*[@id=\"content\"]/div/a[2]");

    private SelenideElement startButton = $x("//*[@id=\"start\"]/button");

    private SelenideElement loading = $x("//*[@id=\"loading\"]");

    private SelenideElement result = $x("//*[@id=\"finish\"]/h4");

    public DynamicLoading hiddenResultExec (){
        hiddenResult.click();
        return this;
    }

    public DynamicLoading byFact (){
        byFact.click();
        return this;
    }

    public DynamicLoading clickStart(){
        startButton.click();
        return this;
    }

    public DynamicLoading loading () {
        loading.shouldBe(hidden, Duration.ofSeconds(10000));
        return this;
    }

}
