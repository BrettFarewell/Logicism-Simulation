package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class CircuitBuilderStateTest {
    private CircuitBuilderState circuitBuilderState;
    Scenario scenario1;
    Scenario scenario2;

    @BeforeEach
    void setup() {
        circuitBuilderState = new CircuitBuilderState();
        scenario1 = new Scenario("Scenario1");
        scenario2 = new Scenario("Scenario2");
    }

    @Test
    void testConstructor() {
        assertTrue(circuitBuilderState.getScenarioList().isEmpty());
    }

    @Test
    void testAddScenarios() {
        circuitBuilderState.addScenario(scenario1);
        assertEquals(scenario1, circuitBuilderState.getScenarioList().get(0));
        circuitBuilderState.addScenario(scenario2);
        assertEquals(scenario1, circuitBuilderState.getScenarioList().get(0));
        assertEquals(scenario2, circuitBuilderState.getScenarioList().get(1));
    }

}
