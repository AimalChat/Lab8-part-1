import java.util.HashMap;

/**
 * Write a description of class itemlist here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class itemlist
{
    // instance variables - replace the example below with your own
    private int x;
private static final String[] items =
    {
        "magic cookie", "gun", "biscuits", "feather", "dumbbell"
    };
    
    private static final HashMap<String,Integer> WEIGHT = new HashMap<>();
    static
    {
        WEIGHT.put("magic cookie", 2);
        WEIGHT.put("gun",10);
        WEIGHT.put("bicuits",2);
        WEIGHT.put("feather",1);
        WEIGHT.put("dumbbell", 5);
    }
    
    private static final HashMap<String,String> DESCRIPTION = new HashMap<>();
    static//21
    {
        DESCRIPTION.put("magic cookie", "a special cookie that gives the power to hold more items.");
        DESCRIPTION.put("gun", "an AK-47 to be exact :D");
        DESCRIPTION.put("biscuits", "a buttery biscoff biscuits, curbs hunger.");
        DESCRIPTION.put("feather", "a pigeon feather.");
        DESCRIPTION.put("dumbbell", "a 5 lbs dumbbell, belongs in the gymnasium.");
    }
    /**
     * Constructor for objects of class itemlist
     */
    public itemlist()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
