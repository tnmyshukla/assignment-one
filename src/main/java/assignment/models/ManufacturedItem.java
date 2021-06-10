package main.java.assignment.models;

/**
 * The type Manufactured item.
 */
public class ManufacturedItem extends Item{
  /**
   * Instantiates a new Manufactured item.
   *
   * @param name     the name
   * @param price    the price
   * @param quantity the quantity
   */
  public ManufacturedItem(String name,int price,int quantity){
    super(name, price, quantity);
    salesTax=12.5*price*0.01;
    salesTax+=0.02*(price+salesTax);
    finalPrice=(salesTax+price)*quantity;
  }

  @Override
  public double getSalesTax() {
    return super.getSalesTax();
  }

  @Override
  public double getFinalPrice() {
    return super.getFinalPrice();
  }
}
