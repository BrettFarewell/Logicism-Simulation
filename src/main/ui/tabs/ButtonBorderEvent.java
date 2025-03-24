package ui.tabs;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;

import ui.tabs.buttons.ElementButton;

// Represents a mouse event where the border changes based on if the mouse cursor is inside the button or not
public class ButtonBorderEvent extends MouseAdapter {
    private static final Color DEFAULT_COLOR = new Color(0xEEEEEE);
    private ElementButton button;
    private Color borderColor;

    // creates a ButtonBorderEvent with corresponding button and border color
    public ButtonBorderEvent(ElementButton button, Color borderColor) {
        this.button = button;
        this.borderColor = borderColor;
    }

    //EFFECTS: button border changes to border color if mouse cursor is over the button
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        button.setBorder(BorderFactory.createLineBorder(borderColor, 1));
    }

    //EFFECTS: button border changes to the DEFAULT_COLOR if mouse cursor exits the button
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        button.setBorder(BorderFactory.createLineBorder(DEFAULT_COLOR, 1));
    }
}
