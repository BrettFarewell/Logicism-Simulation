package model;

// Represents a sound output device with x and y position in the scenario. If powered "on" will play sound
public class SoundOutput extends OutputElement {
    
    // EFFECT: creates an output of sound, with power status "off", and at position x an y, all inputs are "off",
    //         and set logic elements to the left, right, above and below.
    public SoundOutput(int x, int y, LogicElement left, LogicElement right, LogicElement above, LogicElement below) {
        this.posX = x;
        this.posY = y;
        this.elementLeft = left;
        this.elementRight = right;
        this.elementAbove = above;
        this.elementBelow = below;
        this.powerStatus = false;
        this.inputLeftStatus = false;
        this.inputRightStatus = false;
        this.inputAboveStatus = false;
        this.inputBelowStatus = false;
        this.category = Category.values()[5];
    }

    // MODIFIES: this
    // EFFECTS: checks to see if any inputs are "on" and turns power status "on"
    @Override
    public void checkPowerStatus() {
        if (inputLeftStatus == true
                || inputRightStatus == true
                || inputAboveStatus == true
                || inputBelowStatus == true) {
            this.powerStatus = true;
        } else {
            this.powerStatus = false;
        }
    }
}
