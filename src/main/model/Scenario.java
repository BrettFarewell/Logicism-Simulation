package model;

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
    // EFFECT: take input character c
    //              if c == X, call addAndGate(x, y)
    //              if c == X, call addOrGate(x, y)
    //              if c == X, call addPowerSourcex, y)
    //              if c == X, call addWire(x, y)
    //              if c == X, call addLightOutput(x, y)
    //              if c == X, call addSoundOutput(x, y)
    public void addLogicElement(char c, int x, int y) {
        // STUB
    }

    // MODIFIES: this
    // EFFECT: creates an AND Gate at x and y position and adds it to list of logic elements
    public void addAndGate(int x, int y) {
        // STUB
    }

    // MODIFIES: this
    // EFFECT: creates an OR Gate at x and y position and adds it to list of logic elements
    public void addOrGate(int x, int y) {
        // STUB
    }

    // MODIFIES: this
    // EFFECT: creates a power source at x and y position and adds it to list of logic element
    //         and list of power sources
    public void addPowerSource(int x, int y) {
        // STUB
    }

    // MODIFIES: this
    // EFFECT: creates a wire at x and y position and adds it to list of logic elements
    public void addWire(int x, int y) {
        // STUB
    }
    
    // MODIFIES: this
    // EFFECT: creates a light output at x and y position and adds it to list of logic elements
    public void addLightOutput(int x, int y) {
        // STUB
    }

    // MODIFIES: this
    // EFFECT: creates a light output at x and y position and adds it to list of logic elements
    //         and list of sound elements
    public void addSoundOutput(int x, int y) {
        // STUB
    }

    // EFFECT: return list of logic gates
    public List<LogicElement> getLogicGates() {
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
    public List<LightOutput> getOutputElements() {
        return null; // STUB
    }

    // return SCREEN_WIDTH
    public int getScreenWidth() {
        return -1; // STUB
    }

    // return SCREEN_HEIGHT
    public int getScreenHeight() {
        return -1; // STUB
    }
}
