import java.util.ArrayList;

public class Area {
    private String name; 
    private String areaVisualDescription;
    ArrayList<Item> areaItems;
    ArrayList<Area> connectedAreas;

    public Area(String name, String description){
        this.name = name; 
        this.areaVisualDescription = description; 
        this.areaItems = new ArrayList<Item>();
        this.connectedAreas = new ArrayList<Area>();
    }

}
