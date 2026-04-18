public class Item {
    private String name; 
    private String itemDescription;
    private int cost;
    private boolean inPlayerInventory;

    /*overloaded constructor */
   public Item (String name, String description){
        this.name = name; 
        this.itemDescription = description;
        this.cost = 0;
        this.inPlayerInventory = false;
    }
    /*overlaoded constructor */
    public Item (String name, String description, int cost){
        this.name = name; 
        this.itemDescription = description;
        this.cost = cost;
        this.inPlayerInventory = false;
    }

    /*default constructor */
    public Item(String name, String description, int cost, boolean inInventory){
        this.name = name; 
        this.itemDescription = description; 
        this.cost = cost;
        this.inPlayerInventory = inInventory;
    }

}
