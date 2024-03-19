package tests;

import appmanager.ReplaceCamelCase;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayNameGeneration(ReplaceCamelCase.class)
public class TestForLitecartAdmin extends TestBaseAdmin {
  @Test
  public void login() throws Exception {
    assertTrue(app.adminPage().isElementPresent(By.xpath("//*[@title=\"My Store\"]")));
  }
}
