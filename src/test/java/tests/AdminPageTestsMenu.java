package tests;


import appmanager.ReplaceCamelCase;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(ReplaceCamelCase.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class AdminPageTestsMenu extends TestBaseAdmin {


  @Test
  public void clickMenu(){
    assertTrue(app.adminPage().clickMenu());
  }

}
