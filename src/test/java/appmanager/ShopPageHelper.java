package appmanager;

import org.openqa.selenium.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopPageHelper extends HelperBase{

  public ShopPageHelper(WebDriver driver) {
    super(driver);
  }

  public boolean isElementPresent(By locator) {
    try{
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public void goTo(String namePage){

    click(By.xpath("//span[text()='"+namePage+"']"));
  }

  public void goToSubPage(String namePage){
    click(By.xpath("//span[text()='"+namePage+"']"));
    assertTrue(namePage.equals(isOnPage(By.xpath("//h1"))));
  }

  public void goToSubPage(String namePage, String title){
    click(By.xpath("//span[text()='"+namePage+"']"));
    assertTrue(title.equals(isOnPage(By.xpath("//h1"))));
  }

  public boolean onlyOneStickerExist (){
    // Находим все элементы товаров на странице
    List<WebElement> products = driver.findElements(By.className("product"));

    for (WebElement product : products) {

      // Проверяем, что у каждого товара имеется ровно один стикер
      List<WebElement> sticker = product.findElements(By.className("sticker"));
      if (sticker.size() != 1) {
        return false;
      }
    }
    return true;
  }


}
