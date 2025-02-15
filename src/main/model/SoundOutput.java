package model;

// Represents a sound output device with x and y position in the scenario. If powered "on" will play sound
public class SoundOutput extends OutputElement {
    
    // EFFECT: creates an output of given type, with power status "off", and at position x an y
    //         (no need for elements around it as it cannot propgate power)
    public SoundOutput(int x, int y) {
        this.PosX = x;
        this.PosY = y;
        this.powerStatus = false;
        this.inputLeftStatus = false;
        this.inputRightStatus = false;
        this.inputAboveStatus = false;
        this.inputBelowStatus = false;
    }

    // MODIFIES: this
    // EFFECTS: checks to see if any inputs are "on" and turns power status "on"
    public void checkPowerStatus() {
        if (inputLeftStatus == true ||
        inputRightStatus == true ||
        inputAboveStatus == true ||
        inputBelowStatus == true) {
            this.powerStatus = true;
        } else {
            this.powerStatus = false;
        }
    }
}
