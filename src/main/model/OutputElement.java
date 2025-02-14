package model;

// Represents output element with either type "sound" or "light" with x and y positions and power status
public class OutputElement {

    // REQUIRES: type to be "sound" or "light"
    // EFFECT: creates an output of given type, with power status "off", and at position x an y
    public OutputElement(String type, int x, int y) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: set power status to "on"
    public void output() {
        // STUB
    }

    // return power status of output element
    public boolean getPowerStatus() {
        return false; // STUB
    }

    // return output ype of output element
    public String getType() {
        return ""; // STUB
    }

    // EFFECTS: gets x position
    int getPosX() {
        return -1; // STUB
    }

    // EFFECTS: gets y position
    int getPosY() {
        return -1; // STUB
    }
}
