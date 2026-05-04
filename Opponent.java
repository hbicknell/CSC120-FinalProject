public class Opponent {
    private String name; 
    private String opponentVisualDescription;
    private int opponentHealth;
    private boolean opponentAlive;

    /*default constructor */
    public Opponent(String name, String description, int health){
        this.name = name;
        this.opponentVisualDescription = description;
        this.opponentHealth = health;
        this.opponentAlive = true;
    }

    /** GETTERS FOR ATTRIBUTES */
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.opponentVisualDescription;
    }

    public boolean getOpponentAlive(){
        return this.opponentAlive;
    }

    public int getOpponentHealth(){
        return this.opponentHealth;
    }

}
