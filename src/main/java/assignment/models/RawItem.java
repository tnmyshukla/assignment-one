package main.java.assignment.models;

public class RawItem extends Item{
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

