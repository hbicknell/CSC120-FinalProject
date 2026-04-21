import java.util.ArrayList;

public class Trader extends NPC {
    private ArrayList<Item> traderInventory;

   /*default constructor */
    public Trader(String name, String description){
        super(name, description);
        this.traderInventory = new ArrayList<Item>();
    }



}
