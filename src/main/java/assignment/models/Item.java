package main.java.assignment.models;

import org.junit.function.ThrowingRunnable;

public class Item implements ThrowingRunnable {
  private String name;
  private int price;
  private int quantity;
  protected double salesTax;
  protected double finalPrice;

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }
  public int getQuantity(){
    return quantity;
  }
  public Item(String name,int price,int quantity){
    this.name=name;
    this.price=price;
    this.quantity=quantity;
  }

  public double getFinalPrice() {
    return 0.0;
  }

  public double getSalesTax() {
    return 0.0;
  }
  public void displayItemDetails(){
    System.out.println("Item Name: "+this.name);
    System.out.println("Item Type: "+this.getClass().getSimpleName());
    System.out.println("Item Price: "+this.price);
    System.out.println("Item Quantity: "+this.quantity);
    System.out.println("Sales Tax: "+this.salesTax);
    System.out.println("Final Price: "+this.finalPrice);
  }

  @Override
  public void run() throws Throwable {

  }
}
