package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

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

  public int countMostPopular (){
    int i = 0;
    boolean isExist = false;
    do { if (!driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/div/ul/li["+i+"]")).isEmpty()==true){
      i++;
      isExist=true;
    } else isExist=false;

    } while (isExist==true);
    return i;
  }

  public boolean stickersExist (int count){
    boolean exist = true;
    for (int i=0;i<count;i++){
      if (!driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/div/ul/li["+i+"]/a[1]/div[1]/div[1]")).isEmpty()) {
        if(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/div/ul/li["+i+"]/a[1]/div[1]/div[2]")).isEmpty()==false){
          exist=false;
          break;
        }
      } else {
        exist=false;
        break;
      }
    }
    return exist;
  }


}
