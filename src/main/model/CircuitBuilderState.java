package model;

import persistance.Writable;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

// Represents the state of the circuit builder application is currently in will all of the scenarios within
public class CircuitBuilderState implements Writable {
    private List<Scenario> scenarios;

    // EFFECT: creates a CircuitBuilderState with an empty scenario list
    public CircuitBuilderState() {
        scenarios = new ArrayList<Scenario>();
    }

    // MODIFIES: this
    // EFFECT: adds a scenario to the list of scenarios
    public void addScenario(Scenario scenario) {
        this.scenarios.add(scenario);
    }

    // EFFECT: returns list of scenarios in the current state of the circuit builder 
    public List<Scenario> getScenarioList() {
        return this.scenarios;
    }

    @Override
    public JSONObject toJson() {
        return null;
    }
    
}
