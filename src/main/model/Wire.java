package model;

// Represents a wire objects that will propagate any source signal given, with x and y positions in scenario, and 
// "on" or "off" power status.
public class Wire extends LogicElement {
    
    // EFFECTS: creates a wire with power status set to "off" and x and y positions set to given x and y values
    //          and sets logic elements to the left, right, above and below. Also all inputs to "off"
    public Wire(int x, int y, LogicElement left, LogicElement right, LogicElement above, LogicElement below) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: checks to see if any input are "on", if so turns power status "on" and calls outputLeft(),
    //          outputRight(), outputAbove(), outputBelow(),
    public void checkPowerStatus() {
        // STUB
    }
}
