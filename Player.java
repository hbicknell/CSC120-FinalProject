import java.util.ArrayList;

public class Player {
   
    private String name;
    /* 
    private int playerHealth;
    private int strengthScore;
    private int agilityScore;
    private int intelligenceScore;
    private int wisdomScore;
    //private int totalCoins;
    private boolean lanternFlag;
    */
    private Area playerArea;
    ArrayList<Item> playerInventory;

    /* Overloaded Constructor */
    public Player(){
        this.name = "???";
       /* 
        this.playerHealth = 20;
        this.strengthScore = 6; 
        this.agilityScore = 6; 
        this.intelligenceScore = 6;
        this.wisdomScore = 6;
        this.lanternFlag = false;
        */
        this.playerInventory = new ArrayList<Item>();
    }

    public Player(Area area){
        this.name = "???";
       /* 
        this.playerHealth = 20;
        this.strengthScore = 6; 
        this.agilityScore = 6; 
        this.intelligenceScore = 6;
        this.wisdomScore = 6;
        this.lanternFlag = false;
        */
        this.playerArea = area;
        this.playerInventory = new ArrayList<Item>();
    }
    
    /* Full Constructor */
    public Player(String name, int health, int strength, int agility, int intelligence, int wisdom, Area area) {
        this.name = name;
        /*  
        this.playerHealth = health;
        this.strengthScore = strength; 
        this.agilityScore = agility;
        this.intelligenceScore = intelligence;
        this.wisdomScore = wisdom;
        //this.totalCoins = coins;
        this.lanternFlag = false;
        */
        this.playerArea = area;
        this.playerInventory = new ArrayList<Item>();
    }

    /** your standard getters and changeers/accessors */
    public String getName(){
        return this.name;
    }

    /*
    public int getHealth(){
        return this.playerHealth;
    }

    public int getStrength(){
        return this.strengthScore;
    }

    public int getAgility(){
        return this.agilityScore;
    }

    public int getIntelligence(){
        return this.intelligenceScore;
    }

    public int getWisdon(){
        return this.wisdomScore;
    }
    */

    public Area getArea(){
        return this.playerArea;
    }
    
    /* 
    public boolean getLanternFlag(){
        return this.lanternFlag;
    }

    public void changeName(String newName){
        this.name = newName;
    }

    public void changeStrength(int plus){
        this.strengthScore += plus;
    }

    public void changeAgility(int plus){
        this.agilityScore += plus;
    }

    public void changeIntelligence(int plus){
        this.intelligenceScore += plus;
    }

    public void changeWisdom(int plus){
        this.wisdomScore += plus;
    }
    */
    public void changePlayerArea(Area area){
        this.playerArea = area;
    }

    /** inventory things */
    public void listInventory(){
        System.out.println("Items in your inventory:");
        for (Item item : this.playerInventory) {
            System.out.println(item.getName());
        }
    }
    public void addToInventory(Item item){
        this.playerInventory.add(item);
    }

    public void removeFromInventory(Item item){
        this.playerInventory.remove(item);
    }

    /* PLAYER COMMANDS COMPANIONS */

    /** sleep */

    public void sleep(Area area){
        if (this.playerArea == area){
            //this.playerHealth = 20;
            System.out.println("You feel all restored after a nice little rest!");
        } else {
            throw new RuntimeException("Silly you can't sleep here!");
        }
    }

     public Item playerMatchItem(String[] userList){
        for(Item inventoryItem : this.playerInventory){ 
            for(String item : userList){
                String itemLowercase = item.toLowerCase();
                if(inventoryItem.getName().contains(itemLowercase)){
                    return inventoryItem;
                }
            }
        }
        return null;
    }





    //public void pickUpItem();
    
    public static void main(String[] args) {
        Player player = new Player();
        Item urmom = new Item( "ur mom", "ur mom");
        player.addToInventory(urmom);
        player.listInventory();
    }
    

}
