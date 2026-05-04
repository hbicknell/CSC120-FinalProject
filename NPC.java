public class NPC {
    private String name; 
    private String npcVisualDescription;

    /*default constructor */
    public NPC(String name, String description){
        this.name = name; 
        this.npcVisualDescription = description; 
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
        return this.npcVisualDescription;
    }
}
