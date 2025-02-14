package model.logicgate;

// Respresents the OR Gate logic gate that has a left and a bottom input, an x and an y position, and a right output
public class OrGate implements LogicGate {

    // REQUIRES: 0 <= x <= 50 and 0 <= y <= 20
    // EFFECTS: creates OR Gate, with left and bottom input values and output value set to "off" and x and y positions
    //          to given x and y parameters
    public OrGate(int x, int y) {
        // STUB
    }
    
    // MODIFIES: this
    // EFFECTS: takes input direct, if direction is "left", switch left input to "on"
    //                              if direction is "bot", switch bottom input to "on"
    //                              call output() to see if output value changes
    @Override
    public void input(String dir) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: if both left and/or bottom inputs are "on", change output to "on"
    @Override
    public void output() {
        // STUB
    }

    // EFFECTS: gets x position
    @Override
    public int getPosX() {
        return -1; // STUB
    }

    // EFFECTS: gets y position
    @Override
    public int getPosY() {
        return -1; // STUB
    }

    // return output value of OR gate
    public boolean getOutput() {
        return false; // STUB
    }

    // set left input value of OR gate to boolean b, for testing purposes
    public void setLeftInputOn(boolean b) {
        // STUB
    }

     // set bottom input value of OR gate to boolean b, for testing purposes
     public void setBottomInputOn() {
        // STUB
    }

     // return left input value of OR gate, for testing purposes
     public boolean getLeftInput() {
        return false; // STUB
    }

     // return bottom input value of OR gate, for testing purposes
     public boolean getBottomInput() {
        return false; // STUB
    }
}
