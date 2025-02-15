package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SoundOutputTest {
    private LogicElement soundOutput;

    @BeforeEach
    void runBefore() {
        soundOutput = new SoundOutput(20, 10);
    }

    @Test
    void constructorTest() {
        assertEquals(20, soundOutput.getPosX());
        assertEquals(10, soundOutput.getPosY());
        assertFalse(soundOutput.getPowerStatus());
    }

    @Test
    void inputLeftTestPowerStatusOff() {
        assertFalse(soundOutput.getInputLeft());
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.inputLeft();
        assertTrue(soundOutput.getInputLeft());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void inputLeftTestPowerStatusOn() {
        soundOutput.setPowerStatus(true);
        assertFalse(soundOutput.getInputLeft());
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.inputLeft();
        assertFalse(soundOutput.getInputLeft());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void inputRightTestPowerStatusOff() {
        assertFalse(soundOutput.getInputRight());
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.inputLeft();
        assertTrue(soundOutput.getInputRight());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void inputRightTestPowerStatusOn() {
        soundOutput.setPowerStatus(true);
        assertFalse(soundOutput.getInputRight());
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.inputLeft();
        assertFalse(soundOutput.getInputRight());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void inputAboveTestPowerStatusOff() {
        assertFalse(soundOutput.getInputAbove());
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.inputLeft();
        assertTrue(soundOutput.getInputAbove());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void inputAboveTestPowerStatusOn() {
        soundOutput.setPowerStatus(true);
        assertFalse(soundOutput.getInputAbove());
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.inputLeft();
        assertFalse(soundOutput.getInputAbove());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void inputBelowTestPowerStatusOff() {
        assertFalse(soundOutput.getInputBelow());
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.inputLeft();
        assertTrue(soundOutput.getInputBelow());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void inputBelowTestPowerStatusOn() {
        soundOutput.setPowerStatus(true);
        assertFalse(soundOutput.getInputBelow());
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.inputLeft();
        assertFalse(soundOutput.getInputBelow());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusLeftInputOnTest() {
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.setInputLeft(true);
        soundOutput.checkPowerStatus();
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.setInputLeft(false);
        assertFalse(soundOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusRightInputOnTest() {
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.setInputRight(true);
        soundOutput.checkPowerStatus();
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.setInputRight(false);
        assertFalse(soundOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusAboveInputOnTest() {
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.setInputAbove(true);
        soundOutput.checkPowerStatus();
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.setInputAbove(false);
        assertFalse(soundOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusBelowInputOnTest() {
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.setInputBelow(true);
        soundOutput.checkPowerStatus();
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.setInputBelow(false);
        assertFalse(soundOutput.getPowerStatus());
    }   
}
