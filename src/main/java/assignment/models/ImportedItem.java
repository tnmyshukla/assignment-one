package main.java.assignment.models;

/**
 * The type Imported item.
 */
public class ImportedItem extends Item{
  /**
   * Instantiates a new Imported item.
   *
   * @param name     the name
   * @param price    the price
   * @param quantity the quantity
   */
  public ImportedItem(String name,int price,int quantity){
    super(name, price, quantity);
    double importDuty=0.1*price;
    double surcharge;
    if(price+importDuty<=100) {
      surcharge=5.0;
    } else if(price+importDuty<=200) {
      surcharge=10.0;
    }else{
      surcharge=0.05*(price+importDuty);
    }
    salesTax=importDuty+surcharge;
    finalPrice=(this.salesTax+price)*quantity;
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
