package ui.tabs.buttons;

import javax.swing.JButton;

import ui.StartingScreenGUI;

// Represents a button tha is a JButton with StartingScreenGUI JFrame it is attached to
public abstract class Button extends JButton {
    protected StartingScreenGUI controller;

    //EFFECTS: sets up a button with corresponding StartingScreenGUI JFrame
    public Button(StartingScreenGUI controller) {
        this.controller = controller;
    }
}
