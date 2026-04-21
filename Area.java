import java.util.ArrayList;

public class Area {
    private String name; 
    private String areaVisualDescription;
    ArrayList<Item> areaItems;
    ArrayList<Area> connectedAreas;

    /*full constructor */
    public Area(String name, String description){
        this.name = name; 
        this.areaVisualDescription = description; 
        this.areaItems = new ArrayList<Item>();
        this.connectedAreas = new ArrayList<Area>();
    }

    //like a 'you notice... for areaitems, so those are the interactable things'

}
