package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


public class TestForLitecart extends TestBase {
  @Test
  @DisplayName("Тест логина")
  public void login() throws Exception {
    setUp();
    Assert.assertTrue(app.mainPage().successfulLoadPage());
    tearDown();
  }
}
