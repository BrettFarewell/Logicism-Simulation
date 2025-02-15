package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrGateTest {
    private LogicElement andGate;
    private LogicElement wire;
    private LogicElement orGate;
    private LogicElement powerSource;
    private LogicElement soundOutput;

    @BeforeEach
    void runBefore() {
        wire = new Wire(19, 10, null, wire, null, null);
        andGate = new AndGate(21, 10, wire, null, null, null);
        powerSource = new PowerSource(20, 11, null, null, null, wire);
        soundOutput = new SoundOutput(20, 9);
        orGate = new OrGate(20, 10, wire, andGate, powerSource, soundOutput);
    }

    @Test
    void constructorTest() {
        assertEquals(20, orGate.getPosX());
        assertEquals(10, orGate.getPosY());
        assertEquals(wire, orGate.getLeftElement());
        assertEquals(andGate, orGate.getRightElement());
        assertEquals(powerSource, orGate.getAboveElement());
        assertEquals(soundOutput, orGate.getBelowElement());
        assertFalse(orGate.getPowerStatus());
    }

    @Test
    void inputPowerStatusOffTests() {
        assertFalse(orGate.getInputLeft());
        assertFalse(orGate.getInputRight());
        assertFalse(orGate.getInputAbove());
        assertFalse(orGate.getInputBelow());
        orGate.inputLeft();
        orGate.inputRight();
        orGate.inputAbove();
        orGate.inputBelow();
        assertTrue(orGate.getInputLeft());
        assertFalse(orGate.getInputRight());
        assertFalse(orGate.getInputAbove());
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
        assertFalse(orGate.getPowerStatus());
        orGate.setInputLeft(true);
        assertTrue(orGate.getPowerStatus());
        orGate.setInputLeft(false);
        orGate.setInputBelow(true);
        assertTrue(orGate.getPowerStatus());
        orGate.setInputLeft(true);
        assertTrue(orGate.getPowerStatus());
    }   
}
