package model;

// Represents a wire objects that will propagate any source signal given, with x and y positions in scenario, and 
// "on" or "off" power status
public class Wire {
    
    // EFFECTS: creates a wire with power status set to "off" and x and y positions set to given x and y values
    public Wire(int x, int y) {

    }

    // EFFECT: set power status to "on"
    public void input() {
        // STUB
    }

    // return power status of wire
    public boolean getPowerStatus() {
        return false; // STUB
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
