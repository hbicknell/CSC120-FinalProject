import java.util.Scanner;

public class Puzzle {

    private String description; 
    private Item firstSlot; 
    private Item secondSlot;
    private Item thirdSlot;
    private boolean solved;
    private String prize;

    /*Overloaded construction */
    public Puzzle(String description, Item slot1Item, Item slot2Item, Item slot3Item, String prize){
        this.description = description; 
        this.firstSlot = slot1Item;
        this.secondSlot = slot2Item;
        this.thirdSlot = slot3Item;
        this.solved = false;
        this.prize = prize;
    }

    /*Constructor */
    public Puzzle(String description, Item slot1Item, Item slot2Item, Item slot3Item, boolean unsolved, String prize){
    this.description = description; 
        this.firstSlot = slot1Item;
        this.secondSlot = slot2Item;
        this.thirdSlot = slot3Item;
        this.solved = unsolved;
        this.prize = prize;
    }

    public boolean getSolved(){
        return this.solved;
    }

    public boolean checkPuzzle( Item slot1Choice, Item slot2Choice, Item slot3Choice){
       if(this.firstSlot == slot1Choice && this.secondSlot == slot2Choice && this.thirdSlot == slot3Choice){
        return true;
       }
       return false;
    }

    public void solve(){
        this.solved = true;
    }
}
