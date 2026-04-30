public class Door {
    private boolean locked;

    public Door(boolean locked){
        this.locked = locked;
    }

    public boolean getLockedStatus(){
        return this.locked;
    }

    public void unlock(){
        this.locked = false;
    }

    public void lock(){
        this.locked = true;
    }
    
}
