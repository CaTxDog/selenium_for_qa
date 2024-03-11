package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class TestBase {

  public static final ApplicationManager app = new ApplicationManager();


  public void setUp() throws Exception {
    app.init();
  }

  public void tearDown() throws Exception {
    app.stop();
  }

}