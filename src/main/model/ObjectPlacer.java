package model;

// Represents the selected tile's x and y position when placing a new object. When ScenarioDisplayer calls to add new
// object (logic gate, power source, wire, or output element), an object placer element will represent what tile is
// currently selected to place an object
public class ObjectPlacer {
    private int posX;
    private int posY;
    private Scenario scenario;
    
    // EFFECT: creates a object placer that specifies what x and y position to place a specified object. Object placer
    //         will begin at x = 0 and y = 0 position and be given a scenario for its width and height
    public ObjectPlacer(Scenario scenario) {
        this.posX = 0;
        this.posY = 0;
        this.scenario = scenario;
    }

    // MODIFIES: this
    // EFFECT: move object selector right 1 charcter if x position < scenario width (+1 to x position).
    //         If x position = scenario.getScreenWidth(), do nothing
    public void moveRight() {
        if (posX < scenario.getScreenWidth()) {
            this.posX++;
        } else {
            this.posX = scenario.getScreenWidth();
        }
    }

    // MODIFIES: this
    // EFFECT: move object selector left 1 charcter if x position > 0 (-1 to x position).
    //         If x position = 0, do nothing
    public void moveLeft() {
        if (posX > 0) {
            this.posX--;
        } else {
            this.posX = 0;
        }
    }

    // MODIFIES: this
    // EFFECT: move object selector up 1 charcter if y position > 0 (- 1 to y position).
    //         If y position = 0, do nothing
    public void moveUp() {
        if (posY > 0) {
            this.posY--;
        } else {
            this.posY = 0;
        }
    }

    // MODIFIES: this
    // EFFECT: move object selector down 1 charcter if y position < scenario height (+ 1 to y position).
    //         If y position = scenario.getScreenHeight(), do nothing
    public void moveDown() {
        if (posY < scenario.getScreenHeight()) {
            this.posY++;
        } else {
            this.posY = scenario.getScreenHeight();
        }
    }

    // EFFECT: gets x position
    public int getPosX() {
        return this.posX; //STUB
    }

    // EFFECT: gets y position
    public int getPosY() {
        return this.posY; //STUB
    }

    // EFFECT: gets scenario
    public Scenario getScenario() {
        return this.scenario; //STUB
    }
}
