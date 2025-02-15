package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SoundOutputTest {
    private LogicElement soundOutput;
    private LogicElement wire1;
    private LogicElement wire2;
    private LogicElement wire3;
    private LogicElement wire4;

    @BeforeEach
    void runBefore() {
        wire1 = new Wire(19, 10, null, soundOutput, null, null);
        wire2 = new Wire(21, 10, soundOutput, null, null, null);
        wire3 = new Wire(20, 11, null, null, null, soundOutput);
        wire4 = new Wire(20, 9, null, null, soundOutput, null);
        soundOutput = new SoundOutput(20, 10, wire1, wire2, wire3, wire4);
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
        soundOutput.inputRight();
        assertTrue(soundOutput.getInputRight());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void inputRightTestPowerStatusOn() {
        soundOutput.setPowerStatus(true);
        assertFalse(soundOutput.getInputRight());
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.inputRight();
        assertFalse(soundOutput.getInputRight());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void inputAboveTestPowerStatusOff() {
        assertFalse(soundOutput.getInputAbove());
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.inputAbove();
        assertTrue(soundOutput.getInputAbove());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void inputAboveTestPowerStatusOn() {
        soundOutput.setPowerStatus(true);
        assertFalse(soundOutput.getInputAbove());
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.inputAbove();
        assertFalse(soundOutput.getInputAbove());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void inputBelowTestPowerStatusOff() {
        assertFalse(soundOutput.getInputBelow());
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.inputBelow();
        assertTrue(soundOutput.getInputBelow());
        assertTrue(soundOutput.getPowerStatus());
    }

    @Test
    void inputBelowTestPowerStatusOn() {
        soundOutput.setPowerStatus(true);
        assertFalse(soundOutput.getInputBelow());
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.inputBelow();
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
        soundOutput.checkPowerStatus();
        assertFalse(soundOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusRightInputOnTest() {
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.setInputRight(true);
        soundOutput.checkPowerStatus();
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.setInputRight(false);
        soundOutput.checkPowerStatus();
        assertFalse(soundOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusAboveInputOnTest() {
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.setInputAbove(true);
        soundOutput.checkPowerStatus();
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.setInputAbove(false);
        soundOutput.checkPowerStatus();
        assertFalse(soundOutput.getPowerStatus());
    }

    @Test
    void checkPowerStatusBelowInputOnTest() {
        assertFalse(soundOutput.getPowerStatus());
        soundOutput.setInputBelow(true);
        soundOutput.checkPowerStatus();
        assertTrue(soundOutput.getPowerStatus());
        soundOutput.setInputBelow(false);
        soundOutput.checkPowerStatus();
        assertFalse(soundOutput.getPowerStatus());
    }

    // EFFECT: tests the outputs of the OutputElement abstract class. Outputs should not be called but if they are,
    //         they do nothing
    @Test
    void outputsTest() {
        assertFalse(soundOutput.getRightElement().getInputLeft());
        assertFalse(soundOutput.getLeftElement().getInputRight());
        assertFalse(soundOutput.getAboveElement().getInputBelow());
        assertFalse(soundOutput.getBelowElement().getInputAbove());
        soundOutput.outputLeft();
        soundOutput.outputRight();
        soundOutput.outputAbove();
        soundOutput.outputBelow();
        assertFalse(soundOutput.getRightElement().getInputLeft());
        assertFalse(soundOutput.getLeftElement().getInputRight());
        assertFalse(soundOutput.getAboveElement().getInputBelow());
        assertFalse(soundOutput.getBelowElement().getInputAbove());
    }
}
