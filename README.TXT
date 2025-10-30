Project: zuul-bad
Authors: Michael Kölling and David J. Barnes

This project is part of the material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Seventh edition
   David J. Barnes and Michael Kölling

This project is a simple framework for an adventure game. In this version,
it has a few rooms and the ability for a player to walk between these rooms.
That's all.

To start this application, create an instance of class "Game" and call its
"play" method.

This version of the game contains some very bad class design. It should NOT
be used as a basis for extending the project without fixing these design
problems. It serves as an example to discuss good and bad design (chapter 8
of the book).

Chapter 8 of the book contains a detailed description of the problems in this
project, and how to fix them.

The project 'zuul-better' contains a version of this project with better
designed class structure. It includes the fixes discussed in the book.

Lab report (part b = answer)

1. Open the project zuul-bad. (This project is called “bad” because its implementation 
contains some bad design decisions, and we want to leave no doubt that this should not be 
used as an example of good programming practice!) Execute and explore the application. The 
project comment gives you some information about how to run it. 
While exploring the application, answer the following questions: 
▪ What does this application do?
 ▪ What commands does the game accept?
 ▪ What does each command do?
 ▪ How many rooms are in the scenario?
 ▪ Draw a map of the existing rooms. 

1b.It is a text based adventure game, in which you move around areas in a university campus. 
The accepted commands include go with 4 varitaions, go west, go east, go south, go north, 
help and finally quit. The go variations are for traversing the game's areas. The help 
command is for receiving recognized commands and quit is for ending the game. There are 5 rooms in this scenario, Lab, Office, Outiside, Pub, Theatre. Image is attached.

2. After you know what the whole application does, try to find out what each individual class 
does. Write down for each class its purpose. You need to look at the source code to do this. 
Note that you might not (and need not) understand all of the source code. Often, reading 
through comments and looking at method headers is enough.

2b.The game class is responsible for many things, creating rooms, their exits, the messages that need printing out, recognizing commands from user. The command class is responsible for returning a boolean variable to whoever other class sends a command over, either to signal the command understood or the failure to do so. The room class is responsible for creating the different traversable areas. The commandWords class is responsible for holding functional commands and sending a signal to check if a command sent to it is a valid command. Finally, we have the Parser Class, who is responsible for tokenizing input given by user, to individualize each part of a two-word sentence given into different words and sends them to the Command class to apply the command if valid.

3. Design your own game scenario. Do this away from the computer. Do not think about 
implementation, classes, or even programming in general. Just think about inventing an 
interesting game. This could be done with a group of people. The game can be anything that 
has as its base structure a player moving through different locations. 
Here are some examples: 
▪ You are a white blood cell traveling through the body in search of viruses to attack
 ▪ You are lost in a shopping mall and must find the exit
 ▪ You are a mole in its burrow and you cannot remember where you stored your food reserves 
before winter
 ▪ You are an adventurer who searches through a dungeon full of monsters and other characters
 ▪ You are on the bomb squad and must find and defuse a bomb before it goes off
Make sure that your game has a goal (so that it has an end and the player can “win”). Try to 
think of many things to make the game interesting (trap doors, magic items, characters that 
help you only if you feed them, time limits... whatever you like). Let your imagination run 
wild. At this stage, do not worry about how to implement these things. 

3b.An example of a fun game could be, walking around a maze in order to escape, if possible 
make it so that the exit is not always the same. You know, spice up the game with some RNG. 
Have ennemies inside that need to be talked to, if your answer incorrectly, then you will get 
hurt. These choices would be given by the game and not dynamic. An example of this mechanic 
would be: "You encounter a large rat. Do you, a) Touch it, b)Kick it, c)Kiss it.", from this 
example, it would be a and c that make you lose health while b makes you avoid damage. Ive 
included a hand drawn image of my concept in mind. To be clear, room exits are set randomly

4. Draw (on paper) a map for the game you invented in exercise 3. Open the zuul-bad project 
and save it under a different name eg., zuul). This is the project you will use for making 
improvements and modifications throughout this chapter. You can leave off the -bad suffix, 
because it will (hopefully) soon not be that bad anymore. As a first step, change the 
createRooms method in the Game class to create the rooms and exits you invented for your 
game. 

4b. The map is in the image I sent.

5. Both the printWelcome and goRoom methods of the Game class contain code that prints 
information about the current location, but neither can call each other because they also do 
other things. This is bad design, an example of low cohesion. Implement and use a separate 
printLocationInfo method in your project, eliminating this code repetition. Test your changes.

5b.
private void printLocationInfo()
    {
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        if(currentRoom.northExit != null) {
            System.out.print("north ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print("east ");
        }
        if(currentRoom.southExit != null) {
            System.out.print("south ");
        }
        if(currentRoom.westExit != null) {
            System.out.print("west ");
        }
    }

/**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
        System.out.println();
    }

/** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        if(direction.equals("north")) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")) {
            nextRoom = currentRoom.westExit;
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            printLocationInfo();
            System.out.println();
        }
    }

6. Apply the concepts of encapsulation by making the following changes to the Room class. All 
fields should be private, and there should be an acessor method to access them. Then you need 
to change the Game class to use the acessor method whenever an exit variable is accessed.
For example, instead of writing
 nextRoom = currentRoom.eastExit;
we now write 
nextRoom = currentRoom.getExit(“east”);
Once those changes are done, check if you can reduce code repetition in the goRoom method by 
using 
Room nextRoom = currentRoom.getExit(direction);

6b.
/** * 
     * Return a description of the room’s exits, 
     * for example, "Exits: north west". 
     * @return A description of the available exits. 
    */
     
    public Room getExit(String direction)
    {
        if(direction.equals("north")) {
            return northExit;
        }
        if(direction.equals("east")) {
            return eastExit;
        }
        if(direction.equals("south")) {
            return southExit;
        }
        if(direction.equals("west")) {
            return westExit;
        }
        return null;
    }

/** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            currentRoom.getExitString(currentRoom);
            System.out.println();
        }
    }

7. Make a similar change to the printLocationInfo method of Game so that details of the exits 
are now prepared by the Room rather than the Game. Define a method in Room with the following 
header: 
/** * Return a description of the room’s exits, 
* for example, "Exits: north west". 
* @return A description of the available exits. */
 */ 
public String getExitString()

7b.
/** * 
     * Return a description of the room’s exits, 
     * for example, "Exits: north west". 
     * @return A description of the available exits. 
    */
     
    public Room getExit(String direction)
    {
        if(direction.equals("north")) {
            return northExit;
        }
        if(direction.equals("east")) {
            return eastExit;
        }
        if(direction.equals("south")) {
            return southExit;
        }
        if(direction.equals("west")) {
            return westExit;
        }
        return null;
    }

/** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            currentRoom.getExitString(currentRoom);
            System.out.println();
        }
    }

/**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        currentRoom.getExitString(currentRoom);
        System.out.println();
    }
8. Now we want to add up and down exit directions to the Room class. Since the internal 
representation in Room has been completely decoupled from the interface, we can make changes 
without breaking the Game class. The first change you need to make is to replace all separate 
exit fields of the Room class into a single HashMap<String,Room> exits fields, to store 
direction and corresponding rooms. The construtor and setExits methods should be changed as 
following. Make the needed changes (or comment code for now) in the other methods so that 
your project compiles. In order to finally be able to add additional directions, we need to 
modify the header of the setExits method, which is now the only restriction in the Room class 
that makes it only store four exits. Make it so that exits of a room can be set one at a 
time, and any direction can be used for an exit. The new method will look like 
public void setExit(String direction, Room neighbor) {
 exits.put(direction, neighbor);
}
 And in the Game class, instead of writing
 lab.setExits(outside, office, null, null);
 we now write
 lab.setExit(“north”, outside);
 lab.setExit(“east”, office);
 With that, you should be ready to add “up” and “down” as exits with no problem.

8b.
public void setExit(String direction, Room nextRoom)
    {
        exits.put(direction, nextRoom);
    }
/**
     * Create all the rooms and link their exits together.
     */
    public void createRooms()
    {
        Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // initialise room exits
        //outside.setExits(null, theater, lab, pub);
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        //theater.setExits(null, null, null, outside);
        theatre.setExit("west", outside);
        //pub.setExits(null, outside, null, null);
        pub.setExit("east", outside);
        //lab.setExits(outside, office, null, null);
        lab.setExit("north", outside);
        lab.setExit("east", office);
        //office.setExits(null, null, null, lab);
        office.setExit("west", lab);
        
        currentRoom = outside;
    }


9. Look up the keySet method in the documentation of HashMap. What does it do? 

9b. It returns a set of all keys in a HashMap! Cold be useful to further refine the help in the valid 
commands class?

10. Use keySet in your re-write of the getExitString method of the Room class, to iterate 
over the map of exits and concatenate directions into a single String, which is returned. 

10b.
/**
    * Return a description of the room’s exits,
    * for example, "Exits: north west".
    * @return A description of the available exits.
    */
    public void getExitString(Room currentRoom)
    {
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        Set<String> directions = exits.keySet();
        StringBuilder exitString = new StringBuilder();
        for(String direction : directions)
        {
            exitString.append(direction + ", ");
        }
        exitString.deleteCharAt(exitString.length() - 2);
        System.out.print(exitString);
    }

11. Loose coupling demands that changes to the Room class do not require changes to the Game 
class. The Room class holds information about a room, it should also produce a description 
for a room. Add the following method to the Room class and make the Game class use it where 
appropriate.
 public String getLongDescription(){
 return “You are ” + description + “.\n” + getExitString();
 }

11b.
/**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
        System.out.println();
    }

/** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            System.out.println();
        }
    }

12. Draw an object diagram with all objects in your game, the way they are just after 
starting the game. 

12b.

13. How does the object diagram change when you execute a go command? 

13b.

14. Add the look command to your version of the zuul game. The purpose of look is merely to 
print out the description of the room and the exits again (we “look around the room”). You’ll 
need to modify classes CommandWords and Game. 

14b.

15. Add another command to your game. For a start, you could choose something simple, such as 
a command eat that, when executed, just prints out “You have eaten now and you are not hungry 
any more.” Later, we can improve this so that you really get hungry over time and you need to 
find food. 

15b.

16. Implement an improved version of printing out the command words, that allows the help to 
automatically recognize new commands added. The CommandWords class should have a showAll 
method that prints all valid commands. The Game class should not depend on CommandWords 
(unnecessary coupling), it should access the CommandWords object via its parser attribute. 

16b.

17. If you now add another new command, do you still need to change the Game class? Why?

17b.

18. The CommandWords class has a single static field and no instance data, but its methods 
are all instance methods. In the light of this, do you think it would it be more appropriate 
for all of its methods to be static methods, and for the Parser to call those methods on the 
class rather than create an instance of ? 
What are the pros and cons?

