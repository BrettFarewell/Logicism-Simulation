package model;


// Represents all logic elements (logic gates, power sources, wires, and outputs) interface that will be used to provide
// needed methods for all logic gates. All gates will have the ability to take an input and produce an output, as well
// as getters and setters for x and y positions in scenario. All logic elements will contain fields of logic elements
// that are to above, below, right, and left of it in the scenario
public abstract class LogicElement {
    protected Category category;
    protected int posX;
    protected int posY;
    protected LogicElement elementLeft;
    protected LogicElement elementRight;
    protected LogicElement elementAbove;
    protected LogicElement elementBelow;
    protected boolean inputLeftStatus;
    protected boolean inputRightStatus;
    protected boolean inputAboveStatus;
    protected boolean inputBelowStatus;
    protected boolean powerStatus;

    // MODIFIES: this
    // EFFECT: resets logic element back to orginal state, with all inputs powered off and power status off
    public void resetLogicElement() {
        this.inputLeftStatus = false;
        this.inputRightStatus = false;
        this.inputAboveStatus = false;
        this.inputBelowStatus = false;
        this.powerStatus = false;
    }

    // MODIFIES: this
    // EFFECTS: set the logic element that is to the left
    public void setLeftElement(LogicElement logicElement) {
        this.elementLeft = logicElement;
    }

    // MODIFIES: this
    // EFFECTS: set the logic element that is to the right
    public void setRightElement(LogicElement logicElement) {
        this.elementRight = logicElement;
    }

    // MODIFIES: this
    // EFFECTS: set the logic element that is above
    public void setAboveElement(LogicElement logicElement) {
        this.elementAbove = logicElement;
    }

    // MODIFIES: this
    // EFFECTS: set the logic element that is below
    public void setBelowElement(LogicElement logicElement) {
        this.elementBelow = logicElement;
    }

    // EFFECTS: get the logic element that is to the left
    public LogicElement getLeftElement() {
        return this.elementLeft;
    }

    // EFFECTS: get the logic element that is to the right
    public LogicElement getRightElement() {
        return this.elementRight;
    }

    // EFFECTS: get the logic element that is above
    public LogicElement getAboveElement() {
        return this.elementAbove;
    }

    // EFFECTS: get the logic element that is below
    public LogicElement getBelowElement() {
        return this.elementBelow;
    }

    // MODIFIES: this
    // EFFECTS: if power status is "off", set the left input to be powered "on" and call checkPowerStatus().
    //          if power status is "on", do nothing (prevents propagation of already powered on elements)
    public void inputLeft() {
        if (powerStatus == false) {
            this.inputLeftStatus = true;
            checkPowerStatus();
        }
    }

    // MODIFIES: this
    // EFFECTS: if power status is "off", set the right input to be powered "on" and call checkPowerStatus().
    //          if power status is "on", do nothing (prevents propagation of already powered on elements)
    public void inputRight() {
        if (powerStatus == false) {
            this.inputRightStatus = true;
            checkPowerStatus();
        }
    }

    // MODIFIES: this
    // EFFECTS: if power status is "off", set the above input to be powered "on" and call checkPowerStatus().
    //          if power status is "on", do nothing (prevents propagation of already powered on elements)
    public void inputAbove() {
        if (powerStatus == false) {
            this.inputAboveStatus = true;
            checkPowerStatus();
        }
    }

    // MODIFIES: this
    // EFFECTS: if power status is "off", set the below input to be powered "on" and call checkPowerStatus().
    //          if power status is "on", do nothing (prevents propagation of already powered on elements)
    public void inputBelow() {
        if (powerStatus == false) {
            this.inputBelowStatus = true;
            checkPowerStatus();
        }
    }

    // MODIFIES: this
    // EFFECTS: check to see what inputs are "on" and match the required logic to turn power status "on". Then call
    //          required output directions (outputLeft(), outputRight(), etc.) for the logic element type
    //          Example: AND Gate has left and bottom input and right output, if both inputs are "on",
    //                   turns power status "on" and call outputRight()
    abstract void checkPowerStatus();

    // return power status value of logic gate
    public boolean getPowerStatus() {
        return this.powerStatus;
    }

    // MODIFIES: this
    // EFFECTS: propogate powered "on" status output to element to the left (call inputRight() on logic element)
    //          unless null
    public void outputLeft() {
        if (getLeftElement() != null) {
            this.getLeftElement().inputRight();
        }
    }

    // MODIFIES: this
    // EFFECTS: propogate powered "on" status output to element to the right (call inputRight() on logic element)
    //          unless null
    public void outputRight() {
        if (getRightElement() != null) {
            this.getRightElement().inputLeft();
        }
    }

    // MODIFIES: this
    // EFFECTS: propogate powered "on" status output to element to the above (call inputRight() on logic element)
    //          unless null
    public void outputAbove() {
        if (getAboveElement() != null) {
            this.getAboveElement().inputBelow();
        }
    }

    // MODIFIES: this
    // EFFECTS: propogate powered "on" status output to element to the below (call inputRight() on logic element)
    //          unless null
    public void outputBelow() {
        if (getBelowElement() != null) {
            this.getBelowElement().inputAbove();
        }
    }

    // EFFECTS: gets x position
    public int getPosX() {
        return this.posX;
    }

    // EFFECTS: gets y position
    public int getPosY() {
        return this.posY;
    }

    // EFFECTS: get left input status for testing purposes
    public boolean getInputLeft() {
        return this.inputLeftStatus;
    }

    // EFFECTS: get right input status for testing purposes
    public boolean getInputRight() {
        return this.inputRightStatus;
    }

    // EFFECTS: get above input status for testing purposes
    public boolean getInputAbove() {
        return this.inputAboveStatus;
    }

    // EFFECTS: get below input status for testing purposes
    public boolean getInputBelow() {
        return this.inputBelowStatus;
    }

    // EFFECTS: set left input status for testing purposes
    public void setInputLeft(boolean b) {
        this.inputLeftStatus = b;
    }

    // EFFECTS: set right input status for testing purposes
    public void setInputRight(boolean b) {
        this.inputRightStatus = b;
    }

    // EFFECTS: set above input status for testing purposes
    public void setInputAbove(boolean b) {
        this.inputAboveStatus = b;
    }

    // EFFECTS: set below input status for testing purposes
    public void setInputBelow(boolean b) {
        this.inputBelowStatus = b;
    }

    // EFFECTS: set power status for testing purposes
    public void setPowerStatus(boolean b) {
        this.powerStatus = b;
    }
}
