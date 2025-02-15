package model;


// Represents all logic elements (logic gates, power sources, wires, and outputs) interface that will be used to provide
// needed methods for all logic gates. All gates will have the ability to take an input and produce an output, as well
// as getters and setters for x and y positions in scenario. All logic elements will contain fields of logic elements
// that are to above, below, right, and left of it in the scenario
public abstract class LogicElement {

    private int PosX;
    private int PosY;
    private LogicElement elementLeft;
    private LogicElement elementRight;
    private LogicElement elementAbove;
    private LogicElement elementBelow;
    private boolean inputLeftStatus;
    private boolean inputRightStatus;
    private boolean inputAboveStatus;
    private boolean inputBelowStatus;
    private boolean powerStatus;

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

    // MODIFIES: this
    // EFFECTS: propogate powered "on" status output to element to the left unless null
    public void outputLeft() {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: propogate powered "on" status output to element to the right unless null
    //          (call above element's inputbelow())
    public void outputRight() {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: propogate powered "on" status output to element to the above unless null
    public void outputAbove() {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: propogate powered "on" status output to element to the below unless null
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

    // EFFECTS: get left input status for testing purposes
    public boolean getInputLeft() {
        return false; // STUB
    }

    // EFFECTS: get right input status for testing purposes
    public boolean getInputRight() {
        return false; // STUB
    }

    // EFFECTS: get above input status for testing purposes
    public boolean getInputAbove() {
        return false; // STUB
    }

    // EFFECTS: get below input status for testing purposes
    public boolean getInputBelow() {
        return false; // STUB
    }

    // EFFECTS: set left input status for testing purposes
    public void setInputLeft(boolean b) {
        // STUB
    }

    // EFFECTS: set right input status for testing purposes
    public void setInputRight(boolean b) {
        // STUB
    }

    // EFFECTS: set above input status for testing purposes
    public void setInputAbove(boolean b) {
        // STUB
    }

    // EFFECTS: set below input status for testing purposes
    public void setInputBelow(boolean b) {
        // STUB
    }

    // EFFECTS: set power status for testing purposes
    public void setPowerStatus(boolean b) {
        // STUB
    }
}
