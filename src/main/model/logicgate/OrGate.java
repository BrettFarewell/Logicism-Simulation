package model.logicgate;

// Respresents the OR Gate logic gate that has a left and a bottom input, an x and an y position, and a right output
public class OrGate implements LogicGate {

    // REQUIRES: 0 <= x <= 50 and 0 <= y <= 20
    // EFFECTS: creates OR Gate, with left and botton input values set to "off" and x and y positions to given x and y
    //          parameters
    public OrGate(int x, int y) {
        // STUB
    }
    
    // MODIFIES: this
    // EFFECTS: takes input direct, if direction is "left", switch left input to "on"
    //                              if direction is "bot", switch bottom input to "on"
    //                              return result of output()
    @Override
    public boolean input(String dir) {
        return false; // STUB
    }

    // MODIFIES: this
    // EFFECTS: if both left and/or bottom inputs are "on", change output to "on" and return true
    @Override
    public boolean output() {
        return false; // STUB
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
}
