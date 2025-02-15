package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PowerSourceTest {
    private LogicElement andGate;
    private LogicElement wire;
    private LogicElement orGate;
    private LogicElement powerSource;
    private LogicElement soundOutput;

    @BeforeEach
    void runBefore() {
        wire = new Wire(19, 10, null, powerSource, null, null);
        andGate = new AndGate(21, 10, powerSource, null, null, null);
        orGate = new OrGate(20, 11, null, null, null, powerSource);
        soundOutput = new SoundOutput(20, 9);
        powerSource = new PowerSource(20, 10, wire, andGate, orGate, soundOutput);
    }

    @Test
    void constructorTest() {
        assertEquals(20, powerSource.getPosX());
        assertEquals(10, powerSource.getPosY());
        assertEquals(wire, powerSource.getLeftElement());
        assertEquals(andGate, powerSource.getRightElement());
        assertEquals(orGate, powerSource.getAboveElement());
        assertEquals(soundOutput, powerSource.getBelowElement());
        assertTrue(powerSource.getPowerStatus());
    }

    // Every input remains false as getPowerStatus() returns POWER_STATUS = true and stops propagation
    @Test
    void inputTests() {
        assertFalse(powerSource.getInputLeft());
        assertFalse(powerSource.getInputRight());
        assertFalse(powerSource.getInputAbove());
        assertFalse(powerSource.getInputBelow());
        powerSource.inputLeft();
        powerSource.inputRight();
        powerSource.inputAbove();
        powerSource.inputBelow();
        assertFalse(powerSource.getInputLeft());
        assertFalse(powerSource.getInputRight());
        assertFalse(powerSource.getInputAbove());
        assertFalse(powerSource.getInputBelow());
    }

    @Test
    void checkPowerStatusTest() {
        assertFalse(powerSource.getLeftElement().getInputRight());
        assertFalse(powerSource.getRightElement().getInputLeft());
        assertFalse(powerSource.getAboveElement().getInputBelow());
        assertFalse(powerSource.getBelowElement().getInputAbove());
        assertTrue(powerSource.getPowerStatus());
        powerSource.checkPowerStatus();
        assertTrue(powerSource.getLeftElement().getInputRight());
        assertTrue(powerSource.getRightElement().getInputLeft());
        assertTrue(powerSource.getAboveElement().getInputBelow());
        assertTrue(powerSource.getBelowElement().getInputAbove());
        assertTrue(powerSource.getPowerStatus());
    }
}
