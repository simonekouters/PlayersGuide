public enum State {
    OPEN("open"),
    CLOSED("closed"),
    LOCKED("locked");

    private final String name;
	
    State(String name) {
        this.name = name;
    }
	
	
	public String getName() {
		return this.name;
	}
}
