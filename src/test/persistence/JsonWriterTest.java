package persistence;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JsonWriterTest extends JsonTest {
    CircuitBuilderState circuitBuilderState;

    @BeforeEach
    void runBefore() {
        circuitBuilderState = new CircuitBuilderState();
    }
    
    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonWriterTest class
    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonWriterTest class
    @Test
    void testWriterEmptyCircuitBuilderState() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCircuitBuilderState.json");
            writer.open();
            writer.write(circuitBuilderState);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCircuitBuilderState.json");
            circuitBuilderState = reader.read();
            assertTrue(circuitBuilderState.getScenarioList().isEmpty());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo JsonWriterTest class
    @Test
    void testWriterGeneralCircuitBuilderState() {
        try {
            Scenario scenario1 = new Scenario("Scenario1");
            circuitBuilderState.addScenario(scenario1);
            Scenario scenario2 = initializeScenario("Scenario2");
            circuitBuilderState.addScenario(scenario2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCircuitBuilderState.json");
            writer.open();
            writer.write(circuitBuilderState);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCircuitBuilderState.json");
            circuitBuilderState = reader.read();
            List<Scenario> scenarios = circuitBuilderState.getScenarioList();
            assertEquals(2, scenarios.size());
            assertEquals("Scenario1", scenarios.get(0).getName());
            assertEquals("Scenario2", scenarios.get(1).getName());
            checkScenario(scenario1, scenarios.get(0));
            checkScenario(scenario2, scenarios.get(1));


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
