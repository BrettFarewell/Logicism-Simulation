package persistance;

import model.*;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkScenario(Scenario sample, Scenario test) {
        for (int i = 0; i < test.getLogicElementGrid().length; i++) {
            for (int j = 0; j < test.getLogicElementGrid()[i].length; j++) {
                checkElement(sample.getLogicElementGrid()[i][j], test.getLogicElementGrid()[i][j]);
            }
        }
    }

    protected void checkElement(LogicElement sample, LogicElement test) {
        assertEquals(sample.getPosX(), test.getPosX());
        assertEquals(sample.getPosY(), test.getPosY());
        assertEquals(sample.getLeftElement(), test.getLeftElement());
        assertEquals(sample.getRightElement(), test.getRightElement());
        assertEquals(sample.getAboveElement(), test.getAboveElement());
        assertEquals(sample.getBelowElement(), test.getBelowElement());
        assertEquals(sample.getInputLeft(), test.getInputLeft());
        assertEquals(sample.getInputRight(), test.getInputRight());
        assertEquals(sample.getInputAbove(), test.getInputAbove());
        assertEquals(sample.getInputBelow(), test.getInputBelow());
        assertEquals(sample.getPowerStatus(), test.getPowerStatus());
    }

    protected Scenario initializeScenario(String name) {
        Scenario scenario = new Scenario(name);
        scenario.addPowerSource(5, 5);
        scenario.addWire(6, 5);
        scenario.addWire(7, 5);
        scenario.addOrGate(8, 5);
        scenario.addWire(9, 5);
        scenario.addWire(9, 4);
        scenario.addWire(8, 4);
        scenario.addLightOutput(8, 3);
        scenario.addWire(6, 4);
        scenario.addWire(6, 3);
        scenario.addWire(6, 2);
        scenario.addWire(7, 2);
        scenario.addAndGate(8, 2);
        scenario.addWire(9, 2);
        scenario.addWire(10, 2);
        scenario.addSoundOutput(11, 2);
        return scenario;
    }
}
