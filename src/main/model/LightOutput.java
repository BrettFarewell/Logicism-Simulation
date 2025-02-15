package model;

// Represents a light output device with x and y position in the scenario. If powered "on" will light up
public class LightOutput extends LogicElement {

    // EFFECT: creates an output of given type, with power status "off", and at position x an y
    //         (no need for elements around it as it cannot propgate power)
    public LightOutput(int x, int y) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: checks to see if any inputs are "on" and turns power status "on"
    public void checkPowerStatus() {
        // STUB
    }

    // EFFECTS: should not be called, but if so, does nothing and stops propagation of output to the left
    @Override
    public void outputLeft() {
        // STUB
    }

    // EFFECTS: should not be called, but if so, does nothing and stops propagation of output to the right
    @Override
    public void outputRight() {
        // STUB
    }

    // EFFECTS: should not be called, but if so, does nothing and stops propagation of output to above
    @Override
    public void outputAbove() {
        // STUB
    }

    // EFFECTS: should not be called, but if so, does nothing and stops propagation of output to below
    @Override
    public void outputBelow() {
        // STUB
    }
}
