package model;

// Respresents the OR Gate logic gate that has a left and a bottom input, an power status, a right output,
// and an x and an y position.
public class OrGate extends LogicElement  {

    // EFFECTS: Creates an Or Gate at given x and y coordinates, with power status "off"
    //          and set logic elements to the left, right, above and below
    public OrGate(int x, int y, LogicElement left, LogicElement right, LogicElement above, LogicElement below) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: checks to see if left or bottom inputs are "on", if so turns power status "on" and calls outputRight()
    public void checkPowerStatus() {
        // STUB
    }

    // EFFECTS: takes input from right and does nothing
    @Override
    public void inputRight() {
        // STUB
    }

    // EFFECTS: takes input from above and does nothing
    @Override
    public void inputAbove() {
        // STUB
    }
}
