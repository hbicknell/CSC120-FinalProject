public class Weapon extends Item {
    private int damageModifier;

    /*deafualt constructor */
    public Weapon(String name, String description, boolean inPlayerInventory, int mod){
        super(name,description, inPlayerInventory);
        this.damageModifier = mod;
    }
}
