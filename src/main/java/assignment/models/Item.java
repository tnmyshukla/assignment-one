package main.java.assignment.models;

import org.junit.function.ThrowingRunnable;

/**
 * The type Item.
 */
public class Item implements ThrowingRunnable {
  private String name;
  private int price;
  private int quantity;
  /**
   * The Sales tax.
   */
  protected double salesTax;
  /**
   * The Final price.
   */
  protected double finalPrice;

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets price.
   *
   * @return the price
   */
  public int getPrice() {
    return price;
  }

  /**
   * Gets quantity.
   *
   * @return the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Instantiates a new Item.
   *
   * @param name     the name
   * @param price    the price
   * @param quantity the quantity
   */
  public Item(String name, int price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  /**
   * Gets final price.
   *
   * @return the final price
   */
  public double getFinalPrice() {
    return 0.0;
  }

  /**
   * Gets sales tax.
   *
   * @return the sales tax
   */
  public double getSalesTax() {
    return 0.0;
  }

  /**
   * Display item details.
   */
  public void displayItemDetails() {
    System.out.println("Item Name: " + this.name);
    System.out.println("Item Type: " + this.getClass().getSimpleName());
    System.out.println("Item Price: " + this.price);
    System.out.println("Item Quantity: " + this.quantity);
    System.out.println("Sales Tax: " + this.salesTax);
    System.out.println("Final Price: " + this.finalPrice);
  }


  @Override
  public void run() throws Throwable {

  }
}
