package com.gittigidiyor;

import com.gittigidiyor.kullaniciKapsülleme.kullanici;
import com.gittigidiyor.pages.*;
import com.gittigidiyor.utilities.BaseTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.OrderWith;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;

public class TestCase extends BaseTest {
    @Test
    public void gittiGidiyorTest() throws InterruptedException {
        String title = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
        String email = "tahrik1799@gmail.com";
        String password = "tariktestinium99";
//        "mertarann@hotmail.com"
//        "testiniummert98"


        MainPage mainPage = new MainPage(webDriver);
        String webDriverTitle = mainPage.getHomePageTitle();
        Log4j.info("Title: " + webDriverTitle);
        assertEquals(webDriverTitle, title);
        Log4j.info("Giriş sayfasına gidiliyor");

        LoginPage loginPage = mainPage.getLoginPage();
        Log4j.info("email: " + email + ", password: " + password);
        kullanici kullanici = new kullanici(email, password);
        loginPage.login(kullanici);
        Log4j.info("Ana sayfaya gidiliyor");
        String accountButtonText = mainPage.getAccountText();
        Log4j.info("Hesabım: " + accountButtonText);
        assertTrue(accountButtonText.contains("Hesabım"));
        Log4j.info("'bilgisayar'kelimesi aratılıyor");

        FindResultPage findResultPage = mainPage.search("bilgisayar");
        findResultPage.scrollToPage("7200");
        Log4j.info("Seçilen sayfa açılıyor.");
        findResultPage.choosePage("2");
        assertTrue(webDriver.getCurrentUrl().contains("2"));
        Log4j.info("Ürün detay sayfasına gidiliyor");

        ProductDetailPage productDetailPage = findResultPage.goToProductDetails();
        Log4j.info("Ürün fiyat bilgisi alınıyor");
        String productPrice = productDetailPage.productPrice();
        productDetailPage.scrollToPage("200");
        Log4j.info("Seçilen ürün sepete eklendi");
        productDetailPage.addToBasket();
        Log4j.info("Sepetim sayfasına gidiliyor.");

        CartPage cartPage = productDetailPage.goToBasket();
        Log4j.info("Ürün sayfasındaki fiyat, sepetteki ürünün fiyatı ile karşılaştırılırıyor.");
        webDriver.get("https://www.gittigidiyor.com/sepetim");
        Log4j.info("ürün sayısı arttırılıyor.");
        cartPage.setNumberOfProducts();
        Thread.sleep(2000);
        assertTrue(cartPage.getTotalProduct().contains("2 Adet"));
        Log4j.info("ürün sepetten silindi.");
        cartPage.deleteProduct();
        Thread.sleep(10000);
        String sepetMesaj = "Sepetinizde ürün bulunmamaktadır.";
        Log4j.info("Sepetin boş olduğu kontrol ediliyor");
        assertEquals(sepetMesaj, cartPage.isEmpty());
        webDriver.quit();
    }
}