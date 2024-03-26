package tests;

import appmanager.ApplicationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.Browser;

public class TestBaseShop {

  public static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.FIREFOX.browserName()),false);


  @BeforeAll
  public static void setUp() throws Exception {
    app.init();
  }

  @AfterAll
  public static void tearDown() throws Exception {
    app.stop("shop");
  }

}