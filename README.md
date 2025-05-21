# Logic Circuit Simulation - Personal Project

## Application Use & Purpose - Project Discription

Logic Circuit Simulator is an interactive application that allows users to design, build, and test custom digital circuits in a visual, real-time environment. Users can place logic gates (AND, OR, NOT, NOR, etc.), outputs (such as light bulbs or speakers), and power sources, then connect them using drawable wires to create functioning logic systems.

The application provides a flexible workspace where users can create and simulate circuits from scratch, making it ideal for exploring the fundamentals of digital logic and circuit design. It serves as both a powerful prototyping tool and an accessible platform for understanding the basic principles behind modern computing systems.

This project was developed to deepen my understanding of digital systems and low-level architecture, particularly as it relates to security and hardware. Inspired by my involvement in CTF competitions, this simulator is a step toward exploring how logical components interact and where vulnerabilities can arise within computer hardware.


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

# Planned Improvements to Architecture and Design

- UI Refactoring: The StartingScreenGUI contains several redundant associations that can be removed to streamline the interface. Within the buttons package, functionality is overly fragmented—only ElementButton is essential, while constructs like the ButtonName enum introduce unnecessary complexity. Furthermore, responsibility for UI rendering is inconsistently distributed across tab classes. While HomeTab handles its content adequately, ScenarioTab violates the Single Responsibility Principle by constructing and managing all of its UI panels internally. Refactoring ScenarioTab into more modular components would improve maintainability and separation of concerns.

- Model Redesign: The current implementation of the LogicElement class borrows elements from both the Composite and Observer design patterns but lacks a cohesive integration of either. Revisiting the architectural relationship between the Scenario class, LogicElement, and its subclasses could improve clarity and extensibility. A cleaner abstraction—possibly through a hybrid design pattern combining Composite for structural hierarchy and Observer for state propagation—would reduce ambiguity. For instance, the abstract LogicGate class is currently underutilized, lacking shared behavior or structure to justify its existence. A more principled use of inheritance and interfaces could streamline the logic layer and better support future expansion.


