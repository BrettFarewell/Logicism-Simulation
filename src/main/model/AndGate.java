package model;

// Respresents the AND Gate logic gate that has a left and a bottom input, an power status, a right output,
// and an x and an y position.
public class AndGate extends LogicGate {

    // EFFECTS: Creates an AND Gate at given x and y coordinates, with power status "off"
    //          and set logic elements to the left, right, above and below.  Also all inputs to "off"
    public AndGate(int x, int y, LogicElement left, LogicElement right, LogicElement above, LogicElement below) {
        this.posX = x;
        this.posY = y;
        this.elementLeft = left;
        this.elementRight = right;
        this.elementAbove = above;
        this.elementBelow = below;
        this.powerStatus = false;
        this.inputLeftStatus = false;
        this.inputRightStatus = false;
        this.inputAboveStatus = false;
        this.inputBelowStatus = false;
        this.category = Category.values()[2];
    }

    // MODIFIES: this
    // EFFECTS: checks to see if left and bottom inputs are "on", if so turns power status "on" and calls outputRight()
    @Override
    public void checkPowerStatus() {
        if (inputLeftStatus == true && inputBelowStatus == true) {
            this.powerStatus = true;
            outputRight();
        } else {
            this.powerStatus = false;
        }
    }

    // EFFECTS: takes input from right and does nothing
    @Override
    public void inputRight() {
        
    }

    // EFFECTS: takes input from above and does nothing
    @Override
    public void inputAbove() {
        
    }

    // EFFECTS: should not be called, but if so, does nothing and stops propagation of output to the left
    @Override
    public void outputLeft() {
        
    }

    // EFFECTS: should not be called, but if so, does nothing and stops propagation of output to above
    @Override
    public void outputAbove() {
        
    }

    // EFFECTS: should not be called, but if so, does nothing and stops propagation of output to below
    @Override
    public void outputBelow() {
        
    }
}
