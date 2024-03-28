package tests;

import appmanager.ReplaceCamelCase;
import model.AccountData;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(ReplaceCamelCase.class)
public class ShopPageTest extends TestBaseShop{


  @Test
  public void allDucksHaveOneSticker(){
    assertTrue(app.shopPage().onlyOneStickerExist());
  }

  @Test
  public void equalsProduct(){
    assertTrue(app.shopPage().equalsProduct());
  }

  @Test
  public void regestrationTest(){
    AccountData contact = new AccountData();
    contact = app.shopPage().generateRandomAccount();

  }

  @Test
  public void geoZoneSorted(){

    assertTrue(app.adminPage().geoZonesSort());

  }

  @Test
  public void createUserTest(){
    app.shopPage().goToCreatePage();
    AccountData contact = app.shopPage().generateRandomAccount();
    app.shopPage().fillContactForm(contact);
    app.shopPage().logout();
    assertTrue(app.shopPage().login(contact));
    app.shopPage().logout();
  }

  @Test
  public void waitTest(){
    assertTrue(app.shopPage().waitItems());
  }
}
