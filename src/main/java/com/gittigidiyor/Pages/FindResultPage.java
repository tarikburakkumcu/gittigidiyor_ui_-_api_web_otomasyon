package com.gittigidiyor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class FindResultPage extends BasePage{
    public FindResultPage(WebDriver webDriver) {
        super(webDriver);
    }
    public By randomSelectProductBy()
    {
        Random random = new Random();
        int randm = random.nextInt(5) + 1;
        return By.xpath("(//*[@data-testid='productImage'])[" + randm + "]");

    }
    public void choosePage(String pageNumber) {
        webDriver.get(webDriver.getCurrentUrl() + "&sf=" + pageNumber);
    }
    public ProductDetailPage goToProductDetails(){
        click (randomSelectProductBy(),10);
        return new ProductDetailPage(webDriver);
    }
}