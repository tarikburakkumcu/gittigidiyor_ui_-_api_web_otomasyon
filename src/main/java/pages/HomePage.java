package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    By seeSignInLocator = By.id("nav-link-accountList-nav-line-1");
    By acceptCookiesLocator = By.id("sp-cc-accept");
    By helloSignInLocator = By.id("nav-link-accountList");
    By enterMailLocator = By.xpath("//input[@id='ap_email']");
    By enterPasswordLocator = By.xpath("//input[@id='ap_password']");
    By enterVerifyLocator = By.id("nav-link-accountList-nav-line-1");
    By allBoxLocator = By.id("searchDropdownBox");
    By computersBoxLocator = By.xpath("//option[@value='search-alias=computers']");
    By searchBoxLocator = By.id("twotabsearchtextbox");
    By searchResultsLocator = By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public boolean seeToMainPage() {
        return isDisplayed(seeSignInLocator);
    }
    public void acceptCookies() {
        click(acceptCookiesLocator);
    }
    public void signIn() {
        click(helloSignInLocator);
        type(enterMailLocator,"tahrik1799@gmail.com" + Keys.ENTER);
        type(enterPasswordLocator,"Test*Log4j" + Keys.ENTER);
    }
    public boolean signInToMainPage() {
        return isDisplayed(enterVerifyLocator);
    }
    public void allBox() {
        click(allBoxLocator);
        isArrowsActions();
    }
    public boolean categoryBoxIsSelected() {
        return isDisplayed(computersBoxLocator);
    }
    public void searchBox() {
        type(searchBoxLocator,"msi" + Keys.ENTER);
    }
    public boolean searchIsVerify() {
        return isDisplayed(searchResultsLocator);
    }




}
