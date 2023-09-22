package Workers.mitarbeiter;

public enum MitarbeiterTyp {
	BUERO("Bueroarbeiter"), MANAGER("Manager"), SCHICHT("Schichtarbeiter"), FAHRER("Fahrer");
	
	private final String displayName;
	
	MitarbeiterTyp(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
