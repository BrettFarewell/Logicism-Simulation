package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LightOutputTest {
    private LogicElement lightOutput;

    @BeforeEach
    void runBefore() {
        lightOutput = new LightOutput(20, 10);
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
        lightOutput.inputLeft();
        assertTrue(lightOutput.getInputRight());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void inputRightTestPowerStatusOn() {
        lightOutput.setPowerStatus(true);
        assertFalse(lightOutput.getInputRight());
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.inputLeft();
        assertFalse(lightOutput.getInputRight());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void inputAboveTestPowerStatusOff() {
        assertFalse(lightOutput.getInputAbove());
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.inputLeft();
        assertTrue(lightOutput.getInputAbove());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void inputAboveTestPowerStatusOn() {
        lightOutput.setPowerStatus(true);
        assertFalse(lightOutput.getInputAbove());
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.inputLeft();
        assertFalse(lightOutput.getInputAbove());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void inputBelowTestPowerStatusOff() {
        assertFalse(lightOutput.getInputBelow());
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.inputLeft();
        assertTrue(lightOutput.getInputBelow());
        assertTrue(lightOutput.getPowerStatus());
    }

    @Test
    void inputBelowTestPowerStatusOn() {
        lightOutput.setPowerStatus(true);
        assertFalse(lightOutput.getInputBelow());
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.inputLeft();
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
        assertFalse(lightOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusRightInputOnTest() {
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.setInputRight(true);
        lightOutput.checkPowerStatus();
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.setInputRight(false);
        assertFalse(lightOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusAboveInputOnTest() {
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.setInputAbove(true);
        lightOutput.checkPowerStatus();
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.setInputAbove(false);
        assertFalse(lightOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusBelowInputOnTest() {
        assertFalse(lightOutput.getPowerStatus());
        lightOutput.setInputBelow(true);
        lightOutput.checkPowerStatus();
        assertTrue(lightOutput.getPowerStatus());
        lightOutput.setInputBelow(false);
        assertFalse(lightOutput.getPowerStatus());
    }
}
