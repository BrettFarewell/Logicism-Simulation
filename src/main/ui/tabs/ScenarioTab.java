package ui.tabs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.AndGate;
import model.Category;
import model.LightOutput;
import model.LogicElement;
import model.OrGate;
import model.PowerSource;
import model.Scenario;
import model.SoundOutput;
import model.Wire;
import ui.StartingScreenGUI;
import ui.tabs.buttons.ElementButton;

// ATTRIBUTION: some of the methods in the class come from the Hometab class from the SmartHome application
// Represents the Scenario Tab in the Scenes tab. It is a Tab that displays the given scenario in the list
// of scenarios from the circuitBuilderState. Users can add elements, run their scenario, and generate a list 
// of all elements in scenario
public class ScenarioTab extends Tab {
    private static final int BACKGROUND_COLOR = 0xEEEEEE;
    private static final Color BORDER_COLOR = Color.gray;
    private static final String MENU_TEXT = "<html>Run: Run the logic circuit you created!<br>"
                                          + "Logic Element: Select a Logic Element and select a tile on the grid to add"
                                          + "<br>Delete: Select Delete and then select a tile to delete the Logic "
                                          + "Element"
                                          + "<br><br><u>Notes:</u><br>"
                                          + "ANDGate and ORGate: Takes inputs from the left and bottom and outputs"
                                          + "to the right<br>"
                                          + "Power Source: Provides power in all directions, takes no input<br>"
                                          + "Wire: Takes inputted power and distributes power in all direction<br>"
                                          + "Light and Sound Output: Takes power input from all direction and produces"
                                          + " light or sound respectively. Provides no output</html>";
    private JPanel gridPanel;
    private JButton runButton;
    private boolean runButtonStatus;
    private JLabel listLabel;
    private Scenario scenario;
    private JLabel selectedLabel;
    private Category category;

    // EFFECTS: generates the scenario tab with corresponding StartingScreenGUI JFrame and scenario.
    //          layout is set to gridbaglayout and sets up the logic element gris, menu to choose what element to
    //          add, the menu text, and the button the lists all elements
    public ScenarioTab(StartingScreenGUI controller, Scenario scenario) {
        super(controller);
        this.scenario = scenario;
        setLayout(new GridBagLayout());

        add(setupGrid(), setupGBC(0, 0, 1, 1, 1.0, 1.0));

        add(setupMenu(), setupGBC(0, 1, 1, 1, 1.0, 0.0));
        add(setupMenuText(), setupGBC(0, 2, 1, 1, 1.0, 0));

        add(setupElementListButton(), setupGBC(0, 3, 1, 1, 1.0, 0));

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: sets ups the Element List Button that will generate the list of logic elements in scenario in a
    //          new JFrame
    private JPanel setupElementListButton() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(1000, 100));
        JButton elementListButton = new JButton();
        elementListButton.setText("<html><div style='text-align: center;'>"
                                + "Generate list of all logic elements</html>");
        elementListButton.setFont(new Font(TYPE_FACE, Font.PLAIN, 15));
        elementListButton.setBackground(Color.lightGray);
        elementListButton.setPreferredSize(new Dimension(100, 100));
        elementListButton.addActionListener(e -> {
            generateElementList();
        });
        panel.add(elementListButton, setupGBC(0, 0, 1, 1, 0.1, 1.0));
        panel.add(setupEmptyLabelForButton(), setupGBC(1, 0, 1, 1, 1.0, 1.0));
        return panel;
    }

    // MODIFIES: this
    // EFFECTS: sets ups an empty label to position the list element button appropriately
    private JLabel setupEmptyLabelForButton() {
        listLabel = new JLabel();
        listLabel.setPreferredSize(new Dimension(900, 100));
        return listLabel;
    }

    // MODIFIES: this
    // EFFECTS: generates the element list in a new JFrame
    private void generateElementList() {
        JFrame elementList = new JFrame("Logic Element List");
        JLabel label = new JLabel();
        elementList.setResizable(false);
        elementList.setSize(600, 600);
        elementList.setLayout(null);
        label.setText(listElements());
        label.setBounds(0, 0, 600, 500);
        label.setFont(new Font(TYPE_FACE, Font.PLAIN, 20));
        label.setBackground(Color.lightGray);
        label.setHorizontalTextPosition(JLabel.LEFT);
        label.setVerticalTextPosition(JLabel.TOP);
        JScrollPane scrollPane = new JScrollPane(label);
        scrollPane.setBounds(0, 0, 590, 500);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        elementList.add(scrollPane);
        elementList.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: takes all logic elements (except for wires) and lists them by type and position in the scanerio
    //          logic grid in a string which it returns. All logic elements are categorized by either logic gate, 
    //          power source, or output
    private String listElements() {
        String list = "<html><u>All Logic Gates:</u><br>";
        for (LogicElement logicGate: scenario.getLogicGates()) {
            if (logicGate instanceof AndGate) {
                list = list + "AND Gate at " + logicGate.getPosX() + " x " + logicGate.getPosY() + "<br>";
            } else {
                list = list + "OR Gate at " + logicGate.getPosX() + " x " + logicGate.getPosY() + "<br>";
            }
        }
        list = list + "<br><u>All Power Sources:</u><br>";
        for (LogicElement powerSource: scenario.getPowerSources()) {
            list = list + "Power Source at " + powerSource.getPosX() + " x " + powerSource.getPosY() + "<br>";
        }
        list = list + "<br><u>All Outputs:</u><br>";
        for (LogicElement outputElement: scenario.getOutputElements()) {
            if (outputElement instanceof LightOutput) {
                list = list + "Light Output at " + outputElement.getPosX() + " x " + outputElement.getPosY() + "<br>";
            } else {
                list = list + "Sound Output at " + outputElement.getPosX() + " x " + outputElement.getPosY() + "<br>";
            }
        }
        return list;
    }

    // MODIFIES: this
    // EFFECTS: sets up the grid where all the logic elements of the scenario are displayed. Also, where the 
    //          elemetns will light up if powered when the scenario runs
    private JPanel setupGrid() {
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(scenario.getScreenHeight(), scenario.getScreenWidth()));
        for (int i = 1; i <= scenario.getScreenHeight() * scenario.getScreenWidth(); i++) {
            ElementButton button = new ElementButton(controller,
                                                    (i - 1) % scenario.getScreenWidth(),
                                                    (i - 1) / scenario.getScreenWidth());
            button.setBackground(new Color(BACKGROUND_COLOR));
            setButtonIcon(button);
            button.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 0));
            button.setRolloverEnabled(true);
            button.addMouseListener(new ButtonBorderEvent(button, BORDER_COLOR));
            setupButtonAction(button);
            gridPanel.add(button);
        }
        gridPanel.setPreferredSize(new Dimension(1000, 400));
        return gridPanel;
    }

    // MODIFIES: this
    // EFFECTS: sets up the Button action, where if a button is pressed, it updates to the corresponding logic element
    //          based on this.category
    private void setupButtonAction(ElementButton button) {
        button.addActionListener(e -> {
            String key = categoryToKey(this.category);
            if (key != null) {
                this.scenario.addLogicElement(key, button.getPosX(), button.getPosY());
                setButtonIcon(button);
            }
        });
    }

    // EFFECTS: sets up the menu text that informs users about the scenario tab
    private JLabel setupMenuText() {
        JLabel menuText = new JLabel(MENU_TEXT);
        menuText.setFont(new Font(TYPE_FACE, Font.PLAIN, 15));
        menuText.setPreferredSize(new Dimension(1000, 300));
        menuText.setVerticalAlignment(JLabel.TOP);
        return menuText;
    }

    // EFFECTS: gets the corresponding string from category given for the scenario.addLogicElement() method
    private String categoryToKey(Category category) {
        String key = null;
        if (category == Category.ANDGATE) {
            key = "a";
        } else if (category == Category.ORGATE) {
            key = "o";
        } else if (category == Category.POWERSOURCE) {
            key = "p";
        } else if (category == Category.WIRE) {
            key = "w";
        } else if (category == Category.LIGHTOUTPUT) {
            key = "l";
        } else if (category == Category.SOUNDOUTPUT) {
            key = "s";
        } else if (category == Category.DELETE) {
            key = "d";
        }
        return key;
    }

    // MODIFIES: this
    // EFFECTS: sets the button icon for the element buttons in the grid based on if it corresponds to
    //          a logic element in the scenario logic element grid
    private void setButtonIcon(ElementButton button) {
        LogicElement logicElement = scenario.getLogicElementGrid()[button.getPosY()][button.getPosX()];
        if (logicElement != null && logicElement.getPowerStatus()) {
            setButtonIconOn(button);
        } else {
            setButtonIconOff(button);
        }
    }

    // MODIFIES: button
    // EFFECTS: sets the icon of the button to the corresponding image on file when the logic element is off
    private void setButtonIconOff(ElementButton button) {
        LogicElement logicElement = scenario.getLogicElementGrid()[button.getPosY()][button.getPosX()];
        if (logicElement instanceof AndGate) {
            button.setIcon(new ImageIcon("data\\ANDGate.png"));
        } else if (logicElement instanceof OrGate) {
            button.setIcon(new ImageIcon("data\\ORGate.png"));
        } else if (logicElement instanceof PowerSource) {
            button.setIcon(new ImageIcon("data\\PowerSource.png"));
        } else if (logicElement instanceof Wire) {
            button.setIcon(new ImageIcon("data\\Wire.png"));
        } else if (logicElement instanceof LightOutput) {
            button.setIcon(new ImageIcon("data\\LightBulb.png"));
        } else if (logicElement instanceof SoundOutput) {
            button.setIcon(new ImageIcon("data\\Speaker.png"));
        } else {
            button.setIcon(null);
        }
    }

    // MODIFIES: button
    // EFFECTS: sets the icon of the button to the corresponding image on file when the logic element is on
    private void setButtonIconOn(ElementButton button) {
        LogicElement logicElement = scenario.getLogicElementGrid()[button.getPosY()][button.getPosX()];
        if (logicElement instanceof AndGate) {
            button.setIcon(new ImageIcon("data\\ANDGateOn.png"));
        } else if (logicElement instanceof OrGate) {
            button.setIcon(new ImageIcon("data\\ORGateOn.png"));
        } else if (logicElement instanceof PowerSource) {
            button.setIcon(new ImageIcon("data\\PowerSource.png"));
        } else if (logicElement instanceof Wire) {
            button.setIcon(new ImageIcon("data\\WireOn.png"));
        } else if (logicElement instanceof LightOutput) {
            button.setIcon(new ImageIcon("data\\LightBulbOn.png"));
        } else if (logicElement instanceof SoundOutput) {
            button.setIcon(new ImageIcon("data\\SpeakerOn.png"));
        } else {
            button.setIcon(null);
        }
    }

    // EFFECTS: sets the menu with th erun button, the logic panel buttons, and selected panel
    private JPanel setupMenu() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.add(setupRunButton(), setupGBC(0, 0, 1, 1, 0.1, 1));
        menuPanel.add(setupLogicPanel(), setupGBC(1, 0, 1, 1, 1, 1));
        menuPanel.add(setupSelectedPanel(), setupGBC(2, 0, 1, 1, 0.1, 1));
        menuPanel.setPreferredSize(new Dimension(1000, 120));
        return menuPanel;
    }

    // MODIFIES: this
    // EFFECTS: sets the Run Button that will run the scenario and update the panel grid based on the pwoer status of
    //          the logic elements in the scenario logic element grid
    private JPanel setupRunButton() {
        this.runButtonStatus = true;
        JPanel panel = new JPanel();
        this.runButton = new JButton();
        this.runButton.setText("Run");
        this.runButton.setFont(new Font(TYPE_FACE, Font.PLAIN, 30));
        this.runButton.setPreferredSize(new Dimension(150, 100));
        panel.setPreferredSize(new Dimension(100, 100));
        this.runButton.setBackground(Color.lightGray);
        this.runButtonAction();
        panel.add(this.runButton);
        return panel;
    }

    // MODIFIES: this
    // EFFECTS: performs the run button action. if the runButtonStatus == true, then run activateRunButton(), else run
    //          resetRunButton()
    private void runButtonAction() {
        runButton.addActionListener(e -> {
            if (this.runButtonStatus == true) {
                activateRunButton();
            } else {
                resetRunButton();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: run teh scenario and powers on the logic elements in the logic panel grid.
    //          sets runButtonStatus = false and the run button turns red and says "reset"
    private void activateRunButton() {
        this.scenario.runScenario();
        for (int i = 0; i < scenario.getScreenHeight() * scenario.getScreenWidth(); i++) {
            ElementButton elementButton = (ElementButton)gridPanel.getComponent(i);
            LogicElement[][] logicElementGrid = this.scenario.getLogicElementGrid();
            if (logicElementGrid[(i) / scenario.getScreenWidth()]
                    [(i) % scenario.getScreenWidth()] != null) {
                setButtonIcon(elementButton);
            }
        }
        this.runButtonStatus = false;
        this.runButton.setText("Reset");
        this.runButton.setBackground(Color.red);
    }

    // MODIFIES: this
    // EFFECTS: resets the scenario back to everything powered off and the buttons in the grid panel update
    //          sets runButtonStatus = true and the run button turns back to light gray and says "run"
    private void resetRunButton() {
        this.scenario.resetScenario();
        for (int i = 0; i < scenario.getScreenHeight() * scenario.getScreenWidth(); i++) {
            ElementButton elementButton = (ElementButton)gridPanel.getComponent(i);
            LogicElement[][] logicElementGrid = this.scenario.getLogicElementGrid();
            if (logicElementGrid[(i) / scenario.getScreenWidth()]
                    [(i) % scenario.getScreenWidth()] != null) {
                setButtonIcon(elementButton);
            }
        }
        this.runButtonStatus = true;
        this.runButton.setText("Run");
        this.runButton.setBackground(Color.lightGray);
    }

    // MODIFIES: this
    // EFFECTS: sets up the logic panel. when each button is pressed, category is updated corresponding to which 
    //          button is pressed
    private JPanel setupLogicPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText("<html><div style='text-align: center;'>Logic<br>Elements</html>");
        label.setFont(new Font(TYPE_FACE, Font.PLAIN, 15));
        label.setPreferredSize(new Dimension(80, 80));
        panel.setPreferredSize(new Dimension(400, 100));
        panel.add(label);
        panel.add(setupButton(Category.ANDGATE, "ANDGate", "data\\ANDGate.png"));
        panel.add(setupButton(Category.ORGATE, "ORGate", "data\\ORGate.png"));
        panel.add(setupButton(Category.POWERSOURCE, "Power", "data\\PowerSource.png"));
        panel.add(setupButton(Category.WIRE, "Wire", "data\\Wire.png"));
        panel.add(setupButton(Category.LIGHTOUTPUT, "Light", "data\\LightBulb.png"));
        panel.add(setupButton(Category.SOUNDOUTPUT, "Speaker", "data\\Speaker.png"));
        panel.add(setupButton(Category.DELETE, "Delete", "data\\Delete.png"));
        return panel;
    }

    // MODIFIES: this
    // EFFECTS: sets up the individual logic element and delete buttons, 
    //          category is updated corresponding to which button is pressed and updates the selected panel
    //          with appropriate image
    public JButton setupButton(Category category, String name, String path) {
        JButton button = new JButton();
        button.setText(name);
        button.setFont(new Font(TYPE_FACE, Font.PLAIN, 12));
        button.setPreferredSize(new Dimension(100, 100));
        button.setBackground(Color.lightGray);
        try {
            Image image = ImageIO.read(new File(path)).getScaledInstance(70, 70, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(image));
            button.addActionListener(e -> {
                this.category = category;
                selectedLabel.setIcon(new ImageIcon(image));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        button.setHorizontalTextPosition(JLabel.CENTER);
        button.setVerticalTextPosition(JLabel.TOP);
        return button;
    }

    // MODIFIES: this
    // EFFECTS: sets up the selected panel which displays what element is selected absed on this.category
    //          or othing if this.category is null
    private JPanel setupSelectedPanel() {
        JPanel panel = new JPanel();
        selectedLabel = new JLabel();
        selectedLabel.setText("Selected Element");
        selectedLabel.setFont(new Font(TYPE_FACE, Font.PLAIN, 15));
        selectedLabel.setHorizontalTextPosition(JLabel.CENTER);
        selectedLabel.setVerticalTextPosition(JLabel.TOP);
        panel.setPreferredSize(new Dimension(100, 10));
        panel.add(selectedLabel);
        return panel;
    }

    // EFFECTS: sets up the grid bag constraints for when adding components to the grid bag layout
    private GridBagConstraints setupGBC(int gridx, int gridy, int width, int height, double weightx, double weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }
}
