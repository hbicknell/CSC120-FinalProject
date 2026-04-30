import java.util.Scanner;
import java.util.*;

public class Gameloop {
    
    public static void main(String[] args) {
       /**OBJECT SETUP */
        Main main = new Main();
        Area house = new Area("The House", "It is a small little room, decorated sparingly.");
        Area town = new Area("The Town", "A small town, it seems rather empty but has a few houses and shops.");
        Area meadow = new Area("A Meadow", "A beautiful opening in a small forest, the sun shines through illuminating the foliage.");
        Area cave1 = new Area ("The Cave", "A dimly lit cave, filled with decaying barrels and dirt. There is a wall on the opposite side that holds a door.");
        Area cave2 = new Area ("The Cave Room", "A brightly lit room with scattered planks and other building materials in it. In the middle there is a box.");
        Item redrock = new Item("A Ruby", "A brightly colored red stone sphere. ");
        Item bluerock = new Item("Lapis Lazuli", "A brightly colored blue stone sphere.");
        Item purplerock = new Item("An Amethyst", "A brightly colored purple stone sphere.");
        Item key = new Item("A Key", "A rusted old key.");
        Door door = new Door(true);
        Puzzle puzzle = new Puzzle("A box with three top slots that appear to be spherical.", redrock, purplerock, bluerock, "A recipe!");
        town.addToHiddenArea(purplerock);
        meadow.addToHiddenArea(key);
        cave1.addToHiddenArea(redrock);
        cave2.addToHiddenArea(bluerock);
        main.areaSetting(house, town, meadow, cave1, cave2); 
        Player player = new Player(house);

        
    /* SCANNER SET UP */
        Scanner userInput = new Scanner(System.in);
        String userResponse = "";
        
    /* PLAYER QUESTIONS SETUP */
        System.out.println("What is your name?");
        userResponse = userInput.nextLine();
        player.changeName(userResponse);

        boolean firstAttributeNotSelected = true;
        String firstTalent = "";

        while(firstAttributeNotSelected){
            System.out.println("What is more important to you? Strength or Intelligence?");
            userResponse = userInput.nextLine().toLowerCase();
            if (userResponse.equals("strength")){
                player.changeStrength(2);
                firstTalent = "strength";
                break;
            } else if (userResponse.equals("intelligence")){
                player.changeIntelligence(2);
                firstTalent = "intelligence";
                break;
            } else {
                System.out.println("That's not what I asked");
            }
        }

        /*BEGINNING DIALOGUE */
        main.beginningDialogue(player, firstTalent, userInput);

        NPC Ariela = main.arielaFirstDialogue(player, userInput);

        /* MOVE COUNTER SET UP AND EXPLANATION */
        int moveCounter = 18;

        System.out.println("As the woman said, this is a short job!");
        main.promptEnter(userInput);
        System.out.println("You must complete this job in " + moveCounter + " actions or you'll get a negative performace review and be uneployed again!");
        System.out.println("You will be told in the options bar if a command costs an action. Good luck!");
        main.promptEnter(userInput);
       
    /* PROMPT DIALOGUE SET UP */
        System.out.println("Your options are: \n Go Forward [1 Action]");
        System.out.println("At anytime you can type: Show Options");
        System.out.println("What would you like to do?");


    /* GAMELOOP SECTION */
        boolean stillPlaying = true; 
        do {
            
        /* USER RESPONSE SET UP  */
            userResponse = userInput.nextLine().trim().toLowerCase();
            String[] allSplitUserResponse = userResponse.split(" "); 
            String[] firstSplitUserResponse = userResponse.split(" ", 2);

        /* IF PLAYER SAYS GO */
            if (allSplitUserResponse[0].equals("go")){
                if(allSplitUserResponse.length < 2){
                    System.out.println("Not a command!");
                } else if (allSplitUserResponse[1].equals("forward")){
                    boolean specialFlag = false;
                    if(player.getArea() == cave1 && player.playerInventory.contains(key) && door.getLockedStatus() == true){  
                        System.out.println("You try the door and notice it it locked. However you remember the key you picked up earlier. Would you like to try the key?");
                        while(true){
                            userResponse = userInput.nextLine().toLowerCase();
                            if(userResponse.equals("yes")){
                                System.out.println("You try the key and it works! The door swings open.");
                                door.unlock();
                                break;
                            }else if(userResponse.equals("no")){
                                System.out.println("Okay. The door remains closed and you are still where you are.");
                                specialFlag = true;
                                break;
                            }else{
                                System.out.println("Yes or no?");
                            }
                        }
                    }else if(player.getArea() == cave1 && door.getLockedStatus() == true ){
                        System.out.println("You try the door and notice it it locked. You suppose you could try breaking it down. Would you like to try that? YES [1 Action] or NO ");
                        while(true){
                            userResponse = userInput.nextLine().toLowerCase();
                            if(userResponse.equals("yes") && player.getStrength() > 6){
                                System.out.println("You kick the door down succesfully!");
                                moveCounter -= 1;
                                door.unlock();
                                break;
                            }else if(userResponse.equals("yes") && player.getStrength()<= 6){
                                System.out.println("You try your hardest but because you're not strong enough the door does not budge.");
                                specialFlag = true;
                                break;
                            }else if(userResponse.equals("no")){
                                System.out.println("Okay. The door remains closed and you are still where you are.");
                                specialFlag = true;
                                break;
                            }else{
                                System.out.println("Yes [1 Action] or no?");
                            }
                        }
                    }
                    
                    if(specialFlag != true){
                        player.changePlayerArea(player.getArea().getForwardArea());
                        System.out.println("You enter " + player.getArea().getName());
                        System.out.println(player.getArea().getDescription());
                        moveCounter -= 1;
                    }
                
                }else if(allSplitUserResponse[1].equals("back") || allSplitUserResponse[1].equals("backward")){
                   player.changePlayerArea(player.getArea().getBackArea());
                    System.out.println("You enter " + player.getArea().getName());
                    System.out.println(player.getArea().getDescription());
                    moveCounter -= 1; 
                }else{
                    System.out.println("Error. Can\'t find command.");
                    }
                
                }

        /* IF PLAYER SAYS DESCRIBE */
            if (allSplitUserResponse[0].equals("describe")){
                Item itemInArea = player.getArea().areaMatchItem(allSplitUserResponse);
                Item itemInPlayer = player.playerMatchItem(allSplitUserResponse);
                if (itemInArea != null){
                    System.out.println(itemInArea.getDescription());
                } else if(itemInPlayer != null){
                    System.out.println(itemInPlayer.getDescription());
                }else{
                    System.out.println("Item not found");
                }
            }

        /* IF PLAYER SAYS EXPLORE */
            if(allSplitUserResponse[0].equals("explore")){
                System.out.println("You explore " + player.getArea().getName());
                String foundItems = player.getArea().exploreArea();
                System.out.println("You found " + foundItems);
                moveCounter -= 1;
            }
        
        /* IF PLAYER SAYS PICK UP */
            if(allSplitUserResponse[0].equals("pick")){
                Item itemPickUp = player.getArea().areaMatchItem(allSplitUserResponse);
                if (itemPickUp!= null){
                    System.out.println("You picked up " + itemPickUp.getName());
                    player.addToInventory(itemPickUp);
                    player.listInventory();
                    player.getArea().removeFromArea(itemPickUp);
                    moveCounter -= 1;
                }else{
                    System.out.println("Item not found");
                }
            }

        /* IF PLAYER SAYS PUT DOWN */
            if(allSplitUserResponse[0].equals("put")){
                Item itemPutDown = player.playerMatchItem(allSplitUserResponse);
                if(itemPutDown!= null){
                    System.out.println("You put down " + itemPutDown.getName());
                    player.removeFromInventory(itemPutDown);
                    player.getArea().addToArea(itemPutDown);
                    moveCounter -= 1;
                }else{
                    System.out.println("Item not found.");
                }
            }

        /* IF PLAYER SAYS SHOW OPTIONA */
            if(allSplitUserResponse[0].equals("show")){
                if(player.getArea() == house){
                    System.out.println("OPTIONS AVAILABLE:");
                    System.out.println("Go Forward [1 Action]");
                }else if(player.getArea() == cave2){
                    System.out.println("OPTIONS AVAILABLE:");
                    System.out.println("Go Forward or Backward [1 Action]");
                    System.out.println("Describe [OBJECT]");
                    System.out.println("Explore [1 Action]");
                    System.out.println("Pick Up [1 Action]");
                    System.out.println("Put Down [1 Action]");
                    System.out.println("Investigate Box");
                }else{
                    System.out.println("OPTIONS AVAILABLE:");
                    System.out.println("Go Forward or Backward [1 Action]");
                    System.out.println("Describe [OBJECT]");
                    System.out.println("Explore [1 Action]");
                    System.out.println("Pick Up [1 Action]");
                    System.out.println("Put Down [1 Action]");
                }
                    
            }
            
            if(allSplitUserResponse[0].equals("investigate")){
                System.out.println("You walk up to the box and notice three divets on top of it. It appears to be a puzzle box of sorts.");
                main.promptEnter(userInput);
                System.out.println("These divets appear as if they might act like slots and they each appear to be a perfect shape for a sphere.");
                main.promptEnter(userInput);
                System.out.println("Each slot has a painted dot in front of it. The first one has a green dot. The second has a yellow dot. The third one has an orange dot.");
                if(player.getIntelligence() > 6 && player.containAnySphere(redrock, purplerock, bluerock)){
                    System.out.println("You notice that the colors do not match anything you may have in your inventory. But you do notice that a dot may be the opposite color of the " + player.spheresPlayerContains(redrock, purplerock, bluerock) + " rocks in your inventory");
                }
                System.out.println("Would you like to insert objects into the slots? YES[ 1 Action] or NO?");
                boolean investigateBox = false;
                while(true){
                    userResponse = userInput.nextLine().toLowerCase();
                    if(userResponse.equals("yes")){
                        investigateBox = true;
                        moveCounter -= 1;
                        break;
                    }else if(userResponse.equals("no")){
                        System.out.println("Okay. No longer investigating puzzle.");
                        break;
                    }else{ 
                        System.out.println("Yes or No?");
                    }
                }
                if(investigateBox == true){
                    System.out.println("PLAYER AVAILABLE INVENTORY:"); 
                    player.listInventory();
                    
                    System.out.println("What do you put in the first slot?");
                    Item playerChosen1stSlot = null;
                    userResponse = userInput.nextLine().toLowerCase();
                    if(userResponse.contains("red") || userResponse.contains("ruby")){
                        playerChosen1stSlot = redrock;
                    }else if(userResponse.contains("purple") || userResponse.contains("amethyst")){
                        playerChosen1stSlot = purplerock;
                    }else if(userResponse.contains("blue") || userResponse.contains("lapis") || userResponse.contains("lazuli")){
                        playerChosen1stSlot = bluerock;
                    }else{
                        System.out.println("Item not found or Doesn't fit in slot. Nothing put in first slot.");
                    }

                    System.out.println("What do you put in the second slot?");
                    Item playerChosen2ndSlot = null;
                    userResponse = userInput.nextLine().toLowerCase();
                    if(userResponse.contains("red") || userResponse.contains("ruby")){
                        playerChosen2ndSlot = redrock;
                    }else if(userResponse.contains("purple") || userResponse.contains("amethyst")){
                        playerChosen2ndSlot = purplerock;
                    }else if(userResponse.contains("blue") || userResponse.contains("lapis") || userResponse.contains("lazuli")){
                        playerChosen2ndSlot = bluerock;
                    }else{
                        System.out.println("Item not found. Nothing put in first slot.");
                    }

                    System.out.println("What do you put in the third slot?");
                    Item playerChosen3rdSlot = null;
                    userResponse = userInput.nextLine().toLowerCase();
                    if(userResponse.contains("red") || userResponse.contains("ruby")){
                        playerChosen3rdSlot = redrock;
                    }else if(userResponse.contains("purple") || userResponse.contains("amethyst")){
                        playerChosen3rdSlot = purplerock;
                    }else if(userResponse.contains("blue") || userResponse.contains("lapis") || userResponse.contains("lazuli")){
                        playerChosen3rdSlot = bluerock;
                    }else{
                        System.out.println("Item not found. Nothing put in third slot.");
                    }

                    if(puzzle.checkPuzzle(playerChosen1stSlot, playerChosen2ndSlot, playerChosen3rdSlot)){
                        System.out.println("As you put the last sphere in, the box glows brightly and opens!");
                        System.out.println("Inside the box is what appears to be a recipe book!");
                        puzzle.solve();
                    }else{
                        System.out.println("Nothing happens and you reset any items you put back into your inventory.");
                    }
                }
            }

            System.out.println("ACTIONS LEFT " + moveCounter);
            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            
            if(puzzle.getSolved() == true){
                System.out.println("Congratulations you got the recipe and completed your job! You won't get fired!");
                stillPlaying = false;
            }else if (moveCounter <= 0){
                System.out.println("You're all out of actions and therefore your paid time is up! You have failed your job and will go under performance review.");
                stillPlaying = false;
            }
        
        } while (stillPlaying);
        
        // Tidy up
        userInput.close();

        System.out.println("The End");
    }
}


