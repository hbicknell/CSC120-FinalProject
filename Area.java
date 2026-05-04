import java.util.ArrayList;

public class Area {
    private String name; 
    private String areaVisualDescription;
    private Area forwardArea;
    private Area backwardArea;
    ArrayList<Item> areaItems;
    ArrayList<Item> hiddenItems;

    //explore flag? with one or two items in it


    /*full constructor */
    public Area(String name, String description){
        this.name = name; 
        this.areaVisualDescription = description; 
        this.areaItems = new ArrayList<Item>();
        this.hiddenItems = new ArrayList<Item>();
    }

    /** GETTERS FOR EVERYTHING EXCEPT HIDDEN ITEMS */
    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.areaVisualDescription;
    }

    public Area getForwardArea(){
        return this.forwardArea;
    }

    public Area getBackArea(){
        return this.backwardArea;
    }

    public ArrayList<Item> getAreaItems(){
        return this.areaItems;
    }

    /**
     * changes areas forward area
     * @param area
     */
    public void changeForwardArea(Area area){
        this.forwardArea = area;
    }

    /**
     * changes areas backward area
     * @param area
     */
    public void changeBackArea(Area area){
        this.backwardArea = area;
    }

    /**
     * changes the forward and backwards area of area
     * @param forward
     * @param backward
     */
    public void changeAreas(Area forward, Area backward){
        this.forwardArea = forward;
        this.backwardArea = backward;
    }


    /** AREA ITEMS MANIPULATION */

    public void addToArea(Item item){
        this.areaItems.add(item);
    }

    public void addToHiddenArea(Item item){
        this.hiddenItems.add(item);
    }

    public void removeFromArea(Item item){
        this.areaItems.remove(item);
    }

    /**
     * items in area to string
     * @return list
     */
    public String listAreaItems(){
        String list = "";
        for(Item item : this.areaItems){
            String stringItem = item.getName();
            list += stringItem;
            list += ", ";
        }
        return list;
   }

   /* PLAYER COMMANDS COMPANION */

   /**
    * matches what the player has typed in to if it is an item in the area
    * @param userList
    * @return item or null
    */
   public Item areaMatchItem( String[] userList){
        for(Item areaItem : this.areaItems){ 
            String areaItemLowerCase = areaItem.getName().toLowerCase();
            for(String item : userList){
                String itemLowercase = item.toLowerCase();
                if(areaItemLowerCase.contains(itemLowercase)){
                    return areaItem;
                }
            }
        }
        return null;
    }

    /**
     * transfers items from hidden list to area items list and lists what was transferred in a string
     * @return items
     */
    public String exploreArea(){
        String foundItems = "";
        for(Item item : this.hiddenItems){
            this.areaItems.add(item);
            foundItems += item.getName() + ", ";
        }
        return foundItems;
    }

    public static void main(String[] args) {
        Area area = new Area("house", "house");
        Item item = new Item("Rock", "Rock");
        Item item2 = new Item ("f", "f");
        area.areaItems.add(item2);
        area.hiddenItems.add(item);
        System.out.println(area.exploreArea());
        System.out.println(area.listAreaItems());
    }
}

