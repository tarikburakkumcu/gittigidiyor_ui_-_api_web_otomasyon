package com.gittigidiyor.ui.utilities;

import com.gittigidiyor.Log4j;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver webDriver;
    @BeforeMethod
    public void setup(){
        Log4j.info("Test başladı");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.gittigidiyor.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        Log4j.info("Sayfa açılıyor ");
    }

    @AfterMethod
    public void tearDown() {
        Log4j.info("Test bitti.");
    }
}
