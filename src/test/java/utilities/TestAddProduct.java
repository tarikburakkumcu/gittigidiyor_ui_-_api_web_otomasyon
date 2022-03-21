package utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;

public class TestAddProduct extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    @Test
    @Order(1)
    public void signIntoWebPage() {
        homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.seeToMainPage(),"Home page is not opened");
        homePage.acceptCookies();
        homePage.signIn();
        Assertions.assertTrue(homePage.signInToMainPage(),"User is not entered");
    }
    @Test
    @Order(2)
    public void searchProduct() {
        homePage = new HomePage(driver);
        homePage.allBox();
        Assertions.assertTrue(homePage.categoryBoxIsSelected(),"Category box is not selected");
        homePage.searchBox();
    }
    @Test
    @Order(3)
    public void clickProduct() throws InterruptedException {
        homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.searchIsVerify(),"Search is not verify");
        productsPage = new ProductsPage(driver);
        Thread.sleep(2000);
    }
    @Test
    @Order(4)
    public void addProductToFavourites() throws InterruptedException {
        Thread.sleep(2000);
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.clickSecondProduct();
        Thread.sleep(2000);
        String productTitleName=productDetailPage.productTitle();
        System.out.println(productTitleName);
        Thread.sleep(2000);
        productDetailPage.addToList();
        Thread.sleep(2000);
        Assertions.assertEquals(productDetailPage.verifyToFavouriteList(),productTitleName);
        Thread.sleep(2000);
        productDetailPage.deleteProduct();
        Thread.sleep(2000);
        Assertions.assertTrue(productDetailPage.undoToAddedProduct(),"Product is not deleted");
        Thread.sleep(2000);
        productDetailPage.exitAccount();
        Thread.sleep(2000);
    }
}
