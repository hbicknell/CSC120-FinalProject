import java.util.Scanner;

public class Main {
    
    public Main(){
    }

    /*THINGS FOR CASE/PLAYER COMMANDS */

    /** descriptions command getters 
     * NOTE: this was designed with the thought in mind that the player could type in description and get a description of anything
    */

    public void getDescription(Item item){
        System.out.println(item.getDescription());
    }

    public void getDescription(Area area){
        System.out.println(area.getDescription());
    }

    public void getDescription(NPC npc){
        System.out.println(npc.getDescription());
    }

    public void getDescription(Opponent opponent){
        System.out.println(opponent.getDescription());
    }




    /* GAME SETTING UP */

    /**
     * setting area
     * @param house
     * @param town
     * @param meadow
     * @param cave1
     * @param cave2
     */
    public void areaSetting(Area house, Area town, Area meadow, Area cave1, Area cave2){
        house.changeAreas(town, town);
        town.changeAreas(meadow, house);
        meadow.changeAreas(cave1, town);
        cave1.changeAreas(cave2, meadow);
        cave2.changeAreas(cave1, cave1);
        //cave3.changeAreas(cave2, cave2);
    }




    /* MAIN DIALOGUE */

    /**
     * beginning words
     * @param player
     * @param talentOne
     * @param talentTwo
     * @param scanner
     */
    public void beginningDialogue(Player player, String talentOne, Scanner scanner){
        System.out.println("\n");
        System.out.println("There is a figure in front of you, but that is all you can make out about her. Her face and surrondings are a blur, but her voice is clear when she speaks.");
        System.out.println("\"Hello " + player.getName() + ". Welcome to your new life as an adventurer for hire!\"");
        this.promptFirstEnter(scanner);
        System.out.println("\"Here at Hire an Adventurer TM, we've capitalized the average local party of gallavanting saviors into reliable employees and contractors.");
        this.promptEnter(scanner);
        System.out.println("And you, yes you! Have just been hired for your stunning resume. I see here your skill in " + talentOne + " is emphasised.");
        this.promptEnter(scanner);
        System.out.println("We even have a job to start you off! A nice easy intro into this job.");
        this.promptEnter(scanner);
        System.out.println("Now standard procedure is you wake up there with no memory but what is essential...");
        this.promptEnter(scanner);
        System.out.println("I know unorthodox but this little detail keeps our employees motivated on the job and our retention rate 100%!");
        this.promptEnter(scanner);
        System.out.println("Now! Quick warning, this one has not paid for very much time with you completing her request so I suggest you be quick with completng it. Or who knows what will happen!");
        this.promptEnter(scanner);
        System.out.println("So just hold still while I perform a quick spell and in moments you'll start your new job...goodluck!\"");
        System.out.println("\n");
    }

    /**
     * ariela intro dialogue
     * @param player
     * @param scanner
     * @return NPC
     */
    public NPC arielaFirstDialogue(Player player, Scanner scanner){
        NPC Ariela = new NPC("Ariela", "short young woman with a kind face and dark brown eyes. She is wearing an apron covered in flour.");
        System.out.println("You open your eyes to what appears to be a " + Ariela.getDescription());
        this.promptEnter(scanner);
        System.out.println("\"Oh hi! You\'re awake! They told me it wouldn\'t be too long before you did but I was skeptical…you seemed pretty knocked out.");
        System.out.println("My name\'s " + Ariela.getName() + ", do you know yours?\"");
        System.out.println("You tell her your name: \"It's " + player.getName() + ".\"\n");
        this.promptEnter(scanner);
        System.out.println(" \"Oh that\'s lovely. They told me that they wiped your non-essential memory for…oh what was it? Mission effectiveness? Efficiency? I\'m not really sure there was a lot of jargon.");
        this.promptEnter(scanner);
        System.out.println("Anyways, I\'ve hired you because I need you to get something from the local cave. You see, I come from a long line of bakers and we\'ve been in this town forever!");
        this.promptEnter(scanner);
        System.out.println("Our bakery has allowed us a stable income, but recently the town's population has dwindled and with it tourism. There\'s barely anyone to buy my baked goods anymore."); 
        System.out.println("However, there\'s a story in my family that long ago, we possessed a recipe for a baked good so divine it even drew monarchs from neighboring kingdoms!");
        this.promptEnter(scanner);
        System.out.println("The problem is, it is said that a band of bandits came in and stole the recipe all those years ago because they wanted it all for themselves and barricaded themselves in the cave nearby with dozens of monsters to guard them!");
        this.promptEnter(scanner);
        System.out.println("I need this recipe! But I\'m not nearly strong enough if I encounter a monster in that cave. So I\'m asking you to go and see if you can find my family's old recipe, can you do it? \"\n");
        System.out.println("Answer her:");
       
        while(true){
            System.out.println("Yes or Yes");
            String response = scanner.nextLine().toLowerCase();
            if(response.equals("yes") || response.equals("yes ")){
                break;
            }
        }
        System.out.println("\"Great! I could only afford to hire you for a little bit so please hurry! Good luck! \"");
        System.out.println("She leaves the room.");
        return Ariela;
    }

    /** prompt enter */
   
    /**
     * prompts user enter
     * @param scanner
     */
    public void promptEnter(Scanner scanner){
        scanner.nextLine();
    }

    /**
     * prompts first enter by printing
     * @param scanner
     */
    public void promptFirstEnter(Scanner scanner){
        System.out.println("Press ENTER to Continue...");
        scanner.nextLine();
    }

}
