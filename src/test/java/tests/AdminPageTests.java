package tests;


import appmanager.ReplaceCamelCase;
import model.ProductData;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(ReplaceCamelCase.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class AdminPageTests extends TestBaseAdmin {


  @Test
  public void clickMenu(){
    assertTrue(app.adminPage().clickMenu());
  }

  @Test
  public void countrySorted(){
    assertTrue(app.adminPage().countrySorted());
    assertTrue(app.adminPage().countryZonesSort());
  }

  @Test
  public void geoZoneSorted(){
    assertTrue(app.adminPage().geoZonesSort());
  }

  @Test
  public void createNewProduct(){
    app.adminPage().goToCreatePage();
    ProductData product = app.adminPage().generateRandomProduct();
    app.adminPage().fillNewGeneralProduct(product);
    app.adminPage().fillNewInformationProduct(product);
    app.adminPage().fillNewPricesProduct(product);
    app.adminPage().saveNewProduct();
    assertTrue(app.adminPage().checkSaveProduct(product));
  }

  @Test
  public void newTab(){
    assertTrue(app.adminPage().checkNewTab());
  }

  @Test
  public void clearBrowserLog(){
    assertTrue(app.adminPage().getBrowserLog());
  }
}
