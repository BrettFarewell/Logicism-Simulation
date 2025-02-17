package ui;

import model.*;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

// Represents the terminal or ui of the starting screen, where users will create and select scenarios
public class StartingScreen {
    private boolean applicationState;
    private boolean scenarioSelectorState;
    private List<Scenario> scenarios;
    private int currentScenarioIndex;
    private Scanner scanner;
    private String divider = "--------------------------------------------------";
    
    // EFFECTS: initializes the terminal starting screen, sets the application state,
    //          and creates an empty list of scenarios with index set to 0. Brings up the start menu
    //          Temporarily creates starting scenarios for users to select and adds them to scenarios list
    public StartingScreen() {
        this.applicationState = true;
        this.scenarios = new ArrayList<Scenario>();
        this.currentScenarioIndex = 0;
        this.scanner = new Scanner(System.in);

        initializeScenario1();
        initializeScenario2();
        
        startMenu();
    }

    // EFFECTS: sets up the start menu, displays user options, and takes and handles user's input
    //          through handleInputMenu()
    public void startMenu() {
        while (applicationState) {
            startMenuDisplay();
            String key = this.scanner.nextLine();
            handleInputMenu(key);
        }
    }

    // EFFECTS: displays user options in the start menu in the terminal
    public void startMenuDisplay() {
        System.out.println(divider);
        System.out.println("Welcome to Logic Circuit Builder! You're one stop shop for building logic circuits!");
        System.out.println("Please select an option below");
        System.out.println("n - Create a new Logic Circuit Builder Scenario");
        System.out.println("l - List all Logic Circuit Builder Scenarios");
        System.out.println("s - Select from existing Logic Circuit Builder Scenarios");
        System.out.println("q - Quit Application :(");
        System.out.println(divider);
    }

    // EFFECTS: handles user input in menu:
    //              if q - quit application
    //              if n - create new scenario
    //              if s - bring up existing scenarios through scenario selector
    //              else - state "Input not valid"
    public void handleInputMenu(String key) {
        if (key.equals("n")) {
            setupScenario();
        } else if (key.equals("s")) {
            scenarioSelector();
        } else if (key.equals("l")) {
            listScenarios();
            System.out.println(divider);
            System.out.println("Press enter to continue");
            this.scanner.nextLine();
        } else if (key.equals("q")) {
            quitLogicCircuitBuilder();
        } else {
            System.out.println(divider);
            System.out.println("Invalid response, please try again!");
        }
    }

    // EFFECT: lists all scenarios in the terminal with their name
    public void listScenarios() {
        System.out.println(divider);
        for (int i = 0; i < scenarios.size(); i++) {
            System.out.println("Scenario #" + (i + 1) + ": " + scenarios.get(i).getName());
        }
        if (scenarios.isEmpty()) {
            System.out.println("No scenarios to show");
        }
    }

    // MODIFIES: this
    // EFFECTS: pull from list of scenarios and allow users to select a scenario, give a no current scenarios message
    //          if no scenarios exsits in the list of scenarios
    public void scenarioSelector() {
        if (this.scenarios.isEmpty()) {
            System.out.println(divider);
            System.out.println("No scenarios to select. Try making one!");
        } else {
            scenarioSelectorState = true;
            while (scenarioSelectorState) {
                System.out.println(divider);
                System.out.println("Current Scenario: Scenario #" + (currentScenarioIndex + 1));
                System.out.println(scenarios.get(currentScenarioIndex).getName());
                scenarioPreview(scenarios.get(currentScenarioIndex));
                scenarioSelectorDisplay();
                String key = this.scanner.nextLine();
                handleInputScenarioSelector(key);
            }
        }
    }

    // EFFECTS: displays user options in the scenario selector in the terminal
    public void scenarioSelectorDisplay() {
        System.out.println(divider);
        System.out.println("> - go to next scenario");
        System.out.println("< - go to previous scenario");
        System.out.println("s - select current scenario");
        System.out.println("q - quit scenario selector");
    }

    // REQUIRES: scenario != null
    // EFFECTS: displays preview of current scenario in terminal
    public void scenarioPreview(Scenario scenario) {
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

    // MODIFIES: this
    // EFFECTS: handles user input in scenario selector:
    //              if q - quit scenario selector
    //              if > - go to next scenario in list
    //              if < - go to previous scenario in list
    //              if s - select and display scenario
    //              else - state "Input not valid"
    public void handleInputScenarioSelector(String key) {
        if (key.equals(">")) {
            if (currentScenarioIndex == scenarios.size() - 1) {
                this.currentScenarioIndex = 0;
            } else {
                this.currentScenarioIndex++;
            }
        } else if (key.equals("<")) {
            if (currentScenarioIndex == 0) {
                this.currentScenarioIndex = scenarios.size() - 1;
            } else {
                this.currentScenarioIndex--;
            }
        } else if (key.equals("s")) {
            new ScenarioDisplayer(scenarios.get(currentScenarioIndex));
        } else if (key.equals("q")) {
            this.scenarioSelectorState = false;
        } else {
            System.out.println(divider);
            System.out.println("Invalid response, please try again!");
        }
    }

    // MODIFIES: this
    // EFFECTS: sets up a new scenario and adds it to the list of scenarios
    public void setupScenario() {
        System.out.println(divider);
        System.out.println("Please name your scenario");
        String name = this.scanner.nextLine();
        Scenario scenario = new Scenario(name);
        scenarios.add(scenario);
    }

    // EFFECTS: returns list of current scenarios
    public List<Scenario> getScenarioList() {
        return this.scenarios;
    }

    // MODIFIES: this
    // EFFECT: quit the current application and say a goodbye message
    public void quitLogicCircuitBuilder() {
        System.out.println(divider);
        System.out.println("Thanks for stopping by!");
        System.out.println("Hope to see you soon!");
        this.applicationState = false;
    }


    // MODIFIES: this
    // EFFECT: initializes a scenario with functioning AND and OR gates, with light output at the end
    //         and add it to the list of scenarios
    public void initializeScenario1() {
        Scenario scenario = new Scenario("Functioning Circuit");
        scenario.addPowerSource(5, 5);
        scenario.addWire(6, 5);
        scenario.addWire(7, 5);
        scenario.addOrGate(8, 5);
        scenario.addWire(9, 5);
        scenario.addWire(9, 4);
        scenario.addWire(8, 4);
        scenario.addWire(8, 3);
        scenario.addWire(6, 4);
        scenario.addWire(6, 3);
        scenario.addWire(6, 2);
        scenario.addWire(7, 2);
        scenario.addAndGate(8, 2);
        scenario.addWire(9, 2);
        scenario.addWire(10, 2);
        scenario.addSoundOutput(11, 2);
        scenarios.add(scenario);
    }
    
    
    // MODIFIES: this
    // EFFECT: initializes a scenario with a functioning OR gate, but non-functioning AND Gate and sound output
    //         and add it to the list of scenarios
    public void initializeScenario2() {
        Scenario scenario = new Scenario("Non-Functioning Circuit");
        scenario.addPowerSource(5, 5);
        scenario.addWire(6, 5);
        scenario.addWire(7, 5);
        scenario.addOrGate(8, 5);
        scenario.addWire(9, 5);
        scenario.addWire(6, 4);
        scenario.addWire(6, 3);
        scenario.addWire(6, 2);
        scenario.addWire(7, 2);
        scenario.addAndGate(8, 2);
        scenario.addWire(9, 2);
        scenario.addWire(10, 2);
        scenario.addLightOutput(11, 2);
        scenarios.add(scenario);
    }
}
