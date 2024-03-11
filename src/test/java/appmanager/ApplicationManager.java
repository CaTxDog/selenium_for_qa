package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private SessionHelper sessionHelper;

  private MainPageHelper mainPageHelper;

  private final Properties properties;
  WebDriver driver;
  WebDriverWait wait;


  public ApplicationManager() {
        properties = new Properties();
  }

  public void init() throws IOException {

    String target = System.getProperty("target", "local");
    properties.load(new FileReader(String.format("src/test/resources/%s.properties", target)));
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    driver.get(properties.getProperty("web.baseUrl"));
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
    mainPageHelper = new MainPageHelper(driver);
  }

  public void stop() {
    sessionHelper.logout();
    driver.quit();
  }

  public MainPageHelper mainPage() {
    return mainPageHelper;
  }
}
