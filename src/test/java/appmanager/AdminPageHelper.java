package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminPageHelper extends HelperBase{

  public AdminPageHelper(WebDriver driver) {
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

  public boolean clickMenu(){
    // Находим все элементы, внутри бокового меню
    List<WebElement> menuWrappers = driver.findElements(By.id("box-apps-menu-wrapper"));

    for (WebElement menuWrapper : menuWrappers) {
      // Находим элементы меню
      List<WebElement> menuItems = menuWrapper.findElements(By.xpath(".//li[contains(@id,'app-')]"));

      // Перебираем элементы меню и нажимаем на каждый из них
      for (int i = 0; i < menuItems.size(); i++) {
        // Находим элемент заново перед каждым нажатием
        menuWrapper = driver.findElement(By.id("box-apps-menu-wrapper"));
        menuItems = menuWrapper.findElements(By.xpath(".//li[contains(@id,'app-')]"));
        WebElement menuItem = menuItems.get(i);
        menuItem.click(); // Нажатие на элемент меню

        // Вызываем функцию для обработки внутренних пунктов меню
        if (!handleSubMenu(driver)) {
          // Если заголовок не найден, прерываем программу
          return false;
        }
      }
    }
    return true;
  }

  private static boolean handleSubMenu(WebDriver driver) {

    try {
      // Находим элемент, содержащий внутренний список меню
      WebElement subMenuWrapper = driver.findElement(By.id("box-apps-menu-wrapper"));

      // Находим все элементы внутреннего списка меню
      List<WebElement> subMenuItems = subMenuWrapper.findElements(By.xpath(".//li[@class='selected']//ul[contains(@class,'docs')]//li"));

      // Перебираем элементы внутреннего списка меню и нажимаем на каждый из них
      for (int i = 0; i < subMenuItems.size(); i++) {
        // Находим элемент заново перед каждым нажатием
        subMenuWrapper = driver.findElement(By.id("box-apps-menu-wrapper"));
        subMenuItems = subMenuWrapper.findElements(By.xpath(".//li[@class='selected']//ul[contains(@class,'docs')]//li"));
        WebElement subMenuItem = subMenuItems.get(i);
        subMenuItem.click(); // Нажатие на элемент внутреннего списка меню
        try {
          // Проверяем наличие заголовка на странице
          WebElement pageTitle = driver.findElement(By.tagName("h1"));
        } catch (Exception e) {
          return false;
        }
      }
    } catch (Exception e) {
      // Если внутреннего меню нет, просто продолжаем выполнение
    }

    return true;
  }


}
