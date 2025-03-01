package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

// ATTRIBUTION: many of the methods in the class come from the JsonReader class in the JSONSerializeationDemo
// Represents a reader that reads JSON representation of CircuitBuilderState from file
public class JsonReader {
    private String source;

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // EFFECTS: reads CircuitBuilderState from file and returns it;
    // throws IOException if an error occurs reading data from file
    public CircuitBuilderState read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCircuitBuilderState(jsonObject);
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // EFFECTS: parses CircuitBuilderState from JSON object and returns it
    private CircuitBuilderState parseCircuitBuilderState(JSONObject jsonObject) {
        CircuitBuilderState circuitBuilderState = new CircuitBuilderState();
        addScenarios(circuitBuilderState, jsonObject);
        return circuitBuilderState;
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // MODIFIES: circuitBuilderState
    // EFFECTS: parses scenarios from JSON object and adds them to CircuitBuilderState
    private void addScenarios(CircuitBuilderState circuitBuilderState, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("scenarios");
        for (Object json : jsonArray) {
            JSONObject nextScenario = (JSONObject) json;
            addScenario(circuitBuilderState, nextScenario);
        }
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // MODIFIES: circuitBuilderState
    // EFFECTS: parses scenario from JSON object and adds it to CircuitBuilderState
    private void addScenario(CircuitBuilderState circuitBuilderState, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Scenario scenario = new Scenario(name);
        addLogicElements(scenario, circuitBuilderState, jsonObject);
        circuitBuilderState.addScenario(scenario);
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // MODIFIES: circuitBuilderState, scenario
    // EFFECTS: parses LogicElements from JSON object and adds it to CircuitBuilderState
    private void addLogicElements(Scenario scenario, CircuitBuilderState circuitBuilderState, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("logicelements");
        for (Object json : jsonArray) {
            JSONObject nextScenario = (JSONObject) json;
            addLogicElement(scenario, circuitBuilderState, nextScenario);
        }
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // MODIFIES: circuitBuilderState, scenario
    // EFFECTS: parses LogicElement from JSON object and adds it to CircuitBuilderState
    private void addLogicElement(Scenario scenario, CircuitBuilderState circuitBuilderState, JSONObject jsonObject) {
        int posX = jsonObject.getInt("posX");
        int posY = jsonObject.getInt("posY");
        String key = jsonObject.getString("category");
        scenario.addLogicElement(key, posX, posY);
    }
}
