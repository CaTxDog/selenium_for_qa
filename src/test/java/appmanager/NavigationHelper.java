package appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void goToAppearence(){
    click(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[1]/a/span[2]"));
  }

  public void succsessLoadPage(){

  }


}
