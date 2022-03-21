package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{

    By seeSignInLocator = By.xpath("//a[text()='2']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void goToSecondPage() {
        isPageDown();
        click(seeSignInLocator);
    }
    public String secondPageIsOpened() {
        String secondPage = driver.getCurrentUrl();
        return secondPage;
    }

}
