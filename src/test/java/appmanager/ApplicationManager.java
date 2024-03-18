package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.Browser;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private SessionHelper sessionHelper;

  private AdminPageHelper adminPageHelper;

  private final Properties properties;
  WebDriver driver;
  WebDriverWait wait;
  private String browser;


  public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
  }

  public void init() throws IOException {

    String target = System.getProperty("target", "local");
    properties.load(new FileReader(String.format("src/test/resources/%s.properties", target)));

    if (browser.equals(Browser.FIREFOX.browserName())) {
      ProfilesIni profile = new ProfilesIni();
      FirefoxProfile prof = profile.getProfile("fortest");
      prof.setPreference("browser.download.dir","C:\\Developer\\selenium_for_qa");
      prof.setPreference("browser.download.folderList", 2);
      FirefoxOptions opt = new FirefoxOptions();
      //opt.setProfile(prof);
      opt.setBrowserVersion("nightly");
      SeleniumManagerOutput.Result output = DriverFinder.getPath(GeckoDriverService.createDefaultService(), opt);
      opt.setBinary(Path.of(output.getBrowserPath()));
      driver = new FirefoxDriver(opt);
    } else if (browser.equals(Browser.CHROME.browserName())) {
      driver = new ChromeDriver();
    } else if (browser.equals(Browser.EDGE.browserName())){
      driver = new EdgeDriver();
    }
    driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    driver.get(properties.getProperty("web.baseUrl"));
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
    adminPageHelper = new AdminPageHelper(driver);
  }

  public void stop() {
    sessionHelper.logout();
    driver.quit();
  }

  public AdminPageHelper adminPage() {
    return adminPageHelper;
  }

  private Path getFirefoxLocation() {
    FirefoxOptions options = new FirefoxOptions();
    options.setBrowserVersion("nightly");
    SeleniumManagerOutput.Result output =
            DriverFinder.getPath(GeckoDriverService.createDefaultService(), options);
    return Path.of(output.getBrowserPath());
  }

}
