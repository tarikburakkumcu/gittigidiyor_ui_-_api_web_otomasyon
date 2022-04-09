package com.gittigidiyor.pages;

import com.gittigidiyor.kullaniciKapsülleme.kullanici;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    By userNameFieldBy = By.id("L-UserNameField");
    By passwordFieldBy = By.id("L-PasswordField");
    By loginButtonBy = By.id("gg-login-enter");
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    public MainPage login(kullanici kullanici) {
        sendKeys(userNameFieldBy, kullanici.getEmail(),false);
        sendKeys(passwordFieldBy, kullanici.getPassword(),true);
        //click(loginButtonBy, 15);
        MainPage MainPage = new MainPage(webDriver);
        MainPage.waitForLoad();
        return MainPage;
    }
}