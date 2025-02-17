package ui;

import model.*;

import java.util.Scanner;


// Represents the terminal or ui of the selected scenario, where users will create and place logic objects.
// Logic objects will be rendered accordingly
public class ScenarioDisplayer {
    private boolean displayerState;
    private boolean newLogicElementMenuState;
    private boolean chooseElementMenuState;
    private Scenario scenario;
    private Scanner scanner;
    private String divider = "--------------------------------------------------";
    
    // EFFECT: displays scenario given in terminal. Initializes scenario displayer with selected scenario
    public ScenarioDisplayer(Scenario scenario) {
        this.displayerState = true;
        this.scenario = scenario;
        this.scanner = new Scanner(System.in);
        scenarioMenu();
    }

    // EFFECT: sets up the scenario menu, displays user options, and takes and handles user's input
    //          through handleInputMenu()
    public void scenarioMenu() {
        while (displayerState) {
            System.out.println(divider);
            scenarioPreviewer();
            scenarioMenuDisplay();
            String key = this.scanner.nextLine();
            handleInputMenu(key);
        }
    }

    // EFFECTS: displays user options in the scenraio menu in the terminal
    public void scenarioMenuDisplay() {
        System.out.println(divider);
        System.out.println("Please select from the following options:");
        System.out.println("r - run scenario");
        System.out.println("n - create new logic element and add it to scenario");
        System.out.println("s - gives list of logic gates, power sources, and outputs in scenario");
        System.out.println("q - quit scenario");
    }

    // EFFECT: display list of all logic gates, power sources, and outputs in scenario and their
    //         given x, y coordinates
    public void displayLogicElementList() {
        System.out.println(divider);
        System.out.println("All Logic Gates:");
        for (LogicElement logicGate: scenario.getLogicGates()) {
            if (logicGate instanceof AndGate) {
                System.out.println("AND Gate at " + logicGate.getPosX() + " x " + logicGate.getPosY());
            } else {
                System.out.println("OR Gate at " + logicGate.getPosX() + " x " + logicGate.getPosY());
            }
        }
        System.out.println(divider);
        System.out.println("All Power Sources:");
        for (LogicElement powerSource: scenario.getPowerSources()) {
            System.out.println("Power Source at " + powerSource.getPosX() + " x " + powerSource.getPosY());
        }
        System.out.println(divider);
        System.out.println("All Outputs:");
        for (LogicElement outputElement: scenario.getOutputElements()) {
            if (outputElement instanceof LightOutput) {
                System.out.println("Light Output at " + outputElement.getPosX() + " x " + outputElement.getPosY());
            } else {
                System.out.println("Sound Output at " + outputElement.getPosX() + " x " + outputElement.getPosY());
            }
        }
    }

    // EFFECTS: previews scenario in terminal
    public void scenarioPreviewer() {
        System.out.println(divider);
        System.out.println("Scenario Preview:");
        System.out.println("D - AND Gate");
        System.out.println("0 - OR Gate");
        System.out.println("P - PowerSource");
        System.out.println("~ - Wire");
        System.out.println("█ - Light Output");
        System.out.println("▒ - Sound Output");
        System.out.println(divider);
        for (LogicElement[] row: scenario.getLogicElementGrid()) {
            String rowText = "";
            for (LogicElement logicElement: row) {
                rowText = rowText + findLogicElementSymbol(logicElement);
            }
            System.out.println(rowText);
        }
    }

    // EFFECT: displays scenario legend when rendering a scenario
    public void scenarioRenderLegend() {
        System.out.println(divider);
        System.out.println("Scenario Preview:");
        System.out.println("D - AND Gate: takes an input from the left and an input from below"
                + " and gives and output to the right");
        System.out.println("0 - OR Gate: takes an input from the left and an input from below "
                + "and gives and output to the right");
        System.out.println("P - PowerSource: powers your logic circuit and outputs"
                + "on all sides");
        System.out.println("~ - Wire: propagates power from power source to all other"
                + " logic elements. Wires have inputs and outputs on all sides");
        System.out.println("█ - Light Output: takes in power and lights up."
                + " Light Outputs have inputs on all sides but no outputs");
        System.out.println("▒ - Sound Output: takes in power and plays sound."
                + " Sound Outputs have inputs on all sides but no outputs."
                + " Currently not functioning");
        System.out.println("All powered logic elements display green");
    }

    // EFFECTS: renders scenario in terminal after the scenario run
    public void scenarioRender() {
        System.out.println(divider);
        String green = "\u001B[32m";
        String reset = "\u001B[0m";
        for (LogicElement[] row: scenario.getLogicElementGrid()) {
            String rowText = "";
            for (LogicElement logicElement: row) {
                if (logicElement != null && logicElement.getPowerStatus()) {
                    rowText = rowText +  green + findLogicElementSymbol(logicElement) + reset;
                } else {
                    rowText = rowText + findLogicElementSymbol(logicElement);
                }
            }
            System.out.println(rowText);
        }
    }

    // REQUIRES: logicElement is an AndGate, OrGate, PowerSource, Wire, LightOutput, SoundOutput, or null
    // EFFECT: match the logicElement to the specified character
    //              if AndGate, return D
    //              if OrGate, return 0
    //              if PowerSource, return P
    //              if Wire, return ~
    //              if LightOutput, return █
    //              if SoundOutput, return ▒
    //              if null, return " "
    public char findLogicElementSymbol(LogicElement logicElement) {
        if (logicElement instanceof AndGate) {
            return 'D';
        } else if (logicElement instanceof OrGate) {
            return '0';
        } else if (logicElement instanceof PowerSource) {
            return 'P';
        } else if (logicElement instanceof Wire) {
            return '~';
        } else if (logicElement instanceof LightOutput) {
            return '█';
        } else if (logicElement instanceof SoundOutput) {
            return '▒';
        } else {
            return ' ';
        }
    }

    // EFFECTS: handles user input in menu:
    //              if q - quit scenario
    //              if n - create new object (source, logic object, wire, output) and place it in scenario
    //              if r - run scenario
    //              if s - gives list of source, logic object, output currently in scenario
    //              else - state "Input not valid"
    public void handleInputMenu(String key) {
        System.out.println(divider);
        if (key.equals("n")) {
            createNewLogicElement();
        } else if (key.equals("r")) {
            scenario.runScenario();
            scenarioRenderLegend();
            scenarioRender();
            scenario.resetScenario();
            System.out.println("Press enter to continue");
            this.scanner.nextLine();
        } else if (key.equals("s")) {
            displayLogicElementList();
            System.out.println(divider);
            System.out.println("Press enter to continue");
            this.scanner.nextLine();
        } else if (key.equals("q")) {
            quitScenarioDisplayer();
        } else {
            System.out.println(divider);
            System.out.println("Invalid input, please try again!");
        }
    }

    // MODIFIES: this
    // EFFECTS: sets up a new logic element (source, logic object, wire, output) and allows user to add it to
    //          scenario
    public void createNewLogicElement() {
        newLogicElementMenuState = true;
        ObjectPlacer objectPlacer = new ObjectPlacer(scenario);
        while (newLogicElementMenuState) {
            System.out.println(divider);
            previewNewLogicElementInScenario(objectPlacer);
            displayMenuNewLogicElement();
            String key = this.scanner.nextLine();
            hanldeUserInputMenuNewLogicElement(key, objectPlacer);
        }
    }

    // REQUIRES: objectPlacer != null
    // EFFECTS: allows users to preview where the current selected tile is when placing a new logic element in
    //          current scenario
    public void previewNewLogicElementInScenario(ObjectPlacer objectPlacer) {
        System.out.println(divider);
        System.out.println("Scenario Preview:");
        System.out.println("D - AND Gate");
        System.out.println("0 - OR Gate");
        System.out.println("P - PowerSource");
        System.out.println("~ - Wire");
        System.out.println("█ - Light Output");
        System.out.println("▒ - Sound Output");
        System.out.println("▐ - Currently selected tile");
        System.out.println(divider);
        for (int i = 0; i < scenario.getLogicElementGrid().length; i++) {
            String rowText = "";
            LogicElement[] row = scenario.getLogicElementGrid()[i];
            for (int j = 0; j < row.length; j++) {
                LogicElement logicElement = row[j];
                if (objectPlacer.getPosY() == i && objectPlacer.getPosX() == j) {
                    rowText = rowText + '▐';
                } else {
                    rowText = rowText + findLogicElementSymbol(logicElement);
                }
            }
            System.out.println(rowText);
        }
    }

    // EFFECTS: displays user options when placing a new logic element
    public void displayMenuNewLogicElement() {
        System.out.println(divider);
        System.out.println("a - moves cursor tile to the left");
        System.out.println("d - moves cursor tile to the right");
        System.out.println("w - moves cursor tile up");
        System.out.println("s - moves cursor tile down");
        System.out.println("e - selects current cursor tile");
        System.out.println("q - quit");
    }

    // REQUIRES: objectPlacer != null
    // EFFECTS: handles the user's input when the new logic element menu
    //              if "a" is pressed, moves selected tile to the left (unless at left border)
    //              if "d" is pressed, moves selected tile to the right (unless at right border)
    //              if "w" is pressed, moves selected tile to up (unless at top border)
    //              if "s" is pressed, moves selected tile to down (unless at bottom border)
    //              if "e" is pressed, selects tile and gives further options for what logic element to add
    //                  at x and y position of  objectPlacer
    //              if "q" is pressed, quits menu for new logic element
    //              otherwise, gives invalid response message
    public void hanldeUserInputMenuNewLogicElement(String key, ObjectPlacer objectPlacer) {
        if (key.equals("a")) {
            objectPlacer.moveLeft();
        } else if (key.equals("d")) {
            objectPlacer.moveRight();
        } else if (key.equals("w")) {
            objectPlacer.moveUp();
        } else if (key.equals("s")) {
            objectPlacer.moveDown();
        } else if (key.equals("e")) {
            chooseNewLogicElementMenu(objectPlacer);
        } else if (key.equals("q")) {
            quitNewLogicElementMenu();
        } else {
            System.out.println(divider);
            System.out.println("Invalid input, please try again!");
        }
    }

    // REQUIRES: objectPlacer != null
    // MODIFIES: this
    // EFFECTS: allows users to select new logic element in currentlt selected tile location
    //          also allows users to delete existing elements
    public void chooseNewLogicElementMenu(ObjectPlacer objectPlacer) {
        this.chooseElementMenuState = true;
        while (chooseElementMenuState) {
            System.out.println(divider);
            previewNewLogicElementInScenario(objectPlacer);
            displayNewLogicElementOptions();
            String key = this.scanner.nextLine();
            hanldeUserInputMenuChooseLogicelement(key, objectPlacer);
        }
    }

    // EFFECTS: displays user options for what logic element to place once tile is selected
    public void displayNewLogicElementOptions() {
        System.out.println(divider);
        System.out.println("Please select which Logic Element you would like to add!");
        System.out.println("a - Add AND Gate |D|: AND Gates takes an input from the left and an input from below"
                + " and gives and output to the right");
        System.out.println("o - Add OR Gate |0|: OR Gates takes an input from the left and an input from below "
                + "and gives and output to the right");
        System.out.println("p - Add Power Source |P|: Power Sources powers your logic circuit and outputs "
                + "on all sides");
        System.out.println("w - Add Wire |~|: Wires allow you to propagate power from power source to all other "
                + "logic elements. Wires have inputs and outputs on all sides");
        System.out.println("l - Add Light Output |█|: Light Outputs takes in power and lights up. "
                + "Light Outputs have inputs on all sides but no outputs");
        System.out.println("s - Add Sound Output |▒|: Sound Outputs takes in power and plays sound. "
                + "Sound Outputs have inputs on all sides but no outputs");
        System.out.println("d - Delete currently selected logic element");
    }

    // REQUIRES: objectPlacer != null
    // MODIFIES: this
    // EFFECTS: handle user input for choosing a new logic element
    public void hanldeUserInputMenuChooseLogicelement(String key, ObjectPlacer objectPlacer) {
        if (key.equals("a")
                || key.equals("o")
                || key.equals("p")
                || key.equals("w")
                || key.equals("l")
                || key.equals("s")
                || key.equals("d")) {
            this.scenario.addLogicElement(key, objectPlacer.getPosX(), objectPlacer.getPosY());
            this.chooseElementMenuState = false;
        } else {
            System.out.println(divider);
            System.out.println("Invalid input, please try again!");
        }
    }

    // MODIFIES: this
    // EFFECTS: quits scenario displayer menu back to scenario selector
    public void quitScenarioDisplayer() {
        System.out.println("Back to the Scenario Select!");
        this.displayerState = false;
    }

    // MODIFIES: this
    // EFFECTS: quits scenario displayer menu back to scenario selector
    public void quitNewLogicElementMenu() {
        System.out.println("What would you like to do now?");
        this.newLogicElementMenuState = false;
    }
}
