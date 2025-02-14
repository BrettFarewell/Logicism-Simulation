package model.logicgate;


// Represents a logic gate interface that will be used to provide needed methods for all logic gates.
// All gates will have the ability to take an input and produce an output, as well as getters and setters for
// x and y positions in scenario
public interface LogicGate {
    
    // MODIFIES: this
    // EFFECTS: takes input of direction of where power is being supplied and changes output status where necessary.
    //          Call output() and if true, then change output value to "on"
    //          Example: for an OR Gate, if power is supplied to left/bottom, left/bottom input becomes powered and
    //                   output becomes powered
    //          Example: for an AND gate, if power is supplied to left, left input becomes powered but output
    //                   remains unpowered if bottom input is unpowered
    void input(String dir);

    // MODIFIES: this
    // EFFECTS: checks to see if inputs match required logic of specified gate,
    //          if so change output to "on" and return true
    boolean output();

    // EFFECTS: gets x position
    int getPosX();

    // EFFECTS: gets y position
    int getPosY();
}
