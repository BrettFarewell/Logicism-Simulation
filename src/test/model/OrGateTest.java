package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrGateTest {
    private LogicElement orGate;
    private LogicElement wire1;
    private LogicElement wire2;
    private LogicElement wire3;
    private LogicElement wire4;

    @BeforeEach
    void runBefore() {
        wire1 = new Wire(19, 10, null, orGate, null, null);
        wire2 = new Wire(21, 10, orGate, null, null, null);
        wire3 = new Wire(20, 11, null, null, null, orGate);
        wire4 = new Wire(20, 9, null, null, orGate, null);
        orGate = new OrGate(20, 10, wire1, wire2, wire3, wire4);
    }

    @Test
    void constructorTest() {
        assertEquals(20, orGate.getPosX());
        assertEquals(10, orGate.getPosY());
        assertEquals(wire1, orGate.getLeftElement());
        assertEquals(wire2, orGate.getRightElement());
        assertEquals(wire3, orGate.getAboveElement());
        assertEquals(wire4, orGate.getBelowElement());
        assertFalse(orGate.getPowerStatus());
    }

    @Test
    void inputPowerStatusOffTests() {
        orGate.setPowerStatus(false);
        assertFalse(orGate.getInputLeft());
        orGate.inputLeft();
        assertTrue(orGate.getInputLeft());
        orGate.setPowerStatus(false);
        assertFalse(orGate.getInputRight());
        orGate.inputRight();
        assertFalse(orGate.getInputRight());
        orGate.setPowerStatus(false);
        assertFalse(orGate.getInputAbove());
        orGate.inputAbove();
        assertFalse(orGate.getInputAbove());
        orGate.setPowerStatus(false);
        assertFalse(orGate.getInputBelow());
        orGate.inputBelow();
        assertTrue(orGate.getInputBelow());
    }

    @Test
    void outputTestsRightElementNotNull() {
        assertFalse(orGate.getLeftElement().getInputRight());
        assertFalse(orGate.getRightElement().getInputLeft());
        assertFalse(orGate.getAboveElement().getInputBelow());
        assertFalse(orGate.getBelowElement().getInputAbove());
        orGate.outputLeft();
        orGate.outputRight();
        orGate.outputAbove();
        orGate.outputBelow();
        assertFalse(orGate.getLeftElement().getInputRight());
        assertTrue(orGate.getRightElement().getInputLeft());
        assertFalse(orGate.getAboveElement().getInputBelow());
        assertFalse(orGate.getBelowElement().getInputAbove());
    }

    @Test
    void outputTestsRightElementNull() {
        orGate.setRightElement(null);
        assertFalse(orGate.getLeftElement().getInputRight());
        assertFalse(orGate.getAboveElement().getInputBelow());
        assertFalse(orGate.getBelowElement().getInputAbove());
        orGate.outputLeft();
        orGate.outputRight();
        orGate.outputAbove();
        orGate.outputBelow();
        assertFalse(orGate.getLeftElement().getInputRight());
        assertFalse(orGate.getAboveElement().getInputBelow());
        assertFalse(orGate.getBelowElement().getInputAbove());
    }

    @Test
    void checkPowerStatusTest() {
        orGate.checkPowerStatus();
        assertFalse(orGate.getPowerStatus());
        orGate.setInputLeft(true);
        orGate.checkPowerStatus();
        assertTrue(orGate.getPowerStatus());
        orGate.setInputLeft(false);
        orGate.setInputBelow(true);
        orGate.checkPowerStatus();
        assertTrue(orGate.getPowerStatus());
        orGate.setInputLeft(true);
        orGate.checkPowerStatus();
        assertTrue(orGate.getPowerStatus());
    }   
}
