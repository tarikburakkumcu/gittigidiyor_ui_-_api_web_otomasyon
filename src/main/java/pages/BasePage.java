package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BasePage {

    WebDriver driver ;

    public BasePage(WebDriver driver){
        this.driver = driver ;
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
    public void click(By locator){
        find(locator).click();
    }
    public void type(By locator,String text){
        find(locator).sendKeys(text);
    }
    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

//    public Select isSelected(By locator){
//        Select select = new Select((WebElement) locator);
//        return select;
//    }
    public void isActions(By locator){
        Actions actions = new Actions(driver);
        // actions.moveToElement((WebElement) locator);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
    }
    public void isPageDown(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        // actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
    }
    public void onePageDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
    }
    public void isArrowsActions(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                        .sendKeys(Keys.ENTER).perform();
    }
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        }
        catch (InterruptedException e) {
        }
    }
    public void isMoveTo(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement((WebElement) locator).perform();

    }

}
