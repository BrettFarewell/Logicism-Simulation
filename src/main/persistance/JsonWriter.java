package persistance;

import model.CircuitBuilderState;
import model.Scenario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.JSONObject;

// ATTRIBUTION: many of the methods in the class come from the JsonWriter class in the JSONSerializeationDemo
// Represents a writer that writes JSON representation of CircuitBuilderState to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonWriter class
    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        // STUB
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonWriter class
    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        // STUB
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonWriter class
    // MODIFIES: this
    // EFFECTS: writes JSON representation of workroom to file
    public void write(CircuitBuilderState circuitBuilderState) {
        // STUB
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonWriter class
    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        // STUB
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonWriter class
    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        // STUB
    }    
}
