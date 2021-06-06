import main.java.assignment.CommandLineArgumentParser;
import main.java.assignment.exceptions.InvalidArgumentException;
import main.java.assignment.models.ImportedItem;
import main.java.assignment.models.Item;
import main.java.assignment.models.ManufacturedItem;
import main.java.assignment.models.RawItem;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestUnit {
    String message="Sugarcane";
    Item item=new RawItem("Sugarcane",20,3);
    @Test
    public void testNameValues(){
        assertEquals(message,item.getName());
    }
    @Test
    public void testPriceValues(){

        assertEquals(20,item.getPrice());
            }
    @Test
    public void testQuantityValues(){

        assertEquals(3,item.getQuantity());
    }

    @Test
    public void testManufactured(){
        String[] temp=new String[]{"-name", "chocolate", "-type", "manufactured", "-price", "20", "-quantity", "2"};
        Item item=new CommandLineArgumentParser().getItem(temp);
        assertEquals(item.getFinalPrice(),new ManufacturedItem("chocolate",20,2).getFinalPrice(),0.00);

    }
    @Test
    public void testRaw(){
        String[] temp=new String[]{"-name", "chocolate", "-type", "raw", "-price", "20", "-quantity", "2"};
        Item item=new CommandLineArgumentParser().getItem(temp);
        assertEquals(item.getFinalPrice(),new RawItem("chocolate",20,2).getFinalPrice(),0.00);
    }
    @Test
    public void testImported(){
        String[] temp=new String[]{"-name", "chocolate", "-type", "imported", "-price", "20", "-quantity", "2"};
        Item item=new CommandLineArgumentParser().getItem(temp);
        assertEquals(item.getFinalPrice(),new ImportedItem("chocolate",20,2).getFinalPrice(),0.00);

    }
    @Test(expected = InvalidArgumentException.class)
    public void testInvalidOrderArguments(){
        String[] temp={"-type","raw","-name","water"};
        assertThrows(InvalidArgumentException.class,new CommandLineArgumentParser().getItem(temp));
    }
    @Test(expected = InvalidArgumentException.class)
    public void testValuesMissing(){
        String[] temp={"-type","raw","-name","-price"};
        assertThrows(InvalidArgumentException.class,new CommandLineArgumentParser().getItem(temp));
    }
    @Test(expected = InvalidArgumentException.class)
    public void testBlankValues(){
        String[] temp={"-type","raw","-name"," "};
        assertThrows(InvalidArgumentException.class,new CommandLineArgumentParser().getItem(temp));
    }
    @Test(expected = InvalidArgumentException.class)
    public void testInvalidTypeOfValues(){
        String[] temp={"-type","raw","-name","-rubber","-price","10.25"};
        assertThrows(InvalidArgumentException.class,new CommandLineArgumentParser().getItem(temp));
    }




}
