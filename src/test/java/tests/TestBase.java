package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.Browser;

public class TestBase {

  public static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.FIREFOX.browserName()));


  public void setUp() throws Exception {
    app.init();
  }

  public void tearDown() throws Exception {
    app.stop();
  }

}