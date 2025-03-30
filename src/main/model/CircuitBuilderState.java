package model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

// Represents the state of the circuit builder application is currently in will all of the scenarios within
public class CircuitBuilderState implements Writable {
    private List<Scenario> scenarios;

    // EFFECT: creates a CircuitBuilderState with an empty scenario list
    public CircuitBuilderState() {
        scenarios = new ArrayList<Scenario>();
    }

    // ATTRIBUTION: EventLog comes from the the AlermSystem project  
    // MODIFIES: this
    // EFFECT: adds a scenario to the list of scenarios
    public void addScenario(Scenario scenario) {
        EventLog.getInstance().logEvent(new Event("Generated a new Scenario: " + scenario.getName()));
        this.scenarios.add(scenario);
    }

    // EFFECT: returns list of scenarios in the current state of the circuit builder 
    public List<Scenario> getScenarioList() {
        return this.scenarios;
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("scenarios", scenariosToJson());
        return json;
    }
   
    // ATTRIBUTION: Code structure based on JSONSerializationDemo
    // EFFECTS: returns scenarios in this circuit builder as a JSON array
    private JSONArray scenariosToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Scenario s : scenarios) {
            jsonArray.put(s.toJson());
        }
        return jsonArray;
    }
}
