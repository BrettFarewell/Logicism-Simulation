package model.logicgate;

public interface LogicGate {
    
    // MODIFIES: this
    // EFFECTS: takes input of direction of where power is being supplied and changes output status where necessary.
    //          Returns boolean based on output()
    //          Example: for an OR Gate, if power is supplied to left/bottom, left/bottom input becomes powered and
    //                   output becomes powered
    //          Example: for an AND gate, if power is supplied to left, left input becomes powered but output
    //                   remains unpowered if bottom input is unpowered
    boolean input(String dir);

    // EFFECTS: checks to see if inputs match required logic of specified gate, if so returns true
    boolean output();
}
