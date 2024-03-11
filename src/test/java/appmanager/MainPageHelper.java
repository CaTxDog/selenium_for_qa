package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class MainPageHelper extends HelperBase{

  public MainPageHelper(WebDriver driver) {
    super(driver);
  }

  public boolean successfulLoadPage(){
    try{
      driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/a[5]"));
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

}
