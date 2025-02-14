package model;

import model.logicgate.*;

import java.util.List;
import java.util.ArrayList;

// Represents a scenario with size of screen in terminal to be 50x20 (50 characters wide, 20 tall) represented by
// SCREEN_WIDTH and SCREEN_HEIGHT constants. Contains lists of all logic gates, power sources, wires, and output
// elements
public class Scenario {
    private static final int SCREEN_WIDTH = 50;
    private static final int SCREEN_HEIGHT = 20;

    // EFFECT: creates a scenario that is 50x20 charcters, with empty lists of logic gates, power sources, wires, 
    // output elements
    public Scenario() {
        // STUB
    }

    // MODIFIES: this
    // EFFECT: creates an AND Gate at x and y position and adds it to list of logic gates
    public void addAndGate(int x, int y) {
        // STUB
    }

    // MODIFIES: this
    // EFFECT: creates an OR Gate at x and y position and adds it to list of logic gates
    public void addOrGate(int x, int y) {
        // STUB
    }

    // MODIFIES: this
    // EFFECT: creates a power source at x and y position and adds it to list of power sources
    public void addPowerSource(int x, int y) {
        // STUB
    }

    // MODIFIES: this
    // EFFECT: creates a wire at x and y position and adds it to list of wires
    public void addWire(int x, int y) {
        // STUB
    }
    
    // MODIFIES: this
    // EFFECT: creates an output element of type ("sound" or "light") at x and y position and adds it to list of
    //         output elements
    public void addOutputElement(String type, int x, int y) {
        // STUB
    }

    // EFFECT: return list of logic gates
    public List<LogicGate> getLogicGates() {
        return null; // STUB
    }

    // EFFECT: return list of power sources
    public List<PowerSource> getPowerSources() {
        return null; // STUB
    }

    // EFFECT: return list of wires
    public List<Wire> getWires() {
        return null; // STUB
    }

    // EFFECT: return list of output elements
    public List<OutputElement> getOutputElements() {
        return null; // STUB
    }
}
