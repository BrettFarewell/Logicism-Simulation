package persistence;

import org.json.JSONObject;

// Represents a writable interface to allow objects to be written as JSON objects
public interface Writable {
    // ATTRIBUTION: Code structure based on JSONSerializationDemo
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
