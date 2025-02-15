package model;

// Represents the selected tile's x and y position when placing a new object. When ScenarioDisplayer calls to add new
// object (logic gate, power source, wire, or output element), an object placer element will represent what tile is
// currently selected to place an object
public class ObjectPlacer {
    private int PosX;
    private int PosY;
    private Scenario scenario;
    
    // EFFECT: creates a object placer that specifies what x and y position to place a specified object. Object placer
    //         will begin at x = 0 and y = 0 position and be given a scenario for its width and height
    public ObjectPlacer(Scenario scenario) {
        this.PosX = 0;
        this.PosY = 0;
        this.scenario = scenario;
    }

    // MODIFIES: this
    // EFFECT: move object selector right 1 charcter if x position < scenario width (+1 to x position).
    //         If x position = scenario.getScreenWidth(), do nothing
    public void moveRight() {
        if (PosX < scenario.getScreenWidth()) {
            this.PosX++;
        } else {
            this.PosX = scenario.getScreenWidth();
        }
    }

    // MODIFIES: this
    // EFFECT: move object selector left 1 charcter if x position > 0 (-1 to x position).
    //         If x position = 0, do nothing
    public void moveLeft() {
        if (PosX > 0) {
            this.PosX--;
        } else {
            this.PosX = 0;
        }
    }

    // MODIFIES: this
    // EFFECT: move object selector up 1 charcter if y position > 0 (- 1 to y position).
    //         If y position = 0, do nothing
    public void moveUp() {
        if (PosY > 0) {
            this.PosY--;
        } else {
            this.PosY = 0;
        }
    }

    // MODIFIES: this
    // EFFECT: move object selector down 1 charcter if y position < scenario height (+ 1 to y position).
    //         If y position = scenario.getScreenHeight(), do nothing
    public void moveDown() {
        if (PosY < scenario.getScreenHeight()) {
            this.PosY++;
        } else {
            this.PosY = scenario.getScreenHeight();
        }
    }

    // EFFECT: gets x position
    public int getPosX() {
        return this.PosX; //STUB
    }

    // EFFECT: gets y position
    public int getPosY() {
        return this.PosY; //STUB
    }

    // EFFECT: gets scenario
    public Scenario getScenario() {
        return this.scenario; //STUB
    }
}
