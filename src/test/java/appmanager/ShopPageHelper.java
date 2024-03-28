package appmanager;

import model.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopPageHelper extends HelperBase {

  public ShopPageHelper(WebDriver driver) {
    super(driver);
  }

  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

  public boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public void goTo(String namePage) {

    click(By.xpath("//span[text()='" + namePage + "']"));
  }

  public void goToSubPage(String namePage) {
    click(By.xpath("//span[text()='" + namePage + "']"));
    assertTrue(namePage.equals(isOnPage(By.xpath("//h1"))));
  }

  public void goToSubPage(String namePage, String title) {
    click(By.xpath("//span[text()='" + namePage + "']"));
    assertTrue(title.equals(isOnPage(By.xpath("//h1"))));
  }

  public boolean onlyOneStickerExist() {
    // Находим все элементы товаров на странице
    List<WebElement> products = driver.findElements(By.className("product"));

    for (WebElement product : products) {

      // Проверяем, что у каждого товара имеется ровно один стикер
      List<WebElement> sticker = product.findElements(By.className("sticker"));
      if (sticker.size() != 1) {
        return false;
      }
    }
    return true;
  }


  public boolean equalsProduct() {
    // Находим все элементы товаров на странице

    WebElement product = driver.findElement(By.cssSelector("#box-campaigns > div > ul > li:first-child"));
    String name = product.findElement(By.cssSelector(".name")).getText();

    // Находим элемент с обычной ценой
    WebElement regularPrice = product.findElement(By.cssSelector(".regular-price"));
    // Получаем значение
    String grayPrice = regularPrice.getText();
    // Проверяем, зачеркнут ли текст
    String textDecoration = regularPrice.getCssValue("text-decoration");
    boolean isStrikethrough = textDecoration.contains("line-through");
    //Получаем размер текста
    String regularPriceFontSizeString = (regularPrice.getCssValue("font-size")).substring(0, (regularPrice.getCssValue("font-size")).length() - 2);
    Double regularPriceFontSize = Double.parseDouble(regularPriceFontSizeString);
    // Получаем цвет текста
    String colorValue = regularPrice.getCssValue("color");
    Color greyColor = Color.fromString(colorValue);
    // Проверяем, является ли цвет серым и состоит ли он из одинаковых значений R, G и B
    boolean isGray = greyColor.getColor().getRed() == greyColor.getColor().getGreen() && greyColor.getColor().getGreen() == greyColor.getColor().getBlue();

    // Находим элемент с акционной ценой
    WebElement campaignPrice = product.findElement(By.cssSelector(".campaign-price"));
    // Получаем значение
    String redPrice = campaignPrice.getText();
    //Получаем размер акционной цены
    String campaignPriceFontSizeString = (campaignPrice.getCssValue("font-size")).substring(0, (campaignPrice.getCssValue("font-size")).length() - 2);
    Double campaignPriceFontSize = Double.parseDouble(campaignPriceFontSizeString);
    // Проверяем на жирность
    String fontWeight = campaignPrice.getCssValue("font-weight");
    boolean isFontWeight = (fontWeight.equals("700") || fontWeight.equals("bold") || (fontWeight.equals("900")));
    // Проверяем цвет текста
    String campaignPriceColorValue = campaignPrice.getCssValue("color");
    Color redColor = Color.fromString(campaignPriceColorValue);
    boolean isRed = redColor.getColor().getBlue() == 0 && redColor.getColor().getGreen() == 0;
    //Проверяем размер текста
    boolean isFontSize = regularPriceFontSize < campaignPriceFontSize;
    //Переходим на страницу товара
    product.click();

    product = driver.findElement(By.id("box-product"));

    // Находим наименование товара
    String nameNew = product.findElement(By.cssSelector(".title")).getText();
    // Находим элемент с обычной ценой
    WebElement regularPriceNew = product.findElement(By.cssSelector(".regular-price"));
    // Получаем значение
    String grayPriceNew = regularPriceNew.getText();
    // Проверяем, зачеркнут ли текст
    String textDecorationNew = regularPriceNew.getCssValue("text-decoration");
    boolean isStrikethroughNew = textDecorationNew.contains("line-through");
    //Получаем размер текста
    String regularPriceFontSizeStringNew = (regularPriceNew.getCssValue("font-size")).substring(0, (regularPriceNew.getCssValue("font-size")).length() - 2);
    Double regularPriceFontSizeNew = Double.parseDouble(regularPriceFontSizeStringNew);
    // Получаем цвет текста
    String colorValueNew = regularPriceNew.getCssValue("color");
    Color greyColorNew = Color.fromString(colorValueNew);
    // Проверяем, является ли цвет серым и состоит ли он из одинаковых значений R, G и B
    boolean isGrayNew = greyColorNew.getColor().getRed() == greyColorNew.getColor().getGreen() && greyColorNew.getColor().getGreen() == greyColorNew.getColor().getBlue();

    // Находим элемент с акционной ценой
    WebElement campaignPriceNew = product.findElement(By.cssSelector(".campaign-price"));
    // Получаем значение
    String redPriceNew = campaignPriceNew.getText();
    //Получаем размер акционной цены
    String campaignPriceFontSizeStringNew = (campaignPriceNew.getCssValue("font-size")).substring(0, (campaignPriceNew.getCssValue("font-size")).length() - 2);
    Double campaignPriceFontSizeNew = Double.parseDouble(campaignPriceFontSizeStringNew);
    // Проверяем на жирность
    String fontWeightNew = campaignPriceNew.getCssValue("font-weight");
    boolean isFontWeightNew = (fontWeightNew.equals("700") || fontWeightNew.equals("bold") || (fontWeight.equals("900")));
    // Проверяем цвет текста
    String campaignPriceColorValueNew = campaignPriceNew.getCssValue("color");
    Color redColorNew = Color.fromString(campaignPriceColorValueNew);
    boolean isRedNew = redColorNew.getColor().getBlue() == 0 && redColorNew.getColor().getGreen() == 0;
    //Проверяем размер текста
    boolean isFontSizeNew = regularPriceFontSizeNew < campaignPriceFontSizeNew;

    if (name.equals(nameNew)
            && grayPrice.equals(grayPriceNew)
            && redPrice.equals(redPriceNew)
            && isStrikethrough
            && isStrikethroughNew
            && isGray
            && isGrayNew
            && isFontWeight
            && isFontWeightNew
            && isFontSize
            && isFontSizeNew
            && isRed
            && isRedNew) {
      return true;
    } else return false;
  }

  public AccountData generateRandomAccount() {
    AccountData account = new AccountData();
    Random random = new Random();
    // Генерация случайного имени
    String[] FIRST_NAMES = {"John", "Emma", "Michael", "Sophia", "William", "Olivia", "James", "Ava", "Benjamin", "Isabella"};
    String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Jones", "Garcia", "Miller", "Davis", "Martinez", "Taylor", "Thomas"};

    // Генерация случайных данных для полей модели Account
    account.setTaxId("123456789");
    account.setCompany("Random Company");
    account.setFirstName(FIRST_NAMES[random.nextInt(FIRST_NAMES.length)]);
    account.setLastName(LAST_NAMES[random.nextInt(LAST_NAMES.length)]);
    account.setAddress1(random.nextInt(100) + " Random St");
    account.setAddress2("Apt " + random.nextInt(1000));
    account.setPostcode(String.valueOf(random.nextInt(90000) + 10000));
    account.setCity("Random City");
    account.setEmail("random" + random.nextInt(1000) + "@example.com");
    account.setPhone("+1234567890");
    account.setPassword("randompassword123");
    account.setPasswordConfirm("randompassword123");

    // Генерация случайного выбора для страны и зоны
    // Генерация случайной страны - после переделано в US
    account.setCountry("United States");

    // Если страна - Канада или Соединенные Штаты, выбираем случайную зону
    if (account.getCountry().equals("Canada") || account.getCountry().equals("United States")) {
      account.setZone(selectRandomZone(driver));
    }

    return account;
  }


  //Заполнение рандомной старны (не пригодилось по заданию)
  public static String selectRandomCountry(WebDriver driver) {
    WebElement countrySelect = driver.findElement(By.name("country_code"));
    Select countryDropdown = new Select(countrySelect);
    List<WebElement> options = countryDropdown.getOptions();
    // Выбираем случайную страну, исключая пустой элемент "-- Select --"
    Random random = new Random();
    int index = random.nextInt(options.size() - 1) + 1;
    return options.get(index).getText();
  }

  //Заполнение рандомного штата для страны United States
  public String selectRandomZone(WebDriver driver) {
    //Выбираем страну United States
    click(By.className("select2-selection__arrow"));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'United States')]")));
    // Выбираем результат поиска "United States"
    WebElement result = driver.findElement(By.xpath("//li[contains(text(), 'United States')]"));
    result.click();

    WebElement zoneSelect = driver.findElement(By.cssSelector("select[name='zone_code']"));
    Select zoneDropdown = new Select(zoneSelect);
    List<WebElement> options = zoneDropdown.getOptions();

    // Выбираем случайную зону, исключая пустой элемент "-- Select --"
    Random random = new Random();
    int index = random.nextInt(options.size() - 1) + 1;
    return options.get(index).getText();
  }

  public void fillContactForm(AccountData accountData) {
    type(By.name("tax_id"), accountData.getTaxId());
    type(By.name("company"), accountData.getCompany());
    type(By.name("firstname"), accountData.getFirstName());
    type(By.name("lastname"), accountData.getLastName());
    type(By.name("address1"), accountData.getAddress1());
    type(By.name("address2"), accountData.getAddress2());
    type(By.name("postcode"), accountData.getPostcode());
    type(By.name("city"), accountData.getCity());

    //Select countryDropdown = new Select(driver.findElement(By.name("country_code")));
    //countryDropdown.selectByVisibleText("United States");

    // Если страна - Канада или Соединенные Штаты, заполняем зону
    if (accountData.getCountry().equals("Canada") || accountData.getCountry().equals("United States")) {
      WebElement zoneSelect = driver.findElement(By.cssSelector("select[name='zone_code']"));
      Select zoneDropdown = new Select(zoneSelect);
      zoneDropdown.selectByVisibleText(accountData.getZone());
    }
    type(By.name("email"), accountData.getEmail());
    type(By.name("phone"), accountData.getPhone());
    type(By.name("password"), accountData.getPassword());
    type(By.name("confirmed_password"), accountData.getPasswordConfirm());
    click(By.name("create_account"));
  }

  public void goToCreatePage() {
    driver.get("http://localhost/litecart/en/create_account");
  }


  public void logout() {
    click(By.cssSelector("a[href^=\"http://localhost/litecart/en/logout\"]"));
  }

  public boolean login(AccountData accountData) {
    type(By.name("email"), accountData.getEmail());
    type(By.name("password"), accountData.getPassword());
    click(By.name("login"));
    return driver.findElement(By.className("notice")).isDisplayed();
  }

  public boolean waitItems() {
    //Задаем длительность ожидания
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //Указываем колличество повторений, для добавления товара в корзину. Счет ведем с 1 для сверки количества эллементов в таблице
    for (int i = 1; i < 4; i++) {
      driver.get("http://localhost/litecart/en/");
      //Тут не самые красивые селекторы, но время 5 утра и решил не заморачиваться, так как нужен просто первый элемент
      click(By.cssSelector("#box-most-popular > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1)"));
      if (!driver.findElements(By.name("options[Size]")).isEmpty()) {
        // Если есть опция выбора размера, выбираем первое доступное значение
        WebElement sizeDropdown = driver.findElement(By.name("options[Size]"));
        Select sizeSelect = new Select(sizeDropdown);
        sizeSelect.selectByIndex(1); // Выбор первого доступного размера
      }
      WebElement addToCartButton = driver.findElement(By.name("add_cart_product"));
      addToCartButton.click();
      wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("quantity"), String.valueOf(i)));
      WebElement quantityElement = driver.findElement(By.className("quantity"));
      String quantityText = quantityElement.getText();
      // Проверяем, что количество товаров в корзине равно ожидаемому значению
      if (!quantityText.equals(String.valueOf(i))) {
        return false;
      }
    }
    // Переходим в корзину
    driver.get("http://localhost/litecart/en/checkout");
    // Удалениен в корзине
    while (true) {
      // Проверка наличия таблицы
      List<WebElement> tableRows = driver.findElements(By.cssSelector("#order_confirmation-wrapper .item"));
      if (tableRows.isEmpty()) {
        break;
      }
      // Нажатие на первый элемент в shortcuts
      List<WebElement> shortcuts = driver.findElements(By.cssSelector(".shortcuts .shortcut"));
      if (!shortcuts.isEmpty()) {
        shortcuts.getFirst().click();
      }
      // Ожидание появления кнопки Remove
      WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[value*='Remove']")));
      // Нажатие на кнопку Remove
      removeButton.click();
      // Ожидание изменения количества записей в таблице. 0 запись является заголовком таблицы, поэтому проверяем с 1ой.
      wait.until(ExpectedConditions.stalenessOf(tableRows.get(1)));
    }
    return true;
  }

}
