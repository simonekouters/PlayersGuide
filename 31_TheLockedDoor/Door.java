public class Door {
    private DoorState state;
    private int passcode;

    public Door(int passcode) {
        this.passcode = passcode;
        this.state = DoorState.LOCKED;
    }


    public DoorState getState() {
        return this.state;
    }
    
    
    public int getPasscode() {
        return this.passcode;
    }
    
    
    public void setPasscode(int passcode) {
        this.passcode = passcode;
    }


    public void close() {
        if (!state.equals(DoorState.OPEN)) {
            System.out.println("The door is already closed!");
            return;
        }
        
        state = DoorState.CLOSED;
    }
    
    
    public void open() {
        if (!state.equals(DoorState.CLOSED)) {
            System.out.println("The door can only be opened if it's unlocked!");
            return;
        }
        
        state = DoorState.OPEN;
    }
    
    
    public void lock() {
        if (!state.equals(DoorState.CLOSED)) {
            System.out.println("The door can only be locked if it's unlocked and closed!");
            return;
        }
        
        state = DoorState.LOCKED;
    }
    
    
    public void unlock() {
        if (!state.equals(DoorState.LOCKED)) {
            System.out.println("The door can only be unlocked if it's locked!");
            return;
        }
        
        state = DoorState.CLOSED;
    }
}
