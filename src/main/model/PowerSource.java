package model;

// Represents a power sourse where power will start from. Will contain x and y positions
public class PowerSource extends LogicElement {
    private static final boolean POWER_STATUS = true;
    
    // EFFECTS: creates a power source where power will start from, sets x and y positions, and set logic elements
    //          to the left, right, above and below. 
    public PowerSource(int x, int y, LogicElement left, LogicElement right, LogicElement above, LogicElement below) {
        // STUB
    }

    // EFFECT: propagates the signal to logic elements to the left, right, above, and below
    public void checkPowerStatus() {
        // STUB
    }

    // EFFECTS: returns POWER_STATUS
    @Override
    public boolean getPowerStatus() {
        return POWER_STATUS; // STUB
    }
}
