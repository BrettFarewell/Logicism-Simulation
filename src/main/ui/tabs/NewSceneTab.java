package ui.tabs;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CircuitBuilderState;
import model.Scenario;
import ui.StartingScreenGUI;


// Represents the New scene Tab where new scenarios are created based on a text field
public class NewSceneTab extends Tab {
    private static final String PRE_TXT = "Please enter Scenario name below:";
    private static final String FIELD_TXT = "Scenario Name...";
    private static final String NAME_ERROR_TXT = "Name entered is too long. Maximum 25 charatcers.";
    private JTextField textField;
    private JLabel botErrorLabel;
    private JButton button;
    private CircuitBuilderState circuitBuilderState;

    // EFFECTS: Creates a NewScenetab with corresponding StartingScreenGUI JFrame, circuitBuilderState, and creates a
    // text field and button to generate new scenario based on what is in the text field
    public NewSceneTab(StartingScreenGUI controller, CircuitBuilderState circuitBuilderState) {
        super(controller);
        this.circuitBuilderState = circuitBuilderState;
        setLayout(new GridLayout(15, 1));

        setupPreTxt();
        setupTextField();
        setupButton();
        setupBotErrorMessage();

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: sets up preText where users are instructed to enter a scenario name and generate a new scenario
    private void setupPreTxt() {
        JPanel panel = new JPanel();
        JLabel enterTxt = new JLabel(PRE_TXT);
        enterTxt.setFont(new Font(TYPE_FACE, Font.PLAIN, 15));
        panel.add(enterTxt);
        add(panel);
    }

    // MODIFIES: this
    // EFFECTS: sets up text field where users can enter text to choose a name for their scenario
    private void setupTextField() {
        JPanel panel = new JPanel();
        textField = new JTextField(25);
        textField.setText(FIELD_TXT);
        textField.setFont(new Font(TYPE_FACE, Font.PLAIN, 15));
        panel.add(textField);
        this.add(panel);
    }

    // MODIFIES: this
    // EFFECTS: sets up the generate button that generates a new scenario based on the text field
    //          and adds it to the list of scenarios in the circuitBuilderState, then updates the circuitBuilderState
    //          in the scene tab. Constraint: text length in text field must be <= 25 characters to generate
    //          new scenario, gives error message if > 25 characters in the botErrorLabel
    private void setupButton() {
        JPanel panel = new JPanel();
        button = new JButton("Generate");
        button.setFont(new Font(TYPE_FACE, Font.PLAIN, 20));
        button.setBackground(Color.lightGray);
        button.addActionListener(e -> {
            String text = textField.getText();
            if (text.length() > 25) {
                botErrorLabel.setText(NAME_ERROR_TXT);
            } else {
                SceneTab sceneTab = controller.getSceneTab();
                circuitBuilderState.addScenario(new Scenario(text));
                sceneTab.updateCircuitBuilderState(circuitBuilderState);
                sceneTab.getSceneTabs().setSelectedIndex(circuitBuilderState.getScenarioList().size() - 1);
            }
        });
        panel.add(button);
        this.add(panel);
    }

    // MODIFIES: this
    // EFFECTS: sets up the botErrorLabel at the bottom of the tab which will display any errors that arise
    private void setupBotErrorMessage() {
        JPanel errorPanel = new JPanel();
        botErrorLabel = new JLabel("");
        botErrorLabel.setFont(new Font(TYPE_FACE, Font.PLAIN, 15));
        errorPanel.add(botErrorLabel);
        add(errorPanel);
    }
}
