package model;

// Represents the selected tile's x and y position when placing a new object. When ScenarioDisplayer calls to add new
// object (logic gate, power source, wire, or output element), an object placer element will represent what tile is
// currently selected to place an object
public class ObjectPlacer {
    
    // EFFECT: creates a object placer that specifies what x and y position to place a specified object. Object placer
    //         will begin at x = 0 and y = 0 position
    public ObjectPlacer() {
        // STUB
    }

    // EFFECT: move object selector right 1 charcter if x position < 50 (+1 to x position).
    //         If x position = 50, do nothing
    public void moveRight() {
        // STUB
    }

    // EFFECT: move object selector left 1 charcter if x position > 0 (-1 to x position).
    //         If x position = 0, do nothing
    public void moveLeft() {
        // STUB
    }

    // EFFECT: move object selector up 1 charcter if x position < 20 (+1 to y position).
    //         If x position = 20, do nothing
    public void moveUp() {
        // STUB
    }

    // EFFECT: move object selector down 1 charcter if x position > 0 (-1 to y position).
    //         If x position = 0, do nothing
    public void moveDown() {
        // STUB
    }
}
