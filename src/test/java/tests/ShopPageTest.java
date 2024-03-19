package tests;

import appmanager.ReplaceCamelCase;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(ReplaceCamelCase.class)
public class ShopPageTest extends TestBaseShop{


  @Test
  public void allDucksHaveOneSticker(){
    assertTrue(app.shopPade().onlyOneStickerExist());
  }
}
