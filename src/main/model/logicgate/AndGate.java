package model.logicgate;

public class AndGate implements LogicGate {

    // EFFECTS: creates AND Gate, with left and botton input values set to "off"
    public AndGate() {
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
    // EFFECTS: if both left and bottom inputs are "on", change output to "on" and return true
    @Override
    public boolean output() {
        return false; // STUB
    }
}
