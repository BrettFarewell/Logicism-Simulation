package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScenarioTest {
    private Scenario scenario;

    @BeforeEach
    void runBefore() {
        scenario = new Scenario("Scenario1");
    }

    @Test
    void constructorTest() {
        assertEquals(scenario.getScreenHeight(), scenario.getLogicElementGrid().length);
        assertEquals(scenario.getScreenWidth(), scenario.getLogicElementGrid()[0].length);
        for (LogicElement[] row: scenario.getLogicElementGrid()) {
            for (LogicElement logicElement: row) {
                assertNull(logicElement);
            }
        }
        assertTrue(scenario.getLogicGates().isEmpty());
        assertTrue(scenario.getWires().isEmpty());
        assertTrue(scenario.getOutputElements().isEmpty());
        assertTrue(scenario.getPowerSources().isEmpty());
        assertEquals("Scenario1", scenario.getName());
    }

    @Test
    void addLogicElementTests() {
        scenario.addLogicElement('a', 20, 10);
        assertTrue(scenario.getLogicElementGrid()[10][20] instanceof AndGate);
        scenario.addLogicElement('o', 0, 0);
        assertTrue(scenario.getLogicElementGrid()[0][0] instanceof OrGate);
        scenario.addLogicElement('p', 49, 19);
        assertTrue(scenario.getLogicElementGrid()[19][49] instanceof PowerSource);
        scenario.addLogicElement('w', 0, 19);
        assertTrue(scenario.getLogicElementGrid()[19][0] instanceof Wire);
        scenario.addLogicElement('l', 49, 0);
        assertTrue(scenario.getLogicElementGrid()[0][49] instanceof LightOutput);
        scenario.addLogicElement('s', 30, 15);
        assertTrue(scenario.getLogicElementGrid()[15][30] instanceof SoundOutput);
    }

    @Test
    void addAndGateNoElementsAroundTests() {
        scenario.addAndGate(20, 10);
        LogicElement andGate1 = scenario.getLogicElementGrid()[10][20];
        assertTrue(andGate1 instanceof AndGate);
        assertNull(andGate1.getLeftElement());
        assertNull(andGate1.getRightElement());
        assertNull(andGate1.getAboveElement());
        assertNull(andGate1.getBelowElement());
        scenario.addAndGate(0, 0);
        LogicElement andGate2 = scenario.getLogicElementGrid()[0][0];
        assertTrue(andGate2 instanceof AndGate);
        assertNull(andGate2.getLeftElement());
        assertNull(andGate2.getRightElement());
        assertNull(andGate2.getAboveElement());
        assertNull(andGate2.getBelowElement());
        scenario.addAndGate(49, 19);
        LogicElement andGate3 = scenario.getLogicElementGrid()[19][49];
        assertTrue(andGate3 instanceof AndGate);
        assertNull(andGate3.getLeftElement());
        assertNull(andGate3.getRightElement());
        assertNull(andGate3.getAboveElement());
        assertNull(andGate3.getBelowElement());
    }

    @Test
    void addAndGateAllPossibleElementsAroundMiddleTests() {
        scenario.getLogicElementGrid()[10][19] = new Wire(19, 10, null, null, null, null);
        scenario.getLogicElementGrid()[10][21] = new AndGate(21, 10, null, null, null, null);
        scenario.getLogicElementGrid()[9][20] = new PowerSource(20, 9, null,
                                                            null, null, null);
        scenario.getLogicElementGrid()[11][20] = new LightOutput(20, 11, null,
                                                            null, null, null);
        scenario.addAndGate(20, 10);
        LogicElement andGate1 = scenario.getLogicElementGrid()[10][20];
        assertTrue(andGate1 instanceof AndGate);
        assertEquals(scenario.getLogicElementGrid()[10][19], andGate1.getLeftElement());
        assertEquals(andGate1, scenario.getLogicElementGrid()[10][19].getRightElement());
        assertEquals(scenario.getLogicElementGrid()[10][21], andGate1.getRightElement());
        assertEquals(andGate1, scenario.getLogicElementGrid()[10][21].getLeftElement());
        assertEquals(scenario.getLogicElementGrid()[9][20], andGate1.getAboveElement());
        assertEquals(andGate1, scenario.getLogicElementGrid()[9][20].getBelowElement());
        assertEquals(scenario.getLogicElementGrid()[11][20], andGate1.getBelowElement());
        assertEquals(andGate1, scenario.getLogicElementGrid()[11][20].getAboveElement());
    }

    @Test
    void addAndGateAllPossibleElementsAroundTopLeftTests() {
        scenario.getLogicElementGrid()[1][0] = new Wire(0, 1, null, null, null, null);
        scenario.getLogicElementGrid()[0][1] = new AndGate(1, 0, null, null, null, null);
        scenario.addAndGate(0, 0);
        LogicElement andGate2 = scenario.getLogicElementGrid()[0][0];
        assertTrue(andGate2 instanceof AndGate);
        assertNull(andGate2.getLeftElement());
        assertEquals(scenario.getLogicElementGrid()[0][1], andGate2.getRightElement());
        assertEquals(andGate2, scenario.getLogicElementGrid()[0][1].getLeftElement());
        assertNull(andGate2.getAboveElement());
        assertEquals(scenario.getLogicElementGrid()[1][0], andGate2.getBelowElement());
        assertEquals(andGate2, scenario.getLogicElementGrid()[1][0].getAboveElement());
    }

    @Test
    void addAndGateAllPossibleElementsAroundBottomRightTests() {
        scenario.getLogicElementGrid()[18][49] = new Wire(49, 18, null, null, null, null);
        scenario.getLogicElementGrid()[19][48] = new AndGate(48, 19, null, null, null, null);
        scenario.addAndGate(49, 19);
        LogicElement andGate3 = scenario.getLogicElementGrid()[19][49];
        assertTrue(andGate3 instanceof AndGate);
        assertEquals(scenario.getLogicElementGrid()[19][48], andGate3.getLeftElement());
        assertEquals(andGate3, scenario.getLogicElementGrid()[19][48].getRightElement());
        assertNull(andGate3.getRightElement());
        assertEquals(scenario.getLogicElementGrid()[18][49], andGate3.getAboveElement());
        assertEquals(andGate3, scenario.getLogicElementGrid()[18][49].getBelowElement());
        assertNull(andGate3.getBelowElement());
    }

    @Test
    void addOrGateNoElementsAroundTests() {
        scenario.addOrGate(20, 10);
        LogicElement orGate1 = scenario.getLogicElementGrid()[10][20];
        assertTrue(orGate1 instanceof OrGate);
        assertNull(orGate1.getLeftElement());
        assertNull(orGate1.getRightElement());
        assertNull(orGate1.getAboveElement());
        assertNull(orGate1.getBelowElement());
        scenario.addOrGate(0, 0);
        LogicElement orGate2 = scenario.getLogicElementGrid()[0][0];
        assertTrue(orGate2 instanceof OrGate);
        assertNull(orGate2.getLeftElement());
        assertNull(orGate2.getRightElement());
        assertNull(orGate2.getAboveElement());
        assertNull(orGate2.getBelowElement());
        scenario.addOrGate(49, 19);
        LogicElement orGate3 = scenario.getLogicElementGrid()[19][49];
        assertTrue(orGate3 instanceof OrGate);
        assertNull(orGate3.getLeftElement());
        assertNull(orGate3.getRightElement());
        assertNull(orGate3.getAboveElement());
        assertNull(orGate3.getBelowElement());
    }

    @Test
    void addOrGateAllPossibleElementsAroundMiddleTests() {
        scenario.getLogicElementGrid()[10][19] = new Wire(19, 10, null, null, null, null);
        scenario.getLogicElementGrid()[10][21] = new OrGate(21, 10, null, null, null, null);
        scenario.getLogicElementGrid()[9][20] = new PowerSource(20, 9, null,
                                                            null, null, null);
        scenario.getLogicElementGrid()[11][20] = new LightOutput(20, 11, null,
                                                            null, null, null);
        scenario.addOrGate(20, 10);
        LogicElement orGate1 = scenario.getLogicElementGrid()[10][20];
        assertTrue(orGate1 instanceof OrGate);
        assertEquals(scenario.getLogicElementGrid()[10][19], orGate1.getLeftElement());
        assertEquals(orGate1, scenario.getLogicElementGrid()[10][19].getRightElement());
        assertEquals(scenario.getLogicElementGrid()[10][21], orGate1.getRightElement());
        assertEquals(orGate1, scenario.getLogicElementGrid()[10][21].getLeftElement());
        assertEquals(scenario.getLogicElementGrid()[9][20], orGate1.getAboveElement());
        assertEquals(orGate1, scenario.getLogicElementGrid()[9][20].getBelowElement());
        assertEquals(scenario.getLogicElementGrid()[11][20], orGate1.getBelowElement());
        assertEquals(orGate1, scenario.getLogicElementGrid()[11][20].getAboveElement());
    }

    @Test
    void addOrGateAllPossibleElementsAroundTopLeftTests() {
        scenario.getLogicElementGrid()[1][0] = new Wire(0, 1, null, null, null, null);
        scenario.getLogicElementGrid()[0][1] = new OrGate(1, 0, null, null, null, null);
        scenario.addOrGate(0, 0);
        LogicElement orGate2 = scenario.getLogicElementGrid()[0][0];
        assertTrue(orGate2 instanceof OrGate);
        assertNull(orGate2.getLeftElement());
        assertEquals(scenario.getLogicElementGrid()[0][1], orGate2.getRightElement());
        assertEquals(orGate2, scenario.getLogicElementGrid()[0][1].getLeftElement());
        assertNull(orGate2.getAboveElement());
        assertEquals(scenario.getLogicElementGrid()[1][0], orGate2.getBelowElement());
        assertEquals(orGate2, scenario.getLogicElementGrid()[1][0].getAboveElement());
    }

    @Test
    void addOrGateAllPossibleElementsAroundBottomRightTests() {
        scenario.getLogicElementGrid()[18][49] = new Wire(49, 18, null, null, null, null);
        scenario.getLogicElementGrid()[19][48] = new OrGate(48, 19, null, null, null, null);
        scenario.addOrGate(49, 19);
        LogicElement orGate3 = scenario.getLogicElementGrid()[19][49];
        assertTrue(orGate3 instanceof OrGate);
        assertEquals(scenario.getLogicElementGrid()[19][48], orGate3.getLeftElement());
        assertEquals(orGate3, scenario.getLogicElementGrid()[19][48].getRightElement());
        assertNull(orGate3.getRightElement());
        assertEquals(scenario.getLogicElementGrid()[18][49], orGate3.getAboveElement());
        assertEquals(orGate3, scenario.getLogicElementGrid()[18][49].getBelowElement());
        assertNull(orGate3.getBelowElement());
    }

    @Test
    void addWireGateNoElementsAroundTests() {
        scenario.addWire(20, 10);
        LogicElement wireGate1 = scenario.getLogicElementGrid()[10][20];
        assertTrue(wireGate1 instanceof Wire);
        assertNull(wireGate1.getLeftElement());
        assertNull(wireGate1.getRightElement());
        assertNull(wireGate1.getAboveElement());
        assertNull(wireGate1.getBelowElement());
        scenario.addWire(0, 0);
        LogicElement wireGate2 = scenario.getLogicElementGrid()[0][0];
        assertTrue(wireGate2 instanceof Wire);
        assertNull(wireGate2.getLeftElement());
        assertNull(wireGate2.getRightElement());
        assertNull(wireGate2.getAboveElement());
        assertNull(wireGate2.getBelowElement());
        scenario.addWire(49, 19);
        LogicElement wireGate3 = scenario.getLogicElementGrid()[19][49];
        assertTrue(wireGate3 instanceof Wire);
        assertNull(wireGate3.getLeftElement());
        assertNull(wireGate3.getRightElement());
        assertNull(wireGate3.getAboveElement());
        assertNull(wireGate3.getBelowElement());
    }

    @Test
    void addWireGateAllPossibleElementsAroundMiddleTests() {
        scenario.getLogicElementGrid()[10][19] = new Wire(19, 10, null, null, null, null);
        scenario.getLogicElementGrid()[10][21] = new Wire(21, 10, null, null, null, null);
        scenario.getLogicElementGrid()[9][20] = new PowerSource(20, 9, null,
                                                            null, null, null);
        scenario.getLogicElementGrid()[11][20] = new LightOutput(20, 11, null,
                                                            null, null, null);
        scenario.addWire(20, 10);
        LogicElement wireGate1 = scenario.getLogicElementGrid()[10][20];
        assertTrue(wireGate1 instanceof Wire);
        assertEquals(scenario.getLogicElementGrid()[10][19], wireGate1.getLeftElement());
        assertEquals(wireGate1, scenario.getLogicElementGrid()[10][19].getRightElement());
        assertEquals(scenario.getLogicElementGrid()[10][21], wireGate1.getRightElement());
        assertEquals(wireGate1, scenario.getLogicElementGrid()[10][21].getLeftElement());
        assertEquals(scenario.getLogicElementGrid()[9][20], wireGate1.getAboveElement());
        assertEquals(wireGate1, scenario.getLogicElementGrid()[9][20].getBelowElement());
        assertEquals(scenario.getLogicElementGrid()[11][20], wireGate1.getBelowElement());
        assertEquals(wireGate1, scenario.getLogicElementGrid()[11][20].getAboveElement());
    }

    @Test
    void addWireGateAllPossibleElementsAroundTopLeftTests() {
        scenario.getLogicElementGrid()[1][0] = new Wire(0, 1, null, null, null, null);
        scenario.getLogicElementGrid()[0][1] = new Wire(1, 0, null, null, null, null);
        scenario.addWire(0, 0);
        LogicElement wireGate2 = scenario.getLogicElementGrid()[0][0];
        assertTrue(wireGate2 instanceof Wire);
        assertNull(wireGate2.getLeftElement());
        assertEquals(scenario.getLogicElementGrid()[0][1], wireGate2.getRightElement());
        assertEquals(wireGate2, scenario.getLogicElementGrid()[0][1].getLeftElement());
        assertNull(wireGate2.getAboveElement());
        assertEquals(scenario.getLogicElementGrid()[1][0], wireGate2.getBelowElement());
        assertEquals(wireGate2, scenario.getLogicElementGrid()[1][0].getAboveElement());
    }

    @Test
    void addWireGateAllPossibleElementsAroundBottomRightTests() {
        scenario.getLogicElementGrid()[18][49] = new Wire(49, 18, null, null, null, null);
        scenario.getLogicElementGrid()[19][48] = new Wire(48, 19, null, null, null, null);
        scenario.addWire(49, 19);
        LogicElement wireGate3 = scenario.getLogicElementGrid()[19][49];
        assertTrue(wireGate3 instanceof Wire);
        assertEquals(scenario.getLogicElementGrid()[19][48], wireGate3.getLeftElement());
        assertEquals(wireGate3, scenario.getLogicElementGrid()[19][48].getRightElement());
        assertNull(wireGate3.getRightElement());
        assertEquals(scenario.getLogicElementGrid()[18][49], wireGate3.getAboveElement());
        assertEquals(wireGate3, scenario.getLogicElementGrid()[18][49].getBelowElement());
        assertNull(wireGate3.getBelowElement());
    }

    @Test
    void addPowerSourceGateNoElementsAroundTests() {
        scenario.addPowerSource(20, 10);
        LogicElement powerSourceGate1 = scenario.getLogicElementGrid()[10][20];
        assertTrue(powerSourceGate1 instanceof PowerSource);
        assertNull(powerSourceGate1.getLeftElement());
        assertNull(powerSourceGate1.getRightElement());
        assertNull(powerSourceGate1.getAboveElement());
        assertNull(powerSourceGate1.getBelowElement());
        scenario.addPowerSource(0, 0);
        LogicElement powerSourceGate2 = scenario.getLogicElementGrid()[0][0];
        assertTrue(powerSourceGate2 instanceof PowerSource);
        assertNull(powerSourceGate2.getLeftElement());
        assertNull(powerSourceGate2.getRightElement());
        assertNull(powerSourceGate2.getAboveElement());
        assertNull(powerSourceGate2.getBelowElement());
        scenario.addPowerSource(49, 19);
        LogicElement powerSourceGate3 = scenario.getLogicElementGrid()[19][49];
        assertTrue(powerSourceGate3 instanceof PowerSource);
        assertNull(powerSourceGate3.getLeftElement());
        assertNull(powerSourceGate3.getRightElement());
        assertNull(powerSourceGate3.getAboveElement());
        assertNull(powerSourceGate3.getBelowElement());
    }

    @Test
    void addPowerSourceGateAllPossibleElementsAroundMiddleTests() {
        scenario.getLogicElementGrid()[10][19] = new PowerSource(19, 10, null, null, null, null);
        scenario.getLogicElementGrid()[10][21] = new PowerSource(21, 10, null, null, null, null);
        scenario.getLogicElementGrid()[9][20] = new PowerSource(20, 9, null,
                                                            null, null, null);
        scenario.getLogicElementGrid()[11][20] = new LightOutput(20, 11, null,
                                                            null, null, null);
        scenario.addPowerSource(20, 10);
        LogicElement powerSourceGate1 = scenario.getLogicElementGrid()[10][20];
        assertTrue(powerSourceGate1 instanceof PowerSource);
        assertEquals(scenario.getLogicElementGrid()[10][19], powerSourceGate1.getLeftElement());
        assertEquals(powerSourceGate1, scenario.getLogicElementGrid()[10][19].getRightElement());
        assertEquals(scenario.getLogicElementGrid()[10][21], powerSourceGate1.getRightElement());
        assertEquals(powerSourceGate1, scenario.getLogicElementGrid()[10][21].getLeftElement());
        assertEquals(scenario.getLogicElementGrid()[9][20], powerSourceGate1.getAboveElement());
        assertEquals(powerSourceGate1, scenario.getLogicElementGrid()[9][20].getBelowElement());
        assertEquals(scenario.getLogicElementGrid()[11][20], powerSourceGate1.getBelowElement());
        assertEquals(powerSourceGate1, scenario.getLogicElementGrid()[11][20].getAboveElement());
    }

    @Test
    void addPowerSourceGateAllPossibleElementsAroundTopLeftTests() {
        scenario.getLogicElementGrid()[1][0] = new PowerSource(0, 1, null, null, null, null);
        scenario.getLogicElementGrid()[0][1] = new PowerSource(1, 0, null, null, null, null);
        scenario.addPowerSource(0, 0);
        LogicElement powerSourceGate2 = scenario.getLogicElementGrid()[0][0];
        assertTrue(powerSourceGate2 instanceof PowerSource);
        assertNull(powerSourceGate2.getLeftElement());
        assertEquals(scenario.getLogicElementGrid()[0][1], powerSourceGate2.getRightElement());
        assertEquals(powerSourceGate2, scenario.getLogicElementGrid()[0][1].getLeftElement());
        assertNull(powerSourceGate2.getAboveElement());
        assertEquals(scenario.getLogicElementGrid()[1][0], powerSourceGate2.getBelowElement());
        assertEquals(powerSourceGate2, scenario.getLogicElementGrid()[1][0].getAboveElement());
    }

    @Test
    void addPowerSourceGateAllPossibleElementsAroundBottomRightTests() {
        scenario.getLogicElementGrid()[18][49] = new PowerSource(49, 18, null, null, null, null);
        scenario.getLogicElementGrid()[19][48] = new PowerSource(48, 19, null, null, null, null);
        scenario.addPowerSource(49, 19);
        LogicElement powerSourceGate3 = scenario.getLogicElementGrid()[19][49];
        assertTrue(powerSourceGate3 instanceof PowerSource);
        assertEquals(scenario.getLogicElementGrid()[19][48], powerSourceGate3.getLeftElement());
        assertEquals(powerSourceGate3, scenario.getLogicElementGrid()[19][48].getRightElement());
        assertNull(powerSourceGate3.getRightElement());
        assertEquals(scenario.getLogicElementGrid()[18][49], powerSourceGate3.getAboveElement());
        assertEquals(powerSourceGate3, scenario.getLogicElementGrid()[18][49].getBelowElement());
        assertNull(powerSourceGate3.getBelowElement());
    }

    @Test
    void addLightOutputGateNoElementsAroundTests() {
        scenario.addLightOutput(20, 10);
        LogicElement lightOutputGate1 = scenario.getLogicElementGrid()[10][20];
        assertTrue(lightOutputGate1 instanceof LightOutput);
        assertNull(lightOutputGate1.getLeftElement());
        assertNull(lightOutputGate1.getRightElement());
        assertNull(lightOutputGate1.getAboveElement());
        assertNull(lightOutputGate1.getBelowElement());
        scenario.addLightOutput(0, 0);
        LogicElement lightOutputGate2 = scenario.getLogicElementGrid()[0][0];
        assertTrue(lightOutputGate2 instanceof LightOutput);
        assertNull(lightOutputGate2.getLeftElement());
        assertNull(lightOutputGate2.getRightElement());
        assertNull(lightOutputGate2.getAboveElement());
        assertNull(lightOutputGate2.getBelowElement());
        scenario.addLightOutput(49, 19);
        LogicElement lightOutputGate3 = scenario.getLogicElementGrid()[19][49];
        assertTrue(lightOutputGate3 instanceof LightOutput);
        assertNull(lightOutputGate3.getLeftElement());
        assertNull(lightOutputGate3.getRightElement());
        assertNull(lightOutputGate3.getAboveElement());
        assertNull(lightOutputGate3.getBelowElement());
    }

    @Test
    void addLightOutputGateAllPossibleElementsAroundMiddleTests() {
        scenario.getLogicElementGrid()[10][19] = new LightOutput(19, 10, null, null, null, null);
        scenario.getLogicElementGrid()[10][21] = new LightOutput(21, 10, null, null, null, null);
        scenario.getLogicElementGrid()[9][20] = new LightOutput(20, 9, null,
                                                            null, null, null);
        scenario.getLogicElementGrid()[11][20] = new LightOutput(20, 11, null,
                                                            null, null, null);
        scenario.addLightOutput(20, 10);
        LogicElement lightOutputGate1 = scenario.getLogicElementGrid()[10][20];
        assertTrue(lightOutputGate1 instanceof LightOutput);
        assertEquals(scenario.getLogicElementGrid()[10][19], lightOutputGate1.getLeftElement());
        assertEquals(lightOutputGate1, scenario.getLogicElementGrid()[10][19].getRightElement());
        assertEquals(scenario.getLogicElementGrid()[10][21], lightOutputGate1.getRightElement());
        assertEquals(lightOutputGate1, scenario.getLogicElementGrid()[10][21].getLeftElement());
        assertEquals(scenario.getLogicElementGrid()[9][20], lightOutputGate1.getAboveElement());
        assertEquals(lightOutputGate1, scenario.getLogicElementGrid()[9][20].getBelowElement());
        assertEquals(scenario.getLogicElementGrid()[11][20], lightOutputGate1.getBelowElement());
        assertEquals(lightOutputGate1, scenario.getLogicElementGrid()[11][20].getAboveElement());
    }

    @Test
    void addLightOutputGateAllPossibleElementsAroundTopLeftTests() {
        scenario.getLogicElementGrid()[1][0] = new LightOutput(0, 1, null, null, null, null);
        scenario.getLogicElementGrid()[0][1] = new LightOutput(1, 0, null, null, null, null);
        scenario.addLightOutput(0, 0);
        LogicElement lightOutputGate2 = scenario.getLogicElementGrid()[0][0];
        assertTrue(lightOutputGate2 instanceof LightOutput);
        assertNull(lightOutputGate2.getLeftElement());
        assertEquals(scenario.getLogicElementGrid()[0][1], lightOutputGate2.getRightElement());
        assertEquals(lightOutputGate2, scenario.getLogicElementGrid()[0][1].getLeftElement());
        assertNull(lightOutputGate2.getAboveElement());
        assertEquals(scenario.getLogicElementGrid()[1][0], lightOutputGate2.getBelowElement());
        assertEquals(lightOutputGate2, scenario.getLogicElementGrid()[1][0].getAboveElement());
    }

    @Test
    void addLightOutputGateAllPossibleElementsAroundBottomRightTests() {
        scenario.getLogicElementGrid()[18][49] = new LightOutput(49, 18, null, null, null, null);
        scenario.getLogicElementGrid()[19][48] = new LightOutput(48, 19, null, null, null, null);
        scenario.addLightOutput(49, 19);
        LogicElement lightOutputGate3 = scenario.getLogicElementGrid()[19][49];
        assertTrue(lightOutputGate3 instanceof LightOutput);
        assertEquals(scenario.getLogicElementGrid()[19][48], lightOutputGate3.getLeftElement());
        assertEquals(lightOutputGate3, scenario.getLogicElementGrid()[19][48].getRightElement());
        assertNull(lightOutputGate3.getRightElement());
        assertEquals(scenario.getLogicElementGrid()[18][49], lightOutputGate3.getAboveElement());
        assertEquals(lightOutputGate3, scenario.getLogicElementGrid()[18][49].getBelowElement());
        assertNull(lightOutputGate3.getBelowElement());
    }

    @Test
    void addsoundOutputGateNoElementsAroundTests() {
        scenario.addSoundOutput(20, 10);
        LogicElement soundOutputGate1 = scenario.getLogicElementGrid()[10][20];
        assertTrue(soundOutputGate1 instanceof SoundOutput);
        assertNull(soundOutputGate1.getLeftElement());
        assertNull(soundOutputGate1.getRightElement());
        assertNull(soundOutputGate1.getAboveElement());
        assertNull(soundOutputGate1.getBelowElement());
        scenario.addSoundOutput(0, 0);
        LogicElement soundOutputGate2 = scenario.getLogicElementGrid()[0][0];
        assertTrue(soundOutputGate2 instanceof SoundOutput);
        assertNull(soundOutputGate2.getLeftElement());
        assertNull(soundOutputGate2.getRightElement());
        assertNull(soundOutputGate2.getAboveElement());
        assertNull(soundOutputGate2.getBelowElement());
        scenario.addSoundOutput(49, 19);
        LogicElement soundOutputGate3 = scenario.getLogicElementGrid()[19][49];
        assertTrue(soundOutputGate3 instanceof SoundOutput);
        assertNull(soundOutputGate3.getLeftElement());
        assertNull(soundOutputGate3.getRightElement());
        assertNull(soundOutputGate3.getAboveElement());
        assertNull(soundOutputGate3.getBelowElement());
    }

    @Test
    void addsoundOutputGateAllPossibleElementsAroundMiddleTests() {
        scenario.getLogicElementGrid()[10][19] = new SoundOutput(19, 10, null, null, null, null);
        scenario.getLogicElementGrid()[10][21] = new SoundOutput(21, 10, null, null, null, null);
        scenario.getLogicElementGrid()[9][20] = new SoundOutput(20, 9, null,
                                                            null, null, null);
        scenario.getLogicElementGrid()[11][20] = new SoundOutput(20, 11, null,
                                                            null, null, null);
        scenario.addSoundOutput(20, 10);
        LogicElement soundOutputGate1 = scenario.getLogicElementGrid()[10][20];
        assertTrue(soundOutputGate1 instanceof SoundOutput);
        assertEquals(scenario.getLogicElementGrid()[10][19], soundOutputGate1.getLeftElement());
        assertEquals(soundOutputGate1, scenario.getLogicElementGrid()[10][19].getRightElement());
        assertEquals(scenario.getLogicElementGrid()[10][21], soundOutputGate1.getRightElement());
        assertEquals(soundOutputGate1, scenario.getLogicElementGrid()[10][21].getLeftElement());
        assertEquals(scenario.getLogicElementGrid()[9][20], soundOutputGate1.getAboveElement());
        assertEquals(soundOutputGate1, scenario.getLogicElementGrid()[9][20].getBelowElement());
        assertEquals(scenario.getLogicElementGrid()[11][20], soundOutputGate1.getBelowElement());
        assertEquals(soundOutputGate1, scenario.getLogicElementGrid()[11][20].getAboveElement());
    }

    @Test
    void addsoundOutputGateAllPossibleElementsAroundTopLeftTests() {
        scenario.getLogicElementGrid()[1][0] = new SoundOutput(0, 1, null, null, null, null);
        scenario.getLogicElementGrid()[0][1] = new SoundOutput(1, 0, null, null, null, null);
        scenario.addSoundOutput(0, 0);
        LogicElement soundOutputGate2 = scenario.getLogicElementGrid()[0][0];
        assertTrue(soundOutputGate2 instanceof SoundOutput);
        assertNull(soundOutputGate2.getLeftElement());
        assertEquals(scenario.getLogicElementGrid()[0][1], soundOutputGate2.getRightElement());
        assertEquals(soundOutputGate2, scenario.getLogicElementGrid()[0][1].getLeftElement());
        assertNull(soundOutputGate2.getAboveElement());
        assertEquals(scenario.getLogicElementGrid()[1][0], soundOutputGate2.getBelowElement());
        assertEquals(soundOutputGate2, scenario.getLogicElementGrid()[1][0].getAboveElement());
    }

    @Test
    void addsoundOutputGateAllPossibleElementsAroundBottomRightTests() {
        scenario.getLogicElementGrid()[18][49] = new SoundOutput(49, 18, null, null, null, null);
        scenario.getLogicElementGrid()[19][48] = new SoundOutput(48, 19, null, null, null, null);
        scenario.addSoundOutput(49, 19);
        LogicElement soundOutputGate3 = scenario.getLogicElementGrid()[19][49];
        assertTrue(soundOutputGate3 instanceof SoundOutput);
        assertEquals(scenario.getLogicElementGrid()[19][48], soundOutputGate3.getLeftElement());
        assertEquals(soundOutputGate3, scenario.getLogicElementGrid()[19][48].getRightElement());
        assertNull(soundOutputGate3.getRightElement());
        assertEquals(scenario.getLogicElementGrid()[18][49], soundOutputGate3.getAboveElement());
        assertEquals(soundOutputGate3, scenario.getLogicElementGrid()[18][49].getBelowElement());
        assertNull(soundOutputGate3.getBelowElement());
    }

    @Test
    void getListsOfDifferentElementsEmpty() {
        assertTrue(scenario.getLogicGates().isEmpty());
        assertTrue(scenario.getWires().isEmpty());
        assertTrue(scenario.getOutputElements().isEmpty());
        assertTrue(scenario.getPowerSources().isEmpty());
    }

    @Test
    void getListsOfDifferentElementsNotEmpty() {
        scenario.getLogicElementGrid()[10][19] = new Wire(19, 10, null, null, null, null);
        scenario.getLogicElementGrid()[10][21] = new AndGate(21, 10, null, null, null, null);
        scenario.getLogicElementGrid()[9][20] = new PowerSource(20, 9, null,
                                                            null, null, null);
        scenario.getLogicElementGrid()[9][30] = new PowerSource(30, 9, null,
                                                            null, null, null);
        scenario.getLogicElementGrid()[11][20] = new LightOutput(20, 11, null,
                                                            null, null, null);
        scenario.getLogicElementGrid()[0][20] = new SoundOutput(20, 0, null,
                                                            null, null, null);
        scenario.getLogicElementGrid()[1][0] = new Wire(0, 1, null, null, null, null);
        scenario.getLogicElementGrid()[0][1] = new OrGate(1, 0, null, null, null, null);
        scenario.getLogicElementGrid()[18][49] = new Wire(49, 18, null, null, null, null);
        scenario.getLogicElementGrid()[19][48] = new AndGate(48, 19, null, null, null, null);
        assertEquals(3, scenario.getLogicGates().size());
        assertEquals(3, scenario.getWires().size());
        assertEquals(2, scenario.getOutputElements().size());
        assertEquals(2, scenario.getPowerSources().size());
        assertEquals(scenario.getLogicElementGrid()[0][1], scenario.getLogicGates().get(0));
        assertEquals(scenario.getLogicElementGrid()[1][0], scenario.getWires().get(0));
        assertEquals(scenario.getLogicElementGrid()[0][20], scenario.getOutputElements().get(0));
        assertEquals(scenario.getLogicElementGrid()[9][20], scenario.getPowerSources().get(0));
    }
}
