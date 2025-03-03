package persistence;

import model.*;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {
    protected void checkScenario(Scenario sample, Scenario test) {
        for (int i = 0; i < test.getLogicElementGrid().length; i++) {
            for (int j = 0; j < test.getLogicElementGrid()[i].length; j++) {
                checkElement(sample.getLogicElementGrid()[i][j], test.getLogicElementGrid()[i][j]);
            }
        }
    }

    protected void checkElement(LogicElement sample, LogicElement test) {
        if (sample != null && sample != null) {
            assertEquals(sample.getPosX(), test.getPosX());
            assertEquals(sample.getPosY(), test.getPosY());
            checkNextToElements(sample, test);
            assertEquals(sample.getInputLeft(), test.getInputLeft());
            assertEquals(sample.getInputRight(), test.getInputRight());
            assertEquals(sample.getInputAbove(), test.getInputAbove());
            assertEquals(sample.getInputBelow(), test.getInputBelow());
            assertEquals(sample.getPowerStatus(), test.getPowerStatus());
        } else if ((sample == null && sample != null) || (sample != null && sample == null)) {
            fail("If sample logic element is null, then the test logic element should be null");
        }
    }

    private void checkNextToElements(LogicElement sample, LogicElement test) {
        if (sample.getLeftElement() != null) {
            assertEquals(sample.getLeftElement().getCategory(), test.getLeftElement().getCategory());
        } else {
            assertEquals(sample.getLeftElement(), test.getLeftElement());
        }
        if (sample.getRightElement() != null) {
            assertEquals(sample.getRightElement().getCategory(), test.getRightElement().getCategory());
        } else {
            assertEquals(sample.getRightElement(), test.getRightElement());
        }
        if (sample.getAboveElement() != null) {
            assertEquals(sample.getAboveElement().getCategory(), test.getAboveElement().getCategory());
        } else {
            assertEquals(sample.getAboveElement(), test.getAboveElement());
        }
        if (sample.getBelowElement() != null) {
            assertEquals(sample.getBelowElement().getCategory(), test.getBelowElement().getCategory());
        } else {
            assertEquals(sample.getBelowElement(), test.getBelowElement());
        }
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
