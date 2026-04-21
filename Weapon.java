public class Weapon extends Item {
    private int damageModifier;

    /*deafualt constructor */
    public Weapon(String name, String description, int cost, boolean inPlayerInventory, int mod){
        super(name,description,cost, inPlayerInventory);
        this.damageModifier = mod;
    }
}
