package main.java.assignment;
import main.java.assignment.exceptions.InvalidArgumentException;
import main.java.assignment.models.ImportedItem;
import main.java.assignment.models.Item;
import main.java.assignment.models.ManufacturedItem;
import main.java.assignment.models.RawItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommandLineArgumentParser {
  private void validateMinimumArguments(final ArrayList<String> args){
    if(args.size()<=3){
      throw new InvalidArgumentException("Minimum number of arguments needed are 4");
    }
  }
  private void validateNameAndType(final ArrayList<String>args){
    if(args.indexOf("-name")!=0){
      throw new InvalidArgumentException("-name is required to be the first option");
    }
    if(!args.contains("-type")){
      throw new InvalidArgumentException("-type is required to be the present");
    }
  }
  private void validateAllArguments(final ArrayList<String>args){
    for(final Iterator<String> s = args.iterator(); s.hasNext();){
      if(s.next().startsWith("-")&&s.hasNext()&&s.next().startsWith("-")){
        throw new InvalidArgumentException("Each argument must have values");
      }
    }
  }
  private void validatePriceAndQuantity(final ArrayList<String> args) throws InvalidArgumentException {
    try{
      if(args.contains("-price")){
        Integer.parseInt(args.get(args.indexOf("-price")+1));
      }
      if(args.contains("-quantity")){
        Integer.parseInt(args.get(args.indexOf("-quantity")+1));
      }
    }catch (Exception e){
//            System.out.println();(e.toString());
      throw new InvalidArgumentException("Quantity and price must be integers");
    }
  }
  private void validateTypeOfItem(final ArrayList<String>args){
    final String tempType= args.get(args.indexOf("-type")+1);
//        System.out.println(tempType.equals("raw"));
    if(!"raw".equals(tempType)&&!"manufactured".equals(tempType)&&!"imported".equals(tempType)){
      throw new InvalidArgumentException("Type can be only raw, manufactured or imported");
    }
  }
  private void validate(ArrayList<String> args) throws InvalidArgumentException{
    validateMinimumArguments(args);
    validateNameAndType(args);
    validateAllArguments(args);
    validatePriceAndQuantity(args);
    validateTypeOfItem(args);
  }
  public Item getItem(String[] args) throws InvalidArgumentException{
    final ArrayList<String> argsList = new ArrayList<>(Arrays.asList(args));
    validate(argsList);
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
    switch (type){
      case "raw":return new RawItem(name,price,quantity);
      case "manufactured":return new ManufacturedItem(name,price,quantity);
      case "imported":return new ImportedItem(name,price,quantity);
      default:return new Item("Invalid Item",0,0);
    }
  }
}
