package model.logicgate;

public class OrGate implements LogicGate {

    // EFFECTS: creates OR Gate, with left and botton input values set to "off"
    public OrGate() {
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

    // EFFECTS: if both left and/or bottom inputs are "on", return true
    @Override
    public boolean output() {
        return false; // STUB
    }
}
