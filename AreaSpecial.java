
public class AreaSpecial extends Area{
    private boolean exploredWisdom;

    public AreaSpecial(String name, String description){
        super(name, description);
        this.exploredWisdom = false;

    }

    public boolean getExploredWisdom(){
        return this.exploredWisdom;
    }
}
