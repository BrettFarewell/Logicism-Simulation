package ui.tabs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.StartingScreenGUI;
import ui.tabs.buttons.ButtonNames;

// ATTRIBUTION: some of the methods in the class come from the Hometab class from the SmartHome application
// Represents the Home Tab which is a Tab that displays a welcome message and has save and load buttons
public class HomeTab extends Tab {
    private static final String INTRO_TEXT = "<html><div style='text-align: center;'>Welcome to Circuit Builder! "
                                            + "You can save and load your progress<br>"
                                            + "below or select the Scenes tab above to "
                                            + "start creating circuits!</html>";
    private JLabel botLabel;

    // EFFECTS: creates a Home Tab with corresponding StartingScreenGUI JFrame and sets up the intro message,
    //          buttons, and bottom message label
    public HomeTab(StartingScreenGUI controller) {
        super(controller);
        setLayout(new GridLayout(3, 1));
        setupIntro();
        setupButtons();
        setupBotLabel();
    }


    // MODIFIDIES: this
    // EFFECTS: sets ups the save and load buttons and places them in the frame. Saves and loads the data from the
    //          corresponding json file in the StartingScreenGUI JFrame class and updates botLabel accordingly
    private void setupButtons() {
        JButton saveButton = new JButton(ButtonNames.SAVE.getValue());
        JButton loadButton = new JButton(ButtonNames.LOAD.getValue());
        JPanel panel = setupButtonPanel(saveButton, loadButton);

        saveButton.addActionListener(e -> {
            StartingScreenGUI controller = getController();
            controller.saveJson();
            botLabel.setText("Saved file to " + controller.getJSonFilePath());
        });
        loadButton.addActionListener(e -> {
            StartingScreenGUI controller = getController();
            controller.loadJson();
            botLabel.setText("Loaded file from " + controller.getJSonFilePath());
        });
        this.add(panel);
    }

    // MODIFIDIES: this
    // EFFECTS: sets up the label for the intro message at the top of the Home Tab
    private void setupIntro() {
        JLabel intro1 = new JLabel(INTRO_TEXT, JLabel.CENTER);
        intro1.setFont(new Font(TYPE_FACE, Font.PLAIN, 15));
        intro1.setSize(WIDTH, HEIGHT / 6);
        this.add(intro1);
    }

    // MODIFIDIES: this, saveButton, loadButton
    // EFFECTS: sets up button panel where the saveButton and loadButton are modified and added to panel
    private JPanel setupButtonPanel(JButton saveButton, JButton loadButton) {
        JPanel panel = new JPanel();
        saveButton.setFont(new Font(TYPE_FACE, Font.PLAIN, 30));
        loadButton.setFont(new Font(TYPE_FACE, Font.PLAIN, 30));
        saveButton.setBackground(Color.lightGray);
        loadButton.setBackground(Color.lightGray);
        saveButton.setPreferredSize(new Dimension(150, 75));
        loadButton.setPreferredSize(new Dimension(150, 75));
        panel.add(saveButton);
        panel.add(Box.createRigidArea(new Dimension(75, 0)));
        panel.add(loadButton);
        panel.setSize(WIDTH, HEIGHT / 3);
        return panel;
    }

    // MODIFIDIES: this
    // EFFECTS: sets up the label for the bottom message to display
    private  void setupBotLabel() {
        botLabel = new JLabel("", JLabel.CENTER);
        botLabel.setFont(new Font(TYPE_FACE, Font.PLAIN, 15));
        botLabel.setSize(WIDTH, HEIGHT / 6);
        this.add(botLabel);
    }
}
