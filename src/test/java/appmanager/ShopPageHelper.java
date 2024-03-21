package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopPageHelper extends HelperBase{

  public ShopPageHelper(WebDriver driver) {
    super(driver);
  }

  public boolean isElementPresent(By locator) {
    try{
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public void goTo(String namePage){

    click(By.xpath("//span[text()='"+namePage+"']"));
  }

  public void goToSubPage(String namePage){
    click(By.xpath("//span[text()='"+namePage+"']"));
    assertTrue(namePage.equals(isOnPage(By.xpath("//h1"))));
  }

  public void goToSubPage(String namePage, String title){
    click(By.xpath("//span[text()='"+namePage+"']"));
    assertTrue(title.equals(isOnPage(By.xpath("//h1"))));
  }

  public boolean onlyOneStickerExist (){
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


  public boolean equalsProduct (){
    // Находим все элементы товаров на странице

    WebElement product = driver.findElement(By.cssSelector("#box-campaigns > div > ul > li:first-child"));
    String name = product.findElement(By.cssSelector(".name")).getText();

    // Находим элемент с обычной ценой
    WebElement regularPrice  = product.findElement(By.cssSelector(".regular-price"));
    // Получаем значение
    String grayPrice = regularPrice.getText();
    // Проверяем, зачеркнут ли текст
    String textDecoration = regularPrice.getCssValue("text-decoration");
    boolean isStrikethrough = textDecoration.contains("line-through");
    //Получаем размер текста
    String regularPriceFontSizeString = (regularPrice.getCssValue("font-size")).substring(0,(regularPrice.getCssValue("font-size")).length()-2);
    Double regularPriceFontSize = Double.parseDouble(regularPriceFontSizeString);
    // Получаем цвет текста
    String colorValue = regularPrice.getCssValue("color");
    Color greyColor = Color.fromString(colorValue);
    // Проверяем, является ли цвет серым и состоит ли он из одинаковых значений R, G и B
    boolean isGray = greyColor.getColor().getRed() == greyColor.getColor().getGreen() && greyColor.getColor().getGreen() == greyColor.getColor().getBlue();

    // Находим элемент с акционной ценой
    WebElement campaignPrice  = product.findElement(By.cssSelector(".campaign-price"));
    // Получаем значение
    String redPrice = campaignPrice.getText();
    //Получаем размер акционной цены
    String campaignPriceFontSizeString = (campaignPrice.getCssValue("font-size")).substring(0,(campaignPrice.getCssValue("font-size")).length()-2);
    Double campaignPriceFontSize = Double.parseDouble(campaignPriceFontSizeString);
    // Проверяем на жирность
    String fontWeight = campaignPrice.getCssValue("font-weight");
    boolean isFontWeight = (fontWeight.equals("700") || fontWeight.equals("bold") || (fontWeight.equals("900")));
    // Проверяем цвет текста
    String campaignPriceColorValue = campaignPrice.getCssValue("color");
    Color redColor = Color.fromString(campaignPriceColorValue);
    boolean isRed = redColor.getColor().getBlue()==0 && redColor.getColor().getGreen()==0;
    //Проверяем размер текста
    boolean isFontSize = regularPriceFontSize < campaignPriceFontSize;
    //Переходим на страницу товара
    product.click();

    product = driver.findElement(By.id("box-product"));

    // Находим наименование товара
    String nameNew = product.findElement(By.cssSelector(".title")).getText();
    // Находим элемент с обычной ценой
    WebElement regularPriceNew  = product.findElement(By.cssSelector(".regular-price"));
    // Получаем значение
    String grayPriceNew = regularPriceNew.getText();
    // Проверяем, зачеркнут ли текст
    String textDecorationNew = regularPriceNew.getCssValue("text-decoration");
    boolean isStrikethroughNew = textDecorationNew.contains("line-through");
    //Получаем размер текста
    String regularPriceFontSizeStringNew = (regularPriceNew.getCssValue("font-size")).substring(0,(regularPriceNew.getCssValue("font-size")).length()-2);
    Double regularPriceFontSizeNew = Double.parseDouble(regularPriceFontSizeStringNew);
    // Получаем цвет текста
    String colorValueNew = regularPriceNew.getCssValue("color");
    Color greyColorNew = Color.fromString(colorValueNew);
    // Проверяем, является ли цвет серым и состоит ли он из одинаковых значений R, G и B
    boolean isGrayNew = greyColorNew.getColor().getRed() == greyColorNew.getColor().getGreen() && greyColorNew.getColor().getGreen() == greyColorNew.getColor().getBlue();

    // Находим элемент с акционной ценой
    WebElement campaignPriceNew  = product.findElement(By.cssSelector(".campaign-price"));
    // Получаем значение
    String redPriceNew = campaignPriceNew.getText();
    //Получаем размер акционной цены
    String campaignPriceFontSizeStringNew = (campaignPriceNew.getCssValue("font-size")).substring(0,(campaignPriceNew.getCssValue("font-size")).length()-2);
    Double campaignPriceFontSizeNew = Double.parseDouble(campaignPriceFontSizeStringNew);
    // Проверяем на жирность
    String fontWeightNew = campaignPriceNew.getCssValue("font-weight");
    boolean isFontWeightNew = (fontWeightNew.equals("700") || fontWeightNew.equals("bold") || (fontWeight.equals("900")));
    // Проверяем цвет текста
    String campaignPriceColorValueNew = campaignPriceNew.getCssValue("color");
    Color redColorNew = Color.fromString(campaignPriceColorValueNew);
    boolean isRedNew = redColorNew.getColor().getBlue()==0 && redColorNew.getColor().getGreen()==0;
    //Проверяем размер текста
    boolean isFontSizeNew = regularPriceFontSizeNew < campaignPriceFontSizeNew;

    if (name.equals(nameNew)
            &&grayPrice.equals(grayPriceNew)
            &&redPrice.equals(redPriceNew)
            &&isStrikethrough
            &&isStrikethroughNew
            &&isGray
            &&isGrayNew
            &&isFontWeight
            &&isFontWeightNew
            &&isFontSize
            &&isFontSizeNew
            &&isRed
            &&isRedNew){
      return true;
    } else return false;
  }
}
