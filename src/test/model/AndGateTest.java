package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AndGateTest {
    private LogicElement andGate;
    private LogicElement wire;
    private LogicElement orGate;
    private LogicElement powerSource;
    private LogicElement soundOutput;

    @BeforeEach
    void runBefore() {
        wire = new Wire(19, 10, null, andGate, null, null);
        orGate = new OrGate(21, 10, andGate, null, null, null);
        powerSource = new PowerSource(20, 11, null, null, null, andGate);
        soundOutput = new SoundOutput(20, 9);
        andGate = new AndGate(20, 10, andGate, orGate, powerSource, soundOutput);
    }

    @Test
    void constructorTest() {
        assertEquals(20, andGate.getPosX());
        assertEquals(10, andGate.getPosY());
        assertEquals(wire, andGate.getLeftElement());
        assertEquals(orGate, andGate.getRightElement());
        assertEquals(powerSource, andGate.getAboveElement());
        assertEquals(soundOutput, andGate.getBelowElement());
        assertFalse(andGate.getPowerStatus());
    }

    @Test
    void inputPowerStatusOffTests() {
        assertFalse(andGate.getInputLeft());
        assertFalse(andGate.getInputRight());
        assertFalse(andGate.getInputAbove());
        assertFalse(andGate.getInputBelow());
        andGate.inputLeft();
        andGate.inputRight();
        andGate.inputAbove();
        andGate.inputBelow();
        assertTrue(andGate.getInputLeft());
        assertFalse(andGate.getInputRight());
        assertFalse(andGate.getInputAbove());
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
        assertFalse(andGate.getPowerStatus());
        andGate.setInputLeft(false);
        andGate.setInputBelow(true);
        assertFalse(andGate.getPowerStatus());
        andGate.setInputLeft(true);
        assertTrue(andGate.getPowerStatus());
    }
}
