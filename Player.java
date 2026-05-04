import java.util.ArrayList;

public class Player {
   
    private String name;
     
    //private int playerHealth;
    private int strengthScore;
    //private int agilityScore;
    private int intelligenceScore;
    //private int wisdomScore;
    //private int totalCoins;
    //private boolean lanternFlag;
    
    private Area playerArea;
    ArrayList<Item> playerInventory;


    /* Overloaded Constructor */
    public Player(){
        this.name = "???"; 
        //this.playerHealth = 20;
        this.strengthScore = 6; 
        //this.agilityScore = 6; 
        this.intelligenceScore = 6;
        //this.wisdomScore = 6;
        //this.lanternFlag = false;
        this.playerInventory = new ArrayList<Item>();
    }

    /*Overloaded Constructor with Area */
    public Player(Area area){
        this.name = "???";
        //this.playerHealth = 20;
        this.strengthScore = 6; 
        //this.agilityScore = 6; 
        this.intelligenceScore = 6;
        //this.wisdomScore = 6;
        //this.lanternFlag = false;
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

    /** GETTERS FOR ATTRIBUTES */
    public String getName(){
        return this.name;
    }

    public int getStrength(){
        return this.strengthScore;
    }
    
    public int getIntelligence(){
        return this.intelligenceScore;
    }

    /* 
    public int getHealth(){
        return this.playerHealth;
    }

    public int getAgility(){
        return this.agilityScore;
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

    */

    /** MANIPULATORS FOR ATTRIBUTES */
    public void changeName(String newName){
        this.name = newName;
    }

     
    public void changeStrength(int plus){
        this.strengthScore += plus;
    }

    public void changeIntelligence(int plus){
        this.intelligenceScore += plus;
    }

    /* 
    public void changeAgility(int plus){
        this.agilityScore += plus;
    }

    public void changeWisdom(int plus){
        this.wisdomScore += plus;
    }
    */
   
    public void changePlayerArea(Area area){
        this.playerArea = area;
    }


    /**INVENTORY INTERACTION */

    /** Lists inventory as a string */
    public void listInventory(){
        System.out.println("Items in your inventory:");
        for (Item item : this.playerInventory) {
            System.out.println(item.getName());
        }
    }
    /**
     * add to inventory
     * @param item
     */
    public void addToInventory(Item item){
        this.playerInventory.add(item);
    }

    /**
     * removes from inventory
     * @param item
     */
    public void removeFromInventory(Item item){
        this.playerInventory.remove(item);
    }

    /**
     * identifies if the item passed is in the players inventory
     * @param item
     * @return boolean
     */
    public boolean inventoryContainsObject(Item item){
        if(this.playerInventory.contains(item)){
            return true;
        }
        return false;
    }

    /* PLAYER COMMANDS COMPANIONS */

    /** sleep */
    /* 
    public void sleep(Area area){
        if (this.playerArea == area){
            //this.playerHealth = 20;
            System.out.println("You feel all restored after a nice little rest!");
        } else {
            throw new RuntimeException("Silly you can't sleep here!");
        }
    }
        */

    /**
     * identifies if what the user typed in matches an item object in the players inventory
     * @param userList
     * @return item or null
     */
     public Item playerMatchItem(String[] userList){
        for(Item inventoryItem : this.playerInventory){ 
            String inventoryItemLowerCase = inventoryItem.getName().toLowerCase();
            for(String item : userList){
                //String itemLowercase = item.toLowerCase();
                if(inventoryItemLowerCase.contains(item)){
                    return inventoryItem;
                }
            }
        }
        return null;
    }

    /**
     * identifies if player contains a sphere needed for puzzle
     * @param rock1
     * @param rock2
     * @param rock3
     * @return boolean
     */
    public boolean containAnySphere(Item rock1, Item rock2, Item rock3){
        if(this.playerInventory.contains(rock1) || this.playerInventory.contains(rock2) || this.playerInventory.contains(rock3)){
            return true;
        }
        return false;
    }

    /**
     * identifies how many spheres player contains
     * @param rock1
     * @param rock2
     * @param rock3
     * @return int
     */
    public int spheresPlayerContains( Item rock1, Item rock2, Item rock3){
        int rockCount = 0;
        if(this.playerInventory.contains(rock1)){
            rockCount += 1;
        }
        if(this.playerInventory.contains(rock2)){
            rockCount += 1;
        }
        if(this.playerInventory.contains(rock3)){
            rockCount += 1;
        }
        return rockCount;
    }


    
    public static void main(String[] args) {
        Player player = new Player();
        Item urmom = new Item( "ur mom", "ur mom");
        player.addToInventory(urmom);
        player.listInventory();
    }
    

}
