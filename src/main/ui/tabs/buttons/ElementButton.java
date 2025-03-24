package ui.tabs.buttons;

import ui.StartingScreenGUI;

// Represents the element buttons in the scenario tab of the scene tab, which is a Button with X and Y positions
// corresponding to the appropriate X and Y positions of the logic element in the logic element grid of the scenario
public class ElementButton extends Button {
    private int posX;
    private int posY;

    // EFFECTS: creates an element button with corresponding StartingScreenGUI JFrame, X position, and y position
    public ElementButton(StartingScreenGUI controller, int posX, int posY) {
        super(controller);
        this.posX = posX;
        this.posY = posY;
    }

    // EFFECTS: gets X position of the element button in the scenario
    public int getPosX() {
        return posX;
    }

    // EFFECTS: gets Y position of the element button in the scenario
    public int getPosY() {
        return posY;
    }
}
