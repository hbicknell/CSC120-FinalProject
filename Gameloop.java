import java.util.Scanner;

public class Gameloop {
    
    public static void main(String[] args) {
        Main main = new Main();
        Area house = new Area("The House", "House Desc");
        Player player = new Player(house);

        
        Scanner userInput = new Scanner(System.in);

        String userResponse = "";
        
        System.out.println("What is your name?");
        userResponse = userInput.nextLine();
        player.changeName(userResponse);

        boolean firstAttributeNotSelected = true;
        boolean secondAttributeNotSelected = true;
        String firstTalent = "";
        String secondTalent = "";

        while(firstAttributeNotSelected){
            System.out.println("What is more important to you? Strength or Agility?");
            userResponse = userInput.nextLine().toLowerCase();
            if (userResponse.equals("strength")){
                player.changeStrength(2);
                //System.out.println(player.getStrength());
                firstTalent = "strength";
                break;
            } else if (userResponse.equals("agility")){
                player.changeAgility(2);
                firstTalent = "agility";
                break;
            } else {
                System.out.println("That's not what I asked");
            }
        }
        
        while(secondAttributeNotSelected){
            System.out.println("What is more important to you? Intelligence or Wisdom?");
            userResponse = userInput.nextLine().toLowerCase();
            if (userResponse.equals("intelligence")){
                player.changeIntelligence(2);
                //System.out.println(player.getIntelligence());
                secondTalent = "intelligence";
                break;
            } else if (userResponse.equals("wisdom")){
                player.changeWisdom(2);
                secondTalent = "wisdom";
                break;
            } else {
                System.out.println("That's not what I asked");
            }
        }

        main.beginningDialogue(player, firstTalent, secondTalent, userInput);

        NPC Ariela = main.arielaFirstDialogue(player, userInput);

        System.out.println("What would you like to do?");

        
        boolean stillPlaying = true; 
        int moveCounter = 10;
        do {
            // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            System.out.println("You are in the loop");
            userResponse = userInput.nextLine().toLowerCase();
            String[] allSplitUserResponse = userResponse.split(" "); 
            String[] firstSplitUserResponse = userResponse.split(" ", 2);

            if (allSplitUserResponse[0].equals("go")){
                if (allSplitUserResponse[1].equals("forward")){
                    player.changePlayerArea(player.getArea().getForwardArea());
                    System.out.println("You enter" + player.getArea());
                    System.out.println(player.getArea().getDescription());
                }else if(allSplitUserResponse[1].equals("back") || allSplitUserResponse[1].equals("backward")){
                   player.changePlayerArea(player.getArea().getBackArea());
                    System.out.println("You enter" + player.getArea());
                    System.out.println(player.getArea().getDescription()); 
                }else{
                    System.out.println("Error. Can\'t find command.");
                }
            }

            if (allSplitUserResponse[0].equals("describe")){
                Item itemInArea = player.getArea().areaMatchItem(allSplitUserResponse);
                Item itemInPlayer = player.playerMatchItem(firstSplitUserResponse);
                if (itemInArea != null){
                    itemInArea.getDescription();
                } else if(itemInPlayer != null){
                    itemInPlayer.getDescription();
                } else{
                    System.out.println("Item not found");
                }

            if(allSplitUserResponse[0].equals("explore")){
                System.out.println("You explore " + player.getArea().getName());
                String foundItems = player.getArea().exploreArea();
                System.out.println("You found" + foundItems);
            }

            if(allSplitUserResponse[0].equals("pick")){
                Item itemPickUp = player.getArea().areaMatchItem(allSplitUserResponse);
                if (itemPickUp!= null){
                    System.out.println("You picked up " + itemPickUp.getName());
                    player.addToInventory(itemPickUp);
                    player.getArea().removeFromArea(itemPickUp);
                }else{
                    System.out.println("Item not found");
                }
            }

            if(allSplitUserResponse[0].equals("put")){
                 Item itemPutDown = player.playerMatchItem(firstSplitUserResponse);
                if(itemPutDown != null){
                    System.out.println("You put down" + itemPutDown.getName());
                    player.removeFromInventory(itemPutDown);
                    player.getArea().addToArea(itemPutDown);
                }else{
                    System.out.println("Item not found.");
                }
            }
            
            



            try{
                player.userResponse();
            } catch (NoSuchMethodException e) {
                System.out.println("Method was not found!");
            } catch (Exception e) {
                //e.printStackTrace();
            }
                
            
            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            if (userResponse.equals("out")) {
                stillPlaying = false;
            }
        } while (stillPlaying);
        
        // Tidy up


        userInput.close();

        System.out.println("You're out");
    }
}
