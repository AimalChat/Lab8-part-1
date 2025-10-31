import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 7.0
 */

public class CommandWords
{
    // A constant array that holds all valid command words.
    private static final String[] validCommands = {
        "go", "quit", "help", "look", "eat", "details"
    };
    private static final HashMap<String,Integer> LENGTH = new HashMap<>();
    static 
    {
        LENGTH.put("go",2);
        LENGTH.put("quit",1);
        LENGTH.put("help",1);
        LENGTH.put("look",1);
        LENGTH.put("eat",1);
        LENGTH.put("details",1);
    }
    private static final HashMap<String,String> DESCRIPTION = new HashMap<>();
    static
    {
        DESCRIPTION.put("go", "to move around, must specify direction after 'go'.");
        DESCRIPTION.put("quit", "to exit game.");
        DESCRIPTION.put("help", "displays game context & valid commands.");
        DESCRIPTION.put("look", "to examine current surroundings.");
        DESCRIPTION.put("eat", "to consume an item");
        DESCRIPTION.put("details", "this very message shows length%nand a brief explaination of all commands.");
    }

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }
    
    public static String[] getValidCommands()
    {
        return validCommands;
    }
    
    public static void showCommandWords()
    {
        StringBuilder listCommands = new StringBuilder();
        listCommands.append("     ");
        for(String command : getValidCommands())
        {
            listCommands.append(command + "  ");
        }
        String listOfCommands = listCommands.toString();
        System.out.println("Your command words are:");
        System.out.println(listOfCommands);
    }
    
    public static void commandDetails()
    {
        StringBuilder commandDetails = new StringBuilder();
        for(String command : getValidCommands())
        {
            commandDetails.append(command + ": ");
            commandDetails.append(LENGTH.get(command)+ ", " + DESCRIPTION.get(command)+"\n");
        }
        String commandsDetails = commandDetails.toString();
        System.out.println(commandsDetails);
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public static boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString)) {
                return true;
            }
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}
