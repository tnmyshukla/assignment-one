import main.java.assignment.Item;
import main.java.assignment.Main;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
public class TestUnit {
    String message="Sugarcane";
    Item item=new Item("Sugarcane","raw",20,3);
    @Test
    public void testPrintMessage(){
        assertEquals(message,item.name);
    }
    @Test(expected = RuntimeException.class)
    public void testException(){
        ArrayList<String>arg=new ArrayList<>();
        arg.add("-name");
        arg.add("-Bread");
        arg.add("-type");
        arg.add("raw");
        Main.validateAndDisplay(arg);
        arg.add("-price");
        int price=32;
        arg.add(Integer.toString(price));
        arg.add("-quantity");
        arg.add(Integer.toString(2));
    }

}
