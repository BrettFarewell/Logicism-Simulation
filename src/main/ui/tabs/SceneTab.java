package ui.tabs;

import java.util.List;

import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

import model.CircuitBuilderState;
import model.Scenario;
import ui.StartingScreenGUI;

// Respresents the Scene Tab in the application where scenarios can be selected and new scenarios can be added
public class SceneTab extends Tab {
    private JTabbedPane sceneTabs;
    private CircuitBuilderState circuitBuilderState;
    private NewSceneTab newSceneTab;
    
    // EFFECTS: creates the scene tab with corresponding StartingScreenGUI JFrame, circuitBuilderState, and adds
    //          the sceneTabs based on what scenarios are in the circuitBuilderState
    public SceneTab(StartingScreenGUI controller, CircuitBuilderState circuitBuilderState) {
        super(controller);
        this.circuitBuilderState = circuitBuilderState;
        setLayout(new BorderLayout());

        setupTabs();

        add(sceneTabs);

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: sets up the scene tabs by going through every scenario in circuitBuilderState and added it to the
    //          a JTabbedPane, then adding a newSceneTab where  users can generate new scenarios
    public void setupTabs() {
        List<Scenario> scenarioList = circuitBuilderState.getScenarioList();
        sceneTabs = new JTabbedPane(JTabbedPane.LEFT);
        sceneTabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        int i = 0;
        for (i = 0; i <= scenarioList.size() - 1; i++) {
            Scenario scenario = scenarioList.get(i);
            ScenarioTab scenarioTab = new ScenarioTab(controller, scenario);
            sceneTabs.add(scenarioTab);
            sceneTabs.setTitleAt(i, "Scenario " + "#" + (i + 1) + ": " + scenario.getName());
        }

        newSceneTab = new NewSceneTab(controller, circuitBuilderState);
        sceneTabs.add(newSceneTab, i);
        sceneTabs.setTitleAt(i, "Add New Scenario");
    }

    // EFFECTS: gets the Scene Tabs
    public JTabbedPane getSceneTabs() {
        return this.sceneTabs;
    }

    // MODIFIES: this
    // EFFECTS: updates the scene tabs based on the new circuitBuilderState
    public void  updateCircuitBuilderState(CircuitBuilderState circuitBuilderState) {
        this.circuitBuilderState = circuitBuilderState;
        remove(sceneTabs);
        setupTabs();
        add(sceneTabs);
        revalidate();
        repaint();
    }
}
