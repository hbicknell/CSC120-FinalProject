import java.util.Scanner;

public class Gameloop {
    
    public static void main(String[] args) {
        Main main = new Main();
        Area house = new Area("House", "House Desc");
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

        
        System.out.println("There is a figure in front of you, but that is all you can make out about her. Her face and surrondings are a blur, but her voice is clear when she speaks.");
        System.out.println("\"Hello " + player.getName() + ". Welcome to your new life as an adventurer for hire!\"");
        main.promptFirstEnter(userInput);
        System.out.println("\"Here at Hire an Adventurer TM, we've capitalized the average local party of gallavanting saviors into reliable employees and contractors.");
        main.promptEnter(userInput);
        System.out.println("And you, yes you! Have just been hired for your stunning resume. I see here your skils in " + firstTalent + " and " + secondTalent + " are emphasised.");
        main.promptEnter(userInput);
        System.out.println("We even have a job to start you off! A nice easy intro into this job.");
        main.promptEnter(userInput);
        System.out.println("Now standard procedure is you wake up there with no memory but what is essential...");
        main.promptEnter(userInput);
        System.out.println("I know unorthodox but this little detail keeps our employees motivated on the job and our retention rate 100%!");
        main.promptEnter(userInput);
        System.out.println("So just hold still while I perform a quick spell and in moments you'll start your new job...goodluck!\"");


        /** 
        boolean stillPlaying = true; 
        do {
            // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            System.out.println("You are in the loop");
            userResponse = userInput.nextLine().toUpperCase();
            
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
            if (userResponse.equals("OUT")) {
                stillPlaying = false;
            }
        } while (stillPlaying);
        */
        // Tidy up
        userInput.close();

        System.out.println("You're out");
    }
}
