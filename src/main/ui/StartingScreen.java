package ui;

import model.Scenario;

import java.util.List;
import java.util.ArrayList;

// Represents the terminal or ui of the starting screen, where users will create and select scenarios
public class StartingScreen {
    
    // EFFECTS: initializes the terminal starting screen, sets the application state,
    //          and creates an empty list of scenarios. Brings up the start menu
    public StartingScreen() {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: sets up the start menu, displays user options, and takes and handles user's input
    //          through handleInputMenu()
    public void startMenu() {
        // STUB
    }

    // EFFECTS: displays user options in the start menu in the terminal
    public void startMenuDisplay() {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: handles user input in menu:
    //              if q - quit application
    //              if n - create new scenario
    //              if s - bring up existing scenarios through scenario selector
    //              else - state "Input not valid"
    public void handleInputMenu(char c) {
        // STUB
    }

    // EFFECTS: pull from list of scenarios and allow users to select a scenario
    public Scenario scenarioSelector() {
        return null; // STUB
    }

    // EFFECTS: displays user options in the scenario selector in the terminal
    public void scenarioSelectorDisplay() {
        // STUB
    }

    // EFFECTS: handles user input in scenario selector:
    //              if q - quit scenario selector
    //              if -> - go to next scenario in list
    //              if <- - go to previous scenario in list
    //              if s - select and display scenario
    //              else - state "Input not valid"
    public void handleInputScenarioSelector(char c) {
        // STUB
    }

    // EFFECTS: displays scenario given
    public void scenarioDisplayer(Scenario scenario) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: sets up a new scenario and adds it to the list of scenarios
    public void setupScenario() {
        // STUB
    }

    // EFFECTS: returns list of current scenarios, throw NoScenarioException if list is empty
    public List<Scenario> getScenarioList() {
        return null; // STUB
    }
}
