package main.java.assignment.models;

public class ManufacturedItem extends Item{
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
