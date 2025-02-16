package ui;

import model.AndGate;
import model.LightOutput;
import model.LogicElement;
import model.OrGate;
import model.PowerSource;
import model.Scenario;
import model.SoundOutput;
import model.Wire;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


// Represents the terminal or ui of the selected scenario, where users will create and place logic objects.
// Logic objects will be rendered accordingly
public class ScenarioDisplayer {
    private boolean displayerState;
    private Scenario scenario;
    private Scanner scanner;
    private String divider = "--------------------------------------------------";
    
    // EFFECT: displays scenario given in terminal. Initializes scenario displayer with selected scenario
    public ScenarioDisplayer(Scenario scenario) {
        // STUB
    }

    // MODIFIES: this
    // EFFECT: sets up the scenario menu, displays user options, and takes and handles user's input
    //          through handleInputMenu()
    public void scenarioMenu() {
        // STUB
    }

    // EFFECTS: displays user options in the scenraio menu in the terminal
    public void scenarioMenuDisplay() {
        // STUB
    }

    // EFFECTS: previews scenario in terminal
    public void scenarioPreviewer() {
        // STUB
    }

    // EFFECTS: renders scenario in terminal after the scenario run
    public void scenarioRender() {
        // STUB
    }

    // REQUIRES: logicElement is an AndGate, OrGate, PowerSource, Wire, LightOutput, SoundOutput, or null
    // EFFECT: match the logicElement to the specified character
    //              if AndGate, return D
    //              if OrGate, return 0
    //              if PowerSource, return P
    //              if Wire, return ~
    //              if LightOutput, return █
    //              if SoundOutput, return ▒
    //              if null, return " "
    public char findLogicElementSymbol(LogicElement logicElement) {
        return ' '; // STUB
    }

    // MODIFIES: this
    // EFFECTS: handles user input in menu:
    //              if q - quit scenario
    //              if n - create new object (source, logic object, wire, output) and place it in scenario
    //              if r - run scenario
    //              if s - gives list of source, logic object, output currently in scenario
    //              else - state "Input not valid"
    public void handleInputMenu(String key) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: sets up a new logic element (source, logic object, wire, output) and adds allows user to add it to
    //          scenario
    public void createNewLogicElement() {
        // STUB
    }

    // EFFECTS: allows users to preview where the current selected tile is when placing a new logic element in
    //          current scenario
    public void previewNewLogicElementInScenario() {
        // STUB
    }

    // EFFECTS: displays user options when placing a new logic element
    public void displayMenuNewLogicElement() {
        // STUB
    }

    // EFFECTS: handles the user's input when the new logic element menu
    //              if "a" is pressed, moves selected tile to the left (unless at left border)
    //              if "d" is pressed, moves selected tile to the right (unless at right border)
    //              if "w" is pressed, moves selected tile to up (unless at top border)
    //              if "s" is pressed, moves selected tile to down (unless at bottom border)
    //              if "e" is pressed, selects tile and gives further options for what logic element to add
    //              if "q" is pressed, quits menu for new logic element
    //              otherwise, gives invalid response message
    public void hanldeUserInputMenuNewLogicElement() {
        // STUB
    }

    // EFFECTS: displays user options for what logic element to place once tile is selected
    public void displayNewLogicElementOptions() {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: quits scenario displayer menu back to scenario selector
    public void quitScenarioDisplayer() {
        // STUB
    }

    // EFFECTS: returns list of current logic gates, throw NoGatesException if list is empty
    public List<LogicElement> getLogicGateList() {
        return null; // STUB
    }
}
