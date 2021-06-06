package main.java.assignment;

import main.java.assignment.exceptions.InvalidArgumentException;
import main.java.assignment.models.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
  void startManager(String[] args){
    try{
      Item item=new CommandLineArgumentParser().getItem(args);
      item.displayItemDetails();
      checkForNewItem();
    }catch (InvalidArgumentException e){
      System.out.println(e.getMessage());
      checkForNewItem();
      System.exit(1);
    }
  }
  public void checkForNewItem(){
    System.out.println("Do you want to enter details of any other item (y/n):");
    final Scanner scan=new Scanner(System.in);
    String option=scan.nextLine();
    while ("y".equals(option)|| "Y".equals(option)){
      System.out.println("Enter name of Item");
      final String itemName=scan.nextLine();
      System.out.println("Enter type of Item");
      final String itemType= scan.nextLine();
      System.out.println("Enter price of Item");
      final String itemPrice= scan.nextLine();
      System.out.println("Enter quantity of Item");
      final String itemQuantity= scan.nextLine();
      final ArrayList<String> argList= new ArrayList<>();
      String[] args=new String[]{"-name", itemName, "-type", itemType, "-price", itemPrice, "-quantity", itemQuantity};
      try{
      Item item=new CommandLineArgumentParser().getItem(args);
      item.displayItemDetails();
      checkForNewItem();
      }catch (InvalidArgumentException e){
        System.out.println(e.getMessage());
        checkForNewItem();
      }
      System.out.println("Do you want to enter details of any other item (y/n):");
      option=scan.nextLine();
    }
    System.exit(1);
  }
}
