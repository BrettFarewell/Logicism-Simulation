package ui.tabs;

import javax.swing.JPanel;

import ui.StartingScreenGUI;

// Represents an abstract class of a Tab that is a JPanel for the different Tabs in the application
public abstract class Tab extends JPanel {
    protected static final String TYPE_FACE = "Century Gothic";
    protected final StartingScreenGUI controller;

    // EFFECTS: Creates a Tab with corresponding StartingScreenGUI JFrame
    public Tab(StartingScreenGUI controller) {
        this.controller = controller;
    }

    //EFFECTS: returns the SmartHomeUI controller for this tab
    public StartingScreenGUI getController() {
        return controller;
    }
}
