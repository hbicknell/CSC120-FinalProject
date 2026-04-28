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

    public void changeForwardArea(Area area){
        this.forwardArea = area;
    }

    public void changeBackArea(Area area){
        this.backwardArea = area;
    }

    public void changeAreas(Area forward, Area backward){
        this.forwardArea = forward;
        this.backwardArea = backward;
    }


    public void itemsInHouse(){
        //add items to list

    }

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

   public Item areaMatchItem( String[] userList){
        for(Item areaItem : this.areaItems){ 
            for(String item : userList){
                String itemLowercase = item.toLowerCase();
                if(areaItem.getName().contains(itemLowercase)){
                    return areaItem;
                }
            }
        }
        return null;
    }

}
