package main.java.assignment.models;

/**
 * The type Raw item.
 */
public class RawItem extends Item{
  /**
   * Instantiates a new Raw item.
   *
   * @param name     the name
   * @param price    the price
   * @param quantity the quantity
   */
  public RawItem(String name,int price,int quantity){
    super(name, price, quantity);
    salesTax=12.5*price*0.01;
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

