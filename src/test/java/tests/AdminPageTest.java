package tests;


import appmanager.ReplaceCamelCase;
import org.junit.jupiter.api.*;

@DisplayNameGeneration(ReplaceCamelCase.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class AdminPageTest extends TestBase{


  @Test
  @Order(1)
  public void appearence() throws Exception {
    app.adminPage().goTo("Appearence");
    app.adminPage().goToSubPage("Template");
    app.adminPage().goToSubPage("Logotype");
  }

  @Test
  @Order(2)
  public void catalog() throws Exception {
    app.adminPage().goTo("Catalog");
    app.adminPage().goToSubPage("Catalog");
    app.adminPage().goToSubPage("Product Groups");
    app.adminPage().goToSubPage("Manufacturers");
    app.adminPage().goToSubPage("Suppliers");
    app.adminPage().goToSubPage("Delivery Statuses");
    app.adminPage().goToSubPage("Sold Out Statuses");
    app.adminPage().goToSubPage("Quantity Units");
    app.adminPage().goToSubPage("CSV Import/Export");
  }

  @Test
  @Order(3)
  public void countries() throws Exception {
    app.adminPage().goToSubPage("Countries");
  }

  @Test
  @Order(4)
  public void currencies() throws Exception {
    app.adminPage().goToSubPage("Currencies");
  }

  @Test
  @Order(5)
  public void customers() throws Exception {
    app.adminPage().goTo("Customers");
    app.adminPage().goToSubPage("CSV Import/Export");
    app.adminPage().goToSubPage("Newsletter");
  }

  @Test
  @Order(6)
  public void geoZones() throws Exception {
    app.adminPage().goToSubPage("Geo Zones");
  }

  @Test
  @Order(7)
  public void languages() throws Exception {
    app.adminPage().goTo("Languages");
    app.adminPage().goToSubPage("Languages");
    app.adminPage().goToSubPage("Storage Encoding");
  }

  @Test
  @Order(8)
  public void jobModules() throws Exception {
    app.adminPage().goTo("Modules");
    app.adminPage().goToSubPage("Background Jobs", "Job Modules");
    app.adminPage().goToSubPage("Customer", "Customer Modules");
    app.adminPage().goToSubPage("Shipping", "Shipping Modules");
    app.adminPage().goToSubPage("Payment", "Payment Modules");
    app.adminPage().goToSubPage("Order Total", "Order Total Modules");
    app.adminPage().goToSubPage("Order Success", "Order Success Modules");
    app.adminPage().goToSubPage("Order Action", "Order Action Modules");
  }

  @Test
  @Order(9)
  public void orders() throws Exception {
    app.adminPage().goTo("Orders");
    app.adminPage().goToSubPage("Orders");
    app.adminPage().goToSubPage("Order Statuses");
  }

  @Test
  @Order(10)
  public void pages() throws Exception {
    app.adminPage().goToSubPage("Pages");
  }

  @Test
  @Order(11)
  public void reports() throws Exception {
    app.adminPage().goTo("Reports");
    app.adminPage().goToSubPage("Monthly Sales");
    app.adminPage().goToSubPage("Most Sold Products");
    app.adminPage().goToSubPage("Most Shopping Customers");
  }

  @Test
  @Order(12)
  public void settings() throws Exception {
    app.adminPage().goTo("Settings");
    app.adminPage().goToSubPage("Store Info", "Settings");
    app.adminPage().goToSubPage("Defaults", "Settings");
    app.adminPage().goToSubPage("General", "Settings");
    app.adminPage().goToSubPage("Listings", "Settings");
    app.adminPage().goToSubPage("Images", "Settings");
    app.adminPage().goToSubPage("Checkout", "Settings");
    app.adminPage().goToSubPage("Advanced", "Settings");
    app.adminPage().goToSubPage("Security", "Settings");
  }

  @Test
  @Order(13)
  public void slides() throws Exception {
    app.adminPage().goToSubPage("Slides");
  }

  @Test
  @Order(14)
  public void tax() throws Exception {
    app.adminPage().goTo("Tax");
    app.adminPage().goToSubPage("Tax Classes");
    app.adminPage().goToSubPage("Tax Rates");
  }

  @Test
  @Order(15)
  public void translations() throws Exception {
    app.adminPage().goTo("Translations");
    app.adminPage().goToSubPage("Search Translations");
    app.adminPage().goToSubPage("Scan Files","Scan Files For Translations");
    app.adminPage().goToSubPage("CSV Import/Export");
  }

  @Test
  @Order(16)
  public void users() throws Exception {
    app.adminPage().goToSubPage("Users");
  }

  @Test
  @Order(17)
  public void vQmods() throws Exception {
    app.adminPage().goToSubPage("vQmods");
  }
}
