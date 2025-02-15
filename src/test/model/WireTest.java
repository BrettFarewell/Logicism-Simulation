package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WireTest {
    private LogicElement wire;
    private LogicElement andGate;
    private LogicElement orGate;
    private LogicElement powerSource;
    private LogicElement soundOutput;

    @BeforeEach
    void runBefore() {
        andGate = new AndGate(19, 10, null, wire, null, null);
        orGate = new OrGate(21, 10, wire, null, null, null);
        powerSource = new PowerSource(20, 11, null, null, null, wire);
        soundOutput = new SoundOutput(20, 9);
        wire = new Wire(20, 10, andGate, orGate, powerSource, null);
    }

    @Test
    void constructorTest() {
        assertEquals(20, wire.getPosX());
        assertEquals(10, wire.getPosY());
        assertEquals(andGate, wire.getLeftElement());
        assertEquals(orGate, wire.getRightElement());
        assertEquals(powerSource, wire.getAboveElement());
        assertEquals(null, wire.getBelowElement());
        assertFalse(wire.getPowerStatus());
    }

    @Test
    void settersAndGettersTest() {
        wire.setLeftElement(null);
        wire.setRightElement(null);
        wire.setAboveElement(null);
        wire.setBelowElement(null);
        assertNull(wire.getLeftElement());
        assertNull(wire.getRightElement());
        assertNull(wire.getAboveElement());
        assertNull(wire.getBelowElement());
        wire.setLeftElement(andGate);
        wire.setRightElement(orGate);
        wire.setAboveElement(powerSource);
        wire.setBelowElement(soundOutput);
        assertEquals(andGate, wire.getLeftElement());
        assertEquals(orGate, wire.getRightElement());
        assertEquals(powerSource, wire.getAboveElement());
        assertEquals(soundOutput, wire.getBelowElement());
    }

    @Test
    void inputLeftTestPowerStatusOff() {
        assertFalse(wire.getInputLeft());
        assertFalse(wire.getPowerStatus());
        wire.inputLeft();
        assertTrue(wire.getInputLeft());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void inputLeftTestPowerStatusOn() {
        wire.setPowerStatus(true);
        assertFalse(wire.getInputLeft());
        assertTrue(wire.getPowerStatus());
        wire.inputLeft();
        assertFalse(wire.getInputLeft());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void inputRightTestPowerStatusOff() {
        assertFalse(wire.getInputRight());
        assertFalse(wire.getPowerStatus());
        wire.inputLeft();
        assertTrue(wire.getInputRight());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void inputRightTestPowerStatusOn() {
        wire.setPowerStatus(true);
        assertFalse(wire.getInputRight());
        assertTrue(wire.getPowerStatus());
        wire.inputLeft();
        assertFalse(wire.getInputRight());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void inputAboveTestPowerStatusOff() {
        assertFalse(wire.getInputAbove());
        assertFalse(wire.getPowerStatus());
        wire.inputLeft();
        assertTrue(wire.getInputAbove());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void inputAboveTestPowerStatusOn() {
        wire.setPowerStatus(true);
        assertFalse(wire.getInputAbove());
        assertTrue(wire.getPowerStatus());
        wire.inputLeft();
        assertFalse(wire.getInputAbove());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void inputBelowTestPowerStatusOff() {
        assertFalse(wire.getInputBelow());
        assertFalse(wire.getPowerStatus());
        wire.inputLeft();
        assertTrue(wire.getInputBelow());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void inputBelowTestPowerStatusOn() {
        wire.setPowerStatus(true);
        assertFalse(wire.getInputBelow());
        assertTrue(wire.getPowerStatus());
        wire.inputLeft();
        assertFalse(wire.getInputBelow());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void checkPowerStatusLeftInputOnTest() {
        assertFalse(wire.getPowerStatus());
        wire.setInputLeft(true);
        wire.checkPowerStatus();
        assertTrue(wire.getPowerStatus());
        wire.setInputLeft(false);
        assertFalse(wire.getPowerStatus());
    }

    @Test
    void checkPowerStatusRightInputOnTest() {
        assertFalse(wire.getPowerStatus());
        wire.setInputRight(true);
        wire.checkPowerStatus();
        assertTrue(wire.getPowerStatus());
        wire.setInputRight(false);
        assertFalse(wire.getPowerStatus());
    }

    @Test
    void checkPowerStatusAboveInputOnTest() {
        assertFalse(wire.getPowerStatus());
        wire.setInputAbove(true);
        wire.checkPowerStatus();
        assertTrue(wire.getPowerStatus());
        wire.setInputAbove(false);
        assertFalse(wire.getPowerStatus());
    }

    @Test
    void checkPowerStatusBelowInputOnTest() {
        assertFalse(wire.getPowerStatus());
        wire.setInputBelow(true);
        wire.checkPowerStatus();
        assertTrue(wire.getPowerStatus());
        wire.setInputBelow(false);
        assertFalse(wire.getPowerStatus());
    }

    @Test
    void outputLeftNullTest() {
        wire.setLeftElement(null);
        wire.setBelowElement(soundOutput);
        assertFalse(wire.getRightElement().getInputLeft());
        assertFalse(wire.getAboveElement().getInputBelow());
        assertFalse(wire.getBelowElement().getInputAbove());
        wire.outputLeft();
        wire.outputRight();
        wire.outputAbove();
        wire.outputBelow();
        assertTrue(wire.getRightElement().getInputLeft());
        assertTrue(wire.getAboveElement().getInputBelow());
        assertTrue(wire.getBelowElement().getInputAbove());
    }

    @Test
    void outputRightNullTest() {
        wire.setRightElement(null);
        wire.setBelowElement(soundOutput);
        assertFalse(wire.getLeftElement().getInputRight());
        assertFalse(wire.getAboveElement().getInputBelow());
        assertFalse(wire.getBelowElement().getInputAbove());
        wire.outputLeft();
        wire.outputRight();
        wire.outputAbove();
        wire.outputBelow();
        assertTrue(wire.getLeftElement().getInputRight());
        assertTrue(wire.getAboveElement().getInputBelow());
        assertTrue(wire.getBelowElement().getInputAbove());
    }

    @Test
    void outputAboveNullTest() {
        wire.setAboveElement(null);
        wire.setBelowElement(soundOutput);
        assertFalse(wire.getLeftElement().getInputRight());
        assertFalse(wire.getRightElement().getInputLeft());
        assertFalse(wire.getBelowElement().getInputAbove());
        wire.outputLeft();
        wire.outputRight();
        wire.outputAbove();
        wire.outputBelow();
        assertTrue(wire.getLeftElement().getInputRight());
        assertTrue(wire.getRightElement().getInputLeft());
        assertTrue(wire.getBelowElement().getInputAbove());
    }

    @Test
    void outputBelowNullTest() {
        assertFalse(wire.getLeftElement().getInputRight());
        assertFalse(wire.getRightElement().getInputLeft());
        assertFalse(wire.getAboveElement().getInputBelow());
        wire.outputLeft();
        wire.outputRight();
        wire.outputAbove();
        wire.outputBelow();
        assertTrue(wire.getLeftElement().getInputRight());
        assertTrue(wire.getRightElement().getInputLeft());
        assertTrue(wire.getAboveElement().getInputBelow());
    }
}
