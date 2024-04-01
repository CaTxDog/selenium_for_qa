package appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void goToAppearence(){
    click(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[1]/a/span[2]"));
  }

  public void succsessLoadPage(){
  }

  // Метод для открытия ссылки в новой вкладке
  public void openNewTab(WebDriver driver, String url) {
    ((JavascriptExecutor)driver).executeScript("window.open(arguments[0])", url);
  }

  // Метод для переключения на новую вкладку
  public void switchToNewTab(WebDriver driver) {
    Set<String> handles = driver.getWindowHandles();
    List<String> tabs = new ArrayList<>(handles);
    driver.switchTo().window(tabs.getLast());
  }

  // Метод для переключения на основную вкладку
  public void switchToMainTab(WebDriver driver) {
    Set<String> handles = driver.getWindowHandles();
    List<String> tabs = new ArrayList<>(handles);
    driver.switchTo().window(tabs.getFirst());
  }


}
