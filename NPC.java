public class NPC {
    private String name; 
    private String npcVisualDescription;

    /*default constructor */
    public NPC(String name, String description){
        this.name = name; 
        this.npcVisualDescription = description; 
    }

    public String getName(){
        return this.name;
    }

    public String getNpcDescription(){
        return this.npcVisualDescription;
    }
}
