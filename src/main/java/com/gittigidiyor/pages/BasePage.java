package com.gittigidiyor.pages;

import com.gittigidiyor.ReusuableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BasePage extends ReusuableMethods {
    By loginOrRegisterButtonBy = By.cssSelector("div[data-cy='header-user-menu']");
    By loginButtonBy = By.cssSelector("a[data-cy='header-login-button']");
    By searchBoxBy = By.className("sc-4995aq-0");

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }
    public LoginPage getLoginPage(){
        moveToElement(loginOrRegisterButtonBy);
        click(loginButtonBy, 10);
        return new LoginPage(webDriver);
    }
    public String getAccountText(){
        return getText(loginOrRegisterButtonBy);
    }
    public FindResultPage search(String keyword) {
        webDriver.findElement(searchBoxBy).sendKeys(keyword + Keys.ENTER);
        return new FindResultPage(webDriver);
    }


}