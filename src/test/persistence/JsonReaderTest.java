package persistence;

import model.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

public class JsonReaderTest extends JsonTest {

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReaderTest class
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            CircuitBuilderState circuitBuilderState = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReaderTest class
    @Test
    void testReaderEmptyCircuitBuilderState() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCircuitBuilderState.json");
        try {
            CircuitBuilderState circuitBuilderState = reader.read();
            assertEquals(0, circuitBuilderState.getScenarioList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonReaderTest class
    @Test
    void testReaderGeneralCircuitBuilderState() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCircuitBuilderState.json");
        Scenario scenario1 = new Scenario("Scenario1");
        Scenario scenario2 = initializeScenario("Scenario2");
        try {
            CircuitBuilderState circuitBuilderState = reader.read();
            List<Scenario> scenarios = circuitBuilderState.getScenarioList();
            assertEquals(2, scenarios.size());
            assertEquals("Scenario1", scenarios.get(0).getName());
            assertEquals("Scenario2", scenarios.get(1).getName());
            checkScenario(scenario1, scenarios.get(0));
            checkScenario(scenario2, scenarios.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
