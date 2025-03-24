package ui;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// Changes the screen size of the JFrame based on what tab is open in the JTabbedPane
public class TabSizeChanger implements ChangeListener {
    private StartingScreenGUI controller;
    private JTabbedPane tabbedPane;

    // EFFECTS: Creates the tab size changers with corresponding StartingScreenGUI and JTabbedPane
    public TabSizeChanger(StartingScreenGUI controller, JTabbedPane tabbedPane) {
        this.controller = controller;
        this.tabbedPane = tabbedPane;
    }


    // MODIFIES: this
    // EFFECTS: changes JFrame screen size to 600x600 if Home Tab is selected (index 0) and
    //          to 1400x900 if Scene Tab is selected (index 1)
    @Override
    public void stateChanged(ChangeEvent e) {
        int index = this.tabbedPane.getSelectedIndex();
        if (index == 0) {
            controller.setSize(600, 600);
        } else if (index == 1) {
            controller.setSize(1400, 900);
        }
    }

}
