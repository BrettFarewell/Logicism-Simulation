package ui;

import model.Scenario;
import model.logicgate.*;

import java.util.List;
import java.util.ArrayList;


// Represents the terminal or ui of the selected scenario, where users will create and place logic objects.
// Logic objects will be rendered accordingly
public class ScenarioDisplayer {
    
    // EFFECT: displays scenario given in terminal
    public ScenarioDisplayer(Scenario scenario) {

    }

    // MODIFIES: this
    // EFFECT: sets up the scenario menu, displays user options, and takes and handles user's input
    //          through handleInputMenu()
    public void scenarioMenu() {

    }

    // EFFECTS: displays user options in the scenraio menu in the terminal
    public void scenarioMenuDisplay() {
        // STUB
    }

    // EFFECTS: renders scenario in terminal
    public void scenarioRender() {

    }

    // EFFECTS: renders logic gate in terminal
    public void logicGateRender()  {

    }

    // EFFECTS: renders wire in terminal
    public void wireRender()  {

    }

    // EFFECTS: renders power source in terminal
    public void sourceRender()  {

    }

    // EFFECTS: renders output in terminal
    public void outputRender()  {

    }

    // MODIFIES: this
    // EFFECTS: handles user input in menu:
    //              if q - quit scenario
    //              if n - create new object (source, logic object, wire, output) and place it in scenario
    //              if s - gives list of source, logic object, output currently in scenario
    //              else - state "Input not valid"
    public void handleInputMenu(char c) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS: sets up a new object (source, logic object, wire, output) and adds allows user to add it to scenario
    //          if object is a logic gate, add it to list of logic gates
    public void createNewObject() {
        // STUB
    }

    

    // EFFECTS: returns list of current logic gates, throw NoGatesException if list is empty
    public List<LogicGate> getLogicGateList() {
        return null; // STUB
    }
}
