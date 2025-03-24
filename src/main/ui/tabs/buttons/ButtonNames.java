package ui.tabs.buttons;

// ATTRIBUTION: many of the methods in the class come from the ButtonNames enum from the SmartHome application
// Represents the button names for the save and load button on the home tab
public enum ButtonNames {
    SAVE("Save"),
    LOAD("Load");

    private final String name;

    // EFFECTS: creates enum with corresponding name
    ButtonNames(String name) {
        this.name = name;
    }

    //EFFECTS: returns name value of this button
    public String getValue() {
        return name;
    }
}
