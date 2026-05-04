public class Item {
    private String name; 
    private String itemDescription;
    //private int cost;
    private boolean inPlayerInventory;

    /*overloaded constructor */
   public Item (String name, String description){
        this.name = name; 
        this.itemDescription = description;
        //this.cost = 0;
        this.inPlayerInventory = false;
    }

    /*default constructor */
    public Item(String name, String description, boolean inInventory){
        this.name = name; 
        this.itemDescription = description; 
        //this.cost = cost;
        this.inPlayerInventory = inInventory;
    }

    /**
     * getter for name
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * getter for description
     * @return
     */
    public String getDescription(){
        return this.itemDescription;
    }

    /**
     * getter for if in inventory
     * @return
     */
    public boolean getInventory(){
        return this.inPlayerInventory;
    }


}
