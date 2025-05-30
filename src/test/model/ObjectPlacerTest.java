package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObjectPlacerTest {
    private ObjectPlacer objectPlacer;
    private Scenario scenario;

    @BeforeEach
    void runBefore() {
        scenario = new Scenario("Scenario1");
        objectPlacer = new ObjectPlacer(scenario);
    }

    @Test
    void constructorTest() {
        assertEquals(0, objectPlacer.getPosX());
        assertEquals(0, objectPlacer.getPosY());
        assertEquals(scenario, objectPlacer.getScenario());
    }

    @Test
    void moveRightTests() {
        assertEquals(0, objectPlacer.getPosX());
        objectPlacer.moveRight();
        assertEquals(1, objectPlacer.getPosX());
        objectPlacer.moveRight();
        assertEquals(2, objectPlacer.getPosX());
        moveRight(scenario.getScreenWidth() - 4);
        assertEquals(scenario.getScreenWidth() - 2, objectPlacer.getPosX());
        objectPlacer.moveRight();
        assertEquals(scenario.getScreenWidth() - 1, objectPlacer.getPosX());
        objectPlacer.moveRight();
        assertEquals(scenario.getScreenWidth() - 1, objectPlacer.getPosX());
    }

    @Test
    void moveLeftTests() {
        moveRight(scenario.getScreenWidth() - 1);
        assertEquals(scenario.getScreenWidth() - 1, objectPlacer.getPosX());
        objectPlacer.moveLeft();
        assertEquals(scenario.getScreenWidth() - 2, objectPlacer.getPosX());
        objectPlacer.moveLeft();
        assertEquals(scenario.getScreenWidth() - 3, objectPlacer.getPosX());
        moveLeft(scenario.getScreenWidth() - 4);
        assertEquals(1, objectPlacer.getPosX());
        objectPlacer.moveLeft();
        assertEquals(0, objectPlacer.getPosX());
        objectPlacer.moveLeft();
        assertEquals(0, objectPlacer.getPosX());
    }

    @Test
    void moveUpTests() {
        moveDown(scenario.getScreenHeight());
        assertEquals(scenario.getScreenHeight() - 1, objectPlacer.getPosY());
        objectPlacer.moveUp();
        assertEquals(scenario.getScreenHeight() - 2, objectPlacer.getPosY());
        objectPlacer.moveUp();
        assertEquals(scenario.getScreenHeight() - 3, objectPlacer.getPosY());
        moveUp(scenario.getScreenHeight() - 4);
        assertEquals(1, objectPlacer.getPosY());
        objectPlacer.moveUp();
        assertEquals(0, objectPlacer.getPosY());
        objectPlacer.moveUp();
        assertEquals(0, objectPlacer.getPosY());
    }

    @Test
    void moveDownTests() {
        assertEquals(0, objectPlacer.getPosY());
        objectPlacer.moveDown();
        assertEquals(1, objectPlacer.getPosY());
        objectPlacer.moveDown();
        assertEquals(2, objectPlacer.getPosY());
        moveDown(scenario.getScreenHeight() - 4);
        assertEquals(scenario.getScreenHeight() - 2, objectPlacer.getPosY());
        objectPlacer.moveDown();
        assertEquals(scenario.getScreenHeight() - 1, objectPlacer.getPosY());
        objectPlacer.moveDown();
        assertEquals(scenario.getScreenHeight() - 1, objectPlacer.getPosY());
    }

    // MODIFIES: this
    // EFFECT: move object placer x position right by move
    private void moveRight(int move) {
        for (int i = 1; i <= move; i++) {
            objectPlacer.moveRight();
        }
    }

    // MODIFIES: this
    // EFFECT: move object placer x position left by move
    private void moveLeft(int move) {
        for (int i = 1; i <= move; i++) {
            objectPlacer.moveLeft();
        }
    }

    // MODIFIES: this
    // EFFECT: move object placer y position up by move
    private void moveUp(int move) {
        for (int i = 1; i <= move; i++) {
            objectPlacer.moveUp();
        }
    }

    // MODIFIES: this
    // EFFECT: move object placer y position down by move
    private void moveDown(int move) {
        for (int i = 1; i <= move; i++) {
            objectPlacer.moveDown();
        }
    }
}
