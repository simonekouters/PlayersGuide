enum DoorState {
	OPEN("open"),
    CLOSED("closed"),
    LOCKED("locked");

    private final String name;
		
    DoorState(String name) {
        this.name = name;
    }
	
	
	public String getName() {
		return this.name;
    }
}