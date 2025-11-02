import java.util.HashMap;
import java.util.ArrayList;

/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    private int weight;
    private String itemName;
    private String description;
    private static ArrayList<Item> items = new ArrayList<Item>();
    static
    {
        items.add(new Item("magic cookie","a special cookie that gives the power to hold more items.", 2));
    }
    
    /**
     * Constructor for objects of class Item
     */
    public Item(String itemName, String description, int weight)
    {
        this.itemName = itemName;
        this.description = description;
        this.weight = weight;
    }
    
    public static ArrayList<Item> getItemList()
    {
        return items;
    }
    
    public String getItemName()
    {
        return itemName;
    }
    
    public String getItemDescription()
    {
        return description;
    }
    
    public int getWeight()
    {
        return weight;
    }
}
