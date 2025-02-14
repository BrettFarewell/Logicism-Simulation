package model.logicgate;

public class OrGate implements LogicGate {

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
}
