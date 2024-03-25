package model;

import java.io.File;

public class ProductData {
  private String name;
  private String code;
  private String logo;
  private String quantity;
  private String Manufacturer;
  private String shortDescription;
  private String description;
  private String purchasePrice;
  private String priceUSD;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setLogo(File logo) {
    this.logo = logo.getPath();
  }

  public File getLogo() {
    return new File(logo);
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getManufacturer() {
    return Manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPurchasePrice() {
    return purchasePrice;
  }

  public void setPurchasePrice(String purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  public String getPriceUSD() {
    return priceUSD;
  }

  public void setPriceUSD(String priceUSD) {
    this.priceUSD = priceUSD;
  }
}
