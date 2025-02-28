package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircuitBuilderStateTest {
    private CircuitBuilderState circuitBuilderState;
    private Scenario scenario1;
    private Scenario scenario2;

    @BeforeEach
    void runBefore() {
        circuitBuilderState = new CircuitBuilderState();
        scenario1 = new Scenario("Scenario1");
        scenario2 = new Scenario("Scenario2");
    }

    @Test
    void constructorTest() {
        assertTrue(circuitBuilderState.getScenarioList().isEmpty());
    }

    @Test
    void addScenariosTests() {
        circuitBuilderState.addScenario(scenario1);
        assertEquals(scenario1, circuitBuilderState.getScenarioList().get(0));
        circuitBuilderState.addScenario(scenario2);
        assertEquals(scenario1, circuitBuilderState.getScenarioList().get(0));
        assertEquals(scenario2, circuitBuilderState.getScenarioList().get(1));
    }

}
