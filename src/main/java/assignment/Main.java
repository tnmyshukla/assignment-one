package main.java.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static void validateMinimumArguments(final ArrayList<String> args){
        if(args.size()<=3){
            throw new RuntimeException("Minimum number of arguments needed are 4");
        }
    }
    private static void validateNameAndType(final ArrayList<String>args){
        if(args.indexOf("-name")!=0){
            throw new RuntimeException("-name is required to be the first option");
        }
        if(!args.contains("-type")){
            throw new RuntimeException("-type is required to be the present");
        }
    }
    private static void validateAllArguments(final ArrayList<String>args){
        for(final Iterator<String>s=args.iterator();s.hasNext();){
            if(s.next().startsWith("-")&&s.hasNext()&&s.next().startsWith("-")){
                throw new RuntimeException("Each argument must have values");
            }
        }
    }
    private static void validatePriceAndQuantity(final ArrayList<String> args) throws RuntimeException {
        try{
            if(args.contains("-price")){
                Integer.parseInt(args.get(args.indexOf("-price")+1));
            }
            if(args.contains("-quantity")){
                Integer.parseInt(args.get(args.indexOf("-quantity")+1));
            }
        }catch (Exception e){
//            System.out.println();(e.toString());
            throw new RuntimeException("Quantity and price must be integers");
        }
    }
    private static void validateTypeOfItem(final ArrayList<String>args){
        final String tempType= args.get(args.indexOf("-type")+1);
//        System.out.println(tempType.equals("raw"));
        if(!"raw".equals(tempType)&&!"manufactured".equals(tempType)&&!"imported".equals(tempType)){
            throw new RuntimeException("Type can be only raw, manufactured or imported");
        }
    }
    public static void validateAndDisplay(final ArrayList<String>argsList){
        validateMinimumArguments(argsList);
        validateNameAndType(argsList);
        validateAllArguments(argsList);
        validatePriceAndQuantity(argsList);
        validateTypeOfItem(argsList);
        String name;
        String type;
        name=argsList.get(argsList.indexOf("-name")+1);
        type=argsList.get(argsList.indexOf("-type")+1);
        int price=0;
        int quantity=1;
        if(argsList.contains("-price")){
            price=Integer.parseInt(argsList.get(argsList.indexOf("-price")+1));
        }
        if(argsList.contains("-quantity")){
            quantity=Integer.parseInt(argsList.get(argsList.indexOf("-quantity")+1));
        }
        final Item item=new Item(name,type,price,quantity);
        item.displayItemDetails();
    }
    public static void main(final String[] args) {
        final ArrayList<String> argsList = new ArrayList<>(Arrays.asList(args));
        System.out.println();
	// write your code here
        try{
            validateAndDisplay(argsList);

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
                final ArrayList<String>argList= new ArrayList<>();
                argList.add("-name");
                argList.add(itemName);
                argList.add("-type");
                argList.add(itemType);
                argList.add("-price");
                argList.add(itemPrice);
                argList.add("-quantity");
                argList.add(itemQuantity);
                validateAndDisplay(argList);
                System.out.println("Do you want to enter details of any other item (y/n):");
                option=scan.nextLine();
            }
        }
        catch(RuntimeException e){
            System.out.println(e.toString());
        }
    }
}
