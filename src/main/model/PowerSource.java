package model;

// Represents a power sourse where power will start from. Will contain x and y positions
public class PowerSource extends LogicElement {
    private static final boolean POWER_STATUS = true;
    
    // EFFECTS: creates a power source where power will start from, sets x and y positions, and set logic elements
    //          to the left, right, above and below. Power status is set to "on" all inputs are set to "off"
    public PowerSource(int x, int y, LogicElement left, LogicElement right, LogicElement above, LogicElement below) {
        this.posX = x;
        this.posY = y;
        this.elementLeft = left;
        this.elementRight = right;
        this.elementAbove = above;
        this.elementBelow = below;
        this.powerStatus = true;
        this.inputLeftStatus = false;
        this.inputRightStatus = false;
        this.inputAboveStatus = false;
        this.inputBelowStatus = false;
    }

    // EFFECT: propagates the signal to logic elements to the left, right, above, and below
    public void checkPowerStatus() {
        outputLeft();
        outputRight();
        outputAbove();
        outputBelow();
    }

    // EFFECTS: gets the power status which is POWER_STATUS
    @Override
    public boolean getPowerStatus() {
        return POWER_STATUS;
    }
}
