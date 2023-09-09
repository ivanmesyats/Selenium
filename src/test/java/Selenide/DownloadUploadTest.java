package Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DownloadUploadTest {

    @Test
    public void uploadTest(){
        Configuration.browser="Safari";
//        Configuration.holdBrowserOpen=true;
        Selenide.open("https://the-internet.herokuapp.com/upload");

        File file = $(By.id("file-upload")).uploadFile(new File("src/test/java/resttests/LoginJSON"));
        $(By.id("file-submit")).click();

        Assertions.assertEquals("File Uploaded!",$x("//*[@id=\"content\"]/div/h3").text());
    }

    @Test
    public void downloadTest() throws FileNotFoundException {
        Configuration.browser="Safari";
//        Configuration.holdBrowserOpen=true;
        Selenide.open("https://the-internet.herokuapp.com/download");

       File file;
        file = $x("//*[@id=\"content\"]/div/a[2]").download();

        Assertions.assertTrue(file != null);
    }
}
