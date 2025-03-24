package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.CircuitBuilderState;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tabs.*;

// Represents the GUI of the starting screen, where users will create and select scenarios
// Users will also create and place logic objects. Logic objects will be rendered accordingly
public class StartingScreenGUI extends JFrame {
    public static final int HOME_TAB_INDEX = 0;

    private static final String JSON_STORE = "./data/CircuitBuilderState.json";
    private CircuitBuilderState circuitBuilderState;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JTabbedPane hortTabs;
    private SceneTab sceneTab;

    // EFFECTS: initializes the GUI starting screen, sets the application state, initiate tabs,
    //          bring up the home menu tab, and create scene tab with no scenarios, and create load and save buttons
    //          corresponding to loading and saving to file
    public StartingScreenGUI() {
        super("Circuit Builder Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        circuitBuilderState = new CircuitBuilderState();

        configTabs();
        hortTabs.addChangeListener(new TabSizeChanger(this, hortTabs));

        setSize(600, 600);
        setVisible(true);
    }


    // MODIFIES: this
    // EFFECTS: configures the home and scene tabs at the top of the frame 
    public void configTabs() {
        hortTabs = new JTabbedPane(JTabbedPane.TOP);
        loadTabs();
        add(hortTabs);
    }

    // MODIFIES: this
    // EFFECTS: loads the home and scene tabs
    private void loadTabs() {
        JPanel homeTab = new HomeTab(this);

        hortTabs.add(homeTab, HOME_TAB_INDEX);
        hortTabs.setTitleAt(HOME_TAB_INDEX, "Home");

        sceneTab = new SceneTab(this, circuitBuilderState);

        hortTabs.add(sceneTab, 1);
        hortTabs.setTitleAt(1, "Scenes");
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo
    // EFFECTS: loads the CircuitBuilderState to file
    public void loadJson() {
        try {
            this.circuitBuilderState = jsonReader.read();
            this.sceneTab.updateCircuitBuilderState(circuitBuilderState);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // ATTRIBUTION: Code structure based on JSONSerializationDemo
    // EFFECTS: saves the CircuitBuilderState to file
    public void saveJson() {
        try {
            jsonWriter.open();
            jsonWriter.write(circuitBuilderState);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: gets sceneTab
    public SceneTab getSceneTab() {
        return this.sceneTab;
    }

    // EFFECTS: gets relative json file path
    public String getJSonFilePath() {
        return JSON_STORE;
    }
}
