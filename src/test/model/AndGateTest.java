package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AndGateTest {
    private LogicElement andGate;
    private LogicElement wire1;
    private LogicElement wire2;
    private LogicElement wire3;
    private LogicElement wire4;

    @BeforeEach
    void runBefore() {
        wire1 = new Wire(19, 10, null, andGate, null, null);
        wire2 = new Wire(21, 10, andGate, null, null, null);
        wire3 = new Wire(20, 11, null, null, null, andGate);
        wire4 = new Wire(20, 9, null, null, andGate, null);
        andGate = new AndGate(20, 10, wire1, wire2, wire3, wire4);
    }

    @Test
    void constructorTest() {
        assertEquals(20, andGate.getPosX());
        assertEquals(10, andGate.getPosY());
        assertEquals(wire1, andGate.getLeftElement());
        assertEquals(wire2, andGate.getRightElement());
        assertEquals(wire3, andGate.getAboveElement());
        assertEquals(wire4, andGate.getBelowElement());
        assertFalse(andGate.getPowerStatus());
    }

    @Test
    void inputPowerStatusOffTests() {
        andGate.setPowerStatus(false);
        assertFalse(andGate.getInputLeft());
        andGate.inputLeft();
        assertTrue(andGate.getInputLeft());
        andGate.setPowerStatus(false);
        assertFalse(andGate.getInputRight());
        andGate.inputRight();
        assertFalse(andGate.getInputRight());
        andGate.setPowerStatus(false);
        assertFalse(andGate.getInputAbove());
        andGate.inputAbove();
        assertFalse(andGate.getInputAbove());
        andGate.setPowerStatus(false);
        assertFalse(andGate.getInputBelow());
        andGate.inputBelow();
        assertTrue(andGate.getInputBelow());
    }

    @Test
    void outputTestsRightElementNotNull() {
        assertFalse(andGate.getLeftElement().getInputRight());
        assertFalse(andGate.getRightElement().getInputLeft());
        assertFalse(andGate.getAboveElement().getInputBelow());
        assertFalse(andGate.getBelowElement().getInputAbove());
        andGate.outputLeft();
        andGate.outputRight();
        andGate.outputAbove();
        andGate.outputBelow();
        assertFalse(andGate.getLeftElement().getInputRight());
        assertTrue(andGate.getRightElement().getInputLeft());
        assertFalse(andGate.getAboveElement().getInputBelow());
        assertFalse(andGate.getBelowElement().getInputAbove());
    }

    @Test
    void outputTestsRightElementNull() {
        andGate.setRightElement(null);
        assertFalse(andGate.getLeftElement().getInputRight());
        assertFalse(andGate.getAboveElement().getInputBelow());
        assertFalse(andGate.getBelowElement().getInputAbove());
        andGate.outputLeft();
        andGate.outputRight();
        andGate.outputAbove();
        andGate.outputBelow();
        assertFalse(andGate.getLeftElement().getInputRight());
        assertFalse(andGate.getAboveElement().getInputBelow());
        assertFalse(andGate.getBelowElement().getInputAbove());
    }

    @Test
    void checkPowerStatusTest() {
        assertFalse(andGate.getPowerStatus());
        andGate.setInputLeft(true);
        andGate.checkPowerStatus();
        assertFalse(andGate.getPowerStatus());
        andGate.setInputLeft(false);
        andGate.setInputBelow(true);
        andGate.checkPowerStatus();
        assertFalse(andGate.getPowerStatus());
        andGate.setInputLeft(true);
        andGate.checkPowerStatus();
        assertTrue(andGate.getPowerStatus());
    }
}
