package persistence;

import model.CircuitBuilderState;
import model.Event;
import model.EventLog;

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
        this.destination = destination;
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonWriter class
    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonWriter class
    // MODIFIES: this
    // EFFECTS: writes JSON representation of workroom to file
    public void write(CircuitBuilderState circuitBuilderState) {
        EventLog.getInstance().logEvent(new Event("Saved application state to " + destination));
        JSONObject json = circuitBuilderState.toJson();
        saveToFile(json.toString(TAB));
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonWriter class
    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonWriter class
    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }    
}
