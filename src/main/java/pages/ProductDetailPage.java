package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class ProductDetailPage extends BasePage {
    By productTitleName = By.id("productTitle");
    By selectProduct = By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]");
    By addToNewList = By.id("add-to-wishlist-button-submit");
    By goTheList = By.xpath("//a[@class='a-button-text']");
    By verifyToNewList = By.xpath("(//a[@class='a-link-normal'])[11]");
    By verifyToListName = By.xpath("(//span[text()='Favori Listem'])[2]");
    By toDeleteProduct = By.name("submit.deleteItem");
    By toVerifyToDeleteProduct = By.id("undo-delete");
    By toOpenMenu = By.id("nav-hamburger-menu");
    By toExitAccount = By.xpath("(//a[@class='hmenu-item'])[30]");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public String verifyList() {
        String secondProductVerify = find(verifyToListName).getText() ;
        return secondProductVerify;
    }
    public String verifyToFavouriteList() {
        String listNameVerify = find(verifyToNewList).getText();
        return listNameVerify;
    }
    public void deleteProduct() {
        click(toDeleteProduct);
    }
    public boolean undoToAddedProduct() {
        return isDisplayed(toVerifyToDeleteProduct);
    }
    public void exitAccount() throws InterruptedException {
        click(toOpenMenu);
        Thread.sleep(2000);
        click(toExitAccount);
    }
    public void clickSecondProduct()  {
        click(selectProduct);
    }
    public String productTitle() {
        String productName =find(productTitleName).getText();
        return productName;
    }
    public void addToList() throws InterruptedException {
        click(addToNewList);
        Thread.sleep(1000);
        click(goTheList);

    }
}
