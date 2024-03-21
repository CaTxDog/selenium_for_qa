package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
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

  public boolean countrySorted() {

    // Открытие веб-страницы с таблицей
    driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

    // Найти все элементы в столбце "Name"
    List<WebElement> nameElements = driver.findElements(By.xpath("//table[@class='dataTable']//td[5]"));

    // Создание списка для хранения текстовых значений из столбца "Name"
    List<String> names = new ArrayList<>();

    // Получение текстовых значений и добавление их в список
    for (WebElement element : nameElements) {
      names.add(element.getText());
    }

    // Создание копии списка для сортировки
    List<String> sortedNames = new ArrayList<>(names);

    // Сортировка копии списка
    Collections.sort(sortedNames);

    // Проверка, что значения в столбце упорядочены по алфавиту
    if (!names.equals(sortedNames)) {
      return false;
    }
    return true;
  }

  public boolean countryZonesSort() {
    // Открытие страницы
    driver.get("http://localhost/litecart/admin/?app=countries");
    // Находим строки таблицы
    List<WebElement> countryRows = driver.findElements(By.xpath("//tr[@class='row']"));

    // Создаем список для хранения ссылок на страны зонами >0
    List<String> countryLinks = new ArrayList<>();

    // Перебираем строки таблицы
    for (WebElement row : countryRows) {
      // Получаем значение количества зон
      int zoneCount = Integer.parseInt(row.findElement(By.xpath("./td[6]")).getText());

      // Если количество зон больше 0, добавляем ссылку на страну в список
      if (zoneCount > 0) {
        WebElement countryLink = row.findElement(By.xpath("./td[5]/a"));
        countryLinks.add(countryLink.getAttribute("href"));
      }
    }

    // Перебираем список ссылок и проверяем сортировку зон по алфавиту
    for (String link : countryLinks) {
      // Переходим по ссылке на страну
      driver.get(link);

      // Проверяем сортировку зон по алфавиту
      List<WebElement> zoneNameCells = driver.findElements(By.xpath(".//tr[position()>1]/td[3]"));

      // Создаем список названий зон
      List<String> zoneNames = new ArrayList<>();
      for (WebElement cell : zoneNameCells) {
        String zoneName = cell.getText().trim();
        if (!zoneName.isEmpty()) {
          zoneNames.add(zoneName);
        }
      }

      // Создаем копию списка для проверки сортировки
      List<String> sortedZoneNames = new ArrayList<>(zoneNames);

      // Сортируем список
      Collections.sort(sortedZoneNames);

      // Проверяем сортировку
      if (!zoneNames.equals(sortedZoneNames)) {
        return false;
      }
      // Возвращаемся на страницу со странами
      driver.navigate().back();
    }
    return true;
  }

  public boolean geoZonesSort() {
    // Открытие страницы
    driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    // Находим строки таблицы
    List<WebElement> geoZonesRows = driver.findElements(By.xpath("//tr[@class='row']"));

    // Создаем список для хранения ссылок на страны
    List<String> countryLinks = new ArrayList<>();

    // Перебираем строки таблицы
    for (WebElement row : geoZonesRows) {

        WebElement geoLink = row.findElement(By.xpath("./td[3]/a"));
        countryLinks.add(geoLink.getAttribute("href"));
    }

    // Перебираем список ссылок и проверяем сортировку зон по алфавиту
    for (String link : countryLinks) {
      // Переходим по ссылке на страну
      driver.get(link);

      // Проверяем сортировку зон по алфавиту
      List<WebElement> zoneNameCells = driver.findElements(By.xpath(".//tr[position()>1]/td[3]/select"));

      // Создаем список названий зон
      List<String> zoneNames = new ArrayList<>();
      for (WebElement cell : zoneNameCells) {
        Select zoneNameDropdown = new Select(cell);
        String zoneName = zoneNameDropdown.getFirstSelectedOption().getText().trim();
          zoneNames.add(zoneName);
      }

      // Создаем копию списка для проверки сортировки
      List<String> sortedZoneNames = new ArrayList<>(zoneNames);

      // Сортируем список
      Collections.sort(sortedZoneNames);

      // Проверяем сортировку
      if (!zoneNames.equals(sortedZoneNames)) {
        return false;
      }
      // Возвращаемся на страницу со странами
      driver.navigate().back();
    }
    return true;
  }
}
