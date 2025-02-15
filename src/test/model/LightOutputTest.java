package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LightOutputTest {
    private LogicElement lightOutput;
    private LogicElement wire1;
    private LogicElement wire2;
    private LogicElement wire3;
    private LogicElement wire4;

    @BeforeEach
    void runBefore() {
        wire1 = new Wire(19, 10, null, lightOutput, null, null);
        wire2 = new Wire(21, 10, lightOutput, null, null, null);
        wire3 = new Wire(20, 11, null, null, null, lightOutput);
        wire4 = new Wire(20, 9, null, null, lightOutput, null);
        lightOutput = new LightOutput(20, 10, wire1, wire2, wire3, wire4);
    }

    @Test
    void constructorTest() {
        assertEquals(20, lightOutput.getPosX());
        assertEquals(10, lightOutput.getPosY());
        assertFalse(lightOutput.getPowerStatus());
    }

    @Test
    void inputLeftTestPowerStatusOff() {
        assertFalse(lightOutput.getInputLeft());
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.inputLeft();
        assertTrue(lightOutput.getInputLeft());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void inputLeftTestPowerStatusOn() {
        lightOutput.setPowerStatus(true);
        assertFalse(lightOutput.getInputLeft());
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.inputLeft();
        assertFalse(lightOutput.getInputLeft());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void inputRightTestPowerStatusOff() {
        assertFalse(lightOutput.getInputRight());
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.inputRight();
        assertTrue(lightOutput.getInputRight());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void inputRightTestPowerStatusOn() {
        lightOutput.setPowerStatus(true);
        assertFalse(lightOutput.getInputRight());
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.inputRight();
        assertFalse(lightOutput.getInputRight());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void inputAboveTestPowerStatusOff() {
        assertFalse(lightOutput.getInputAbove());
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.inputAbove();
        assertTrue(lightOutput.getInputAbove());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void inputAboveTestPowerStatusOn() {
        lightOutput.setPowerStatus(true);
        assertFalse(lightOutput.getInputAbove());
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.inputAbove();
        assertFalse(lightOutput.getInputAbove());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void inputBelowTestPowerStatusOff() {
        assertFalse(lightOutput.getInputBelow());
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.inputBelow();
        assertTrue(lightOutput.getInputBelow());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void inputBelowTestPowerStatusOn() {
        lightOutput.setPowerStatus(true);
        assertFalse(lightOutput.getInputBelow());
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.inputBelow();
        assertFalse(lightOutput.getInputBelow());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusLeftInputOnTest() {
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.setInputLeft(true);
        lightOutput.checkPowerStatus();
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.setInputLeft(false);
        lightOutput.checkPowerStatus();
        assertFalse(lightOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusRightInputOnTest() {
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.setInputRight(true);
        lightOutput.checkPowerStatus();
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.setInputRight(false);
        lightOutput.checkPowerStatus();
        assertFalse(lightOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusAboveInputOnTest() {
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.setInputAbove(true);
        lightOutput.checkPowerStatus();
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.setInputAbove(false);
        lightOutput.checkPowerStatus();
        assertFalse(lightOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusBelowInputOnTest() {
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.setInputBelow(true);
        lightOutput.checkPowerStatus();
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.setInputBelow(false);
        lightOutput.checkPowerStatus();
        assertFalse(lightOutput.getPowerStatus());
    }

    // EFFECT: tests the outputs of the OutputElement abstract class. Outputs should not be called but if they are,
    //         they do nothing
    @Test
    void outputsTest() {
        assertFalse(lightOutput.getRightElement().getInputLeft());
        assertFalse(lightOutput.getLeftElement().getInputRight());
        assertFalse(lightOutput.getAboveElement().getInputBelow());
        assertFalse(lightOutput.getBelowElement().getInputAbove());
        lightOutput.outputLeft();
        lightOutput.outputRight();
        lightOutput.outputAbove();
        lightOutput.outputBelow();
        assertFalse(lightOutput.getRightElement().getInputLeft());
        assertFalse(lightOutput.getLeftElement().getInputRight());
        assertFalse(lightOutput.getAboveElement().getInputBelow());
        assertFalse(lightOutput.getBelowElement().getInputAbove());
    }
}
