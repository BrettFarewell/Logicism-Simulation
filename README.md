# Logic Circuit Simulation - Personal Project

## Application Use & Purpose - Project Discription

The *Logic Circuit Simulation* is an application where users can design and test their logic circuits. Thus, users will be able to place logic gates (e.g. OR Gate, NOR Gate, AND Gate, NOT Gate, etc.), outputs (e.g. light bulb, speaker, etc.), and a source (power), then interconnect them via drawable wires. *Logic Circuit Simulation* will serve as an educational tool, allowing individuals to learn more about logic circuits and the fundamentals that computers use for computations. users will be able to create a blank scenario in which they can draw out their desired logical circuits and then run them in real-time.


As mentioned, *Logic Circuit Simulation* is designed for individuals who want to experiment and educate themselves on the building blocks of digital circuits in a simulated hands-on environment. Additionally, the project interests me as I recently have been partaking in the  Maple Bacon club, a club dedicated to capture the flag (CTF) hacking competitions. Thus, I want to gain a better knowledge and understanding of computer architecture and logical circuits, to educate myself on computer hardware vulnerabilities.


## User Stories

List of **User Stories**:
- As a user, I want to be able to create a scenario (blank world state) and add it to a list of scenarios.
- As a user, I want to be able to create a scenario (blank world state), then add and draw any number of logical gates, outputs, sources, and wires to said scenario.
- As a user, I want to be able to view a scenario from a list of scenarios I have created.
- As a user, I want to be able to view a list of all logical gates and outputs added to a scenario.
- As a user, I want to be able to draw wires to interconnect logic gates, sources, and outputs and run them in real-time to create a functioning logic circuit.
- As a user, I want to be able to select the OR gate, NOR gate, AND gate, NAND gate, NOT gate, XOR gate, or XNOR gate from a menu and then have the menu tell me what the gate does.
- As a user, I want to have a light source and an audio source that plays a frequency as outputs and I want to be able to select the colour or frequency at which the output emits.

- *Old save and load user stories for Terminal*
- As a user, I want the option to save the current application state with the list of all scenarios when the I quit the application
- As a user, I want the option to load a previously saved application state that contains a list of scenarios when the I start the application

- *Updated save and load user stories for GUI*
- As a user, I want the option to save the current application state with the list of all scenarios from the home tab of the gui
- As a user, I want the option to load a previously saved application state that contains a list of scenarios from the home tab of the gui


# Instructions for End User

- You can generate the first required action related to the user story "adding multiple Xs to a Y" by selecting the Scenes
Tab at the top, then selecting a scenario (or generating a scenario in the new scene tab on the left), then hitting 
selecting a logic element to add by clicking any of the logic elements (ANDGate, ORGate, Power, etc.). After, the selected
element field should chnage to what you selected and you can add an element to anywhere on the grid above. You can also
delete an element by hitting delete the delete button and then selecting the element you want to delete on the grid.
- You can generate the second required action related to the user story "adding multiple Xs to a Y" by hitting the generate list of of logic elements at the bottom of any Scenario Tab which will create a new window will all logic elements (except wires) that are in the scenario. These elements will be categorized by type and tell you where the element is located in the grid. Also you can run you scenario by hitting the Run button, then reset the scenario by hitting it again
- You can locate my visual component by going to the Scene Tab and generating or selecting a new scenario, the grid
up top of the selected Scenario Tab will be the where you add your logic elements to and where your circuit when it is off and on will display. You can hit the run button to run your circuit scenario based on what
you place and it will light up above in the grid
- You can save the state of my application by hitting the save button on the Home Tab
- You can reload the state of my application by hitting the load button on the Home Tab


# Phase 4: Task 2

```
Sat Mar 29 09:50:40 PDT 2025
Generated a new Scenario: Test Scenario


Sat Mar 29 09:50:43 PDT 2025
Added Power Source at 12 x 9 in Scenario: Test Scenario


Sat Mar 29 09:50:44 PDT 2025
Added Wire at 13 x 9 in Scenario: Test Scenario


Sat Mar 29 09:50:45 PDT 2025
Added Wire at 14 x 9 in Scenario: Test Scenario


Sat Mar 29 09:50:46 PDT 2025
Added ORGate at 15 x 9 in Scenario: Test Scenario


Sat Mar 29 09:50:47 PDT 2025
Added Wire at 16 x 9 in Scenario: Test Scenario


Sat Mar 29 09:50:48 PDT 2025
Added Wire at 17 x 9 in Scenario: Test Scenario


Sat Mar 29 09:50:49 PDT 2025
Added Light Output at 18 x 9 in Scenario: Test Scenario


Sat Mar 29 09:50:52 PDT 2025
Added Power Source at 16 x 15 in Scenario: Test Scenario


Sat Mar 29 09:50:53 PDT 2025
Added Wire at 23 x 15 in Scenario: Test Scenario


Sat Mar 29 09:50:55 PDT 2025
Removed Element at 23 x 15 in Scenario: Test Scenario


Sat Mar 29 09:50:56 PDT 2025
Removed Element at 16 x 15 in Scenario: Test Scenario


Sat Mar 29 09:50:58 PDT 2025
Listed PowerSources in Scenario: Test Scenario


Sat Mar 29 09:50:58 PDT 2025
Ran Logic Circuit in ScenarioTest Scenario


Sat Mar 29 09:50:59 PDT 2025
Reset Logic Circuit in Scenario:Test Scenario


Sat Mar 29 09:51:01 PDT 2025
Listed LogicGates in Scenario: Test Scenario


Sat Mar 29 09:51:01 PDT 2025
Listed PowerSources in Scenario: Test Scenario


Sat Mar 29 09:51:01 PDT 2025
Listed OutputElements in Scenario: Test Scenario


Sat Mar 29 09:51:06 PDT 2025
Saved application state to ./data/CircuitBuilderState.json
```

# Phase 4: Task 3

- For the UI, there was a lot of unnecessary associations of the StartingScreenGUI that were not needed in the end. Also, there is too much coupling in the buttons package as only ElementButton was needed. Even the enum ButtonName was over-complicating the buttons in the HomeTab class. On the other hand, the Tab subclasses often were responsible for displaying everything on each tab. While this was fine with the HomeTab, the ScenarioTab does not follow the Single Design Principle as each panel the in the ScenarioTab is exclusively made in the ScenarioTab class.

- Additionally, for my model, while the LogicElement class does take some inspiration from the composite design patterns, it also has some elements that a observer design pattern would have. As such, a more robust design pattern tackling the Scenario class and the LogicElement class and subclasses and trying to implement a better design pattern that incorporates both the observer and composite design patterns would be beneficial for clarity and ease of use. This can be made especially clear looking at the abstract LogicGate class that has nothing in it and was originally designed to differentiate but still group the OrGate and AndGate from the rest of the LogicElements.