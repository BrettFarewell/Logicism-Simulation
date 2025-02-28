package model;

import persistance.Writable;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

// Represents the state of the circuit builder application is currently in will all of the scenarios within
public class CircuitBuilderState implements Writable {

    // EFFECT: creates a CircuitBuilderState with an empty scenario list
    public CircuitBuilderState() {

    }

    // MODIFIES: this
    // EFFECT: adds a scenario to the list of scenarios
    public void addScenario() {
        
    }

    // EFFECT: returns list of scenarios in the current state of the circuit builder 
    public ArrayList<Scenario> getScenarioList() {
        return null;
    }

    @Override
    public JSONObject toJson() {
        return null;
    }
    
}
