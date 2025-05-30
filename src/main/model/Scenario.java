package model;

import persistence.*;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// ATTRIBUTION: Many methods using EventLog comes from the the AlermSystem project
// Represents a scenario with size of screen in terminal to be 50x20 (50 characters wide, 20 tall) represented by
// SCREEN_WIDTH and SCREEN_HEIGHT constants. Contains grid of all logic gates, power sources, wires, and output
// elements
public class Scenario implements Writable {
    private static final int SCREEN_WIDTH = 50;
    private static final int SCREEN_HEIGHT = 20;
    private LogicElement[][] logicElementGrid;
    private String name;

    // EFFECT: creates a scenario that is SCREEN_WIDTH x SCREEN_HEIGHT grid of null logic elements,
    //         as well as a name given by String name
    public Scenario(String name) {
        logicElementGrid = new LogicElement[SCREEN_HEIGHT][SCREEN_WIDTH];
        this.name = name;
    }

    // MODIFIES: this
    // EFFECT: finds all power sources and starts the logic circuit by calling checkPowerStatus() on all power sources
    public void runScenario() {
        List<LogicElement> powersources = getPowerSources();
        for (LogicElement powerSource: powersources) {
            powerSource.checkPowerStatus();
        }
        EventLog.getInstance().logEvent(new Event("Ran Logic Circuit in Scenario" + name));
    }

    // MODIFIES: this
    // EFFECT: resets all non-power sources to be powered off and all inputs to be powered off
    public void resetScenario() {
        for (LogicElement[] row: logicElementGrid) {
            for (LogicElement logicElement: row) {
                if (logicElement != null) {
                    logicElement.resetLogicElement();
                }
            }
        }
        EventLog.getInstance().logEvent(new Event("Reset Logic Circuit in Scenario:" + name));
    }

    // REQUIRES: c == a, o, p, w, l, s, or d and 0 <= x <= SCREEN_WIDTH - 1 and 0 <= y <= SCREEN_HEIGHT - 1
    // MODIFIES: this
    // EFFECT: take input character c
    //              if c == a, create an AndGate at x, y through addAndGate()
    //              if c == o, create an OrGate at x, y through addOrGate(x, y)
    //              if c == p, create a PowerSource at x, y through addPowerSourcex, y)
    //              if c == w, create a Wire at x, y through addWire(x, y)
    //              if c == l, create a LightOutput at x, y through addLightOutput(x, y)
    //              if c == s, create a SoundOutput at x, y through addSoundOutput(x, y)
    //              if c == d, delete logic element at x, y through deleteElement(x, y)
    public void addLogicElement(String c, int x, int y) {
        logAddElementEvent(c, x, y);
        if (c.equals("a")) {
            addAndGate(x, y);
        } else if (c.equals("o")) {
            addOrGate(x, y);
        } else if (c.equals("p")) {
            addPowerSource(x, y);
        } else if (c.equals("w")) {
            addWire(x, y);
        } else if (c.equals("l")) {
            addLightOutput(x, y);
        } else if (c.equals("s")) {
            addSoundOutput(x, y);
        } else {
            deleteElement(x, y);
        }
    }

    private void logAddElementEvent(String c, int x, int y) {
        if (c.equals("a")) {
            EventLog.getInstance().logEvent(new Event("Added ANDGate at " + x + " x " + y + " in Scenario: " + name));
        } else if (c.equals("o")) {
            EventLog.getInstance().logEvent(new Event("Added ORGate at " + x + " x " + y + " in Scenario: " + name));
        } else if (c.equals("p")) {
            EventLog.getInstance().logEvent(new Event("Added Power Source at " + x + " x " + y + " in Scenario: "
                    + name));
        } else if (c.equals("w")) {
            EventLog.getInstance().logEvent(new Event("Added Wire at " + x + " x " + y + " in Scenario: " + name));
        } else if (c.equals("l")) {
            EventLog.getInstance().logEvent(new Event("Added Light Output at " + x + " x " + y + " in Scenario: "
                    + name));
        } else if (c.equals("s")) {
            EventLog.getInstance().logEvent(new Event("Added Sound Output at " + x + " x " + y + " in Scenario: "
                    + name));
        } else if (c.equals("d")) {
            EventLog.getInstance().logEvent(new Event("Removed Element at " + x + " x " + y + " in Scenario: " + name));
        }
    }

    // REQUIRES: 0 <= x <= SCREEN_WIDTH and 0 <= y <= SCREEN_HEIGHT
    // MODIFIES: this
    // EFFECT: deletes element at position x and y in the logic element grid (replaces with null),
    //         also removes the element from the elements around it
    public void deleteElement(int x, int y) {
        logicElementGrid[y][x] = null;
        if (x != 0 && logicElementGrid[y][x - 1] != null) {
            LogicElement left = logicElementGrid[y][x - 1];
            left.setRightElement(null);
        }
        if (x != SCREEN_WIDTH - 1 && logicElementGrid[y][x + 1] != null) {
            LogicElement right = logicElementGrid[y][x + 1];
            right.setLeftElement(null);
        }
        if (y != 0 && logicElementGrid[y - 1][x] != null) {
            LogicElement above = logicElementGrid[y - 1][x];
            above.setBelowElement(null);
        }
        if (y != SCREEN_HEIGHT - 1 && logicElementGrid[y + 1][x] != null) {
            LogicElement below = logicElementGrid[y + 1][x];
            below.setAboveElement(null);
        }
    }

    // REQUIRES: 0 <= x <= SCREEN_WIDTH and 0 <= y <= SCREEN_HEIGHT
    // MODIFIES: this
    // EFFECT: creates an AND Gate at x and y position and adds it to grid of logic elements
    //         when it is created it is given logic elements/null around it in the grid
    //              (example if x = 20, y = 10; given OrGate at x = 19, y = 9 to its left)
    //         if on the edge of grid (e.i. x == 0, SCREEN_WIDTH and/or y == 0, SCREEN_HEIGHT) then given null
    //              in directions outside of grid (i.e. logic element cannot exist at x = -1, y = 10 so given null)
    //         for elements around create logic element, set appropriate element direction to crete AND gate
    //              (example set element Right of OrGate at x = 19, y = 10 to AndGate created at x = 20, y = 10)
    public void addAndGate(int x, int y) {
        LogicElement andGate = new AndGate(x, y, null, null, null, null);
        placeLogicElement(x, y, andGate);
        logicElementGrid[y][x] = andGate;
    }

    // REQUIRES: 0 <= x <= SCREEN_WIDTH and 0 <= y <= SCREEN_HEIGHT
    // MODIFIES: this
    // EFFECT: when it is created it is given logic elements/null around it in the grid
    //              (example if x = 20, y = 10; given OrGate at x = 19, y = 9 to its left)
    //         if on the edge of grid (e.i. x == 0, SCREEN_WIDTH and/or y == 0, SCREEN_HEIGHT) then given null
    //              in directions outside of grid (i.e. logic element cannot exist at x = -1, y = 10 so given null)
    //         for elements around create logic element, set appropriate element direction to crete AND gate
    //              (example set element Right of OrGate at x = 19, y = 10 to AndGate created at x = 20, y = 10)
    private void placeLogicElement(int x, int y, LogicElement logicElement) {
        if (x != 0 && logicElementGrid[y][x - 1] != null) {
            LogicElement left = logicElementGrid[y][x - 1];
            logicElement.setLeftElement(left);
            left.setRightElement(logicElement);
        }
        if (x != SCREEN_WIDTH - 1 && logicElementGrid[y][x + 1] != null) {
            LogicElement right = logicElementGrid[y][x + 1];
            logicElement.setRightElement(right);
            right.setLeftElement(logicElement);
        }
        if (y != 0 && logicElementGrid[y - 1][x] != null) {
            LogicElement above = logicElementGrid[y - 1][x];
            logicElement.setAboveElement(above);
            above.setBelowElement(logicElement);
        }
        if (y != SCREEN_HEIGHT - 1 && logicElementGrid[y + 1][x] != null) {
            LogicElement below = logicElementGrid[y + 1][x];
            logicElement.setBelowElement(below);
            below.setAboveElement(logicElement);
        }
    }

    // REQUIRES: 0 <= x <= SCREEN_WIDTH and 0 <= y <= SCREEN_HEIGHT
    // MODIFIES: this
    // EFFECT: creates an OR Gate at x and y position and adds it to grid of logic elements
    //         when it is created it is given logic elements/null around it in the grid
    //              (example if x = 20, y = 10; given OrGate at x = 19, y = 9 to its left)
    //         if on the edge of grid (e.i. x == 0, SCREEN_WIDTH and/or y == 0, SCREEN_HEIGHT) then given null
    //              in directions outside of grid (i.e. logic element cannot exist at x = -1, y = 10 so given null)
    //         for elements around create logic element, set appropriate element direction to crete AND gate
    //              (example set element Right of OrGate at x = 19, y = 10 to OrGate created at x = 20, y = 10)
    public void addOrGate(int x, int y) {
        LogicElement orGate = new OrGate(x, y, null, null, null, null);
        placeLogicElement(x, y, orGate);
        logicElementGrid[y][x] = orGate;
    }

    // REQUIRES: 0 <= x <= SCREEN_WIDTH and 0 <= y <= SCREEN_HEIGHT
    // MODIFIES: this
    // EFFECT: creates an PowerSource Gate at x and y position and adds it to grid of logic elements
    //         when it is created it is given logic elements/null around it in the grid
    //              (example if x = 20, y = 10; given OrGate at x = 19, y = 9 to its left)
    //         if on the edge of grid (e.i. x == 0, SCREEN_WIDTH and/or y == 0, SCREEN_HEIGHT) then given null
    //              in directions outside of grid (i.e. logic element cannot exist at x = -1, y = 10 so given null)
    //         for elements around create logic element, set appropriate element direction to crete AND gate
    //              (example set element Right of OrGate at x = 19, y = 10 to PowerSource created at x = 20, y = 10)
    public void addPowerSource(int x, int y) {
        LogicElement powerSource = new PowerSource(x, y, null, null, null, null);
        placeLogicElement(x, y, powerSource);
        logicElementGrid[y][x] = powerSource;
    }

    // REQUIRES: 0 <= x <= SCREEN_WIDTH and 0 <= y <= SCREEN_HEIGHT
    // MODIFIES: this
    // EFFECT: creates an Wire Gate at x and y position and adds it to grid of logic elements
    //         when it is created it is given logic elements/null around it in the grid
    //              (example if x = 20, y = 10; given OrGate at x = 19, y = 9 to its left)
    //         if on the edge of grid (e.i. x == 0, SCREEN_WIDTH and/or y == 0, SCREEN_HEIGHT) then given null
    //              in directions outside of grid (i.e. logic element cannot exist at x = -1, y = 10 so given null)
    //         for elements around create logic element, set appropriate element direction to crete AND gate
    //              (example set element Right of OrGate at x = 19, y = 10 to Wire created at x = 20, y = 10)
    public void addWire(int x, int y) {
        LogicElement wire = new Wire(x, y, null, null, null, null);
        placeLogicElement(x, y, wire);
        logicElementGrid[y][x] = wire;
    }

    // REQUIRES: 0 <= x <= SCREEN_WIDTH and 0 <= y <= SCREEN_HEIGHT
    // MODIFIES: this
    // EFFECT: creates an LightOutput Gate at x and y position and adds it to grid of logic elements
    //         when it is created it is given logic elements/null around it in the grid
    //              (example if x = 20, y = 10; given OrGate at x = 19, y = 9 to its left)
    //         if on the edge of grid (e.i. x == 0, SCREEN_WIDTH and/or y == 0, SCREEN_HEIGHT) then given null
    //              in directions outside of grid (i.e. logic element cannot exist at x = -1, y = 10 so given null)
    //         for elements around create logic element, set appropriate element direction to crete AND gate
    //              (example set element Right of OrGate at x = 19, y = 10 to LightOutput created at x = 20, y = 10)
    public void addLightOutput(int x, int y) {
        LogicElement lightOutput = new LightOutput(x, y, null, null, null, null);
        placeLogicElement(x, y, lightOutput);
        logicElementGrid[y][x] = lightOutput;
    }

    // REQUIRES: 0 <= x <= SCREEN_WIDTH and 0 <= y <= SCREEN_HEIGHT
    // MODIFIES: this
    // EFFECT: creates an SoundOutput Gate at x and y position and adds it to grid of logic elements
    //         when it is created it is given logic elements/null around it in the grid
    //              (example if x = 20, y = 10; given OrGate at x = 19, y = 9 to its left)
    //         if on the edge of grid (e.i. x == 0, SCREEN_WIDTH and/or y == 0, SCREEN_HEIGHT) then given null
    //              in directions outside of grid (i.e. logic element cannot exist at x = -1, y = 10 so given null)
    //         for elements around create logic element, set appropriate element direction to crete AND gate
    //              (example set element Right of OrGate at x = 19, y = 10 to SoundOutput created at x = 20, y = 10)
    public void addSoundOutput(int x, int y) {
        LogicElement soundOutput = new SoundOutput(x, y, null, null, null, null);
        placeLogicElement(x, y, soundOutput);
        logicElementGrid[y][x] = soundOutput;
    }

    // EFFECT: return grid of logic elements
    public LogicElement[][] getLogicElementGrid() {
        return this.logicElementGrid;
    }

    // EFFECT: return grid of logic elements
    public List<LogicElement> getLogicElements() {
        List<LogicElement> logicGateList = new ArrayList<LogicElement>();
        for (LogicElement[] row: logicElementGrid) {
            for (LogicElement logicElement: row) {
                if (logicElement != null) {
                    logicGateList.add(logicElement);
                }
            }
        }
        return logicGateList;
    }

    // EFFECT: return list of logic gates by going through grid of logic elements starting from row 0
    //         to row SCREEN_HEIGHT - 1
    public List<LogicElement> getLogicGates() {
        EventLog.getInstance().logEvent(new Event("Listed LogicGates in Scenario: " + name));
        List<LogicElement> logicGateList = new ArrayList<LogicElement>();
        for (LogicElement[] row: logicElementGrid) {
            for (LogicElement logicElement: row) {
                if (logicElement instanceof LogicGate) {
                    logicGateList.add(logicElement);
                }
            }
        }
        return logicGateList;
    }

    // EFFECT: return list of wires  by going through grid of logic elements starting from row 0
    //         to row SCREEN_HEIGHT - 1 
    public List<LogicElement> getWires() {
        List<LogicElement> wireList = new ArrayList<LogicElement>();
        for (LogicElement[] row: logicElementGrid) {
            for (LogicElement logicElement: row) {
                if (logicElement instanceof Wire) {
                    wireList.add(logicElement);
                }
            }
        }
        return wireList;
    }

    // EFFECT: return list of output elements  by going through grid of logic elements starting from row 0
    //         to row SCREEN_HEIGHT - 1
    public List<LogicElement> getOutputElements() {
        EventLog.getInstance().logEvent(new Event("Listed OutputElements in Scenario: " + name));
        List<LogicElement> outputElementList = new ArrayList<LogicElement>();
        for (LogicElement[] row: logicElementGrid) {
            for (LogicElement logicElement: row) {
                if (logicElement instanceof OutputElement) {
                    outputElementList.add(logicElement);
                }
            }
        }
        return outputElementList;
    }

    // EFFECT: return list of power sources  by going through grid of logic elements starting from row 0
    //         to row SCREEN_HEIGHT - 1
    public List<LogicElement> getPowerSources() {
        EventLog.getInstance().logEvent(new Event("Listed PowerSources in Scenario: " + name));
        List<LogicElement> powerSourceList = new ArrayList<LogicElement>();
        for (LogicElement[] row: logicElementGrid) {
            for (LogicElement logicElement: row) {
                if (logicElement instanceof PowerSource) {
                    powerSourceList.add(logicElement);
                }
            }
        }
        return powerSourceList;
    }

    // return SCREEN_WIDTH
    public int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    // return SCREEN_HEIGHT
    public int getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    // EFFECT: return name of scenario
    public String getName() {
        return this.name;
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("logicelements", logicElementsToJson());
        return json;
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo
    // EFFECTS: returns logic elements in this scenario as a JSON array
    private JSONArray logicElementsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (LogicElement l : getLogicElements()) {
            jsonArray.put(l.toJson());
        }

        return jsonArray;
    }
}
