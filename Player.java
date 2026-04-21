import java.util.ArrayList;

public class Player {
   
    private String name;
    private int playerHealth;
    private int strengthScore;
    private int agilityScore;
    private int intelligenceScore;
    private int wisdomScore;
    //private int totalCoins;
    ArrayList<Item> playerInventory;

    /* Overloaded Constructor */
    public Player(){
        this.name = "???";
        this.playerHealth = 20;
        this.strengthScore = 6; 
        this.agilityScore = 6; 
        this.intelligenceScore = 6;
        this.wisdomScore = 6;
        //this.totalCoins = 0;
        this.playerInventory = new ArrayList<Item>();
    }
    
    /* Full Constructor */
    public Player(String name, int health, int strength, int agility, int intelligence, int wisdom) {
        this.name = name; 
        this.playerHealth = health;
        this.strengthScore = strength; 
        this.agilityScore = agility;
        this.intelligenceScore = intelligence;
        this.wisdomScore = wisdom;
        //this.totalCoins = coins;
        this.playerInventory = new ArrayList<Item>();
    }
    


}
