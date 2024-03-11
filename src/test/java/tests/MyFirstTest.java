package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyFirstTest /*extends TestBase*/ {

  public WebDriver driver;
  public WebDriverWait wait;

  @Before
  public void start(){
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  @Test
  @DisplayName("Первый тест")
  public void myFirstTest() {
    driver.navigate().to("http://ya.ru/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.name("text")).sendKeys("Алексей Баранцев selenium");
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector("body > main > div.body__content > form > div.search3__inner > button")).click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.xpath("/html/body/main/div[3]/button")).click();
    driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div[1]/ul/li[1]/div/div[1]/a")).click();
  }

  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}