package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PowerSourceTest {
    private LogicElement powerSource;
    private LogicElement wire1;
    private LogicElement wire2;
    private LogicElement wire3;
    private LogicElement wire4;

    @BeforeEach
    void runBefore() {
        wire1 = new Wire(19, 10, null, powerSource, null, null);
        wire2 = new Wire(21, 10, powerSource, null, null, null);
        wire3 = new Wire(20, 11, null, null, null, powerSource);
        wire4 = new Wire(20, 9, null, null, powerSource, null);
        powerSource = new PowerSource(20, 10, wire1, wire2, wire3, wire4);
    }

    @Test
    void constructorTest() {
        assertEquals(20, powerSource.getPosX());
        assertEquals(10, powerSource.getPosY());
        assertEquals(wire1, powerSource.getLeftElement());
        assertEquals(wire2, powerSource.getRightElement());
        assertEquals(wire3, powerSource.getAboveElement());
        assertEquals(wire4, powerSource.getBelowElement());
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
