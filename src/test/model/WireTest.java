package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WireTest {
    private LogicElement wire;
    private LogicElement wire1;
    private LogicElement wire2;
    private LogicElement wire3;
    private LogicElement wire4;

    @BeforeEach
    void runBefore() {
        wire1 = new Wire(19, 10, null, wire, null, null);
        wire2 = new Wire(21, 10, wire, null, null, null);
        wire3 = new Wire(20, 11, null, null, null, wire);
        wire4 = new Wire(20, 9, null, null, wire, null);
        wire = new Wire(20, 10, wire1, wire2, wire3, null);
    }

    @Test
    void constructorTest() {
        assertEquals(20, wire.getPosX());
        assertEquals(10, wire.getPosY());
        assertEquals(wire1, wire.getLeftElement());
        assertEquals(wire2, wire.getRightElement());
        assertEquals(wire3, wire.getAboveElement());
        assertEquals(null, wire.getBelowElement());
        assertFalse(wire.getInputLeft());
        assertFalse(wire.getInputRight());
        assertFalse(wire.getInputAbove());
        assertFalse(wire.getInputBelow());
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
        wire.setLeftElement(wire1);
        wire.setRightElement(wire2);
        wire.setAboveElement(wire3);
        wire.setBelowElement(wire4);
        assertEquals(wire1, wire.getLeftElement());
        assertEquals(wire2, wire.getRightElement());
        assertEquals(wire3, wire.getAboveElement());
        assertEquals(wire4, wire.getBelowElement());
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
        wire.inputRight();
        assertTrue(wire.getInputRight());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void inputRightTestPowerStatusOn() {
        wire.setPowerStatus(true);
        assertFalse(wire.getInputRight());
        assertTrue(wire.getPowerStatus());
        wire.inputRight();
        assertFalse(wire.getInputRight());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void inputAboveTestPowerStatusOff() {
        assertFalse(wire.getInputAbove());
        assertFalse(wire.getPowerStatus());
        wire.inputAbove();
        assertTrue(wire.getInputAbove());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void inputAboveTestPowerStatusOn() {
        wire.setPowerStatus(true);
        assertFalse(wire.getInputAbove());
        assertTrue(wire.getPowerStatus());
        wire.inputAbove();
        assertFalse(wire.getInputAbove());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void inputBelowTestPowerStatusOff() {
        assertFalse(wire.getInputBelow());
        assertFalse(wire.getPowerStatus());
        wire.inputBelow();
        assertTrue(wire.getInputBelow());
        assertTrue(wire.getPowerStatus());
    }

    @Test
    void inputBelowTestPowerStatusOn() {
        wire.setPowerStatus(true);
        assertFalse(wire.getInputBelow());
        assertTrue(wire.getPowerStatus());
        wire.inputBelow();
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
        wire.checkPowerStatus();
        assertFalse(wire.getPowerStatus());
    }

    @Test
    void checkPowerStatusRightInputOnTest() {
        assertFalse(wire.getPowerStatus());
        wire.setInputRight(true);
        wire.checkPowerStatus();
        assertTrue(wire.getPowerStatus());
        wire.setInputRight(false);
        wire.checkPowerStatus();
        assertFalse(wire.getPowerStatus());
    }

    @Test
    void checkPowerStatusAboveInputOnTest() {
        assertFalse(wire.getPowerStatus());
        wire.setInputAbove(true);
        wire.checkPowerStatus();
        assertTrue(wire.getPowerStatus());
        wire.setInputAbove(false);
        wire.checkPowerStatus();
        assertFalse(wire.getPowerStatus());
    }

    @Test
    void checkPowerStatusBelowInputOnTest() {
        assertFalse(wire.getPowerStatus());
        wire.setInputBelow(true);
        wire.checkPowerStatus();
        assertTrue(wire.getPowerStatus());
        wire.setInputBelow(false);
        wire.checkPowerStatus();
        assertFalse(wire.getPowerStatus());
    }

    @Test
    void outputLeftNullTest() {
        wire.setLeftElement(null);
        wire.setBelowElement(wire4);
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
        wire.setBelowElement(wire4);
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
        wire.setBelowElement(wire4);
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
