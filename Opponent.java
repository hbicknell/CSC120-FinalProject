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
}
