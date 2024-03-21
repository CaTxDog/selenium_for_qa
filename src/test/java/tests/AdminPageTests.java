package tests;


import appmanager.ReplaceCamelCase;
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

}
