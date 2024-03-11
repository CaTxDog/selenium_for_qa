package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String login, String password) {
    type(By.name("username"),login);
    type(By.name("password"),password);
    click(By.xpath("//*[@id=\"box-login\"]/form/div[2]/button"));
  }

  public void logout() {
    click(By.xpath("//*[@id=\"sidebar\"]/div[2]/a[5]"));
  }


}
