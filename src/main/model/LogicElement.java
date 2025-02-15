package model;


// Represents all logic elements (logic gates, power sources, wires, and outputs) interface that will be used to provide
// needed methods for all logic gates. All gates will have the ability to take an input and produce an output, as well
// as getters and setters for x and y positions in scenario. All logic elements will contain fields of logic elements
// that are to above, below, right, and left of it in the scenario
public abstract class LogicElement {

    // MODIFIES: this
    // EFFECTS: set the logic element that is to the left
    public void setLeftElement(LogicElement logicElement) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: set the logic element that is to the right
    public void setRightElement(LogicElement logicElement) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: set the logic element that is above
    public void setAboveElement(LogicElement logicElement) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: set the logic element that is below
    public void setBelowElement(LogicElement logicElement) {
        // STUB
    }

    // EFFECTS: get the logic element that is to the left
    public LogicElement getLeftElement() {
        return null; // STUB
    }

    // EFFECTS: get the logic element that is to the right
    public LogicElement getRightElement() {
        return null; // STUB
    }

    // EFFECTS: get the logic element that is above
    public LogicElement getAboveElement() {
        return null; // STUB
    }

    // EFFECTS: get the logic element that is below
    public LogicElement getBelowElement() {
        return null; // STUB
    }

    // MODIFIES: this
    // EFFECTS: if power status is "off", set the left input to be powered "on" and call isOutputTrue().
    //          if power status is "on", do nothing (prevents propagation of already powered on elements)
    public void inputLeft() {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: if power status is "off", set the right input to be powered "on" and call isOutputTrue()
    //          if power status is "on", do nothing (prevents propagation of already powered on elements)
    public void inputRight() {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: if power status is "off", set the above input to be powered "on" and call isOutputTrue()
    //          if power status is "on", do nothing (prevents propagation of already powered on elements)
    public void inputAbove() {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: if power status is "off", set the below input to be powered "on" and call isOutputTrue()
    //          if power status is "on", do nothing (prevents propagation of already powered on elements)
    public void inputBelow() {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: check to see what inputs are "on" and match the required logic to turn power status "on". Then call
    //          required output directions (outputLeft(), outputRight(), etc.) for the logic element type
    //          Example: AND Gate has left and bottom input and right output, if both inputs are "on",
    //                   turns power status "on" and call outputRight()
    abstract void checkPowerStatus();

    // return power status value of logic gate
    public boolean getPowerStatus() {
        return false;// STUB
    }

    // EFFECTS: propogate powered "on" status output to element to the left
    public void outputLeft() {
        // STUB
    }

    // EFFECTS: propogate powered "on" status output to element to the right
    public void outputRight() {
        // STUB
    }

    // EFFECTS: propogate powered "on" status output to element to the above
    public void outputAbove() {
        // STUB
    }

    // EFFECTS: propogate powered "on" status output to element to the below
    public void outputBelow() {
        // STUB
    }

    // EFFECTS: gets x position
    public int getPosX() {
        return -1; // STUB
    }

    // EFFECTS: gets y position
    public int getPosY() {
        return -1; // STUB
    }
}
