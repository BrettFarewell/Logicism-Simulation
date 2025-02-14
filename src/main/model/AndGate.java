package model;

// Respresents the AND Gate logic gate that has a left and a bottom input, an power status, a right output,
// and an x and an y position.
public class AndGate extends LogicElement {

    // EFFECTS: Creates an AND Gate at given x and y coordinates, with power status "off"
    //          and set logic elements to the left, right, above and below
    public AndGate(int x, int y, LogicElement left, LogicElement right, LogicElement above, LogicElement below) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: checks to see if left and bottom inputs are "on", if so turns power status "on" and calls outputRight()
    public void checkPowerStatus() {
        // STUB
    }
}
