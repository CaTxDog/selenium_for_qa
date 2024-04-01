package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class HelperBase {
  protected WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  protected void click(By locator) {
    driver.findElement(locator).click();
  }

  protected String isOnPage(By locator){
    return driver.findElement(locator).getText();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = driver.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
      }
    }
  }

  protected void attach(By locator, File file) {
    if (file != null) {
      driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }
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