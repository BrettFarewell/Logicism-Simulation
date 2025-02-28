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
        return null; // STUB
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return null; // STUB
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // EFFECTS: parses CircuitBuilderState from JSON object and returns it
    private CircuitBuilderState parseCircuitBuilderState(JSONObject jsonObject) {
        return null; // STUB
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // MODIFIES: circuitBuilderState
    // EFFECTS: parses scenarios from JSON object and adds them to CircuitBuilderState
    private void addScenarios(CircuitBuilderState circuitBuilderState, JSONObject jsonObject) {
        // STUB
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // MODIFIES: circuitBuilderState
    // EFFECTS: parses scenario from JSON object and adds it to CircuitBuilderState
    private void addScenario(CircuitBuilderState circuitBuilderState, JSONObject jsonObject) {
        // STUB
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // MODIFIES: circuitBuilderState
    // EFFECTS: parses LogicElements from JSON object and adds it to CircuitBuilderState
    private void addLogicElements(CircuitBuilderState circuitBuilderState, JSONObject jsonObject) {
        // STUB
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReader class
    // MODIFIES: circuitBuilderState
    // EFFECTS: parses LogicElement from JSON object and adds it to CircuitBuilderState
    private void addLogicElement(CircuitBuilderState circuitBuilderState, JSONObject jsonObject) {
        // STUB
    }
}
