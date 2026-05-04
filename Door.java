public class Door {
    private boolean locked;

    public Door(boolean locked){
        this.locked = locked;
    }

    /**
     * getter for door locked status
     * @return boolean
     */
    public boolean getLockedStatus(){
        return this.locked;
    }

    /** Changers for locked flag of door*/
    public void unlock(){
        this.locked = false;
    }

    public void lock(){
        this.locked = true;
    }
    
}
